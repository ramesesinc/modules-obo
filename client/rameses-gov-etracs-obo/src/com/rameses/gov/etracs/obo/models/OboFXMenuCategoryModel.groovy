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
import com.rameses.menu.models.*;

class OboFXMenuCategoryModel  extends FXMenuCategoryModel {

    @Service("QueryService")
    def querySvc;
    
    @Service("BuildingEvaluationTypeService")
    def evalTypeSvc;
    
    @Service("OccupancyInspectionTypeService")
    def inspectionTypeSvc;
    
    /*
    public String getMenuContextName() {
        return "building_application";
    }
    
    def secProvider = clientContext.getSecurityProvider();
        def orgFilter = [:];
        boolean isRoot = (OsirisContext.env.ORGROOT == 1);
        if(isRoot) {
            orgFilter = ["org.objid IS NULL"];
        }
        else {
            orgFilter = ["org.objid = :orgid", [orgid: OsirisContext.env.ORGID] ];
        }
        
    */
    
    void loadDynamicItems( String _id, def subitems, def invokers ) {
        def buildInvokers = { list, title ->
            int i = 100;
            list.each {
                def id = title + "/" + it.objid;
                def notid = (title + ":" + it.objid.toLowerCase()).trim();
                def subitem = [ id: id, caption: it.title, index: (i++), notificationid: notid, event: title ];
                subitems << subitem;
                def sinv = title + ":list"
                def op = Inv.lookupOpener(sinv, [typeid: it.objid, 'title': it.title ]);
                op.domain = "OBO";
                op.target = 'window';
                op.id = sinv;
                invokers.put( id, op );
                subitem.modulename = "obo";
                subitem.domain = op.domain;
                subitem.connection = "obo";                
            }
        }
        
        if(_id == 'building_evaluation' ) {
            def list = evalTypeSvc.getAllowedEvaluationTypes( [:] );
            buildInvokers( list, 'building_evaluation' );
        }
        else if(_id == 'occupancy_inspection' ) {
            def list = inspectionTypeSvc.getAllowedEvaluationTypes( [:] );
            buildInvokers( list, 'occupancy_inspection' );
        }        
       
    }
    
}