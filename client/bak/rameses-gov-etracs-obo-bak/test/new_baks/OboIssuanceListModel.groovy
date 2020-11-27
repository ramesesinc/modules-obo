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

class OboIssuanceListModel extends CrudListModel {
    
    @Invoker
    def invoker;
    
    def typeid;
    String title;
    
    @FormId
    public String getFormId() {
        return  typeid + ":list";
    }

    public String getState() {
        return invoker.properties.state; 
    }
    
    def getCustomFilter() {
        if( state == "for-release") {
            return [ "issuancetypeid = :typeid AND state=0", [typeid: typeid] ];
        }
        else {
            return [ "issuancetypeid = :typeid AND NOT(state=0)", [typeid: typeid] ];            
        }
    }
    
    
}