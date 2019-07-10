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

class BuildingPermitEvaluationModel extends WorkflowTaskModel {

    @Service("BuildingPermitEvaluationService")
    def appSvc;
    
    def infos;
    
    def findingListHandler;
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    /*
    String getBarcodeFieldname() {
        return "appno";
    }
    */
    
    @FormTitle
    public String getTitle() {
        return entity.app.appno + " " + entity.type.title;
    }
    
    public String getWindowTitle() {
        return entity.app.appno;
    }
    
    public String getFormId() {
        return entity.objid;
    }
  
    def addFinding() {
        def m = [:];
        m.appid = entity.appid;
        m.parentid = entity.objid;
        m.handler = {
            findingListHandler.reload();
        }
        return Inv.lookupOpener("building_permit_finding:create", m);
    }
    
    def viewApplication() {
        def op = Inv.lookupOpener("vw_building_permit:open", [entity: [objid: entity.appid ] ] );
        op.target = "popup";
        return op;
    }
}