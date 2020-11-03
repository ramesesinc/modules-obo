package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.client.OsirisContext
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;
import com.rameses.rcp.framework.ClientContext;

class ApplicationDocumentListModel extends AbstractComponentModel {

    @Script("User")
    def user;
    
    String sectionid;
    String apptype;
    
    void init() {
        //MsgBox.alert("init "+ sectionid + " " + orgid);
    }
    
    void beforeLoadList(def params) {
        if(sectionid) {
            params.where = ["sectionid = :sectionid", [sectionid: sectionid ]];
        }
    }
    
    def addDocument() {
        if( !apptype) throw new Exception("Please specify apptype");
        
        def h = [:]
        h.onselect = { o->
            def s = entitySchemaName;
            if(!s) s = schemaName;
            def pq = [_schemaname: s];
            pq.appid = appid;
            pq.doctypeid = o.objid;
            pq.doctype = [objid: o.objid ];
            pq.state = 0;
            pq.amount = 0;
            if(handler!=null && handler.beforeSave ) {
                handler.beforeSave( pq );
            }
            persistenceService.create( pq );
            refresh();
        }
        h.listHandler = [
            fetchList: {
                def m = [_schemaname:"obo_doctype"];
                m.findBy = [apptype: apptype];
                if( OsirisContext.getEnv().ORGROOT == 1 ) {
                    m.where = ["section.org.objid IS NULL"];
                }
                else {
                    m.where = ["section.org.objid = :orgid", [orgid: OsirisContext.getEnv().ORGID ]];
                }
                return queryService.getList(m);
            },
            getColumns: {
                return [
                    [name:"objid", caption:"Document Type"],
                    [name:"title", caption:"Document Title"],                    
                ];
            }
        ] as BasicListModel;
        h.title = "Please select a document type";
        return Inv.lookupOpener( "simple_list_lookup" , h );
    }
    
    def removeDocument() {
        if(!selectedItem) throw new Exception("Please select a document.");
        if( user.org == null ) {
            if( selectedItem.org?.objid !=null )
                throw new Exception("Cannot remove this document because it is not on the same org");
        }
        else {
            if(selectedItem.org?.objid != user.org )
                throw new Exception("Cannot remove this document because it is not on the same org");            
        }
        if( sectionid != selectedItem.sectionid )
            throw new Exception("Cannot remove this document because it is not on the same section");
        
        if(!MsgBox.confirm("You are about to remove this document. Proceed?")) return null;
        def s = entitySchemaName;
        if(!s) s = schemaName;
        def u = [_schemaname: s];
        u.objid = selectedItem.objid;
        persistenceService.removeEntity( u );
        refresh();
    }
    
    
}
