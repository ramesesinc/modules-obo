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
        return "building_permit";
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
                def notid = it.objid.toLowerCase();
                subitems << [ id: id, caption: it.title, index: (i++), notificationid: notid, event: title ];
                def sinv = title + ":list"
                def op = Inv.lookupOpener(sinv, [typeid: it.objid, 'title': it.title ]);
                op.domain = "OBO";
                op.target = 'window';
                op.id = sinv;
                invokers.put( id, op );
            }
        }
        
        if(_id == 'building_permit_section' ) {
            def m = [_schemaname: "obo_section" ];
            m._limit = 100;
            orgFilter[0]+= " AND NOT(buildingpermitstate IS NULL)"
            m.where =  orgFilter;
            m.orderBy = "sortindex";
            def list = querySvc.getList( m );
            buildInvokers( list, 'building_permit_section' );
        }
        else if(_id == 'occupancy_permit_section' ) {
            def m = [_schemaname: "obo_section" ];
            m._limit = 100;
            orgFilter[0] += " AND NOT(occupancypermitstate IS NULL)"
            m.where =  orgFilter;
            m.orderBy = "sortindex";
            def list = querySvc.getList( m );
            buildInvokers( list, 'occupancy_permit_section' );
        }        
        else if( _id == "permit_issuance") {
            def m = [_schemaname: "obo_issuance_type" ];
            m._limit = 100;
            
            def sorgFilter = [:]
            if(isRoot) {
                sorgFilter = ["section.org.objid IS NULL"];
            }
            else {
                sorgFilter = ["section.org.objid = :orgid", [orgid: OsirisContext.env.ORGID] ];
            }
            m.where =  sorgFilter;
            m.orderBy = "sortindex";
            def list = querySvc.getList( m );
            buildInvokers( list, 'building_permit_issuance' );
        }
    }
    
}