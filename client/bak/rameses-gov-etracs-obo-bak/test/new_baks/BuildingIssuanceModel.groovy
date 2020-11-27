package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class BuildingIssuanceModel extends CrudFormModel {
    
    @Service("BuildingIssuanceService")
    def issuanceSvc;
    
    public String getTitle() {
        return caller.title + " " + caller.state;;
    }
    
    def viewApplication() {
        def op = Inv.lookupOpener("vw_building_application:open", [entity: [objid: entity.appid]] );
        op.target = "popup";
        return op;
    }
    
    def issueControlNo() {
        def h = { o->
            o.objid = entity.objid;
            def u = issuanceSvc.issueControlNo( o );
            entity.putAll( u );
            binding.refresh();
        }
        return Inv.lookupOpener("obo_issue_controlno", [handler: h]);
    }
    
}