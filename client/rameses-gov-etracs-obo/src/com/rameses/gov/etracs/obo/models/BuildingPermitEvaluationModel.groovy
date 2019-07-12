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
    
     def viewAncillaryPermit() {
        //find first the objid of ancillary permit
        def m = [_schemaname: 'building_permit_ancillary'];
        m.findBy = [appid: entity.appid,permittypeid: entity.ancillarypermitid ];
        def zz = queryService.findFirst( m );
        def op = Inv.lookupOpener("building_permit_ancillary:open", [entity: [objid: zz.objid ] ] );
        op.target = "popup";
        return op;
    }

    def viewAssessment() {
        MsgBox.alert("view assessment");
        //
        /*
        def f = [:];
        f.app = [ 
            appno:entity.appno, 
            appdate:entity.appdate, 
            apptype:entity.apptype, 
            projectcost: entity.projectcost, 
            height: ((entity.height == null)?0:entity.height),
            numunits: entity.numunits,
            floorarea: entity.floorarea
        ];
        f.occupancytype = [division:entity.occupancytypeid, group:entity.occupancytypegroup ];
        f.infos = infos;
        f.permits = [ [type: entity.typeid ] ];
        return Inv.lookupOpener("view_assessment", [params: f] );
        */
    }
    
}