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

class BuildingPermitRequirementModel {

    @Service("BuildingPermitRequirementService")
    def reqSvc;

    @Binding
    def binding;
    
    @Caller
    def caller;

    def entity;

    String pagename = "view"
    String title = "Review Requirement";
    
    boolean getShowNavigation() {
        return true;
    }
    
    void open() {
        def ctask = caller.task;
        if( ctask.state != 'receiving' ) throw new Exception("Requirement can only be edited in receiving state");
        if( ctask.assignee?.objid == null ) throw new Exception("Please assign first a person to the receiving task.");
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
    
}