package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class ApplicationRequirementListModel extends AbstractComponentModel {

    def viewType = "open";
    
    @PropertyChangeListener
    def listener = [
        "viewType" : { o->
            refresh();
        }
    ]
    
    void beforeLoadList(def m) {
        m.orderBy = "type.sortorder";
        String w1 = "supersederid IS NULL";
        if( viewType == "open" ) {
            w1 += " AND state IN (0,2) ";
        }
        else if( viewType == "applicable") {
            w1 += " AND state <> 3 ";
        }
        m.where = [ w1 ];        
    }
    
    def openItem(def o) {
        def p = [:];
        p.schemaName = schemaName;
        p.connection = connection;
        p.saveHandler = { 
            listHandler.reload();
        };
        p.entity = selectedItem;
        p.listHandler = listHandler;
        p.allowEdit = editable;
        p.editable = editable;
        def op = Inv.lookupOpener("application_requirement:open", p );
        op.target = "popup";
        return op;
    }
    
    def viewRequirement() {
        if(!selectedItem ) throw new Exception("Please select an item");
        return openItem(selectedItem);
    }
    
}
