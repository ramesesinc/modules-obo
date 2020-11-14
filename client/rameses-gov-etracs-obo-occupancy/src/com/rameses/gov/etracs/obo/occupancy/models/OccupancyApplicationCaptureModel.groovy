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
import com.rameses.gov.etracs.obo.models.*;

class OccupancyApplicationCaptureModel  {

    @Service("OccupancyApplicationCaptureService")
    def svc;
    
    def permitno;
    def entity;
    def page;
    
    def appTypes = ["FULL", "PARTIAL"];
    def txnTypes = ["SIMPLE","COMPLEX"];
    
    String title  = "New Occupancy Permit Application";
    
    def create() {
        entity = [:];
        page = "initial";
    }
    
    def next() {
        def permit = svc.findBldgPermit( [controlno: permitno] );
        if(!permit) throw new Exception("Building Permit not found");
        entity.bldgpermit = permit;
        page = "view";
        return page;
    }
    
    def back() {
        page = "initial";
        return page;
    }
    
    def save() {
        
    }
    
    
    
}