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
    def appid;
    def evaluationid;
    def entity;
    def typeid;
    
    boolean showpermitno = false;
    
    void create() {
        if( caller.entity.txnmode == 'CAPTURE' ) {
            showpermitno = true;
        }
        entity = [:];
        entity.txnmode = caller.entity.txnmode;
        entity.appid = appid;
        entity.evaluationid = evaluationid;
        entity.typeid = typeid;
    }
    
    def doOk() {
        def pmt = permitSvc.create( entity );
        if(handler) handler( pmt );
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}