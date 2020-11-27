package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class ApplicationSubTaskListModel extends AbstractComponentModel {

    def typeSchema;
    def viewType = "all";
    
    @PropertyChangeListener
    def listener = [
        "viewType": {
            listHandler.reload();
        }
    ];
    
    void beforeLoadList( def m ) {
        if( viewType == "open" ) {
            m.where = [" NOT(task.state = 'end')"];
        }
        else if( viewType == "completed") {
            m.where = [ " task.state = 'end' "];
        }
    }
    
    def addItem() {
        if( !entitySchemaName ) throw new Exception("Please specify entitySchemaName in component");
        def h = [:]
        h.onselect = { o->
            def s = entitySchemaName;
            def pq = [_schemaname: s];
            pq.appid = appid;
            pq.typeid = o.objid;
            pq.type = [objid: o.objid ];
            pq.state = 0;
            persistenceService.create( pq );
            refresh();
        }
        h.listHandler = [
            fetchList: {
                def m = [_schemaname:typeSchema];
                m.where = "1=1";
                return queryService.getList(m);
            },
            getColumns: {
                return [
                    [name:"objid", caption:"Type"],
                    [name:"title", caption:"Title"],     
                    [name:"section.org.objid", caption:"Org"],  
                ];
            }
        ] as BasicListModel;
        h.title = "Select a type";
        return Inv.lookupOpener( "simple_list_lookup" , h );
    }
    
    def removeItem() {
        if(!selectedItem?.objid ) throw new Exception("Please select an item first");
        if( !MsgBox.confirm("You are about to remove item") ) return;
        def m = [_schemaname: entitySchemaName ];
        m.objid = selectedItem.objid 
        persistenceService.removeEntity( m );
        refresh();
    }
    
}
