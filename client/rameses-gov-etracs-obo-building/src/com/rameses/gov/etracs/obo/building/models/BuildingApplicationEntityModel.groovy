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

class BuildingApplicationEntityModel  {
    
    @Binding
    def binding;
    
    @Service("QueryService")
    def querySvc;
    
    def entityTypes = ["INDIVIDUAL", "CORPORATION", "MULTIPLE", "GOVERNMENT"];
    def entity;
    def idTypes;
    def applicant;
    def handler;
    boolean editable  = true;
    
    @PropertyChangeListener
    def listener = [
        "applicant" : { o->
            if( entity.entitytype == "INDIVIDUAL") {
                entity.name = applicant.name;
                entity.lastname = applicant.lastname;
                entity.firstname = applicant.firstname;
                entity.middlename = applicant.middlename;
                entity.address = applicant.address;
                entity.profileid = applicant.objid;
            }
            else {
                def etype = entity.entitytype;
                entity = [address:[:], id:[:]];
                entity.name = applicant.name;
                entity.profileid = applicant.objid;
                entity.entitytype = etype;
            }
            binding.refresh();
        },
        "entity.entitytype" : { o->
            applicant = null;
            entity = [:];
            entity.entitytype = o;
            binding.refresh();
        }
    ];
    
    def getEntityType() {
        if( entity.entitytype.matches("INDIVIDUAL|MULTIPLE")) {
            return entity.entitytype;
        }
        if( entity.entitytype == "GOVERNMENT") {
            return "juridical:gov";
        }
        else if(entity.entitytype == "CORPORATION") {
            return "juridical:corp";
        }
        else {
            return "juridical";
        }
    }
    
    void init() {
        def m = [_schemaname: "idtype"];
        m._limit = 100;
        idTypes = querySvc.getList( m );
        if( !entity ) {
            entity = [address:[:], id:[:]];
            entity.entitytype = entityTypes[0];  
        }
        else {
            entity.entitytype = entity.entitytype?.toUpperCase();
            if( entity.id?.type?.name ) {
                entity.id.type = idTypes.find{ it.name == entity.id.type.name };                
            }
        }
    }
    
    def doOk() {
        if( editable ) {
            if( entity.address.type == "local") {
                entity.resident = 1;
            }
            else {
                entity.resident = 0;
            }
            handler( entity );            
        }
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }

}