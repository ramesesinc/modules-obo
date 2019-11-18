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

class BuildingPermitSectionModel extends AbstractOboApplicationSectionModel {

    @Service("BuildingPermitSectionService")
    def appSvc;
    
    public String getPermitName() {
        return "building_permit";
    }
    
    public String getCaption() {
        return "Building Permit";
    }
    
    public String getPrefix() {
        return "BP";
    }

    def viewAncillaryPermit() {
        if(!entity.ancillaryid ) 
            throw new Exception("There is no associated ancillary permit ");
        def op = Inv.lookupOpener("building_permit_ancillary:open", [entity: [objid: entity.ancillaryid ] ] );
        op.target = "popup";
        return op;
    }

    def assess() {
        if(! entity.app.zoneclass?.objid )
            throw new Exception("Please specify a zone class first");
        return super.assess();    
    }
    
    def updateZoneclass() {
        def app = [objid: entity.appid, zoneclass: entity.app.zoneclass, zone: entity.app.zone ];
        def h = { o->
            entity.app.zoneclass = o.zoneclass;
            entity.app.zone = o.zone;
            binding.refresh("entity.app.zone.*");
        }
        return Inv.lookupOpener("building_permit_zoneclass:view", [app: app, handler: h ] );
    }
    
    public boolean isActionable() {
        return (task.assignee.objid == userInfo.userid);
    }
    
}