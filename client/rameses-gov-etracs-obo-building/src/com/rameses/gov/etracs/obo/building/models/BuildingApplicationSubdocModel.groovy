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
    boolean showFees;
    boolean canIssue;
    boolean manualIssue;
    boolean canPrint;
    boolean currentOrg = false;
    
    boolean showOtherDocs = false;
    def docList;
    
    def worktypetext;
    
    void toggleOtherDocs() {
        showOtherDocs = !showOtherDocs;
    }
    
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
        
        
        if(!docList) {
            def m = [_schemaname: "vw_building_permit_doc"];
            m.findBy = [ appid: entity.appid ];
            if( entity.doctype.org?.objid !=null ) {
                m.where = ["doctype.org.objid = :orgid", [orgid: entity.doctype.org?.objid ]];
            }
            else {
                m.where = ["doctype.org.objid IS NULL"];
            }
            docList = queryService.getList( m );
        }
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
    
    def issueControl() {
        def p = [:];
        p.handler = { o->
            entity.putAll( o );
            binding.refresh();
        }
        p.doctype = entity.doctype;
        p.appid = entity.objid;
        return Inv.lookupOpener("obo_issuance", p );
    }
    
    
}