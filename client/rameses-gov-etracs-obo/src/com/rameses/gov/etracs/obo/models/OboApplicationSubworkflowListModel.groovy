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

class OboApplicationSubworkflowListModel extends WorkflowTaskListModel {
    
    def typeid;
    String title;
    
    @FormId
    public String getFormId() {
        return getProcessName() + ":" + typeid + ":list";
    }

    def getCustomFilter() {
        return [ "typeid = :typeid", [typeid: typeid] ];
    }
    
    public String getNotificationid() {
        return getProcessName() + ":" + typeid.toLowerCase();
    }
    
    /*
    def beforeFetchNodes( param ) {
        super.beforeFetchNodes(param);
        param.typeid = typeid;
        return null;
    }
    */
    
}