package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.gov.etracs.obo.models.*;


class BuildingApplicationEditModel extends CrudFormModel {

    @PropertyChangeListener
    def listener = [
        "entity.applicant" : { o->
            entity.applicant.profileid = o.objid;
        }
    ];
    
    public def edit() {
        entity = caller.entity;
        super.open();
        return super.edit();
    }
    
    def unedit() {
        return "_close";
    }
    
    
    def save() {
        super.save();
        caller.reloadEntity();
        return "_close";
    }
    
}


