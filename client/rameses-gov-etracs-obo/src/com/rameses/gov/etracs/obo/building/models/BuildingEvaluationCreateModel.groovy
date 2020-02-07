package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.gov.etracs.obo.models.*;


class BuildingEvaluationCreateModel  {

    @Service("BuildingEvaluationService")
    def evalSvc;
    
    @Caller
    def caller;
    
    def typeid;
    def appno;
    
    void create() {
        typeid = caller.typeid;
    }
    
    def doOk() {
        def m = [:];
        m.appno = appno;
        m.typeid = typeid;
        evalSvc.create( m );
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}


