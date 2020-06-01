package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.gov.etracs.obo.models.*;


class BuildingApplicationModel extends AbstractApplicationModel {

    @Service("BuildingApplicationFeeService")
    def feeSvc;
    
    @Service("BuildingApplicationService")
    def appSvc;
    
    public String getPermitName() {
        return "building_application";   
    }

    public def getFeeService() {
        return feeSvc;
    }
    
    public String getTitle() {
        return "Building Permit " + (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return "Bldg "+ (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    public boolean isActionable() {
        return (task.assignee.objid == userInfo.userid);
    }
    
    def listPermissionModel = [
        isAllowCreate: {
            return isActionable();
        },
        isAllowDelete: {
            return isActionable();
        }
    ];
    
    //impt for documents
    def selectedDoc;
    
    def changeOccupancyType() {
        def h = { o->
            def u = [_schemaname: "building_application"];
            u.findBy = [objid: entity.objid];
            u.occupancytype = o;
            u.occupancytypeid = o.objid;
            persistenceService.update(u);
            entity.occupancytype = o;
            binding.refresh("entity.occupancytype");
        }
        return Inv.lookupOpener("vw_obo_occupancy_type:lookup", [onselect: h] );
    }
    
     /**************************************************************************
    * assessment actions
    ***************************************************************************/
    def assess() {
        def f = [:];
        f.appid = entity.objid;
        def h  = { u->
            def m1 = [appid: entity.objid, items: u.items];
            m1 = feeSvc.saveFees( m1 );
            entity.amount = m1.amount;            
            feeListHandler.reload();
            binding.refresh("entity.amount")
        }
        return Inv.lookupOpener("building_assessment", [params: f, handler: h] );
    }
    
    def addFee() {
        def m = [:];
        m.lookupName = "obo_itemaccount";
        m.entity = [appid:entity.objid];
        m.saveHandler = { o->
            o = feeSvc.saveFee( o );
            entity.amount = o.amount;
            feeListHandler.reload();
            binding.refresh("entity.amount");
        }
        return Inv.lookupOpener("building_application_fee", m );
    }
    
    void clearFees() {
        feeSvc.clearFees( [appid:entity.objid ]);
        entity.amount = 0;
        binding.refresh("entity.amount");
    }
    
    def issuePermit() {
          def h = { o->
            o.objid = entity.objid;
            appSvc.issuePermitNo( o );
            reloadEntity();
        }
        return Inv.lookupOpener("obo_issue_controlno", [handler: h, showcontrolno: false]);
    }
    
    public static String formatTime( def o ) {
        if( o == null ) return "";
        return o + " seconds";
    }
    
    
}


