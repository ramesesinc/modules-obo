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
   
    def selectedItem;
    def sectionList;

    void afterInit() {
         //load sections
        def m = [_schemaname: "obo_section"];
        m.where = ["1=1"];
        sectionList = queryService.getList(m);
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