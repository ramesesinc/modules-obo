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

class BuildingPermitFindingModel {

    @Service("BuildingPermitFindingService")
    def findingSvc;

    @Caller
    def caller;
    
    def appid;
    def sectionid;
    def entity;
    
    def pagename = "view";

    
    void create() {
        entity = [:];
        if( !sectionid ) {
            entity.appid = appid;
        }
        else {
            entity.appid = appid;
            entity.parentid = sectionid;
        }
    }
    
    void open() {
        
    }
    
    def save() {
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
    }
    
    def closeIssue() {
        if(!MsgBox.confirm("This will close this finding. Proceed?")) return;
        findingSvc.closeIssue( entity );
        caller.findingListHandler.reload();
        return "_close";
    }
    
    
    void viewHistory() {
        pagename = "hist";
    }
    
    void viewBack() {
        pagename = "view";
    }

}