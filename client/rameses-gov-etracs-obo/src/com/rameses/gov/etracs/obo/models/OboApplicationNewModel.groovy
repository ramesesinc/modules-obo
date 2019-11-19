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
import javax.swing.*;
import com.rameses.io.*;

class OboApplicationNewModel  {

    @Service("BuildingPermitOnlineService")
    def bpSvc;
    
    @Service("OccupancyPermitOnlineService")
    def occSvc;
    
    def trackingno;
    def source = "web";
    def schemaName;
    
    @FormTitle
    String title ;
    
    def createBldgPermit() {
        title = "New Building Permit (Initial)";
        schemaName = "vw_building_permit";
        return "initial";
    }
    
    def createOccupancyPermit() {
        title = "New Occupancy Permit (Initial)";
        schemaName = "vw_occupancy_permit";
        return "initial";        
    }
    
    def next() {
        def svc = (schemaName == "vw_building_permit") ? bpSvc : occSvc;
        
        def v = null;
        if(source.matches("web|local")) {
            v = svc.getApplication( [appid: trackingno ] );
        }
        else {
            throw new Exception("File option not yet accepted!");
        }
        if(!v) throw new Exception("File not found");
        
        if(!MsgBox.confirm("You are about to upload this application. Proceed?")) {
            return null;
        };
        
        v = svc.upload( v );
        def entity = [objid: v.objid ];
        return Inv.lookupOpener(schemaName + ":open", [entity:entity] );       
    }
    
    
    
    
    
}