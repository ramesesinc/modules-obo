package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import com.rameses.enterprise.models.*;

public class OboIssuanceModel {
    
    @Service("OboIssuanceService")
    def issuanceSvc;
    
    def doctype;
    def entity;
    def appid;
    def handler;
    
    void init() {
        entity = [appid:appid];
    }
    
    def doOk() {
        def m = [:];
        m.doctypeid = doctype.objid;
        m.putAll( entity );
        entity = issuanceSvc.create( m );
        entity.issuanceid = entity.remove("objid");
        if(handler) handler(entity);
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}