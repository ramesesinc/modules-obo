package com.rameses.gov.etracs.obo.building.models;

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

class BuildingEvaluationModel extends WorkflowTaskModel {

    boolean getCanEdit() {
        return (userid == task.assignee?.objid);
    }
    
    @FormTitle
    public String getTitle() {
        return "Building Evaluation " +  entity.app.appno + " " + entity.type.title + " (" + entity.task?.title + ")";
    }
    
    public String getWindowTitle() {
        return "BE:" + entity.app.appno;
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    public String getNotificationid() {
        return "building_evaluation:" + entity.typeid.toLowerCase();
    }
    
    public def viewApplication() {
        def op = Inv.lookupOpener("vw_building_application:open", [entity: [objid: entity.appid]]);
        op.target = "popup";
        return op;
    }
    
}