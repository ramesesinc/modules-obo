package com.rameses.gov.etracs.obo.occupancy.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;

class OccupancysPermitEditModel  {
    
    @Service("PersistenceService")
    def persistenceSvc;

    @Binding
    def binding;
    
    @Caller
    def caller;
    
    def txnTypes = ["SIMPLE", "COMPLEX"]; 
    def appTypes = ["FULL", "PARTIAL"]; 
    
    String title = "Occupancy Permit Edit Info";
    
    def entity;
    def editContext;
    
    @PropertyChangeListener
    def listener = [
        "entity.total(material|directlabor|equipment|other)cost" : { o->
            entity.actualprojectcost = entity.totalmaterialcost+entity.totaldirectlaborcost+entity.totalequipmentcost+entity.totalothercost;
            binding.refresh("entity.actualprojectcost");
        }
    ];
    
    void init(def inv) {
        editContext = inv.properties.context;
        def _old = entity;
        entity = [_schemaname:"occupancy_permit"];
        entity.objid = _old.objid;
        
        if(editContext == "txntype" ) {
            entity.txntype = _old.txntype;
        }
        else if(editContext == "apptype" ) {
            entity.apptype = _old.apptype;
        }
        else if(editContext == "occupancystate" ) {
            entity.occupancystate = _old.occupancystate;
        }        
        else if(editContext == "contact") {
            entity.contact = _old.contact;
        }
        else if(editContext == "project") {
            entity.bldgpermit = _old.bldgpermit;
            entity.actualnumunits = _old.actualnumunits;
            entity.actualnumfloors = _old.actualnumfloors;
            entity.actualtotalfloorarea = _old.actualtotalfloorarea;
            entity.actualheight = _old.actualheight;
            entity.totalmaterialcost = _old.totalmaterialcost;
            entity.totaldirectlaborcost = _old.totaldirectlaborcost;
            entity.totalequipmentcost = _old.totalequipmentcost;
            entity.totalotherpermit = _old.totalotherpermit;
            entity.actualprojectcost = _old.actualprojectcost;
            entity.dtactualstarted = _old.dtactualstarted;
            entity.dtactualcompleted = _old.actualcompleted;
        }
        else if(editContext == "supervisor") {
            entity.supervisor = _old.supervisor;
        }
        else if(editContext == "contractor") {
            entity.contractor = _old.contractor;
        }
        else if(editContext == "applicant") {
            entity.applicant = _old.applicant;
        }
        else if(editContext== "occupancytype" ) {
            entity.occupancytype = _old.occupancytype;            
        }
    }
    
    def lookupApplicant() {
        def p = [:];
        p.handler = { o->
            entity.applicant = o;
            binding.refresh();
        }
        if( entity.applicant ) {
            p.entity = entity.applicant;
            p.applicant = [name: entity.applicant.name ];            
        }
        else {
            p.entity = [:];
            p.applicant = null;
        }
        return Inv.lookupOpener("occupancy_permit_entity", p );
    }
    
    public void beforeSave( def o )  {
    }
    
    public def doOk() {
        if(!MsgBox.confirm("You are about to update the changes. Proceed?")) return null;
        persistenceSvc.update(entity);
        if(caller) caller.reloadEntity();
        return "_close";
    }
    
    public def doCancel() {
        return "_close";        
    }

    
}