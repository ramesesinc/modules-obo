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

class OboApplicationSubapplicationListModel extends WorkflowTaskListModel {
    
    def sectionid;
    String title;
    
    void afterInit() {
        MsgBox.alert("after init " + sectionid);
    }
    
    
}