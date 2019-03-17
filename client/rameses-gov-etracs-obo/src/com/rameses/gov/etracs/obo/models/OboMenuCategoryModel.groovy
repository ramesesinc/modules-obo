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
        if(_id.matches('building|occupancy') ) {
            def m = [_schemaname: "obo_section" ];
            m.orderBy = "idx";
            m._limit = 200;
            def list = querySvc.getList( m );
            list.each {
                if(it.role) {
                    boolean b = secProvider.checkPermission( workunit.workunit.module.domain, it.role, ".*" );
                    if(!b) return;
                }
                def id = _id + "/" + it.objid;
                subitems << [ id: id, caption: it.title, index: (100+ it.idx) ];
                def op = Inv.lookupOpener("obo_subapplication:list", ['sectionid': it.objid, 'title': it.title ]);
                op.target = 'window';
                invokers.put( id, op);
            }
            
            //load also subprocesses
            m.clear();
            m = [_schemaname: "obo_requirement_type" ];
            m.findBy = [type:'PROC'];
            m._limit = 100;
            //m.where = ["org.objid = :"]
            list = querySvc.getList( m );
            int i = 100;
            list.each {
                def id = _id + "/" + it.objid;
                subitems << [ id: id, caption: it.title, index: (i++) ];
                def op = Inv.lookupOpener("obo_application_subproc:list", [typeid: it.objid, 'title': it.title ]);
                op.target = 'window';
                invokers.put( id, op );
            }
        }
        
    }
    
}