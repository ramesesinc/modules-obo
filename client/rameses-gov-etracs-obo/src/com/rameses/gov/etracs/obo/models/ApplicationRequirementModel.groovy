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
import com.rameses.osiris2.client.OsirisContext;

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
    String title = "Review Requirement";

    def info = [:];
    boolean editable;
    boolean overridable;
    boolean supsededed;
    def saveHandler;

    //this will be passed by caller
    String schemaName;
    def connection;

    boolean getShowNavigation() {
        return true;
    }

    void init() {
        def userid = user.userid;
        //OsirisContext.getEnv().USERID
        overridable = false;
        if( entity.transmittalid ) {
            editable = false;
            overridable = true;
        }
        if(editable) {
            if( entity.reviewer?.objid!=null && entity.reviewer?.objid != userid ) {
                overridable = true;
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
        if( listHandler.isLastItem( listHandler.getSelectedItem() )) return "_close";
        listHandler.moveNextRecord();
        entity = listHandler.getSelectedItem()?.item;
        init();
        binding.refresh();
        return null;
    }
    
    def save() {
        if(!info.state) throw new Exception("Please specify state ");
        if(info.state == 2 && !info.remarks ) throw new Exception("Please specify remarks ");
        def m = [_schemaname:schemaName];
        m.objid = entity.objid;    
        m.state = info.state;
        m.remarks = info.remarks;
        def e  = persistenceService.update( m );
        listHandler.getSelectedItem().item.putAll( e );
        listHandler.refreshSelectedItem();
        //saveHandler( e );
        if( superseded == true ) {
            return "_close";
        }
        return moveDown();
    }

    void createEntry(def state, def remarks) {
        def prev = info;
        def m = [_schemaname:schemaName];
        m.state = state;
        m.remarks = remarks; 
        m.previd = entity.objid;
        m.appid = entity.appid;
        m.type = entity.type;  //type of requirement
        entity = persistenceService.create( m );
    }
    
    void supersede() {
        supsededed = true;
        createEntry(2, info.remarks);
        editable = true;
        overridable = false;
        init();
        listHandler.reload();
        binding.refresh();
    }
    
    def closeIssue() {
        createEntry(1, null);
        return "_close";
    }
    
   
}