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

class BuildingApplicationCaptureModel  {
    
    @Binding
    def binding;
    
    @Service("BuildingApplicationCaptureService")
    def svc;
    
    def txnTypes = ["SIMPLE", "COMPLEX"];
    def appTypes = ["NEW", "RENOVATION", "AMENDMENT"];
    
    String title = "Building Permit Application (Manual Capture)";
    def entity;
    boolean askpermitissued = true;
    
    void create() {
        entity = [:];
        entity.numunits = 1;
        entity.numfloors = 1;        
        entity.contact = [:];        
        entity.worktypes = [];
        entity.location = [:];
        entity.txnmode = "CAPTURE";
    }
    
    void createPermit() {
        create();
        askpermitissued = false;
        entity.permitissued = true;
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
    
    public def save() {
        if(!MsgBox.confirm("You are about to save this application. Proceed?")) return;
        entity = svc.create(entity);
        def op =  Inv.lookupOpener("vw_building_application:open", [entity: entity ] );
        op.target = "topwindow";
        return op;
    }
    

    
}