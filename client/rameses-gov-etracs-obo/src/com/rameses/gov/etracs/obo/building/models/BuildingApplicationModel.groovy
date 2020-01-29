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


class BuildingApplicationModel extends AbstractApplicationModel {

    @Service("BuildingPermitAssessmentService")
    def feeSvc;
    
    public String getPermitName() {
        return "building_application";   
    }

    public def getFeeService() {
        return feeSvc;
    }
    
    public String getTitle() {
        return "Building Permit " + (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return "Bldg "+ (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    public boolean getShowAssessAction() {
        return true;
    }
    
    def ancillaryListModel;
    def lookupAncillary() {
        def h = { o->
            def v = [appid: entity.objid, items: o*.objid ]
            bldgSvc.addAncillary( v );
            ancillaryListModel.reload();
        }
        return Inv.lookupOpener("obo_ancillary:lookup", [onselect: h]);
    }
    
    def changeOccupancyType() {
        def h = { o->
            def u = [_schemaname: "building_application"];
            u.findBy = [objid: entity.objid];
            u.occupancytype = o;
            u.occupancytypeid = o.objid;
            persistenceService.update(u);
            entity.occupancytype = o;
            binding.refresh("entity.occupancytype");
        }
        return Inv.lookupOpener("vw_obo_occupancy_type:lookup", [onselect: h] );
    }
}


