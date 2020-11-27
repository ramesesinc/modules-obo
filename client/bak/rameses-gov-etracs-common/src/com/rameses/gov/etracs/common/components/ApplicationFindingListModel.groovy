package com.rameses.gov.etracs.common.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class ApplicationFindingListModel extends ComponentBean {

    @Binding
    def binding;

    def _querySvc;
    def getQueryService() {
        if(!_querySvc) {
            _querySvc= InvokerProxy.getInstance().create("QueryService", null, connection);
        }
        return _querySvc;
    }
    
    def _persistenceSvc;
    def getPersistenceService() {
        if(!_persistenceSvc) {
            _persistenceSvc = InvokerProxy.getInstance().create("PersistenceService", null, connection);
        }
        return _persistenceSvc;
    }  
    
    String schemaName;
    String appid;
    def connection;
    def selectedItem;
    def viewType = "open";
    boolean visible;
    boolean editable;
    
    @PropertyChangeListener
    def listener = [
        "viewType": { o->
            listHandler.reload();
        }
    ];
    
    def listHandler = [
        fetchList: { o->
            def m = [_schemaname: schemaName];
            m.orderBy = "type.sortorder";
            String w1 = "appid = :appid AND supersederid IS NULL";
            def p = [appid: appid];
            if( viewType == "open" ) {
                w1 += " AND state IN (0,2) ";
            }
            else if( viewType == "applicable") {
                w1 += " AND state <> 3 ";
            }
            m.where = [ w1, p ];
            return queryService.getList( m );
        }
    ] as BasicListModel;
    
    void refresh() {
        listHandler.reload();
    }
    
    void viewRequirement() {
        if(!selectedItem ) throw new Exception("Please select an item");
        def p = [:];
        p.schemaName = schemaName;
        p.connection = connection;
        p.handler = {
            listHandler.reload();
        };
        p.entity = selectedItem;
        p.listHandler = listHandler;
        p.editable = editable;
        Modal.show( "application_requirement:open", p )
    }
    
}
