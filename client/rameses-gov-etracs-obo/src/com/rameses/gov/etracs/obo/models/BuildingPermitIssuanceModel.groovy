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

    @Service("BuildingPermitIssuanceService")
    def issuanceSvc;
    
    def feeQry = [:];
    def feeListHandler;
    
    void buildQuery() {
        feeQry.appid = entity.appid;
        feeQry.where = "appid = :appid";
        if( entity.sectionid == null ) {
            feeQry.where += " AND org.objid IS NULL";
        }
        else {
            feeQry.sectionid = entity.sectionid;
            feeQry.where += " AND sectionid = :sectionid ";
        }
    }
    
    
    public void afterOpen() {
        buildQuery();
        //MsgBox.alert( "appid " + entity.appid + " " + entity.sectionid )
    }
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    String getBarcodeFieldname() {
        return "appno";
    }
    
    public String getTitle() {
        return entity.type.title + " Issuance: " + ((entity.controlno==null) ?"(New)" : entity.controlno);
    }
    
    public String getWindowTitle() {
        return (entity.controlno==null? entity.typeid + " " + entity.appno : entity.controlno);
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    def viewApplication() {
        def op = Inv.lookupOpener("vw_building_permit:open", [entity: [objid: entity.appid ] ] );
        op.target = "popup";
        return op;
    }
    
    def issue() {
        def h = { o->
            entity.putAll(o);
            binding.refresh();
        }
        return Inv.lookupOpener("building_permit_issuance:issue", [handler: h])
    }
    
    def print() {
        
    }
    
}


