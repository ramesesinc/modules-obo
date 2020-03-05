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

class BuildingEvaluationCreateModel {
    
    @Service("BuildingEvaluationService")
    def evalSvc;

    @Service("QueryService")
    def querySvc;
    
    @Caller 
    def caller;
    
    String title = "Add Evaluation";
    def selectedItem;
    
    def listHandler = [
        getColumns: {
            return [
                [name:"objid", caption:"Name"]  
            ];
        },
        fetchList: { o->
            def m = [_schemaname:"building_evaluation_type"];
            m.findBy = [activationstate: caller.task.state];
            return querySvc.getList( m );
        }
    ] as BasicListModel;
    
    def doOk() {
        if(!selectedItem?.objid) throw new Exception("Please select an item");
        def m = [typeid: selectedItem.objid, appno: caller.entity.appno ];
        evalSvc.create( m );
        caller.reload();
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}