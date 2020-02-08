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


abstract class AbstractApplicationModel extends WorkflowTaskModel {
    
    public abstract String getPermitName();
    public abstract def getFeeService();

    
    def reqViewType = "open";
    def reqQuery = [:];
    def reqListHandler;
    
    def sectionView = "all";
    def sectionQry = [:];
    def sectionListHandler;
    
    def findingView = "all"
    def findingQry = [:];
    def findingListHandler;

    def feeQry = [:];
    def feeListHandler;
    
    @PropertyChangeListener
    def listener = [
        "reqViewType": { o->
            //this is the entire filter for requirements
            if (o == "open") {
                reqQuery.where = reqQuery._filter + " AND state IN (0,2) ";
            }
            else if( o == "applicable") {
                reqQuery.where = reqQuery._filter + " AND state <> 3 ";                
            }
            else {
                reqQuery.where = reqQuery._filter;
            }
            reqListHandler.reload();
        },
        "sectionView" : { o->
            if(o == "open") {
                sectionQry.where = sectionQry._filter +  " AND task.state NOT IN ('end', 'obo-processing') ";
            }
            else if(o == "closed") {
                sectionQry.where = sectionQry._filter +  " AND task.state IN ('end', 'obo-processing') ";
            }            
            else {
                sectionQry.where = sectionQry._filter;                
            }
            sectionListHandler.reload();           
        },
        "findingView" : { o->
            findingListHandler.reload();
        }
    ];
    
    void buildQuery()  {
        reqQuery.appid =  entity.objid;
        reqQuery._filter = "appid = :appid AND supersederid IS NULL";
        reqQuery.where = reqQuery._filter + " AND state IN (0,2) "; 
        
        sectionQry.appid = entity.objid;
        sectionQry._filter = "appid = :appid";
        sectionQry.where = sectionQry._filter;
        
        findingQry.appid = entity.objid;
        findingQry._filter = "appid = :appid AND supersederid IS NULL AND state=2";
        findingQry.where = findingQry._filter;
        
        feeQry.appid = entity.objid;
        feeQry.where  = "appid = :appid";
    }    
    
    public void afterOpen() {
        buildQuery();
    }
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    String getBarcodeFieldname() {
        return "appno";
    }
    
    public String getFormId() {
        return entity.objid;
    }
    
    
    
    
    def previewFees() {
        def m = [entity:[objid: entity.objid ]];
        return Inv.lookupOpener(getPermitName() + "_assessment:preview", m );        
    }
    
    /***************
    * capture payment
    ***************/
    def capturePayment() {
        return nInv.lookupOpener(getPermitName() + "_capture_payment", [entity: entity] );
    }
    
}


