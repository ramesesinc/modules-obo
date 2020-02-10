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
import com.rameses.gov.etracs.obo.models.*;

class BuildingEvaluationModel extends AbstractApplicationSectionModel {
    
    public String getCaption() {
        return "Building Evaluation";
    }
    
    public String getPrefix() {
        return "BE";
    }
    
    def viewApplication() {
        String s = "vw_building_application:open"; 
        def op = Inv.lookupOpener(s, [entity: [objid: entity.appid ] ] );
        op.target = "popup";
        return op;
    }
    
    def updateZoneclass() {
        def app = [objid: entity.appid, zoneclass: entity.app.zoneclass, zone: entity.app.zone ];
        def h = { o->
            entity.app.zoneclass = o.zoneclass;
            entity.app.zone = o.zone;
            binding.refresh("entity.app.zone.*");
        }
        return Inv.lookupOpener("building_application_zoneclass:view", [app: app, handler: h ] );
    }
    
    
    def addFinding() {
        return super.addFinding( "building_evaluation_finding");
    }
    
    /**************************************************************************
    * DOCUMENT ITEMS
    ***************************************************************************/
    def selectedDoc;
     def doclistModel;
    
    def addDocument() {
        def q = [:];
        q.put("query.typeid", entity.typeid )
        q.onselect = { o->
            def pq = [_schemaname: "building_application_subdoc"];
            pq.appid = entity.appid;
            pq.doctypeid = o.objid;
            pq.doctype = [objid: o.objid ];
            pq.state = 0;
            pq.amount = 0;
            pq.debug = true;
            persistenceService.create( pq );
            doclistModel.reload();
        }
        return Inv.lookupOpener("building_doc_type_typeid:lookup", q );
    }
    
    void removeDocument() {
        if(selectedDoc?.objid ==null ) throw new Exception("Please select document");
        if(!MsgBox.confirm("You are about to remove this document. Proceed?")) return;
        def m = [_schemaname: "building_application_subdoc"];
        m.objid = selectedDoc.objid;
        persistenceService.removeEntity(m);
        doclistModel.reload();
    }

    
}