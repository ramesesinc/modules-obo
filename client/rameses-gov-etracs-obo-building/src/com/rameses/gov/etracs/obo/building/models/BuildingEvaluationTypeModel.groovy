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


class BuildingEvaluationTypeModel extends CrudFormModel {

    def activationStates = ["zoning-evaluation", "trade-evaluation"];
    def selectedItem;
    def sectionList;
    
    def stateList;
    
    void afterInit() {
        //load states
        def m = [_schemaname:"sys_wf_node"];
        m.where = ["processname='building_evaluation' AND nodetype='state' AND tracktime=1 "]
        m.select = "name";
        m.orderBy = "idx";
        stateList = queryService.getList(m)*.name;
        
        //load sections
        def m1 = [_schemaname: "obo_section"];
        m1.where = ["1=1"];
        sectionList = queryService.getList(m1);
    }
    
    
    def roleListModel = [
        fetchList: { o->
            return entity.customroles;
        },
        isColumnEditable: { item, colname ->
            return ( mode != "read");
        },
        createItem: {
            return [typeid: entity.objid];
        },
        addItem: { o->
            addItem("customroles", o);
        }
    ] as EditorListModel;
    
    void removeRole() {
        if( !selectedItem ) throw new Exception("Please select an item to remove");
        removeItem("customroles", selectedItem );
    }
    
}