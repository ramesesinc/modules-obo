package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class BuildingZoneClassificationModel  {

    @Service("PersistenceService")
    def persistenceService;
    
    @Caller
    def caller;
    
    def app;
    def entity;
    
    void init(def inv) {
        if(inv.properties.parent == "building_evaluation") {
            def p = caller.entity;
            app = [objid: p.appid, zoneclass: p.app.zoneclass, zone: p.app.zone, infoid: p.app.infoid ];
        }
        entity = [:];
        entity.zoneclass = app.zoneclass;
        entity.zone = app.zone;
    }
    
    def getLookupZoneclass() {
        def h = { zc ->
            entity.zoneclass = zc;
        }
        return Inv.lookupOpener("obo_zoneclass:lookup", [ onselect:  h] );
    }
    
    public def doOk() {
        def m = [_schemaname:'building_info'];
        m.findBy = [objid: app.infoid ];
        m.zoneclass = entity.zoneclass;
        m.zoneclassid = entity.zoneclass.objid;
        m.zone = entity.zone;
        m = persistenceService.update(m);
        caller.reloadEntity();
        return "_close";
    }
    
    public def doCancel() {
        return "_close";
    }
    
    
    
    
}