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
    
   def viewAncillaryPermit() {
        if(!entity.ancillaryid ) 
            throw new Exception("There is no associated ancillary permit ");
        def op = Inv.lookupOpener("building_application_ancillary:open", [entity: [objid: entity.ancillaryid ] ] );
        op.target = "popup";
        return op;
    }
    
    //This is a temporary proc.
    def addAncillary() {
        def e = appSvc.addAncillary( [appid: entity.appid, typeid: entity.typeid ] );
        entity.ancillaryid = e.objid;
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
    
    def assess() {
        if(! entity.app.zoneclass?.objid )
            throw new Exception("Please specify a zone class first");
        return super.assess("building_evaluation:assessment");    
    }

    def addFee() {
        return super.addFee( "building_application_fee");
    }
    
    def addFinding() {
        return super.addFinding( "building_evaluation_finding");
    }
}