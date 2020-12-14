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

class BuildingPermitDocModel extends CrudFormModel {

    //@Service("BuildingApplicationChecklistService")
    //def chklistSvc;

    @FormId
    public String getFormid() {
        return "building_doc:" + entity.objid;
    }
    
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
    
    def docList;
    boolean showDocList;
    def selectedRefDoc;
    
    def worktypetext;
    
    public String getTitle() {
        return entity.doctype.title;
    }
    
    void checkCurrentOrg( def orgid ) {
        currentOrg = false;
        if(  orgid == userInfo.env.ORGID ) currentOrg = true;
        else if( orgid ==null && userInfo.env.ORGROOT == 1 ) currentOrg = true;
    }
    
    void afterOpen() {
        //showChecklist = entity.showchecklist;
        //showInfos = entity.showinfo;
        //showFees = entity.showfees;
        
        showChecklist = true;
        showInfos = true;
        showFees = true;
        reloadRefDocList();
    }
    
    public void checkCanIssue() {
        if(docList.findAll{ it.controlid==null} ) {
            throw new Exception("This document cannot be issued because there are unissued reference documents");
        }
    }
    
    void reloadRefDocList() {
        def m = [_schemaname: "vw_building_permit_doc"];
        m.findBy = [ appid: entity.appid ];
        m.where = ["doctype.refdoc = :refdoc", [refdoc: entity.doctype.objid ]];
        docList = queryService.getList( m );
        if( docList ) showDocList = true;
    }
    
    public boolean getCanIssueControl() {
        return (entity.controlid == null && entity.doctype.issuetype == 2 && entity.app?.task?.state == 'releasing' ); 
    }
    
    
    
    /* ************************************************************************
    * INFOS ADDED IN THE ANCILLARY 
    *************************************************************************/
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
    
   
    
    //additional work types
    /*
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
    
    def checklistHandler = [
        saveItems: { o->
            chklistSvc.addItems( o );
        },
        removeItems : { o->
            chklistSvc.removeItems( o );
        },
        updateItem: { o->
            chklistSvc.updateItem( o );
        }
    ]
    */
    
    def openRefDoc() {
        if(!selectedRefDoc) return null;
         def op = Inv.lookupOpener( "vw_building_permit_doc:open", [entity: selectedRefDoc] );
         op.target = "popup";
         return op;
    }
    
    def docListHandler = [
        fetchList: { o->
            return docList;
        },
        openItem: { o,col->
            return openRefDoc();
        }
    ] as BasicListModel;
    
    def reloadEntity() {
        def r = super.reloadEntity();
        reloadRefDocList();
        docListHandler.reload();
        return r;
    }
    
    
}