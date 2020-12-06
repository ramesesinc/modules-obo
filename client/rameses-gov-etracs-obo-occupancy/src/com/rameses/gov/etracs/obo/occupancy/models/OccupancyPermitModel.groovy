package com.rameses.gov.etracs.obo.occupancy.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.io.*;


class OccupancytPermitModel extends WorkflowTaskModel  {

    @Service("OccupancyApplicationService")
    def appSvc;
    
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
        return true;
    }
    
    public boolean getAllowEdit() {
        return isUserTaskAssignee();
    }
    
    public boolean getEditRequirements() {
        return isUserTaskAssignee() && (task.state == "requirement-verification");
    }
    
    public boolean getEditAssessment() {
        return true;
        //return isUserTaskAssignee() && (task.state == "requirement-verification");
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
    
    def issuePermit() {
        def p = [:];
        p.handler = { o->
            entity.putAll( o );
            binding.refresh();
        };
        p.doctype = [objid: "OCCUPANCY_PERMIT"];
        p.appid = entity.objid;
        return Inv.lookupOpener("obo_issuance", p );
    }
        
    def openPermit() {
        def m = [_schemaname: "vw_occupancy_permit"];
        m.findBy = [objid: entity.objid];
        def perm = queryService.findFirst( m );
        if(!perm) throw new Exception("Permit does not exist");
        schemaName = "vw_occupancy_permit";
        entity = [objid: perm.appid ];
        return open();
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


