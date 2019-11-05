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
    
    def showOption = "showall";
    def query = [:];
    def evaluationHandler;
    def reqListHandler;
    def findingListHandler;
    def receipt;
    
    @PropertyChangeListener
    def listener = [
        "showOption" : { o->
            if(o == "showunfinished") {
                query.where = " task.state IN ('evaluation', 'review', 'approval' ) ";
            }
            else if(o == "showfinished") {
                query.where = " task.state = 'end' ";
            }            
            else {
                query.remove("where");                
            }
            evaluationHandler.reload();            
        }
    ]
    
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
    
    public void afterInit() {
        query.objid = entity.objid;
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
    
    void receive() {
        if(!MsgBox.confirm("You are about to receive this application. Proceed?")) return;
        def o = bldgSvc.generateAppNo( [appid: entity.objid ] );
        entity.putAll( o );
        MsgBox.alert("App no " + o.appno + " is successfully generated");
    }
    
    def printAck() {
        return Inv.lookupOpener("building_permit_claimstub", [entity: [objid: entity.objid] ]);
    }
    
    def printReqChecklist() {
        return Inv.lookupOpener("building_permit_requirement_checklist", [entity: [objid: entity.objid] ]);
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