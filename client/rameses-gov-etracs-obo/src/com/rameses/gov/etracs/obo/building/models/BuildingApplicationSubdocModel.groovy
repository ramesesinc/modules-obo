package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;
import javax.swing.*;
import com.rameses.io.*;

class BuildingApplicationSubdocModel extends CrudFormModel {

    
    @Service("BuildingApplicationInfoService")
    def infoSvc;
    
    @Service("BuildingApplicationFeeService")
    def feeSvc;

    @Service("BuildingApplicationChecklistService")
    def chklistSvc;

    @Service("BuildingIssuanceService")
    def issuanceSvc;
    
    def selectedInfo;
    def infos;
    boolean editable;
    boolean showInfos;
    boolean showProfessionals;
    boolean showChecklist;
    boolean showFees;
    boolean canIssue;
    boolean manualIssue;
    boolean canPrint;
    boolean currentOrg = false;
    
    def worktypetext;
    
    public String getTitle() {
        return entity.doctype.title;
    }
    
    void addNew(def inv) {
        //parent is either building app or evaluation
        boolean pass = false;
        def parent = caller.entity;
        
        String lookupName = null;
        String appid = null;
        
        def q = [:];
        if( inv.properties.parent == "building_application"  ) {
            appid = parent.objid;
            lookupName = "building_doc_type";
        }
        else {
            appid = parent.appid;
            q.put("query.typeid", parent.typeid );            
            lookupName = "building_doc_type_typeid";
        }
        
        q.onselect = { o->
            //check current org;
            checkCurrentOrg(o.org?.objid);
            if( currentOrg == false ) throw new Exception("You cannot add this document. Only the org associated with it");
            def pq = [_schemaname: "building_application_subdoc"];
            pq.appid = appid;
            pq.doctypeid = o.objid;
            pq.doctype = [objid: o.objid ];
            pq.state = 0;
            pq.amount = 0;
            pq.occupancytypeid = '';
            persistenceService.create( pq );
            caller.reloadEntity();
        }
        Modal.show(lookupName + ":lookup", q );
        if(!pass) throw new BreakException();
    }
    
    void checkCurrentOrg( def orgid ) {
        currentOrg = false;
        if(  orgid == userInfo.env.ORGID ) currentOrg = true;
        else if( orgid ==null && userInfo.env.ORGROOT == 1 ) currentOrg = true;
    }
    
    void afterInit() {
        this.infos = infoSvc.getInfos([parentid: entity.objid ] );
        editable = false;
        def task = caller.task;
        
        checkCurrentOrg(entity.doctype.org.objid );
       
        editable = false;
        if( currentOrg == true ) {
            //editable only during evaluation and assessment
            if( entity.appstate.matches('.*evaluation.*|assessment') ) {
                editable = true;
            }
        }
        
        if( entity.doctype.type.toLowerCase() == 'ancillary') {
            showProfessionals = true;
        }
        if( entity.doctype.issuetype != 0 ) {
            canIssue = true;
        }
        manualIssue = false;
        if( entity.doctype.issuetype == 2 ) {
            if( currentOrg == true && entity.issuanceid == null && entity.appstate.matches("releasing|end") ) {
                manualIssue = true;                
            }
        }
        if( entity.doctype.template !=null ) {
            canPrint = true;
        }
        showChecklist = true;
        showInfos = true;
        showFees = true;
        if(  entity.doctype.type.toLowerCase() == 'checklist' ) {
            showInfos = false;
            showFees = false;
        }
        else {
            //showChecklist = false;
        }
        
    }
    
    /* ************************************************************************
    * INFOS ADDED IN THE ANCILLARY 
    *************************************************************************/
    def infoListModel = [
        isMultiSelect: {
            return true;
        },
        fetchList: { o -> 
            return infos;      
        }
    ] as EditorListModel;
    
    void saveInfos(def items) {
        def _infos = [];
        items.each { v->
            def existInfo = infos.find{it.name == v.name};
            if( !existInfo ) {
                v.objid = null;
                v.parentid = entity.objid;
                v.appid = entity.appid;
                _infos << v;
            }
            else {
                existInfo.value =  v.value;
                _infos << existInfo;                    
            }
        }
        infoSvc.saveInfos( _infos );
        this.infos = infoSvc.getInfos([parentid: entity.objid ] ); 
        infoListModel.load();
    }
    
    
    def addInfos() {
        def h = { o->
            saveInfos(o);
        }
        return Inv.lookupOpener( "obo_variable:picklist", [typeid: entity.doctype.objid, onselect: h ]);
    }
    
    def editInfos() {
        def selectedItems = infoListModel.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to edit");
        def h = { o->
            saveInfos(o);
        }
        def op= Inv.lookupOpener("obo_detail_info", [items: selectedItems, onselect: h ]);
        op.target = "popup";
        return op;
    }
    
    void removeInfos() {
        def selectedItems = infoListModel.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to remove");
        infoSvc.removeInfos( selectedItems );
        this.infos = infoSvc.getInfos([parentid: entity.objid ] ); 
        infoListModel.load();
    }

    void editRemarks() {
        if( !selectedInfo ) return;
        def msg = MsgBox.prompt("Enter Remarks");
        if(msg) {
            selectedInfo.remarks = msg;
            infoListModel.load();
        }
    }
    
