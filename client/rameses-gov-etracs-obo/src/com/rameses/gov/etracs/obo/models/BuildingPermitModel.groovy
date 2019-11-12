package com.rameses.gov.etracs.obo.models;

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


class BuildingPermitModel extends WorkflowTaskModel {

    @Service("BuildingPermitAssessmentService")
    def feeSvc;
    
    @Service("BuildingPermitService")
    def bldgSvc;
    
    @Service("BuildingPermitRequirementService")
    def reqSvc;
    
    @Service("BuildingPermitFindingService")
    def findingSvc;
    
    @Service("BuildingPermitRptService")
    def rptSvc;
    
    @Service("BuildingPermitIssuanceService")
    def issuanceSvc;
    
    def receipt;
    
    def reqViewType = "all";
    def reqQuery = [:];
    def reqListHandler;
    
    def sectionView = "all";
    def sectionQry = [:];
    def sectionListHandler;
    
    def findingView = "all"
    def findingQry = [:];
    def findingListHandler;

    def feeQry = [:];
    def feeListHandler;
    
    def ancillaryListModel;
    
    @PropertyChangeListener
    def listener = [
        "reqViewType": { o->
            //this is the entire filter for requirements
            if (o == "open") {
                reqQuery.where = reqQuery._filter + " AND state IN (0,2) ";
            }
            else if( o == "applicable") {
                reqQuery.where = reqQuery._filter + " AND state <> 3 ";                
            }
            else {
                reqQuery.where = reqQuery._filter;
            }
            reqListHandler.reload();
        },
        "sectionView" : { o->
            if(o == "open") {
                sectionQry.where = sectionQry._filter +  " AND NOT(task.state = 'end' )";
            }
            else if(o == "closed") {
                sectionQry.where = sectionQry._filter +  " AND task.state = 'end' ";
            }            
            else {
                sectionQry.where = sectionQry._filter;                
            }
            sectionListHandler.reload();           
        },
        "findingView" : { o->
            findingListHandler.reload();
        }
    ];
    
    void buildQuery()  {
        sectionQry.appid = entity.objid;
        sectionQry._filter = "appid = :appid";
        sectionQry.where = sectionQry._filter;
        
        reqQuery.appid =  entity.objid;
        reqQuery._filter = "appid = :appid AND supersederid IS NULL";
        reqQuery.where = reqQuery._filter; 
        
        findingQry.appid = entity.objid;
        findingQry._filter = "appid = :appid AND supersederid IS NULL AND transmittalid IS NULL";
        findingQry.where = findingQry._filter;
        
        feeQry.appid = entity.objid;
        feeQry.where  = "appid = :appid";
    }
    
    public void afterInit() {
        buildQuery();
    }
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    String getBarcodeFieldname() {
        return "appno";
    }
    
    public String getTitle() {
        return (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    public boolean getShowAssessAction() {
        return true;
    }
    
    public boolean getShowUpdateZoneclass() {
        return (task.state == "zoning-evaluation");
    }
    
    /**************************************************************************
    * requirement-verification actions
    ***************************************************************************/
    void acceptApplication() {
        if(!MsgBox.confirm("You are about to receive this application. Proceed?")) return;
        def o = bldgSvc.accept( [appid: entity.objid ] );
        entity.putAll( o );
        MsgBox.alert("App no " + o.appno + " is successfully generated");
    }
    
    def printClaimstub() {
        def p = [:];
        p.put("query.objid", entity.objid );
        return Inv.lookupOpener("building_permit_claimstub", p );
    }
    
    def sendClaimstub() {
        return Inv.lookupOpener("obo_mailer:claimstub", [entity:entity]);
    }
        
    void buildRequirementChecklist() {
        if( !MsgBox.confirm("You are about to finalize the requirement checklist. You cannot undo this transaction. Proceed?") ) return;
        def t = reqSvc.buildCheckList( [appid: entity.objid, taskid: task.taskid ]);
        entity.reqtransmittalid = t.objid;
    }
    
    void removeChecklist() {
        if( !MsgBox.confirm("You are about to remove this checklist. Proceed?") ) return;
        def t = reqSvc.removeCheckList( [transmittalid: entity.reqtransmittalid ]);
        entity.reqtransmittalid = null;        
    }
    
    def printReqChecklist() {
        def p = [:];
        p.put("query.transmittalid", entity.reqtransmittalid );
        return Inv.lookupOpener("building_permit_requirement_checklist", p );
    }
    
    def sendReqChecklist() {
        return Inv.lookupOpener("obo_mailer:reqchecklist", [entity:entity]);
    }
    
    /**************************************************************************
    * coordinator actions
    ***************************************************************************/
    void buildFindingChecklist() {
        if( !MsgBox.confirm("You are about to finalize the findings checklist. You cannot undo this transaction. Proceed?") ) return;
        def t = findingSvc.buildCheckList( [appid: entity.objid, taskid: task.taskid ]);
        entity.transmittalid = t.objid;
    }
    
    def printFindingChecklist() {
        def p = [:];
        p.put("query.transmittalid", entity.transmittalid );
        return Inv.lookupOpener("building_permit_finding_checklist", p );
    }
    
    def sendFindingChecklist() {
        return Inv.lookupOpener("obo_mailer:findingchecklist", [entity:entity]);
    }

    def lookupAncillary() {
        def h = { o->
            def v = [appid: entity.objid, items: o*.objid ]
            bldgSvc.addAncillary( v );
            ancillaryListModel.reload();
        }
        return Inv.lookupOpener("obo_ancillary:lookup", [onselect: h]);
    }

    /**************************************************************************
    * assessment actions
    ***************************************************************************/
    def assess() {
        def f = [:];
        f.appid = entity.objid;
        def h  = { u->
            feeListHandler.reload();
            entity.amount = u.amount;
            binding.refresh("entity.amount")
        }
        return Inv.lookupOpener("building_permit_assessment", [params: f, handler: h] );
    }
    
    def addFee() {
        def m = [appid: entity.objid ];
        m.handler = { o->
            feeListHandler.reload();
        }
        return Inv.lookupOpener("building_permit_fee:create", m );
    }
    
    def clearFees() {
        def u = feeSvc.clearFees( [appid: entity.objid ] );
        entity.amount = u.amount;
        feeListHandler.reload();
    }
    
    def startRelease() {
        def p = issuanceSvc.startRelease( [appid: entity.objid ] );
        MsgBox.alert("Released");
    }
    
    /**************
    * RPT Clearances
    **************/
    def selectedRpu;
    void issueTrueCopy() {
        rptSvc.issueTrueCopy([appid: entity.objid] );
    }

    def viewClearance() {
        if(!selectedRpu) throw new Exception("Please select an RPU Entry");
        
        def op= Inv.lookupOpener("tdtruecopy:open", [entity: [objid: selectedRpu.certid ]] );
        File f = new File("tdprint.pdf")
        op.handle.report.exportToPDF( f );
        op.target = "popup";
        return op;
    }
    
    
}


