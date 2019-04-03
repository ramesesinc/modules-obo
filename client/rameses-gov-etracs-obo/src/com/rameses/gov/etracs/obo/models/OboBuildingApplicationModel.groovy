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

class OboBuildingApplicationModel extends WorkflowTaskModel {

    def selectedSubApplication;
    def selectedDocument;
    def docHandler;
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    String getBarcodeFieldname() {
        return "appno";
    }
    
    public String getTitle() {
        return entity.appno + "[ " +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return entity.appno;
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    
    def subApplicationListModel = [
        fetchList: { o->
            def m = [_schemaname: "vw_obo_building_subapplication" ];
            m.findBy = [appid: entity.objid];
            return queryService.getList( m );
        }
    ] as BasicListModel;
    
    def workitemListModel = [
        fetchList: { o->
            def m = [_schemaname: "vw_obo_building_application_workitem" ];
            m.findBy = [appid: entity.objid];
            return queryService.getList( m );
        }
    ] as BasicListModel;
   
    def infoListModel = [
        fetchList : { o->
            return [];
        }
    ] as BasicListModel;
    
    void verifyDoc() {
        if(!selectedDocument)throw new Exception("Please select a document to verify");
        def m = [_schemaname: 'obo_building_application_requirement'];
        m.findBy = [objid: selectedDocument.objid];
        m.status = 1;
        persistenceService.update( m );
        docHandler.reload();
    }
    
    
    def uploadDocument() {
        MsgBox.alert("upload document");
    }    
    
    def viewDocument() {
        MsgBox.alert("view document");
    }  

    def addFinding() {
        def m = [:];
        m.appid = entity.appid;
        m.workitemid = entity.objid;
        m.handler = {
            
        }
        return Inv.lookupOpener("obo_building_application_finding:create", [handler: h ]);
    }
    
      

    /*
    void addAttachment()  {
        def p = [:];
        p.appid = entity.objid;
        p._schemaname = 'obo_building_application_attachment';
        
        def h = { o->
            attachmentListModel.reload();
        }
        Modal.show( "obo_application_attachment:create", [info:p, handler: h] );
    }

    def attachmentListModel = [
        fetchList: { o->
            def m = [_schemaname: 'obo_building_application_attachment'];
            m.findBy = [appid: entity.objid];
            return queryService.getList( m );
        },
        onOpenItem: { o,colName->
            def opener = Inv.lookupOpener("sys_file:open", [entity: [objid: o.fileid]] );
            opener.target = 'popup'; 
            return opener; 
        }
    ] as BasicListModel;
    */
    
}