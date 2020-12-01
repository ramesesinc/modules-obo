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
import com.rameses.gov.etracs.obo.models.*;

class OccupancyInspectionModel extends WorkflowTaskModel {

    boolean getCanEdit() {
        return true;
        //return (userid == task.assignee?.objid);
    }
    
    @FormTitle
    public String getTitle() {
        return "Occupancy Inspection " +  entity.app.appno + " " + entity.type.title + " (" + entity.task?.title + ")";
    }
    
    public String getWindowTitle() {
        return "OCI:" + entity.app.appno;
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    public String getNotificationid() {
        return "occupancy_inspection:" + entity.typeid.toLowerCase();
    }
    
    public def viewApplication() {
        def op = Inv.lookupOpener("vw_occupancy_permit:open", [entity: [objid: entity.appid]]);
        op.target = "popup";
        return op;
    }
    
}