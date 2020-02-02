package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*; 
import com.rameses.treasury.common.models.*; 
import com.rameses.osiris2.client.*
import com.rameses.osiris2.common.*
import com.rameses.util.*;
import com.rameses.seti2.models.*;
import com.rameses.rcp.framework.ClientContext;


public class PermitIssuanceReportFormModel extends FormReportModel {
    
    @Service("QueryService")
    def qrySvc;
    
    def appid;
    def sectionid;
    def entity;

    public def getQuery() {
        return [objid: entity.objid ];
    }

    def init() {
        String schemaname = getReportId();
        def m = [_schemaname: schemaname ];
        m.findBy = [appid : appid ];
        m.select = "objid";
        def p = qrySvc.findFirst( m );
        
        if(!p) {
            entity = [_schemaname:schemaname];
            entity.appid = appid;
            entity.sectionid = sectionid;
            entity.txnmode = "CAPTURE";
            boolean pass = false;
            def h = { o->
                entity = o;
                pass=  true;
            }
            Modal.show( "obo:permit_issuance", [entity: entity] );
            if(!pass) throw new BreakException();
        }
        else {
            entity = p;
        }
        return super.preview();
    }
    
    
    
}