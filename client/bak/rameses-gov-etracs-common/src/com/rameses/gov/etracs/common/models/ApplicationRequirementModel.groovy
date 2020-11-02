package com.rameses.gov.etracs.common.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class ApplicationRequirementModel {

    //states:
    //0 - untouched
    //1 - passed
    //2 - for revision
    //3 - not applicable
    //4 - overridden
    
    @Binding
    def binding;
    
    @Script("User")
    def user;
    
    def listHandler;

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
    
    
    def entity;
    String pagename = "view"
    String title = "Review Requirement";

    def info = [:];
    boolean editable;
    boolean overridable;

    //this will be passed by caller
    String schemaName;
    def connection;

    boolean getShowNavigation() {
        return true;
    }

    void init() {
        overridable = false;
        if(editable) {
            if( entity.transmittalid ) {
                overridable = true;
            }
            else {
                if( entity.reviewer.objid!=null && entity.reviewer.objid != userid ) {
                    overridable = true;
                }
            }
        }
        if( entity.state == null ) {
            info.state = 0;
        }
        else {
            info.state = entity.state;            
        }    
        info.remarks = entity.remarks;
    }
    
    def moveUp() {
        listHandler.moveBackRecord();
        entity = listHandler.getSelectedItem()?.item;
        init();
        binding.refresh();
        return null;
    }
    
    def moveDown() {
        listHandler.moveNextRecord();
        entity = listHandler.getSelectedItem()?.item;
        init();
        binding.refresh();
        return null;
    }
    
    void save() {
        if(!info.state) throw new Exception("Please specify state ");
        if(info.state == 2 && !info.remarks ) throw new Exception("Please specifyremarks ");
        def m = [_schemaname:schemaName];
        m.objid = entity.objid;    
        m.state = info.state;
        m.remarks = info.remarks;
        def e  = persistenceService.update( m );
        listHandler.getSelectedItem().item.putAll( e );
        moveDown();
    }

    void createEntry(def state, def remarks) {
        def prev = info;
        def m = [_schemaname:schemaName];
        m.state = state;
        m.remarks = remarks; 
        m.previd = entity.objid;
        m.appid = entity.appid;
        m.parentid = entity.parentid;
        m.type = entity.type;  //type of requirement
        entity = persistenceSvc.create( m );
        init();
        listHandler.reload();        
    }
    
    void supersede() {
        createEntry(2, info.remarks);
    }
    
    void closeIssue() {
        createEntry(1, null);
    }
    
    void back() {
        pagename = "view";
    }
    void viewHist() {
        pagename = "hist"
    }
    
    def histHandler = [
        fetchList : { o->
            def m = [_schemaname: schemaName];
            m.findBy = [appid: entity.appid ];
            m.where = ["typeid = :typeid", [typeid : entity.typeid ]];
            queryService.getList( m );
        }
    ] as BasicListModel;
    
}