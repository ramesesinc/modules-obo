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
        return true;
        //return (userid == task.assignee?.objid);
    }
    
    public def getSectionid() {
        if( entity.sectionid !=null ) {
            return entity.sectionid;
        }
        else {
            //this is default so there will be no items in filter;
            return "#NULL";
        }
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
    
    public boolean getEditFindings() {
        return isUserTaskAssignee() ;
    }
    
    
    public def viewApplication() {
        def op = Inv.lookupOpener("vw_building_permit:open", [entity: [objid: entity.appid]]);
        op.target = "popup";
        return op;
    }
    
    
    boolean _inited;
    
    @PropertyChangeListener
    def listener = [
        "selectedTask" : { o->
            if(_inited) {
                entity = [objid: o.objid];
                println "running open";
                open();
                binding.refresh();
            }
            else {
                _inited = true;
            }
        }
    ];
    
    def taskList;
    def selectedTask;
    def appid;
    def taskstate;
    
    public void afterOpen() {
        if( !taskList ) {
            appid = entity.appid;
            taskstate = entity.task.state;
            def m = [_schemaname: "vw_building_evaluation_consolidated"];
            m.findBy = [appid:appid ];
            def str = "state = :state AND (assignee.objid IS NULL OR assignee.objid = :userid ) "; 
            def parms = [state:taskstate, userid: OsirisContext.env.USERID];
            if( OsirisContext.env.ORGROOT == 1 ) {
                str += " AND org.objid IS NULL";
            }
            else {
                str += " AND org.objid = :orgid";
                parms.orgid = OsirisContext.env.ORGID;
            }
            m.where = [str, parms];
            m.orderBy = "sortindex";
            taskList = queryService.getList(m);
            /*
            taskList.each {
                println it;
            }
            */
            selectedTask = taskList.find{ it.typeid == entity.typeid };
        }
    }
    
}