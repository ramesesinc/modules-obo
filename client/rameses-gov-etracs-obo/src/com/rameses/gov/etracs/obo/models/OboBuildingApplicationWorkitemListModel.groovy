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

class OboBuildingApplicationWorkitemListModel extends WorkflowTaskListModel {
    
    def typeid;
    String title;
    
    def getCustomFilter() {
        return [ "reqtype.objid = :typeid", [typeid: typeid] ];
    }
    
}