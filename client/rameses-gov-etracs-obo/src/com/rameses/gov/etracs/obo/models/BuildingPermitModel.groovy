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

    @Service("BuildingPermitFeeService")
    def feeSvc;
    
    @Service("BuildingPermitService")
    def bldgSvc;
    
    @Service("BuildingPermitRequirementService")
    def reqSvc;
    
    def showOption = "showall";
    def query = [:];
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
                sectionQry.where = sectionQry._filter +  " AND task.state IN ('evaluation', 'review', 'approval' ) ";
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
        reqQuery.appid = entity.objid;
        reqQuery._filter = "appid = :appid AND supersederid IS NULL";
        reqQuery.where = reqQuery._filter;   
        
        sectionQry.appid = entity.objid;
        sectionQry._filter = "appid = :appid ";
        sectionQry.where = sectionQry._filter;
        
        findingQry.appid = entity.objid;
        findingQry._filter = "appid = :appid AND supersederid IS NULL";
        findingQry.where = findingQry._filter;
    }
    
    public void afterInit() {
        query.objid = entity.objid;
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
    
   
    
    def feeListModel = [
        fetchList: { o->
            return feeSvc.getFees( [appid: entity.objid ] );
        }
    ] as BasicListModel;
    
    /**************************************************************************
    * requirement-verification actions
    ***************************************************************************/
    void acceptApplication() {
        if(!MsgBox.confirm("You are about to receive this application. Proceed?")) return;
        def o = bldgSvc.generateAppNo( [appid: entity.objid ] );
        entity.putAll( o );
        MsgBox.alert("App no " + o.appno + " is successfully generated");
    }
    
    def printClaimstub() {
        def p = [:];
        p.put("query.objid", entity.objid );
        return Inv.lookupOpener("building_permit_claimstub", p );
    }
    
    void transmitApplication() {
        bldgSvc.transmitApplication( [appid: entity.objid ]);
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
    
    void transmitChecklist() {
        reqSvc.transmitCheckList( [transmittalid: entity.reqtransmittalid ]);
    }
    
    def printReqChecklist() {
        def p = [:];
        p.put("query.transmittalid", entity.reqtransmittalid );
        return Inv.lookupOpener("building_permit_requirement_checklist", p );
    }

    /**************************************************************************
    * assessment actions
    ***************************************************************************/
    void assess() {
        def result  = feeSvc.assess( [appid: entity.objid ] );
        entity.amount = result.amount;
        feeListModel.reload();
        binding.refresh("entity.amount");
    }
    
    void clearAssessment() {
        def result = feeSvc.clearAssessment( [appid: entity.objid ] );
        entity.amount = result.amount;
        feeListModel.reload();
        binding.refresh("entity.amount");
    }
    
    
    def issuePermit() {
        def m = [appid:entity.objid];
        m.handler = { o->
            entity.permit = o;
            reload();
        }
        return Inv.lookupOpener("building_permit_issuance:create", m );
    }
    
    
    
    
}