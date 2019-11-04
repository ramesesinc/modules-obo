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

class BuildingPermitSectionModel extends WorkflowTaskModel {

    @Service("BuildingPermitSectionService")
    def appSvc;
    
    @Service("BuildingPermitInfoService")
    def infoSvc;
    
     @Service("BuildingPermitFeeService")
    def feeSvc;
    
    def infos;
    def receipt;
    def findingListHandler;
    def feeListHandler;
    
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
        m.findBy = [appid: entity.appid,permittypeid: entity.typeid ];
        def zz = queryService.findFirst( m );
        if(!zz )
            throw new Exception("There is no associated ancillary permit for this section");
        
        def op = Inv.lookupOpener("building_permit_ancillary:open", [entity: [objid: zz.objid ] ] );
        op.target = "popup";
        return op;
    }

    def viewAssessment() {
        if(! entity.app.zoneclass?.objid )
            throw new Exception("Please specify a zone class first");
        def f = [:];
        f.app = [ 
            appid: entity.app.objid,
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
        f.permits = [ [type: entity.typeid ] ];
        f.sectionid = entity.typeid;
        def h  = { list->
            list.each {
                it.appid = entity.appid;
                it.parentid = entity.objid;
                it.amtpaid = 0;
            }
            feeSvc.saveFees( list );
            feeListHandler.reload();
        }
        return Inv.lookupOpener("view_assessment", [params: f, handler: h] );
    }
    
    def addFee() {
        def m = [appid: entity.appid, parentid: entity.objid, typeid: entity.typeid ];
        return Inv.lookupOpener("building_permit_fee:create", m );
    }
    
    
    def issuePermit() {
        def m = [showpermitno:true, appid:entity.appid, evaluationid: entity.objid, typeid: entity.typeid ];
        m.handler = { o->
            entity.permit = o;
            reload();
        }
        return Inv.lookupOpener("building_permit_issuance:create", m );
    }
    
    
}