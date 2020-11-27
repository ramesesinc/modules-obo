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
import com.rameses.gov.etracs.obo.models.*;


class OboDocListModel extends CrudListModel {
    
    def typeid;
    
    public def getCustomFilter() {
        return [ " doctypeid = :doctypeid ", [doctypeid: typeid ] ];
    }
    
    public String getTitle() {
        return typeid;
    }
    
    
}