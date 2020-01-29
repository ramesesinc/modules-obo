package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import com.rameses.enterprise.models.*;

public class PermitIssuanceModel {
    
    def showcontrolno = true;
    /*
    @Service(value="PersistenceService")
    def persistenceSvc;
    
    @Service("BuildingPermitService")
    def bldgPermitSvc;
    
    @Caller
    def caller;
    
    def entity;
    def handler;
    def txntype;
   
    //This is a flag to allow showing of control and validity date
    boolean showcontrolno = true;
    
    void init() {
        
    }
   
    void initBldgPermit() {
        entity = [:];
        txntype = "building_application";
        showcontrolno = false;
    }
    
    def doOk() {
        if(txntype == "building_application") {
            entity.objid = caller.entity.objid;
            def u = bldgPermitSvc.updatePermitNo( entity );
            caller.entity.putAll(u);
            caller.reload();
            return "_close";
        }
        else {
           def u = persistenceSvc.create( entity );
           if(handler) handler( u );
           return "_close";
        }
    }
    
    def doCancel() {
        return "_close";
    }
    */
    def entity;
    def handler;
    
    def doOk() {
        if(handler) handler(entity);
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}