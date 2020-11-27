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
import javax.swing.*;
import com.rameses.io.*;


class OccupancyPermitModel extends AbstractOboApplicationModel {

    public String getPermitName() {
        return "occupancy_permit";   
    }
    
    public String getTitle() {
        return "Occupancy Permit " + (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return "OP " + (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    def specifySchedule() {
        def h = { o->
            def m = [_schemaname: "occupancy_permit"];
            m.debug = true;
            m.findBy = [objid: entity.objid ];
            m.inspectiondate = o.date + " " + o.hour + ":" + o.minute;
            persistenceService.update( m );
            reload();
        };
        return Inv.lookupOpener("date:prompt", [handler: h, title:"Enter Inspection Schedule", includeTime:true]);
    }
    
    def viewBldgPermit() {
        def op = Inv.lookupOpener("vw_building_permit:open", [ entity: [objid: entity.bldgpermitid ] ]);
        op.target = "popup";
        return op;
    }
    
}


