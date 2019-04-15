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
import javax.swing.*;
import com.rameses.io.*;

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
        },
        openItem: { o, colName ->
            def op = Inv.lookupOpener("vw_obo_building_subapplication:open", [entity: o]);
            op.target = "popup";
            return op;
        }
    ] as BasicListModel;
    
    def workitemListModel = [
        fetchList: { o->
            return [];
            /*
            def m = [_schemaname: "vw_obo_building_application_workitem" ];
            m.findBy = [appid: entity.objid];
            return queryService.getList( m );
            */
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
        def chooser = new JFileChooser();
        int i = chooser.showOpenDialog(null);
        if(i==0) {
            MsgBox.alert("uploaded!");
        }
    }    
    
    def viewDocument() {
        return Inv.lookupOpener("view_document", [:]);
    }  

    
}