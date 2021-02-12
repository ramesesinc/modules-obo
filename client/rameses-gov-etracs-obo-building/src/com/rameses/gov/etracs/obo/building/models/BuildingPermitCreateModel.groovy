package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;

class BuildingPermitCreateModel extends CrudFormModel {
    
    def txnTypes = ["SIMPLE", "COMPLEX"];
    def appTypes = ["NEW", "RENEWAL", "AMENDMENT"];
    def txnmode;
    def taskstate;
    
    String title = "Building Permit Application (Manual Capture)";
    String schemaName = "vw_building_permit";
    String entitySchemaName = "building_permit";
    
    void afterCreate() {
        entity.numunits = 1;
        entity.numfloors = 1;        
        entity.contact = [:];  
        entity.supervisor = [prc:[:],ptr:[:],id:[:]];
        entity.worktypes = [];
        entity.location = [:];
        entity.txnmode = txnmode;
        if(taskstate) entity.task = [state:taskstate];
        entity.apptype = "NEW";
    }
    
    boolean getShowZoning() {
        if( entity.txnmode == 'CAPTURE' ) {
            return (!entity.task?.state?.matches('receiving|requirement-verification') );
        }
        else {
            return false;
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
        if( !entity.applicant ) throw new Exception("Applicant is required");
        if( !entity.location ) throw new Exception("Location is required");
        if( !entity.worktypes ) throw new Exception("At least one worktype is required");
        if( !entity.supervisor ) throw new Exception("supervisor is required");
    }
    
    public def save() {
        def res = super.save();
        if( res != null ) {
            def op =  Inv.lookupOpener("vw_building_permit:open", [entity: entity ] );
            op.target = "topwindow";
            return op;                
        }
        return res;
    }
    
    
}