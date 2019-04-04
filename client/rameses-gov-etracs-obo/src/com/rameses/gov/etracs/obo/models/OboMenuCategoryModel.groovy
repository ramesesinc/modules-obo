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
import com.rameses.menu.models.MenuCategoryModel;

class OboMenuCategoryModel  extends MenuCategoryModel {

    @Service("QueryService")
    def querySvc;
    
    void loadDynamicItems( String _id, def subitems, def invokers ) {
        def secProvider = clientContext.getSecurityProvider();
        if(_id.matches('(building|occupancy)_other') ) {
            boolean isRoot = (OsirisContext.env.ORGROOT == 1)
            def m = [_schemaname: "obo_requirement_type" ];
            m._limit = 200;
            m.orderBy = "sortindex";
            if(isRoot) {
                m.where = ["type IN ('PROC','PERMIT') AND org.objid IS NULL"];
            }
            else {
                m.where = ["type IN ('PROC','PERMIT') AND org.objid = :orgid", [orgid: OsirisContext.env.ORGID] ];
            }
            def list = querySvc.getList( m );
            int i = 100;
            list.each {
                if(it.role) {
                    boolean b = secProvider.checkPermission( workunit.workunit.module.domain, it.role, ".*" );
                    if(!b) return;
                }
                def id = _id + "/" + it.objid;
                subitems << [ id: id, caption: it.title, index: (i++) ];
                def sinv = "obo_" + _id.split("_")[0] + "_application_workitem:list"
                def op = Inv.lookupOpener(sinv, [typeid: it.objid, 'title': it.title ]);
                op.target = 'window';
                invokers.put( id, op );
            }
        }
        
    }
    
}