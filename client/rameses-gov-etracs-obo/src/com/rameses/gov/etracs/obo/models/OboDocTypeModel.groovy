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
import com.rameses.gov.etracs.obo.models.*;


class OboDocTypeModel extends CrudFormModel {
    
    def docTypes = ["MAIN", "ANCILLARY","CLEARANCE", "CERTIFICATE", "CHECKLIST",  "OTHER"];
    def appTypes = ["building", "occupancy"];
    def sectionList;
    
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
        def m = [_schemaname: "obo_section"];
        m.where = ["1=1"];
        sectionList = queryService.getList(m);
    }
    
    
}