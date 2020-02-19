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
import com.rameses.gov.etracs.obo.models.*;


class BuildingSubdocTypeModel extends CrudFormModel {
    
    def docTypes = ["ANCILLARY","CLEARANCE", "CHECKLIST", "MAIN", "OTHER"];
    def evalTypes;
    
    def itemHandler;

    @PropertyChangeListener
    def listener = [
        "entity.type" : { o->
            if(!o?.toString().toLowerCase().equals("checklist")) {
                entity.subtypeof = null;
            }
        }
    ];
    
    def _subTypes;
    public def getSubTypes() {
        if(_subTypes) return _subTypes;
        def m = [_schemaname: schemaName];
        m.where = ["type <> 'CHECKLIST' "];
        _subTypes = queryService.getList(m)*.objid;
        return _subTypes;
    }
    
    public void afterInit() {
        def m = [_schemaname: "building_evaluation_type"];
        m.where = ["1=1"];
        evalTypes = queryService.getList(m)*.objid;
    }
    
    def addFeeItem() {
        def h = { o->
            def m = [_schemaname:"building_doc_type_itemaccount"];
            m.typeid = entity.objid;
            m.itemid = o.objid;
            m.item = [objid: o.objid];
            persistenceService.create( m );
            itemHandler.reload();
        }
        def op = Inv.lookupOpener("obo_itemaccount:lookup", [onselect: h]);
        op.target = "popup";
        return op;
        
    }
    
}