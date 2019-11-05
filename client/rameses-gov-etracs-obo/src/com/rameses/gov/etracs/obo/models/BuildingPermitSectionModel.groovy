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
        if(!entity.ancillaryid ) 
            throw new Exception("There is no associated ancillary permit ");
        def op = Inv.lookupOpener("building_permit_ancillary:open", [entity: [objid: entity.ancillaryid ] ] );
        op.target = "popup";
        return op;
    }

    def viewAssessment() {
        if(! entity.app.zoneclass?.objid )
            throw new Exception("Please specify a zone class first");
        def f = [:];
        f.appid = entity.app.objid;
        f.sectionid = entity.typeid;
        f.ancillaryid = entity.ancillaryid;
        f.save_fees = false;
        def h  = { list->
            list.each {
                it.appid = entity.appid;
                it.parentid = entity.objid;
                it.amtpaid = 0;
            }
            feeSvc.saveFees( list );
            feeListHandler.reload();
        }
        return Inv.lookupOpener("building_permit_assessment", [params: f, handler: h] );
    }
    
    def addFee() {
        def m = [appid: entity.appid, parentid: entity.objid, typeid: entity.typeid ];
        m.handler = { o->
            feeListHandler.reload();
        }
        return Inv.lookupOpener("building_permit_fee:create", m );
    }
    
    def updateZoneclass() {
        def app = [objid: entity.appid, zoneclass: entity.app.zoneclass, zone: entity.app.zone ];
        def h = { o->
            entity.app.zoneclass = o.zoneclass;
            entity.app.zone = o.zone;
            binding.refresh("entity.app.zone.*");
        }
        return Inv.lookupOpener("building_permit_zoneclass:view", [app: app, handler: h ] );
    }
    
    def addFinding() {
        def m = [:];
        m.sectionid = entity.objid;
        m.appid = entity.appid;
        m.parent = [typeid: entity.typeid ];
        m.handler = { o->
            findingListHandler.reload();
        }
        return Inv.lookupOpener("building_permit_finding:create", m );
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