    /* ************************************************************************
    * FEES COMPUTATION AND ASSESSMENT
    *************************************************************************/
   def feeListHandler;
   def selectedFee;
   
   def assess() {
        def f = [:];
        f.appid = entity.appid;
        f.parentid = entity.objid;
        def h  = { u->
            def m1 = [appid: entity.appid, parentid: entity.objid, items: u.items];
            m1 = feeSvc.saveFees( m1 );
            entity.amount = m1.amount;
            feeListHandler.reload();
            binding.refresh("entity.amount");
        }
        return Inv.lookupOpener("building_assessment", [params: f, handler: h] );
    }
    
    def addFee() {
        def m = [typeid: entity.doctype.objid ];
        m.lookupName = "building_doc_type_itemaccount";
        m.entity = [appid:entity.appid, parentid:entity.objid];
        m.saveHandler = { o->
            o = feeSvc.saveFee( o );
            entity.amount = o.amount;
            feeListHandler.reload();
            binding.refresh("entity.amount");
        }
        return Inv.lookupOpener("building_application_fee", m );
    }
    
    def editFee() {
        if(!selectedFee) throw new Exception("select an item first");
        def m = [typeid: entity.doctype.objid ];
        m.lookupName = "building_doc_type_itemaccount";
        m.entity = selectedFee;
        m.saveHandler = { o->
            o = feeSvc.saveFee( o );
            entity.amount = o.amount;
            feeListHandler.reload();
            binding.refresh("entity.amount");
        }
        return Inv.lookupOpener("building_application_fee", m );
    }

    void clearFees() {
        feeSvc.clearFees( [appid:entity.appid, parentid:entity.objid ]);
        entity.amount = 0;
        binding.refresh("entity.amount");
    }
    
    /**************************************************************************
    * CHECKLIST ITEMS
    ***************************************************************************/
    def selectedChecklistItem;
    def checklistHandler = [
        isMultiSelect: {
            return true;
        },
        openItem: { o, col ->
            return updateChecklistItem(o);
        }, 
        fetchList: { o->
            return chklistSvc.getList( [objid: entity.objid ] );
        }
    ] as BasicListModel;
    
    public void refreshChecklistItems() {
        checklistHandler.reload();
    }
    
    public def addChecklistItems() {
        def pp = [:]
        pp.onselect = { o->
            def p = [:];
            p.objid = entity.objid;
            p.items = o.collect{ [objid: it.objid ] };
            chklistSvc.addItems( p );
            checklistHandler.reload();
        };
        pp.put("query.typeid", entity.doctype.objid );
        return Inv.lookupOpener("obo_checklist_master:lookup", pp);
    }
    
    public def removeChecklistItems() {
        def selectedChecklistItems = checklistHandler.getSelectedValue();
        if(!selectedChecklistItems) return;
        def p = [:];
        p.items = selectedChecklistItems.collect{[objid: it.objid] };
        chklistSvc.removeItems( p );
        checklistHandler.reload();
    }
    
    public def updateChecklistItem(def o) {
        def h = {
            checklistHandler.reload();
        }
        return Inv.lookupOpener( "building_application_checklist_item", [entity: o, handler: h])
    }
    
    public def editItem() {
        if(selectedChecklistItem == null) throw new Exception("Please select an item");
        return updateChecklistItem(selectedChecklistItem);
    }
    
     def issueControl() {
          def h = { o->
            o.objid = entity.objid;
            issuanceSvc.issueControl( o );
            reloadEntity();
        }
        return Inv.lookupOpener("obo_issue_controlno", [handler: h, showcontrolno: true]);
    }
    
    //additional work types
    def editWorktypes() {
        def p = [:];
        p.onselect = { o->
            def e = [_schemaname: schemaName];
            e.objid = entity.objid;
            e.worktypes = o*.objid;
            persistenceService.update(e);
            entity.worktypes = e.worktypes;
            binding.refresh();
        };
        p.put("query.typeid", [typeid: entity.doctypeid ]);
        return Inv.lookupOpener("obo_work_type:lookup", p );
    }
    
    public String getWorktypesText() {
        if( entity.worktypes == null ) return "";
        return entity.worktypes.join(",");
    }
    
    def editContractorName() {
        def p = [:];
        p.fields = [
            [caption:'Contractor name', name:'contractorname' ]
        ];
        p.data = [
            contractorname: entity.contractorname
        ];
        p.handler = { o->
            def e = [_schemaname: schemaName];
            e.objid = entity.objid;
            e.contractorname = o.contractorname;
            persistenceService.update(e);
            entity.contractorname = o.contractorname;
            binding.refresh();
        }
        return Inv.lookupOpener("dynamic:form", p );
    }
    
    def editRemarks() {
        def p = [:];
        p.fields = [
            [caption:'Remarks', name:'remarks' ]
        ];
        p.data = [
            remarks: entity.remarks
        ];
        p.handler = { o->
            def e = [_schemaname: schemaName];
            e.objid = entity.objid;
            e.remarks = o.remarks;
            persistenceService.update(e);
            entity.remarks = o.remarks;
            binding.refresh();
        }
        return Inv.lookupOpener("dynamic:form", p );
    }
}