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
    
    void checkCurrentOrg( def orgid ) {
        currentOrg = false;
        if(  orgid == userInfo.env.ORGID ) currentOrg = true;
        else if( orgid ==null && userInfo.env.ORGROOT == 1 ) currentOrg = true;
    }
    
    void afterOpen() {
        showChecklist = entity.showchecklist;
        showInfos = entity.showinfo;
        showFees = entity.showfees;
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
    
    /**************************************************************************
    * CHECKLIST ITEMS
    ***************************************************************************/
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
    
    def infoHandler = [
        /*
        getInfos: {
            return infoSvc.getInfos( [parentid: entity.objid ] );
        },
        */
        saveInfos: { items ->
            infoSvc.saveInfos( items );
        },
        removeInfos: { items ->
            infoSvc.removeInfos( items );
        },
        getLookupFilter: {
            return [typeid: entity.doctype.objid ]
        }
    ];
    
    def feeHandler = [
        saveFee: { o->
            feeSvc.saveFee( o );
        },
        saveFees: { o->
            feeSvc.saveFees( o );
        },
        removeFee: { o->
            feeSvc.removeFee( o );
        },
        clearFees: {
            feeSvc.clearFees( [parentid: entity.objid] );
        },
        getAccountLookupHandler: {
            return Inv.lookupOpener( "obo_itemaccount:type:lookup", ["query.doctypeid":entity.doctypeid ]);
        },
        getAssessHandlerName: {
            return "building_assessment";
        }
    ];
    
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
    
    
}