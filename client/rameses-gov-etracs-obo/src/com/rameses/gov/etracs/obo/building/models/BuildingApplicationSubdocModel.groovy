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

    /*
    def getHtmlInfo() {
        return TemplateProvider.instance.getResult( "com/rameses/gov/etracs/obo/templates/ancillaryinfo.gtpl", [info:[:] ] );
    }
    */
    
    @Service("BuildingApplicationInfoService")
    def infoSvc;
    
    @Service("BuildingApplicationFeeService")
    def feeSvc;

    @Service("BuildingApplicationChecklistService")
    def chklistSvc;

    
    def selectedInfo;
    def infos;
    boolean editable;
    boolean showInfos;
    boolean showProfessionals;
    boolean showChecklist;
    
    public String getTitle() {
        return entity.doctype.title;
    }
    
    void afterInit() {
        this.infos = infoSvc.getInfos([parentid: entity.objid ] );
        editable = false;
        def task = caller.task;
        if( task?.assignee?.objid == userid ) {
            editable = true;
        }
        if( entity.doctype.type.toLowerCase() == 'ancillary') {
            showInfos = true;
            showProfessionals = true;
        }
        showChecklist = true;
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
    
}