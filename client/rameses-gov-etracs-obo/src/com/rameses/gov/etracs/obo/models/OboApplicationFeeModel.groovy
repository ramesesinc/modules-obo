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

class OboApplicationFeeModel extends CrudFormModel {
    
    def appid;
    def parentid;
    def typeid;
    def handler;
    def source;
    
    def open( inv ) {
        schemaName = inv.properties.schemaName;
        source = inv.properties.source;
        return super.open();
    }
    
    def create( inv ) {
        schemaName = inv.properties.schemaName;
        source = inv.properties.source;
        return super.create();
    }

    void afterCreate() {
        entity.appid = appid;
        entity.sectionid = typeid;
        entity.amtpaid = 0;
    }
    
    def getLookupAccount() {
        def m = ["query.typeid": typeid ];
        return Inv.lookupOpener(source + ":lookup", m );
    }
    
    void afterSave() {
        if(handler) handler(entity);
    }
}