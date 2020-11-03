package com.rameses.gov.etracs.obo.occupancy.models;

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

class OccupancyApplicationInitialModel  {

    @Service("OccupancyApplicationInitialService")
    def svc;
    
    @Service("BuildingPermitService")
    def bldgPermitSvc;
    
    
    def trackingno;
    def source = "web";
    
    @FormTitle
    String title = "New Occupancy Permit (Initial)";
    
    def entity;
    
    def create() {
        entity = [:];
        return "initial";
    }
    
    def next() {
        def v = null;
        if(source.matches("web|local")) {
            v = svc.getApplication( [appid: trackingno ] );
        }
        else if( source == "capture" ) {
            return "capture";
        }
        else {
            throw new Exception("File option not yet accepted!");
        }
        
        if(!v) throw new Exception("File not found");
        
        if(!MsgBox.confirm("You are about to upload this application. Proceed?")) {
            return null;
        };
        
        v = svc.create( v );
        def entity = [objid: v.objid ];
        def op = Inv.lookupOpener("vw_occupancy_application:open", [entity:entity] );  
        op.target = "topwindow";
        return op;
    }
    
    
    /******************
    * CAPTURE ROUTINES
    ******************/
    int capturestep = 1
    def bldgpermitno;
    boolean blocksearch = false;
    
    void doSearch() {
        entity.bldgpermit = bldgPermitSvc.findByPermitNo( [permitno:bldgpermitno]);
        blocksearch = true;
    }
    
    void resetSearch() {
        entity.bldgpermit = null;
        blocksearch = true;
        bldgpermitno = null;
    }
    
    void doCaptureNext() {
        capturestep++;
    }
    
    void doCaptureBack() {
        if(capturestep-1 <=0) return;
        capturestep--;
    }
    
    
}