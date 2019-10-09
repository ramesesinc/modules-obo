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

class BuildingPermitRequirementModel {

    
    @Service("OboFindingService")
    def findingSvc;

    @Invoker
    def invoker;
    
    @Caller
    def caller;

    def entity;

    void open() {
    }
    
    def doOk() {
        if( entity.checked == null ) 
            throw new Exception("Please status");
        entity.tag = "building_permit_requirement";
        findingSvc.save( entity );
        caller.reqListHandler.reload();
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}