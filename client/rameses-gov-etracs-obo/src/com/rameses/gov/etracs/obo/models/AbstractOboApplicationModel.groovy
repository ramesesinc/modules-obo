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


abstract class AbstractOboApplicationModel extends WorkflowTaskModel {

    @Service("OboApplicationService")
    def appSvc;
    
    @Service("OboApplicationAssessmentService")
    def feeSvc;
    
    @Service("OboApplicationRequirementService")
    def reqSvc;
    
    @Service("OboApplicationFindingService")
    def findingSvc;
    
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
                sectionQry.where = sectionQry._filter +  " AND task.state NOT IN ('obo-processing', 'end') ";
            }
            else if(o == "closed") {
                sectionQry.where = sectionQry._filter +  " AND task.state IN ('obo-processing', 'end') ";
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
        findingQry._filter = "appid = :appid AND supersederid IS NULL AND transmittalid IS NULL";
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
    
    public abstract String getPermitName();
    
    /**************************************************************************
    * assessment actions
    ***************************************************************************/
    def assess() {
        def f = [:];
        f.appid = entity.objid;
        def h  = { u->
            feeListHandler.reload();
            entity.amount = u.amount;
            binding.refresh("entity.amount")
        }
        return Inv.lookupOpener("building_permit_assessment", [params: f, handler: h] );
    }
    
    def addFee() {
        def m = [appid: entity.objid ];
        m.handler = { o->
            feeListHandler.reload();
        }
        return Inv.lookupOpener("building_permit_fee:create", m );
    }
    
    def clearFees() {
        def u = feeSvc.clearFees( [appid: entity.objid ] );
        entity.amount = u.amount;
        feeListHandler.reload();
    }
    
    /***************
    * capture payment
    ***************/
    def capturePayment() {
        return nInv.lookupOpener("building_permit_capture_payment", [entity: entity] );
    }
    
}


