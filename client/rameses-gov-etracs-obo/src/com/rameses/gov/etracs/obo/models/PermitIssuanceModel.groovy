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
    
    @Service(value="PersistenceService")
    def persistenceSvc;
    
    def entity;
    def handler;
   
    void init() {}
   
    def doOk() {
        def u = persistenceSvc.create( entity );
        if(handler) handler( u );
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}