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

public class OboRequirementTypeModel extends CrudFormModel {
    
    def types = ["DOC", "PROC"];
    def workflowStates;
    
    def processNames  = ["obo_application", "obo_subapplication"];
    
    @PropertyChangeListener
    def listener = [
        "entity.processname" : { o->
           loadWorkflowStates(o); 
        }
    ];
    
    void afterInit() {
        loadWorkflowStates(entity.processname);
    }
    
    void loadWorkflowStates( def o ) {
        if( o!=null ) {
            def m = [_schemaname:'sys_wf_node'];
            m.select = "name,title";
            m.findBy = [processname: o];
            m.where = [ " name NOT IN ('start','end') "];
            m.orderBy = "idx";
            workflowStates = queryService.getList(m);
        }
        else {
            workflowStates = [];
            entity.activationstate = null;
            entity.validationstate = null;
        }
    }
    
}