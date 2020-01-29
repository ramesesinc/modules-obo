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

abstract class AbstractApplicationSectionModel extends WorkflowTaskModel {
    
    def findingListHandler;
    def feeListHandler;
    
    public abstract String getPermitName();
    public abstract String getCaption();
    public abstract String getPrefix();
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    @FormTitle
    public String getTitle() {
        return getCaption() + " " +  entity.app.appno + " " + entity.type.title + " (" + entity.task?.title + ")";
    }
    
    public String getWindowTitle() {
        return getPrefix() + ":" + entity.app.appno;
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    def viewApplication() {
        String s = "vw_" + getPermitName() + ":open"; 
        def op = Inv.lookupOpener(s, [entity: [objid: entity.appid ] ] );
        op.target = "popup";
        return op;
    }
    
    def assess() {
        def f = [:];
        f.appid = entity.app.objid;
        f.sectionid = entity.typeid;
        f.ancillaryid = entity.ancillaryid;
        def h  = { u->
            feeListHandler.reload();
        }
        return Inv.lookupOpener(getPermitName() + ":assessment", [params: f, handler: h] );
    }
    
    def addFee() {
        def m = [appid: entity.appid, typeid: entity.typeid ];
        m.handler = { o->
            feeListHandler.reload();
        }
        return Inv.lookupOpener(getPermitName() + "_fee:create", m );
    }
    
    def addFinding() {
        def m = [:];
        m.sectionid = entity.objid;
        m.appid = entity.appid;
        m.section = entity;
        m.handler = { o->
            findingListHandler.reload();
        }
        return Inv.lookupOpener(getPermitName() + "_finding:create", m );
    }
    
    /*
    def issuePermit() {
        def h = { o->
            def m = [:];
            m.schemaname = getPermitName() + "_section";
            m.permitname = entity.type.reportname;
            m.appid = entity.appid;
            m.sectionid = entity.typeid;
            m.controlno = o.controlno;
            m.dtvalidity = o.dtvalidity;
            m.remarks = o.remarks;
            m.parentid = entity.objid;
            def p = permSvc.createSectionPermit( m );
            MsgBox.alert( "Permit no " + p.permitno + " is created");
            entity.permitno = p.permitno;
            reload();
        }
        return Inv.lookupOpener( "obo:permit_issuance", [ handler: h] );
    }
    
    def viewPermit() {
        def e = [objid: entity.issuanceid];
        return Inv.lookupOpener(entity.type.reportname, [entity:e] );
    }
    */
   
   
    
    public boolean isActionable() {
        return (task.assignee.objid == userid);
    }
    
    public boolean isEditable() {
        return (task.assignee?.objid !=null && task.assignee?.objid == userid);
    }
    
    //task.assignee?.objid !=null 
    //&amp;&amp; task.state.matches( 'review|evaluation|evaluation-approval')
    
}