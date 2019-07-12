package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class BuildingPermitFindingModel extends CrudFormModel {

    def appid;
    def parentid;
    def handler;
    def statusList = ["APPROVED", "REVISION"];
    def categoryList = [];
    
    void afterInit() {
        categoryList << [ objid:'V1', title:'Improper Installation' ];
        categoryList << [ objid:'V2', title:'Encroachment of road' ];        
    }
    
    void afterCreate() {
        entity.appid = appid;
        entity.parentid = parentid;
    }
    
    void afterSave(def o ) {
        if(handler) handler(entity);
    }
    
    void changeStatus( def o ) {
        def m = [_schemaname: getSchemaName() ];
        m.findBy = [objid: entity.objid];
        m.status = o;
        persistenceService.update( m );
        entity.status = o;
        binding.refresh();
    }
    
    void approve() {
        changeStatus("APPROVED");
    }
    
    void revise() {
        changeStatus("FOR-REVISION");
    }
    
}