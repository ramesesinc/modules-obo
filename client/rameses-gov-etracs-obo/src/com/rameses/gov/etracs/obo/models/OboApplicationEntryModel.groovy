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

class OboApplicationEntryModel extends PageFlowController {
    
    @Service("OboApplicationService")
    def appService;
    
    @Service("QueryService")
    def queryService;

    def entity;
    def sections;
    def appTypes = ["NEW", "RENEW","ADDITIONAL"];
    
    void initNew() {
        entity = [subapplications:[]];
        def m = [_schemaname:'obo_section'];
        m._limit = 1000;
        m.orderBy = "idx";
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
            [sectionid: it.objid]
        }
        appService.create( entity );
    }
    
}