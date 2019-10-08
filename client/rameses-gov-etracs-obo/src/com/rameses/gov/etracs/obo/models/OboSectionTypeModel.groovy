package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*
import com.rameses.rcp.common.*
import com.rameses.osiris2.client.*
import com.rameses.osiris2.common.*
import java.rmi.server.*;
import com.rameses.gov.etracs.bpls.application.*;
import com.rameses.util.*;
import com.rameses.osiris2.reports.*;
import com.rameses.seti2.models.*;

public class OboSectionTypeModel extends CrudFormModel {
    
    @Service("OboMiscListService")
    def svc;

    def workflowStates;
    def permitTypes;

    @PropertyChangeListener
    def listener = [
        "entity.permittype" : { o->
            if(o == null) {
                entity.permitid = null;
            }
            else {
                entity.permitid = o.objid;
            }
        }
    ]
    
    void afterInit() {
        permitTypes = svc.getPermitTypes();
        workflowStates = svc.getEvaluationTypeStates()*.name;
    }
    
    
}