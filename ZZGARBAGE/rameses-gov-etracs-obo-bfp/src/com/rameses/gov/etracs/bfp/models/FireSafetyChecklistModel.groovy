package com.rameses.gov.etracs.bfp.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import com.rameses.enterprise.models.*;

public class FireSafetyChecklistModel  {
    
    @Service("FireSafetyChecklistService")
    def checklistSvc;
    
    @Service("QueryService")
    def qrySvc;
    
    @Caller
    def caller;
    
    def entity;
    def parent;
    def selectedChecklistItem;
    boolean editable;
    
    
    def create() {
        parent = caller.entity;
        def appid = parent.appid;
        def sectionid = parent.typeid;
        entity = checklistSvc.create( [appid: appid ] );
        entity.firesafetychecklist = [objid: entity.objid];
        editable = caller.editable;        
        caller.reload();
    }
    
    def open() {
        parent = caller.entity;
        def appid = parent.appid;
        def sectionid = parent.typeid;
        entity = checklistSvc.open( [objid: parent.firesafetychecklist.objid ] );
        editable = caller.editable;
    }
    
    
    def checklistHandler = [
        isMultiSelect: {
            return true;
        },
        openItem: { o, col ->
            return updateChecklistItem(o);
        }, 
        fetchList: { o->
            return checklistSvc.getList( [objid: entity.objid ] );
        }
    ] as BasicListModel;
    
    public void refreshChecklistItems() {
        checklistHandler.reload();
    }
    
    public def addChecklistItems() {
        def pp = [:]
        pp.onselect = { o->
            def p = [:];
            p.objid = entity.objid;
            p.items = o.collect{ [objid: it.objid ] };
            checklistSvc.addItems( p );
            checklistHandler.reload();
        };
        return Inv.lookupOpener("fire_safety_checklist_master:lookup", pp);
    }
    
    public def removeChecklistItems() {
        def selectedChecklistItems = checklistHandler.getSelectedValue();
        if(!selectedChecklistItems) return;
        def p = [:];
        p.items = selectedChecklistItems.collect{[objid: it.objid] };
        checklistSvc.removeItems( p );
        checklistHandler.reload();
    }
    
    public def updateChecklistItem(def o) {
        def h = {
            checklistHandler.reload();
        }
        return Inv.lookupOpener( "fire_safety_checklist_entry", [entity: o, handler: h])
    }
    
    public def editItem() {
        if(selectedChecklistItem == null) throw new Exception("Please select an item");
        return updateChecklistItem(selectedChecklistItem);
    }
    
    public def printReport() {
        def p = ["query.objid" : entity.objid]
        return Inv.lookupOpener("fire_safety_checklist_report", p );
    }
    
    
}