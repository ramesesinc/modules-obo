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

    @Service("OboMenuService")
    def menuSvc;
    
    def buildInvokers = { list, subitems, invokers ->
        int i = 100;
        list.each {
            try {
                if(!it.handler) return;
                def title = it.handler;
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
    
    void loadDynamicItems( String _id, def subitems, def invokers ) {
        if(_id == 'building_evaluation' ) {
            def list = menuSvc.getEvaluationTypesMenu();
            list.each {
                it.handler = "building_evaluation";
            }
            buildInvokers( list, subitems, invokers );
        }
        else if(_id == 'occupancy_inspection' ) {
            def list = menuSvc.getInspectionTypesMenu();
            list.each {
        	it.handler = "occupancy_inspection";
            }
            buildInvokers( list, subitems, invokers );
        }        
        else if( _id == 'obo_doctype' ) {
            def list = menuSvc.getDocumentsForIssuance();
            list.each {
		it.handler = it.apptype + "_permit_doc";
            }
            buildInvokers( list, subitems, invokers );
        }
    }
    
}