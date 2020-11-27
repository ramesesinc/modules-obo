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

class OboAssessmentModel extends PageFlowController {
    
    @Service("OboApplicationFeeService")
    def assmtSvc;

    def params;
    def list;
    def handler;
    def schemaName;

    def listHandler = [
        fetchList: { o->
            return list;
        }
    ] as BasicListModel;

    void execute() {
        params.savefees = false;
        params._schemaname = schemaName;
        list = assmtSvc.assess( params ).items;
    }

    def doCancel() {
        return "_close";
    }

    def doOk() {
        if(!list) return;
        handler( [items: list] );
        return "_close";
    }

}