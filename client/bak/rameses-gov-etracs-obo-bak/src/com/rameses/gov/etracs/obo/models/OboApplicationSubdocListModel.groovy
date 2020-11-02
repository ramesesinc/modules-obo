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

class OboApplicationSubdocListModel extends CrudListModel {
    
    def typeid;
    String title;
    
    @Invoker
    def invoker;
    
    @FormId
    public String getFormId() {
        return typeid.toLowerCase() + ":list";
    }

    def getCustomFilter() {
        return [ "doctypeid = :typeid", [typeid: typeid] ];
    }
    
    public String getNotificationid() {
        return typeid.toLowerCase();
    }
    
    /*
    def beforeFetchNodes( param ) {
        super.beforeFetchNodes(param);
        param.typeid = typeid;
        return null;
    }
    */
    
}