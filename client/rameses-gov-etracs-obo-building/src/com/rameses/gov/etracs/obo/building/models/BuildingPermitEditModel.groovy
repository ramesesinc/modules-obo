package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;

class BuildingPermitEditModel  {
    
    @Service("PersistenceService")
    def persistenceSvc;

    @Binding
    def binding;
    
    @Caller
    def caller;
    
    def txnTypes = ["SIMPLE", "COMPLEX"];    
    
    String title = "Building Permit Application (Edit Info)";
    
    def entity;
    def editContext;
    
    void init(def inv) {
        editContext = inv.properties.context;
        def _old = entity;
        entity = [_schemaname:"building_permit"];
        entity.objid = _old.objid;
        
        if(editContext == "txntype" ) {
            entity.txntype = _old.txntype;
        }
        else if(editContext == "contact") {
            entity.contact = _old.contact;
        }
        else if(editContext == "project") {
            entity.title = _old.title;
            entity.description = _old.description;
            entity.location = _old.location;
            entity.numunits = _old.numunits;
            entity.numfloors = _old.numfloors;
            entity.totalfloorarea = _old.totalfloorarea;
            entity.height = _old.height;
            entity.worktypes = _old.worktypes;
            entity.supervisor = _old.supervisor;
            entity.projectcost = _old.projectcost;
            entity.dtproposedconstruction = _old.dtproposedconstruction;
            entity.dtexpectedcompletion = _old.dtexpectedcompletion;
        }
        else if(editContext == "applicant") {
            entity.applicant = _old.applicant;
        }
        else if(editContext== "occupancytype" ) {
            entity.occupancytype = _old.occupancytype;            
        }
        else if(editContext == "zoneclass" ) {
            entity.zone = _old.zone; 
            entity.zoneclass = _old.zoneclass;             
        }
        else if(editContext == "zoning_zoneclass" ) {
            entity.objid = _old.appid;
            entity.zone = _old.app.zone; 
            entity.zoneclass = _old.app.zoneclass;             
        }
    }
    
    
    def selectWorkTypes() {
        def p = [:];
        p.onselect = { v->            
            entity.worktypes = v*.objid;
            binding.refresh();
        }
        p.query = [typeid: "BUILDING_PERMIT"];
        return Inv.lookupOpener( "obo_work_type:lookup", p );
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
        return Inv.lookupOpener("building_permit_entity", p );
    }
    
    def viewLocation() {
        def p = [:];
        p.entity = entity.location;
        if( !p.entity ) p.entity = [:];
        p.handler = { o->
            entity.location = o;
            binding.refresh();
        }
        return Inv.lookupOpener("building_permit_location", p);
    }
    
    public void beforeSave( def o )  {
        //if( !entity.applicant ) throw new Exception("Applicant is required");
        //if( !entity.location ) throw new Exception("Location is required");
        //if( !entity.worktypes ) throw new Exception("At least one worktype is required");
       // if( !entity.supervisor ) throw new Exception("supervisor is required");
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