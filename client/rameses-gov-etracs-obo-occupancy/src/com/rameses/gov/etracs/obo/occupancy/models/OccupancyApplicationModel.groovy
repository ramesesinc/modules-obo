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


class OccupancytApplicationModel extends WorkflowTaskModel  {

    @Service("OccupancyApplicationService")
    def appSvc;
    
    @Service("OccupancyApplicationFeeService")
    def feeSvc;
    
    public String getTitle() {
        return "Occupancy Permit " + (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return "Occupancy "+ (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    public String getNotificationid() {
        return "occupancy_application";
    }
    
    public boolean getCanEdit() {
        return ( task.assignee?.objid == user.objid );
    }
    
    def professionalListHandler  = [
        getList: {
             return appSvc.getProfessionalList([objid: entity.objid]);
        }
    ];
    
    def assessmentHandler = [
        saveFee: { o->
            feeSvc.saveFee( o );
        },
        saveFees: { o->
            feeSvc.saveFees( o );
        },
        removeFee: { o->
            feeSvc.removeFee( o );
        },
        clearFees: {
            feeSvc.clearFees( [parentid: entity.objid] );
        },
        getAccountLookupHandler: {
            return Inv.lookupOpener( "obo_itemaccount:obo:lookup", [:]);
        },
        getAssessHandlerName: {
            return "occupancy_assessment";
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
        schemaName = "vw_occupancy_application";
        entity = [objid: perm.appid ];
        return open();
    }
    
}


