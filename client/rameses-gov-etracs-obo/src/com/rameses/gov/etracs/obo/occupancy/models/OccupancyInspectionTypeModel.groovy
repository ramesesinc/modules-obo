package com.rameses.gov.etracs.obo.occupancy.models;

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


class OccupancyInspectionTypeModel extends CrudFormModel {

    def activationStates = ["inspection"];
   
    def selectedItem;
    def stateList;
    
    void afterInit() {
        def m = [_schemaname:"sys_wf_node"];
        m.where = ["processname='occupancy_inspection' AND nodetype='state' AND tracktime=1 "]
        m.select = "name";
        m.orderBy = "idx";
        stateList = queryService.getList(m)*.name;
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