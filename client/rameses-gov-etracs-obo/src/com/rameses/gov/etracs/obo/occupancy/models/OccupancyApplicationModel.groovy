package com.rameses.gov.etracs.obo.occupancy.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;
import javax.swing.*;
import com.rameses.io.*;
import com.rameses.gov.etracs.obo.models.*;


class OccupancyApplicationModel extends AbstractApplicationModel {
  
    @Service("OccupancyInspectionScheduleService")
    def scheduleSvc;
    
    public String getNotificationid() {
        return "occupancy_application";
    }
    
    public def getFeeService() {
        return null;
    }
    
    public String getPermitName() {
        return "occupancy_application";   
    }
    
    public String getTitle() {
        return "Occupancy Permit " + (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return "OP " + (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    def specifySchedule() {
        def h = { o->
            scheduleSvc.updateSchedule( [objid: entity.objid, date:  o.date + " " + o.hour + ":" + o.minute]);
            reload();
        };
        
        def d = entity.inspectionschedule;
        return Inv.lookupOpener("date:prompt", [handler: h, title:"Enter Inspection Schedule", date:d, includeTime:true]);
    }
    
    def viewBldgPermit() {
        def op = Inv.lookupOpener("vw_building_permit:open", [ entity: [objid: entity.bldgpermitid ] ]);
        op.target = "popup";
        return op;
    }
    
    def selectedDoc;
    def doclistModel;
    
    
}


