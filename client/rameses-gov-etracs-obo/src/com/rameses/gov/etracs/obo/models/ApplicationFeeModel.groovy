package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class ApplicationFeeModel  {
    
    def doctypeid;
    def entity;
    def saveHandler;

    void init() {
        if(!entity) entity = [:];
        if(!entity.amtpaid) entity.amtpaid = 0;
    }
    
    def getLookupAccount() {
        if( doctypeid ) {
            def filter = ["query.doctypeid": doctypeid];
            return Inv.lookupOpener( "obo_itemaccount:type:lookup", filter );
        }
        else {
            return Inv.lookupOpener( "obo_itemaccount:obo:lookup", [:] );
        } 
    }
    
    def doOk() {
        saveHandler( entity );
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}