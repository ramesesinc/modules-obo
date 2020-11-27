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

class OccupancyPermitNewModel  {

    @Service("OccupancyPermitOnlineService")
    def svc;
    
    def trackingno;
    def source = "web";
    
    @FormTitle
    String title = "New Occupancy Permit (Initial)";
    
    def create() {
        return "initial";        
    }
    
    def next() {
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
        return Inv.lookupOpener("vw_occupancy_permit:open", [entity:entity] );       
    }
    
    
    
    
    
}