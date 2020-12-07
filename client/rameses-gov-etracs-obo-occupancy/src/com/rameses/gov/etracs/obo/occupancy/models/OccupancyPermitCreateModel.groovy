package com.rameses.gov.etracs.obo.occupancy.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;

class OccupancyPermitCreateModel extends CrudFormModel {
    
    @Service("BuildingPermitService")
    def svc;
    
    def appTypes = ["FULL", "PARTIAL"];
    def txnTypes = ["SIMPLE","COMPLEX"];
    boolean hascontractor;
    
    def permitno;
    def txnmode;
    def taskstate;
    def page;
    
    String title = "Occupancy Permit Application (Manual Capture)";
    String schemaName = "vw_occupancy_permit";
    String entitySchemaName = "occupancy_permit";
    
    @PropertyChangeListener
    def listener = [
        "entity.total(material|directlabor|equipment|other)cost" : { o->
            entity.actualprojectcost = entity.totalmaterialcost+entity.totaldirectlaborcost+entity.totalequipmentcost+entity.totalothercost;
            binding.refresh("entity.actualprojectcost");
        }
    ];
    
    void afterCreate() {
        entity.contact = [:];
        entity.task = [state:taskstate];
        page = "initial";
    }
    
    def back() {
        page = "initial";
        return page;
    }
    
    def next() {
        def permit = svc.findByPermitNo( [permitno: permitno] );
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
        entity.txnmode = txnmode;
        page = "view";
        return page;
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
    
    def viewLocation() {
        def p = [:];
        p.entity = entity.location;
        if( !p.entity ) p.entity = [:];
        p.handler = { o->
            entity.location = o;
            binding.refresh();
        }
        return Inv.lookupOpener("occupancy_permit_location", p);
    }
    
    def editContractor() {
        def h = { o->
            entity.contractor = o;
            binding.refresh()
        }
        return Inv.lookupOpener("occupancy_contractor", [entity: entity.contractor, handler: h])
    }
    
    public void beforeSave( def o )  {
        if( !entity.applicant ) throw new Exception("Applicant is required");
        if( !entity.supervisor ) throw new Exception("supervisor is required");
    }
    
    public def save() {
        def res = super.save();
        if( res != null ) {
            def op =  Inv.lookupOpener("vw_occupancy_permit:open", [entity: entity ] );
            op.target = "topwindow";
            return op;                
        }
        return res;
    }
    

    
}