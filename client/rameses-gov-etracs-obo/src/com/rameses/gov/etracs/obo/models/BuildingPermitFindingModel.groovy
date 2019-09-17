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

class BuildingPermitFindingModel {

    @Service("OboFindingService")
    def findingSvc;

    @Caller
    def caller;

    def entity;

    void create() {
        entity = [:];
        if( caller.schemaName == "vw_building_permit") {
            entity.appid = caller.entity.objid;
        }
        else {
            entity.appid = caller.entity.appid;
            entity.parentid = caller.entity.objid;
        }
        entity.checked = 0;
    }
    
    void open() {
    }
    
    void afterSave(def o ) {
        if(caller) {
            caller.findingListHandler.reload();
        }
    }
    
    def doOk() {
        entity.tag = "building_permit_finding";
        findingSvc.save( entity );
        if(caller.findingListHandler ) {
            caller.findingListHandler.reload();
        }
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
    
}