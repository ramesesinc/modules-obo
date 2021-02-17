package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class ApplicationFindingListModel extends AbstractComponentModel {

    String sectiontitle;
    String sectiontypeid;
        
    def viewType = "open";
    
    @PropertyChangeListener
    def listener = [
        "viewType": { o->
            listHandler.reload();
        }
    ];

    public void beforeLoadList( def qry ) {
        qry.where = [ " supersederid IS NULL "]; 
        /*
        if( viewType == "open" ) {
            w1 += " AND state IN (0,2) ";
        }
        else if( viewType == "applicable") {
            w1 += " AND state <> 3 ";
        }
        */        
    }

    def handler = [
        save: { o->
            o._schemaname = schemaName;
            if(!o.objid) {
                o.appid = appid;
                o.parentid = parentid;
                persistenceService.save( o );
            }
            else {
                persistenceService.update( o );                
            }
            listHandler.reload();
        },
        removeItem: { o->
            removeItem();            
        } 
    ]
    
    def addFinding() {
        def t = null;
        if( schemaName.matches(".*evaluation.*") ) {
            t = "evaluation";
        }
        else {
            t = "inspection";
        }
        def q = [query:[:]];
        q.query.typeid = sectiontypeid;
        q.onselect = { itms ->
            itms.each {
                def r = [:];
                r.checklistitemid = it.objid;
                r.state = 2;
                handler.save(r);
                listHandler.reload();
            }
        }
        def op = Inv.lookupOpener("obo_checklist_master_"+t+":lookup", q);
        return op;
        /*
        def p = [:];
        p.handler = handler;
        p.title = "Finding";
        p.sectiontitle = sectiontitle;
        p.editable = editable;
        def op = Inv.lookupOpener("application_finding:create", p );
        op.target = "popup";
        return op;
        */
    }
    
    public def openItem(def o) {
        def p = [:];
        p.title = "Finding";
        p.sectiontitle = o.parent?.type?.title;
        p.entity = o;
        p.handler = handler;
        p.editable = editable;
        def op = Inv.lookupOpener("application_finding:open", p );
        op.target = "popup";
        return op;
    }
    
    void removeItem() {
        if(!selectedItem) throw new Exception("Please select an item");
        //if(selectedItem.state != 2) throw new Exception("Only open items can be deleted")        
        //if(selectedItem.supersederid !=null) throw new Exception("Superseded items cannot be deleted")
        //if(selectedItem.createdby.objid != user.userid )
        //    throw new Exception("Only the creator of this item can delete it");
        def m = [_schemaname: schemaName ];
        m.objid = selectedItem.objid;
        persistenceService.removeEntity( m );
        listHandler.reload();
    }
    
}
