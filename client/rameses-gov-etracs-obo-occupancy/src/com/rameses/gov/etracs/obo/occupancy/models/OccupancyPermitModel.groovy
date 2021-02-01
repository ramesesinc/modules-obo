package com.rameses.gov.etracs.obo.occupancy.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;


class OccupancytPermitModel extends WorkflowTaskModel  {

    @Service("OccupancyApplicationService")
    def appSvc;
    
    public String getSchemaName() {
        return "vw_occupancy_permit";
    }
    
    public String getEntitySchemaName() {
        return "occupancy_permit";
    }

    public String getTitle() {
        return "Occupancy Permit " + (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return "Occupancy "+ (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    public String getNotificationid() {
        return "occupancy_permit";
    }
    
    public boolean getCanEdit() {
        return ( task.assignee?.objid == user.objid );
    }
    
    public boolean getEditDocuments() {
        return isUserTaskAssignee() && !task.state.matches('receiving|requirement-verification|end');
    }
    
    public boolean getAllowEdit() {
        return isUserTaskAssignee() && !task.state.matches('approval|releasing|end');
    }
    
    public boolean getEditInspectionDate() {
        return (isUserTaskAssignee() && task.state == "schedule-inspection");
    }
    
    public boolean getEditRequirements() {
        return isUserTaskAssignee() && (task.state == "requirement-verification");
    }
    
    public boolean getEditAssessment() {
        return isUserTaskAssignee() && (task.state == "assessment");
    }
    
    public boolean getEditInspections() {
       return hasRole("ADMIN") && (task.state == "inspection"); 
    }
    
    public boolean hasRole( def role ) {
        return secProvider.checkPermission( "OBO", role, null );
    }
    
    public void checkPermission() {
        def o = secProvider.checkPermission( "OBO", "REQUIREMENT_REVIEWER", null );
    }
    
    def professionalListHandler  = [
        getList: {
             return appSvc.getProfessionalList([objid: entity.objid]);
        }
    ];
    
    def viewReceipt() {
        def op = Inv.lookupOpener(entity.payment.reftype + ":open", [entity:[objid:entity.payment.refid]] );
        op.target = "popup";
        return op;
    }
    
    def setInspectionDate() {
        def h = { o->
            def m = [_schemaname: "occupancy_permit"];
            m.objid = entity.objid;
            m.inspectiondate = o.date + " " + o.hour + ":" + o.minute;
            persistenceService.update( m );
            reload();
        };
        def d = entity.inspectiondate;
        return Inv.lookupOpener("date:prompt", [handler: h, title:"Enter Inspection Date/Time", date:d, includeTime:true]);
    }
    
    def editContractor() {
        return Inv.lookupOpener("occupancy_contractor", [entity: entity.contractor, editable: false])
    }
    
}


