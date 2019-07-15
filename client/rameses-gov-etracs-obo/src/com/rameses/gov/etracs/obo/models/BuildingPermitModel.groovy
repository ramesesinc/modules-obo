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

class BuildingPermitModel extends WorkflowTaskModel {

    def showOption = "showall";
    def query = [:];
    def evaluationHandler;
    
    @PropertyChangeListener
    def listener = [
        "showOption" : { o->
            if(o == "showunfinished") {
                query.where = " task.state NOT IN ('end', 'for-verification') ";
            }
            else if(o == "showfinished") {
                query.where = " task.state = 'end' ";
            }            
            else {
                query.remove("where");                
            }
            evaluationHandler.reload();            
        }
    ]
    
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    String getBarcodeFieldname() {
        return "appno";
    }
    
    public String getTitle() {
        return (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + "[ " +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    public void afterInit() {
        query.objid = entity.objid;
    }
    
    /*
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
    */
    
    public boolean getShowUpdateZoneclass() {
        return (task.state == "zoning-evaluation");
    }
    
    def updateZoneclass() {
        def h = { zc ->
            def m = [_schemaname:'building_permit'];
            m.findBy = [objid: entity.objid ];
            m.zoneclassid = zc.objid;
            persistenceService.update(m);
            entity.zoneclass = zc;
            binding.refresh();
        }
        return Inv.lookupOpener("obo_zoneclass:lookup", [ onselect:  h] );
    }
    
}