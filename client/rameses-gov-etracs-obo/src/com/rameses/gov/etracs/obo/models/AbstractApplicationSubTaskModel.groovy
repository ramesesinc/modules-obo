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

abstract class AbstractApplicationSubTaskModel extends WorkflowTaskModel {
    
    def findingListHandler;
    def selectedDoc;
    
    public abstract String getCaption();
    public abstract String getPrefix();
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    @FormTitle
    public String getTitle() {
        return getCaption() + " " +  entity.app.appno + " " + entity.type.title + " (" + entity.task?.title + ")";
    }
    
    public String getWindowTitle() {
        return getPrefix() + ":" + entity.app.appno;
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    def addFinding(String openerName) {
        def m = [:];
        m.sectionid = entity.objid;
        m.appid = entity.appid;
        m.section = entity;
        m.handler = { o->
            findingListHandler.reload();
        }
        return Inv.lookupOpener(openerName + ":create", m );
    }
    
    public boolean isActionable() {
        return (task.assignee.objid == userid);
    }
    
    public boolean isEditable() {
        return (task.assignee?.objid !=null && task.assignee?.objid == userid);
    }
    
}