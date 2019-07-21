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
    
    
    def showOption = "showall";
    def query = [:];
    def evaluationHandler;
    def reqListHandler;
    
    @PropertyChangeListener
    def listener = [
        "showOption" : { o->
            if(o == "showunfinished") {
                query.where = " task.state NOT IN ('end', 'for-verification') ";
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
        return (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + "[ " +  task?.title + "]" ;
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
    
    def updateZoneclass() {
        def h = { zc ->
            def m = [_schemaname:'building_permit'];
            m.findBy = [objid: entity.objid ];
            m.zoneclassid = zc.objid;
            persistenceService.update(m);
            entity.zoneclass = zc;
            binding.refresh();
        }
        return Inv.lookupOpener("obo_zoneclass:lookup", [ onselect:  h] );
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
    
    public boolean isViewReportAllowed() {
        return true;
    }
}