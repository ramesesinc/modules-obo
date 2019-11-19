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

    @Service("OboApplicationRequirementService")
    def reqSvc;

    @Service("QueryService")
    def qrySvc;
    
    @Binding
    def binding;
    
    @Script("User")
    def user;
    
    @Caller
    def caller;

    def entity;
    String pagename = "view"
    String title = "Review Requirement";
    def schemaName;
    
    boolean getShowNavigation() {
        return true;
    }
    
    void openBldgPermit() {
        schemaName  = "building_permit";
    }
    
    void openOccupancyPermit() {
        schemaName  = "occupancy_permit";
    }

    //can display the pass, fail or NA buttons
    public boolean isActionable() {
        def task = caller.task;
        if( caller.entity.appno != null ) return false;
        if( task.state != 'requirement-verification' ) return false;
        if(pagename!="view") return false;
        if( entity.state == 0 ) {
            if( task.assignee?.objid == user.userid ) return true;
            return false;
        }    
        else {
            return false;
        }; 
    }
        
    //can display the editable button
    public boolean isEditable() {
        def task = caller.task;
        if( caller.entity.appno != null ) return false;
        if( task.state != 'requirement-verification' ) return false;
        if(pagename!="view") return false;
        if( entity.state == 0 ) return false;
        if( entity.transmittalid != null ) return false;
        if(task.assignee.objid != user.userid ) return false;
        return ( entity.reviewer.objid == user.userid );
    }
    
    public boolean isOverridable() {
        def task = caller.task;
        if( caller.entity.appno != null ) return false;        
        if( task.state != 'requirement-verification' ) return false;        
        if(pagename!="view") return false;
        if( caller.entity.reqtransmittalid ) return false; 
        if( entity.state == 0 ) return false;
        if( entity.transmittalid !=null ) {
            return ( task.assignee.objid == user.userid );
        }
        return false;
    }
    
    public boolean getForRevision() {
        return true;
    }

    def moveUp() {
        def handler = caller.reqListHandler;
        handler.moveBackRecord();
        entity = handler.getSelectedItem()?.item;
        int idx  = handler.getSelectedItem().index;
        int maxRow = handler.getMaxRows();
        if( idx == 0 && handler.pageIndex != 1 ) {
            handler.moveBackPage();
            handler.setSelectedItem( maxRow - 1 );
            entity = handler.getSelectedItem()?.item;
        }
        return null;
    }
    
    def moveDown() {
        def handler = caller.reqListHandler;
        handler.moveNextRecord();
        entity = handler.getSelectedItem()?.item;
        int idx = handler.getSelectedItem().index;
        int maxRow = handler.getMaxRows();
        if( idx == (maxRow-1) ) {
            handler.moveNextPage();
            handler.setSelectedItem( 0 );
            entity = handler.getSelectedItem()?.item;
        }
        return null;
    }
    
    void updateState( int state ) {
        entity.state = state;
        entity.schemaname = schemaName; 
        def e = reqSvc.update( entity );    
        caller.reqListHandler.getSelectedItem().item.putAll( e );
        moveDown();
        binding.refresh();
    }
    
    void accept() {
        updateState(1); 
    }
    void revise() {
        if(!entity.remarks) throw new Exception("Please specify remarks")
        updateState(2);         
    }
    void na() {
        updateState(3); 
    }
    
    void edit() {
        entity.state = 0;
    }
    
    
    void supersede() {
        def prev = entity;
        entity = [:];
        entity.remarks = prev.remarks
        entity.appid = prev.appid;
        entity.parentid = prev.parentid;
        entity.type = prev.type;
        entity.previd = prev.objid;
        entity.state = 0;
    }
    
    void closeIssue() {
        if(!MsgBox.confirm("You are about to close this issue. Continue?")) return;
        supersede();
        updateState( 1 );
    }
    
    void back() {
        pagename = "view";
    }
    void viewHist() {
        pagename = "hist"
    }
    
    def histHandler = [
        fetchList : { o->
            def m = [_schemaname: schemaName + "_requirement"];
            m.findBy = [appid: entity.appid ];
            m.where = ["typeid = :typeid", [typeid : entity.typeid ]];
            qrySvc.getList( m );
        }
    ] as BasicListModel;
    
}