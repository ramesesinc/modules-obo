package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class ApplicationFeeModel  {
    
    def handler;
    def entity;
    def saveHandler;

    void init() {
        if(!entity) entity = [:];
        if(!entity.amtpaid) entity.amtpaid = 0;
    }
    
    def getLookupAccount() {
        return handler.getAccountLookupHandler();
    }
    
    def doOk() {
        saveHandler( entity );
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}