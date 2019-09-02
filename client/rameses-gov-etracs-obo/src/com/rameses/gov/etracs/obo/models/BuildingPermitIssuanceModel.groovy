package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import com.rameses.enterprise.models.*;

public class BuildingPermitIssuanceModel {
    
    @Service(value="BuildingPermitIssuanceService")
    def permitSvc;
    
    @Caller
    def caller;
    
    def handler;
    def app;
    def entity;
    
    void create() {
        entity = [:];
        app = caller.entity;
        entity.txnmode = app.txnmode;
        entity.appid = app.objid;
    }
    
    def doOk() {
        def pmt = permitSvc.create( entity );
        app.permitid = pmt.objid;
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}