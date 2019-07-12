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

class BuildingPermitRequirementModel extends CrudFormModel {

    def checked;
    def remarks;
    
    void afterInit() {
        checked = entity.checked;
        remarks = entity.remarks;
    }
    
    def updateReq() {
        def m = [_schemaname: getSchemaName() ];
        m.findBy = [objid: entity.objid];
        m.checked = checked;
        m.remarks = remarks;
        persistenceService.update( m );
        return "_close";
    }
    
    
}