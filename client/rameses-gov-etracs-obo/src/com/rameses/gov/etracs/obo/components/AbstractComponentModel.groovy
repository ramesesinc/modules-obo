package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class AbstractComponentModel extends ComponentBean {

    @Binding
    def binding;
    
    @Script("User")
    def user;

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
    String entitySchemaName;
    String appid;
    String parentid;
    def connection;
    def selectedItem;
    boolean visible;
    boolean editable;
    def filter;
    def handler;
    def _items;
    
    void init() {
        
    }
    
    void beforeLoadList(def params) {}
    void afterLoadList() {}
    
    def openItem(def o) {
        def p = [:];
        p.entity = o;
        p.editable = editable;
        def op = Inv.lookupOpener(schemaName + ":open", p );
        op.target = "popup";
        return op;
    }
    
    def openItem() {
        if(!selectedItem) throw new Exception("Please select an item");
        return openItem( selectedItem );
    }
    
    def createItem() {
        def op = Inv.lookupOpener(schemaName+":create", [appid:appid, parentid: parentid]);
        op.target = "popup";
        return op;
    }
    
    public boolean isMultiSelect() {
        return false;
    }
    
    def listHandler = [
        isMultiSelect: {
            return isMultiSelect();
        },
        fetchList: { o->
            def m = [_schemaname: schemaName];
            if( parentid ) {
                m.findBy = [parentid: parentid];
            }
            else if(appid) {
                m.findBy = [appid: appid ];
            }
            beforeLoadList( m );
            _items = queryService.getList( m );
            afterLoadList();
            return _items;
        },
        openItem: { o,colName->
            return openItem(o);
        }
    ] as BasicListModel;  
    
    void refresh() {
        listHandler.reload();
    }
    
    
    
}
