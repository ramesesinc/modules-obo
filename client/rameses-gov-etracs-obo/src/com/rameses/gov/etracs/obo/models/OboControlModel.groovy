package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import com.rameses.enterprise.models.*;

public class OboControlModel {
    
    @Service("OboControlService")
    def controlSvc;
    
    @Caller
    def caller;
    
    def doctypeid;
    def entity;
    def schemaName;
    def objid;
    def notificationid;
    def controlno;
    def remarks;
    boolean showControlno = false;
    def saveHandler;
    
    void init(def inv) {
        schemaName = inv.properties.schemaName;
        doctypeid = schemaName;
        objid = entity.objid;
        notificationid = schemaName;
        showControlno = false;
    }
    
    void initDoc(def inv) {
        caller.checkCanIssue();
        schemaName = inv.properties.schemaName;
        doctypeid = entity.doctype?.objid;
        objid = entity.objid;
        notificationid = schemaName+":"+doctypeid.toLowerCase();
        showControlno = true;
    }

    void initNew() {
        if(!schemaName) throw new Exception("schemaName is required");
        if(!entity) throw new Exception("entity is required");        
        doctypeid = entity.doctype?.objid;
        objid = entity.objid;        
        notificationid = schemaName+":"+doctypeid.toLowerCase();
        showControlno = true;
    }
    
    def doOk() {
        def m = [:];
        m.doctypeid = doctypeid;
        m._schemaname = schemaName;
        m.objid = objid;
        m.notificationid = notificationid;
        m.controlno = controlno;
        m.remarks = remarks;
        entity = controlSvc.create( m );
        def z = [:];
        z.controlid = entity.objid;
        z.controlno = entity.controlno;
        z.dtissued = entity.dtissued;
        if( saveHandler ) {
            saveHandler();
        }
        else {
            caller.reloadEntity();
        }
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}