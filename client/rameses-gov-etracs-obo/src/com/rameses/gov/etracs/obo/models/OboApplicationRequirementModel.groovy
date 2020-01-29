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

class OboApplicationRequirementModel {

    //states:
    //0 - untouched
    //1 - passed
    //2 - for revision
    //3 - not applicable
    //4 - overridden
    
    @Service("QueryService")
    def qrySvc;

    @Service("PersistenceService")
    def persistenceSvc;
    
    @Binding
    def binding;
    
    @Script("User")
    def user;
    
    @Caller
    def caller;

    @Controller
    def workunit;

    def entity;
    String pagename = "view"
    String title = "Review Requirement";

    def info = [:];
    boolean editable;
    boolean overridable;

    public String getSchemaName() {
        return workunit?.info?.workunit_properties?.schemaName;
    }

    boolean getShowNavigation() {
        return true;
    }

    void init() {
        editable = false;
        overridable = false;
        
        def task = caller.task;
        if( task.state == 'requirement-verification' ) {
            //if current task assignee
            if( task.assignee.objid == user.userid ) {
                if( entity.reviewer?.objid == null  ) {
                    editable = true;
                }
                else if( entity.reviewer.objid == user.userid ) {
                    editable = true;
                }
                else if( entity.transmittalid !=null ) {
                    overridable = true;
                }
                else if( entity.reviewer.objid != user.userid ) {
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
        def handler = caller.reqListHandler;
        handler.moveBackRecord();
        entity = handler.getSelectedItem()?.item;
        init();
        binding.refresh();
        return null;
    }
    
    def moveDown() {
        def handler = caller.reqListHandler;
        handler.moveNextRecord();
        entity = handler.getSelectedItem()?.item;
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
        def e  = persistenceSvc.update( m );
        caller.reqListHandler.getSelectedItem().item.putAll( e );
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
        caller.reqListHandler.reload();        
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
            qrySvc.getList( m );
        }
    ] as BasicListModel;
    
}