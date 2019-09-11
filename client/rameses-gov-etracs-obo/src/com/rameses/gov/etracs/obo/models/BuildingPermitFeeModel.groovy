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
    
    void afterCreate() {
        entity.appid = caller.entity.appid;
        entity.parentid = caller.entity.objid;
        entity.amtpaid = 0;
    }
    
    def getLookupAccount() {
        def m = ["query.typeid": caller.entity.typeid ];
        return Inv.lookupOpener( "obo_itemaccount:type:lookup", m );
    }
    
}