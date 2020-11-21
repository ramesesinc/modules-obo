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

class OccupancyApplicationEditModel  {

    @Service("OccupancyApplicationPersistenceService")
    def svc;
    
    @Binding
    def binding;
    
    def permitno;
    def entity;
    def page;
    boolean hascontractor;
    
    def appTypes = ["FULL", "PARTIAL"];
    def txnTypes = ["SIMPLE","COMPLEX"];
    
    String title  = "New Occupancy Permit Application";
    
    @PropertyChangeListener
    def listener = [
        "entity.total(material|directlabor|equipment|other)cost" : { o->
            entity.actualprojectcost = entity.totalmaterialcost+entity.totaldirectlaborcost+entity.totalequipmentcost+entity.totalothercost;
            binding.refresh("entity.actualprojectcost");
        }
    ]
    
    
    def create() {
        entity = [contact:[:]];
        page = "initial";
    }
    
    def next() {
        def permit = svc.findBldgPermit( [controlno: permitno] );
        if(!permit) throw new Exception("Building Permit not found");
        entity.bldgpermit = permit;
        entity.txntype = permit.txntype;
        entity.applicant = permit.applicant;
        entity.occupancytype = permit.occupancytype;
        entity.actualnumunits = permit.numunits;
        entity.actualnumfloors = permit.numfloors;
        entity.actualtotalfloorarea = permit.totalfloorarea;
        entity.actualheight = permit.height;
        entity.supervisor = permit.supervisor;
        entity.totalmaterialcost = 0;
        entity.totaldirectlaborcost = 0;
        entity.totalequipmentcost = 0;
        entity.totalothercost = 0;
        entity.actualprojectcost = 0;
        page = "view";
        return page;
    }
    
    def back() {
        page = "initial";
        return page;
    }
    
    def save() {
        if(!MsgBox.confirm("You are about to create this application. Proceed?")) return null;
        def e = svc.create( entity );
        def op = Inv.lookupOpener("vw_occupancy_application:open", [entity:e]);
        op.target = "topwindow";
        return op;
    }
    
    def editContractor() {
        def h = { o->
            entity.contractor = o;
            binding.refresh()
        }
        return Inv.lookupOpener("occupancy_contractor", [entity: entity.contractor, handler: h])
    }
    
    
}