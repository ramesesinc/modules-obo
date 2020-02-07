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
import com.rameses.gov.etracs.obo.models.*;

class BuildingEvaluationModel extends AbstractApplicationSectionModel {
    
    def doclistModel;
    
    public String getCaption() {
        return "Building Evaluation";
    }
    
    public String getPrefix() {
        return "BE";
    }
    
    def viewApplication() {
        String s = "vw_building_application:open"; 
        def op = Inv.lookupOpener(s, [entity: [objid: entity.appid ] ] );
        op.target = "popup";
        return op;
    }
    
    //This is a temporary proc.
    def addAncillary() {
        def m = [_schemaname: "building_application_subdoc"];
        m.appid = entity.appid;
        m.typeid = entity.typeid;
        def z = persistenceService.create( m );
        entity.ancillaryid = z.objid;
        reload();
    }
    
    def updateZoneclass() {
        def app = [objid: entity.appid, zoneclass: entity.app.zoneclass, zone: entity.app.zone ];
        def h = { o->
            entity.app.zoneclass = o.zoneclass;
            entity.app.zone = o.zone;
            binding.refresh("entity.app.zone.*");
        }
        return Inv.lookupOpener("building_application_zoneclass:view", [app: app, handler: h ] );
    }
    
    
    def addFinding() {
        return super.addFinding( "building_evaluation_finding");
    }
}