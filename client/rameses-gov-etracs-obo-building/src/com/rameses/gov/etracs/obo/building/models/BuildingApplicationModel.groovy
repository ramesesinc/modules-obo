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


class BuildingApplicationModel extends WorkflowTaskModel  {

    @Service("BuildingApplicationService")
    def appSvc;
    
    @Service("BuildingApplicationFeeService")
    def feeSvc;
    
    public String getTitle() {
        return "Building Permit " + (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return "Bldg "+ (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    public String getNotificationid() {
        return "building_application";
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
            return "building_assessment";
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
        p.doctype = [objid: "BUILDING_PERMIT"];
        p.appid = entity.objid;
        return Inv.lookupOpener("obo_issuance", p );
    }
    
    void emailPermits() {
        appSvc.emailPermits( entity );
    }
    
    
    
}


