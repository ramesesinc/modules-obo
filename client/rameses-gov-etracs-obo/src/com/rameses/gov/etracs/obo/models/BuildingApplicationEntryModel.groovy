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

class BuildingApplicationEntryModel extends PageFlowController {
    
    @Service("OboBuildingApplicationService")
    def appService;
    
    @Service("QueryService")
    def queryService;

    def entity;
    def sections;
    def appTypes = ["NEW", "RENEW","ADDITIONAL"];
    def workTypes = ["NEW CONSTRUCTION", "ADDITION", "RENOVATION", "ALTERATION", "DEMOLITION", "OTHER"];
    
    void initNew() {
        entity = [subapplications:[], numunits: 1];
        def m = [_schemaname:'obo_subapplication_type'];
        m.where = ["required = 0 "];
        m._limit = 1000;
        m.orderBy = "sortindex";
        sections = queryService.getList(m);
    }
    
    def sectionList = [
        isMultiSelect: {
            return true;
        },
        fetchList: { o->
            sections;
        }
    ] as BasicListModel;
    
    void save() {
        if( !sectionList.selectedValue )
            throw new Exception("Please select at least one permit to apply")
        entity.subapplications = sectionList.selectedValue.collect{
            [typeid: it.objid]
        }
        entity = appService.create( entity );
    }
    
    public def onComplete() {
        def op =  Inv.lookupOpener("vw_obo_building_application:open", [entity: entity ] );
        op.target = "topwindow";
        return op;
    }
    
}