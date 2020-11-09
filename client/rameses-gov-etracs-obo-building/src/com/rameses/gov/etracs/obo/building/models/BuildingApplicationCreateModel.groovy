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

class BuildingApplicationCreateModel  {

    @Service("BuildingApplicationInitialService")
    def svc;
    
    def trackingno;
    def source = "web";
    def entity;
    
    @FormTitle
    String title = "New Building Permit (Initial)";
    
    def create() {
        return "initial";
    }
    
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
            entity = [location:[:], units:1];
            return "capture";
        }
        else {
            throw new Exception("File option not yet accepted!");
        }
    }
    
    @PropertyChangeListener
    def propListener = [
        "entity.applicant" : { o->
            o.each {k,v->
                println k+"="+v;
            }
            o.profiled = o.objid;
            o.remove("objid");
        }
    ]
    
    
    void saveNew() {
        if(!MsgBox.confirm("You are about to save this application. Proceed?")) return;
        svc.create( entity );
    }
    
    
    
    
}