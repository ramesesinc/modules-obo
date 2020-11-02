package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;
import java.text.*;

class ApplicationChecklistModel extends AbstractComponentModel {

    def doctypeid;
    
    /*
    def listHandler = [
        isMultiSelect: {
            return true;
        },
        openItem: { o, col ->
            return updateChecklistItem(o);
        }, 
        fetchList: { o->
            def m = [_schemaname: schemaName];
            m.findBy = 
            return chklistSvc.getList( [objid: entity.objid ] );
        }
    ] as BasicListModel;
    */
    
    
    void afterLoadList() {
        def result = [];
        _items.each {
                def m = [:];
                m.objid = it.objid;
                m.template = it.type.title;
                m.category = it.type.category;
                m.params = it.type.params;
                m.typeid = it.typeid;
                m.indexno = it.type.indexno;
                m.values = it.values;
                if( it.values ) {
                    Object[] ov = it.values;
                    m.particulars = MessageFormat.format( m.template, ov );
                }
                else {
                    m.particulars = m.template;
                }
                result << m;
        }
        _items = result.sort{ it.typeid };
    }    
    
    public def addItems() {
        def pp = [:]
        pp.onselect = { o->
            def p = [:];
            p.objid = parentid;
            p.items = o.collect{ [objid: it.objid ] };
            handler.saveItems( p );
            listHandler.reload();
        };
        pp.put("query.typeid", doctypeid );
        return Inv.lookupOpener("obo_checklist_master:lookup", pp);
    }
    
    public def removeItems() {
        def selectedChecklistItems = listHandler.getSelectedValue();
        if(!selectedChecklistItems) return;
        def p = [:];
        p.items = selectedChecklistItems.collect{[objid: it.objid] };
        handler.removeItems( p );
        listHandler.reload();
    }
    
    
    public def editItem() {
        if(selectedItem == null) throw new Exception("Please select an item");
        return updateItem(selectedItem);
    }
    
    public def openItem( def o ) {
        return updateItem( o );
    }
    
    public def updateItem(def o) {
        def h = { u ->
            handler.updateItem( u );
            listHandler.reload();
        }
        return Inv.lookupOpener( "application_checklist_item", [entity: o, handler: h])
    }
    
    
}
