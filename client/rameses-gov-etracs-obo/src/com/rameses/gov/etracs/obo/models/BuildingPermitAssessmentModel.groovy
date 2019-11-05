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

class BuildingPermitAssessmentModel extends PageFlowController {
    
    @Service("BuildingPermitAssessmentService")
    def assmtSvc;

    def params;
    def list;
    def handler;

    def listHandler = [
        fetchList: { o->
            return list;
        }
    ] as BasicListModel;

    void execute() {
        params.savefees = false;
        list = assmtSvc.assess( params ).items;
    }

    def doClose() {
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }

    def doOk() {
        if(handler) handler( list );
        return "_close";
    }

}