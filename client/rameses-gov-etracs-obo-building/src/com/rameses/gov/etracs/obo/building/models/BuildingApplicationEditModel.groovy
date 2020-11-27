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

class BuildingApplicationEditModel  {
    
    @Binding
    def binding;
    
    @Service("BuildingApplicationPersistenceService")
    def svc;
    
    def txnTypes = ["SIMPLE", "COMPLEX"];
    def appTypes = ["NEW", "RENEWAL", "AMENDMENT"];
    
    String title = "Building Permit Application (Manual Capture)";
    def entity;
    boolean askpermitissued = true;
    def mode = "create";
    
    void create() {
        entity = [:];
        entity.numunits = 1;
        entity.numfloors = 1;        
        entity.contact = [:];        
        entity.worktypes = [];
        entity.location = [:];
        entity.txnmode = "CAPTURE";
        entity.apptype = "NEW";
    }
    
    void createPermit() {
        create();
        askpermitissued = false;
        entity.permitissued = true;
    }
    
    void edit() {
        mode = "edit";
        askpermitissued = false;
        title = "Building Permit Application (Edit)";
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
        return Inv.lookupOpener("building_application_entity", p );
    }
    
    def viewLocation() {
        def p = [:];
        p.entity = entity.location;
        if( !p.entity ) p.entity = [:];
        p.handler = { o->
            entity.location = o;
            binding.refresh();
        }
        return Inv.lookupOpener("building_application_location", p);
    }
    
    public def save() {
        if(!MsgBox.confirm("You are about to save this application. Proceed?")) return;
        if( mode == "create") {
            entity = svc.create(entity);
            def op =  Inv.lookupOpener("vw_building_application:open", [entity: entity ] );
            op.target = "topwindow";
            return op;            
        }
        else {
            entity = svc.update(entity);
            return "_close";
        }
    }
    

    
}