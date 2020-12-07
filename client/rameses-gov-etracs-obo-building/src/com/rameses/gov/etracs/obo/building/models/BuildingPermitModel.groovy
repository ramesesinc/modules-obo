package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.io.*;


class BuildingPermitModel extends WorkflowTaskModel  {

    @Service("BuildingApplicationService")
    def appSvc;
    
    public String getTitle() {
        return "Building Permit " + (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return "Bldg "+ (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    public String getNotificationid() {
        return "building_permit";
    }
    
    public boolean getCanEdit() {
        return true;
        //return ( task.assignee?.objid == user.objid );
    }
    
    public boolean getAllowEdit() {
        return true;
        //return isUserTaskAssignee();
    }
    
    public boolean getEditRpu() {
        return  true;
        //return isUserTaskAssignee() && (task.state == "receiving");
    }
    
    public boolean getEditRequirements() {
        return isUserTaskAssignee() && (task.state == "requirement-verification");
    }
    
    public void checkPermission() {
        def o = secProvider.checkPermission( "OBO", "REQUIREMENT_REVIEWER", null );
        MsgBox.alert( "check " + o);
    }
    
    def professionalListHandler  = [
        getList: {
             return appSvc.getProfessionalList([objid: entity.objid]);
        }
    ];
    
    
    def viewApplicant() {
        def p = [:];
        p.editable = false;
        p.applicant = [name: entity.applicant.name ];
        p.entity = entity.applicant;
        return Inv.lookupOpener("building_permit_entity", p);
    }
    
    def viewReceipt() {
        if(!entity.payment.refid) throw new Exception("Payment refid is not specified for this payment");
        def op = Inv.lookupOpener(entity.payment.reftype + ":open", [entity:[objid:entity.payment.refid]] );
        op.target = "popup";
        return op;
    }
    
    def issuePermit() {
        def p = [:];
        p.handler = { o->
            entity.putAll( o );
            binding.refresh();
        };
        p.doctype = [objid: "BUILDING_PERMIT"];
        p.appid = entity.objid;
        return Inv.lookupOpener("obo_issuance", p );
    }
        
    def openPermit() {
        def m = [_schemaname: "vw_building_permit"];
        m.findBy = [objid: entity.objid];
        def perm = queryService.findFirst( m );
        if(!perm) throw new Exception("Permit does not exist");
        schemaName = "vw_building_permit";
        entity = [objid: perm.appid ];
        return open();
    }
    
}


