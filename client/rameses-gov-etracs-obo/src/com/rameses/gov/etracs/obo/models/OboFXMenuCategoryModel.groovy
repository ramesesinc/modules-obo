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
    
    void loadDynamicItems( String _id, def subitems, def invokers ) {
        def buildInvokers = { list, title ->
            int i = 100;
            list.each {
                try {
                    def id = title + "/" + it.objid;
                    def notid = (title + ":" + it.objid.toLowerCase()).trim();
                    def subitem = [ id: id, caption: it.title, index: (i++), notificationid: notid, event: title ];
                    subitems << subitem;
                    def sinv = title + ":list";
                    def op = Inv.lookupOpener(sinv, [typeid: it.objid, 'title': it.title ]);
                    op.domain = "OBO";
                    op.target = 'window';
                    op.id = sinv;
                    invokers.put( id, op );
                    subitem.modulename = "obo";
                    subitem.domain = op.domain;
                    subitem.connection = "obo";      
                }
                catch(e) {
                    //println e.message;
                }
            }
        }
        
        if(_id == 'building_evaluation' ) {
            def list = evalTypeSvc.getAllowedEvaluationTypes( [:] );
            buildInvokers( list, 'building_evaluation' );
        }
        else if(_id == 'occupancy_inspection' ) {
            def list = inspectionTypeSvc.getAllowedInspectionTypes( [:] );
            buildInvokers( list, 'occupancy_inspection' );
        }        
        else if( _id == 'obo_doctype' ) {
            def m = [_schemaname:"vw_obo_doctype"];
            m.where = ["issuetype = 2", [:] ];
            m.orderBy = "sortorder";
            m.select = "objid,title,apptype";
            if(userInfo.env.ORGROOT == 1) {
                m.where[0] += " AND org.objid IS NULL";
            } 
            else {
                m.where[0] += " AND org.objid = :orgid"
                m.where[1].orgid = userInfo.env.ORGID;
            }
            def list = querySvc.getList(m);
            buildInvokers( list.findAll{ it.apptype == 'building' }, 'building_application_subdoc' );
            //buildInvokers( list.findAll{ it.apptype == 'occupancy' }, 'occupancy_application_subdoc' );            
        }
    }
    
}