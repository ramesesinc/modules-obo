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
import javax.swing.*;
import com.rameses.io.*;
import com.rameses.gov.etracs.obo.models.*;

class ConsolidatedFindingModel  {

    @Service("QueryService")
    def qrySvc;
    
    @Service("PersistenceService")
    def persistenceService;
    
    def appid;
    def schemaName;
    def selectedItem;
    
    def listHandler = [
        fetchList: { o->
            def m = [_schemaname: schemaName];
            m.findBy = [appid: appid];
            m.where = ["transmittalid IS NULL AND supersederid IS NULL AND state=2"];
            m.orderBy = "parent.type.sortindex,dtcreated"
            return qrySvc.getList(m);
        }
    ] as BasicListModel;   
    
    
    def doOk() {
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
    def viewFinding() {
        if(!selectedItem) throw new Exception("Please select an item");
        def p = [:];
        p.entity = selectedItem;
        p.editable = true;
        p.saveHandler = { o->
            o._schemaname = schemaName;
            if(!o.objid) {
                o.appid = appid;
                o.parentid = selectedItem.parentid;
                persistenceService.create( o );
            }
            else {
                persistenceService.update( o );                
            }
            listHandler.reload();
        }
        def op = Inv.lookupOpener("application_finding:open", p );
        op.target = "popup";
        return op;
    }
    
}