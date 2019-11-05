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

class BuildingPermitFeeModel extends CrudFormModel {
    
    def appid;
    def parentid;
    def typeid;
    def handler;
    
    void afterCreate() {
        entity.appid = appid;
        entity.parentid = parentid;
        entity.amtpaid = 0;
    }
    
    def getLookupAccount() {
        def m = ["query.sectionid": typeid ];
        return Inv.lookupOpener( "obo_itemaccount:type:lookup", m );
    }
    
    void afterSave(o) {
        if(handler) handler(o);
    }
}