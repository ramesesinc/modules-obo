package com.rameses.gov.etracs.obo.rpt.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import com.rameses.enterprise.models.*;

public class LookupBuildingPermitModel {
    
    @Service("BuildingPermitService")
    def buildingPermitSvc;

    def permitno;
    def entity;
    def onselect;

    def init() {
       return "default"; 
    }
    
    def searchPermitNo() {
        entity = buildingPermitSvc.findByPermitNo( [_show_minial:true, permitno: permitno ] );
        if(entity.state!=2) throw new Exception("This permit is not yet released");
        return "view";
    }
    
    def doCancel() {
        return "_close";
    }
    
    def doOk() {
        onselect( entity );
        return "_close";
    }
    
    def viewFullInfo() {
        def op = Inv.lookupOpener( "vw_building_permit:open", [entity: [objid: entity.objid ] ] );
        if( op== null) throw new Exception("Handler vw_building_permit:open not found");
        return op;
    }
}