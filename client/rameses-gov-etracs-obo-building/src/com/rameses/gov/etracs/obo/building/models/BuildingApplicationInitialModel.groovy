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
import javax.swing.*;
import com.rameses.io.*;
import com.rameses.gov.etracs.obo.models.*;

class BuildingApplicationInitialModel  {

    @Service("BuildingApplicationInitialService")
    def svc;
    
    def trackingno;
    def source = "web";
    
    @FormTitle
    String title = "New Building Permit Application (Initial)";
    
    
    def next() {
        if(source.matches("web|local")) {
            def v = svc.getApplication( [appid: trackingno ] );
            if(!MsgBox.confirm("You are about to upload this application. Proceed?")) {
                return null;
            };
            v = svc.create( v );
            entity = [objid: v.objid ];            
            def op = Inv.lookupOpener("vw_building_application:open", [entity:entity] );  
            op.target = "topwindow";
            return op;
        }
        else if( source == "capture") {
            return Inv.lookupOpener( "building_application:create", [:] )
        }
        else {
            throw new Exception("File option not yet accepted!");
        }
    }
    
    
    
    
}