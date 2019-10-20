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

class BuildingPermitNewModel  {

    @Service("BuildingPermitOnlineService")
    def bpSvc;
    
    def trackingno;
    def source = "web";
    
    @FormTitle
    String title ="Building Permit Initial";
    
    def next() {
        def v = null;
        if(source.matches("web|local")) {
            v = bpSvc.getApplication( [appid: trackingno ] );
        }
        else {
            throw new Exception("File option not yet accepted!");
        }
        if(!v) throw new Exception("File not found");
        
        if(!MsgBox.confirm("You are about to upload this application. Proceed?")) {
            return null;
        };
        
        v = bpSvc.upload( v );
        def entity = [objid: v.objid ]
        return Inv.lookupOpener("vw_building_permit:open", [entity:entity] );       
    }
    
    def save() {
        
    }
    
    def create() {
        return "initial";
    }
    
}