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

class BuildingPermitZoneClassificationModel  {

    @Service("PersistenceService")
    def persistenceService;
    
    def app;
    def entity;
    def handler;
    
    void init() {
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
        def m = [_schemaname:'building_permit'];
        m.findBy = [objid: app.objid ];
        m.zoneclass = entity.zoneclass;
        m.zoneclassid = entity.zoneclass.objid;
        m.zone = entity.zone;
        m = persistenceService.update(m);
        if( handler ) {
            handler( m );
        }
        return "_close";
        
    }
    
    public def doCancel() {
        return "_close";
    }
    
    
    
    
}