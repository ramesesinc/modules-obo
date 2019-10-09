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

class BuildingPermitOnlineModel extends WorkflowTaskModel {

    @Service("BuildingPermitOnlineService")
    def bpSvc;
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    String getBarcodeFieldname() {
        return "trackingno";
    }
    
    public String getTitle() {
        return "Online Building Permit Application - " + entity.trackingno;
    }
    
    public String getWindowTitle() {
        return entity.appno;
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    def infoListModel = [
        fetchList : { o->
            return [];
        }
    ] as BasicListModel;
    
    void verifyDoc() {
        if(!selectedDocument)throw new Exception("Please select a document to verify");
        def m = [_schemaname: 'building_permit_requirement'];
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
    
    def accept() {
        if(!MsgBox.confirm("You are about to accept this application. Proceed?")) return;
        bpSvc.accept( entity );
        return Inv.lookupOpener("vw_building_permit:open", [entity:entity] );       
    }
    
}