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
    
    @Service("OboMenuNotificationService")
    def oboMenuSvc;
    
    public String getMenuContextName() {
        return "building_application";
    }
    
    public def getMenuNotificationService() {
        return oboMenuSvc;
    }
    
    void loadDynamicItems( String _id, def subitems, def invokers ) {
        def secProvider = clientContext.getSecurityProvider();
        def orgFilter = [:];
        boolean isRoot = (OsirisContext.env.ORGROOT == 1);
        if(isRoot) {
            orgFilter = ["org.objid IS NULL"];
        }
        else {
            orgFilter = ["org.objid = :orgid", [orgid: OsirisContext.env.ORGID] ];
        }
        
        def buildInvokers = { list, title ->
            int i = 100;
            list.each {
                if(it.role) {
                    boolean b = secProvider.checkPermission( workunit.workunit.module.domain, it.role, ".*" );
                    if(!b) return;
                };
                def id = title + "/" + it.objid;
                def notid = title + ":" + it.objid.toLowerCase();
                subitems << [ id: id, caption: it.title, index: (i++), notificationid: notid, event: title ];
                def sinv = title + ":list"
                def op = Inv.lookupOpener(sinv, [typeid: it.objid, 'title': it.title ]);
                op.domain = "OBO";
                op.target = 'window';
                op.id = sinv;
                invokers.put( id, op );
            }
        }
        
        if(_id == 'building_evaluation' ) {
            def m = [_schemaname: "building_evaluation_type" ];
            m._limit = 100;
            m.where =  orgFilter;
            m.orderBy = "sortindex";
            def list = querySvc.getList( m );
            buildInvokers( list, 'building_evaluation' );
        }
        else if( _id == 'building_issuance_release' ) {
            def m = [_schemaname: "building_evaluation_type" ];
            m._limit = 100;
            orgFilter[0] = orgFilter[0] + ' AND NOT(issuanceid IS NULL) ';
            m.where =  orgFilter;
            m.orderBy = "sortindex";
            def list = querySvc.getList( m ).collect{ [objid: it.issuanceid, title: it.issuance.title ] };
            buildInvokers( list, 'building_issuance_release' );            
        }        
        else if( _id == 'building_issuance' ) {
            def m = [_schemaname: "building_evaluation_type" ];
            m._limit = 100;
            orgFilter[0] = orgFilter[0] + ' AND NOT(issuanceid IS NULL) ';
            m.where =  orgFilter;
            m.orderBy = "sortindex";
            def list = querySvc.getList( m ).collect{ [objid: it.issuanceid, title: it.issuance.title ] };
            buildInvokers( list, 'building_issuance' );            
        }
        else if(_id == 'occupancy_inspection' ) {
            def m = [_schemaname: "occupancy_inspection_type" ];
            m._limit = 100;
            m.where =  orgFilter;
            m.orderBy = "sortindex";
            def list = querySvc.getList( m );
            buildInvokers( list, 'occupancy_inspection' );
        }        
       
    }
    
}