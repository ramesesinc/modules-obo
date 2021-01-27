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
        return  isUserTaskAssignee(); 
    }
    
    public boolean getAllowEdit() {
        return isUserTaskAssignee();
    }
    
    public boolean getEditRpu() {
        return isUserTaskAssignee() && (task.state == "receiving");
    }
    
    public boolean getEditRequirements() {
        return isUserTaskAssignee() && (task.state == "requirement-verification");
    }
    
    public boolean getAllowIssue() {
        return isUserTaskAssignee() && (task.state == 'releasing') && (entity.controlid == null);
    }
    
    public boolean getEditEvaluations() {
       return hasRole("ADMIN") && (task.state == "trade-evaluation"); 
    }
    
    public boolean hasRole( def role ) {
        return secProvider.checkPermission( "OBO", role, null );
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
    
    public String getSchemaName() {
        return "vw_building_permit";
    }
    
    public String getEntitySchemaName() {
        return "building_permit";
    }
    
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
    
    
}


