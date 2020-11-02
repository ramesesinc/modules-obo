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


class BuildingApplicationEditModel  {

    @Service("BuildingApplicationService")
    def appSvc;
    
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

    def changeOccupancyType() {
        def h = { o->
            def u = [_schemaname: "building_info"];
            u.findBy = [objid: entity.infoid];
            u.occupancytype = o;
            u.occupancytypeid = o.objid;
            persistenceService.update(u);
            entity.occupancytype = o;
            binding.refresh("entity.occupancytype");
        }
        return Inv.lookupOpener("vw_obo_occupancy_type:lookup", [onselect: h] );
    }
    
    public void changeTxnType() {
        def m = [:];
        m.fields = [
            [name:"txntype", caption:"SIMPLE", optionValue:"SIMPLE", datatype:"radio"],
            [name:"txntype", caption:"COMPLEX", optionValue:"COMPLEX", datatype:"radio"]            
        ];
        m.data = [txntype:entity.txntype];
        m.handler = { o->
            def u = [objid: entity.infoid, txntype: o.txntype, _schemaname:"building_info"];
            persistenceService.update( u );
            entity.txntype = u.txntype;
            binding.refresh("entity.txntype");
        }
        Modal.show("dynamic:form", m, [title:"Change Txn Type"]);
    }
    
    def issuePermit() {
          def h = { o->
            o.objid = entity.objid;
            appSvc.issuePermitNo( o );
            reloadEntity();
        }
        return Inv.lookupOpener("obo_issue_controlno", [handler: h, showcontrolno: false]);
    }
    
    //handlers
    def docHandler = [
        canRemoveDocument: { o->
            if(o.doctype.org?.objid) {
                throw new Exception("You cannot remove this document");
            }
            return true;
        }
    ];
    
    
    
}


