package com.rameses.gov.etracs.obo.occupancy.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class OccupancyAssessmentModel extends PageFlowController {
    
    @Service("OccupancyAssessmentService")
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

    def doCancel() {
        return "_close";
    }

    def doOk() {
        if(!list) return;
        //save it here
        list.each {
            it.appid = params.appid;
            it.sectionid = params.sectionid;
            it.amtpaid = 0;
        }
        def pp = [appid: params.appid, items: list ];
        def u = assmtSvc.saveFees( pp );
        handler( u );
        return "_close";
    }

}