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
    
    @Service("BuildingPermitInfoService")
    def infoSvc;
    
    def infos;
    def receipt;
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
        if(! entity.app.zoneclass?.objid )
            throw new Exception("Please specify a zone class first");
        def f = [:];
        f.app = [ 
            appno:entity.app.appno, 
            appdate:entity.app.appdate, 
            apptype:entity.app.apptype, 
            projectcost: entity.app.projectcost, 
            fixedcost: entity.app.fixedcost,
            height: ((entity.app.height == null)?0:entity.app.height),
            numunits: entity.app.numunits,
            totalfloorarea: entity.app.totalfloorarea,
            zoneclass: entity.app.zoneclass?.objid
        ];
        def occ = entity.app.occupancytype;
        f.occupancytype = [division:occ.division.objid, group:occ.group.objid, type:occ.objid ];
        if( entity.ancillarypermitid != null  ) {
            def m = [_schemaname: 'building_permit_ancillary'];
            m.findBy = [appid: entity.appid,permittypeid: entity.ancillarypermitid ];
            def zz = queryService.findFirst( m );
            f.infos = infoSvc.getInfos( [parentid: zz.objid ]);            
        }
        MsgBox.alert( "type id is " + entity.typeid);
        f.permits = [ [type: entity.typeid ] ];
        return Inv.lookupOpener("view_assessment", [params: f] );
    }
    
    def issuePermit() {
        MsgBox.alert("issue permit");
    }
    
}