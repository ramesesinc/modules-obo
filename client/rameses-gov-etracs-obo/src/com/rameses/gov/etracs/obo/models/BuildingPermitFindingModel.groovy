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

/******
* state is similar to the requirements
* 0 = editing state
* 1 =  
******/

class BuildingPermitFindingModel {

    @Service("BuildingPermitFindingService")
    def findingSvc;

    @Caller
    def caller;

    @Script("User")
    def userInfo;
    
    def appid;
    def sectionid;
    def entity;
    
    def pagename = "view";
    
    boolean editable = false;
    boolean closeable = false;
    
    void create() {
        entity = [:];
        if( !sectionid ) {
            entity.appid = appid;
        }
        else {
            entity.appid = appid;
            entity.parentid = sectionid;
        }
        entity.state = 0;
    }
    
    void open() {
    }

    boolean getEditable() {
        def task = caller.task;
        if( task.assignee.objid != userInfo.userid ) return false;
        if( pagename != "view") return false;
        if( entity.state == 0 ) return false;
        if( entity.transmittalid != null ) return false;
        if( entity.createdby.objid == userInfo.userid ) return true;
        return false;
    }
    
    boolean getCloseable() {
        def task = caller.task;
        if( task.assignee.objid != userInfo.userid ) return false;
        if( pagename != "view") return false;
        if(!entity.objid) return false;
        if( entity.transmittalid !=null ) return true;
        if( entity.createdby.objid != userInfo.userid ) return true;
        return false;
    }
    
    void edit() {
        entity.state = 0;
    }
    
    def revert() {
        return save( 1 );
        entity.state = 1;
    }
    
    def save() {
        return save(2);
    }
    
    def save( int state ) {
        entity.state = state;
        findingSvc.create( entity );
        caller.findingListHandler.reload();
        return "_close";        
    }

    void supersede() {
        def preventity = entity;
        entity = [:];
        entity.objid = null;
        entity.previd = preventity.objid;
        entity.appid = preventity.appid;
        entity.parentid = preventity.parentid;
        entity.rootid = preventity.rootid;        
        entity.particulars = preventity.particulars;
        entity.state = 0;
    }
    
    def closeIssue() {
        if(!MsgBox.confirm("This will close this finding. Proceed?")) return;
        return save(1);
    }
    
    void viewHistory() {
        pagename = "hist";
    }
    
    void viewBack() {
        pagename = "view";
    }

}