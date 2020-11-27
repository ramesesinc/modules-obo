package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class ApplicationFeeListModel extends AbstractComponentModel {
    
    @Service("OboApplicationFeeService")
    def feeSvc;
    
    def doctypeid;
    def amount;
    
    void calcAmount() {
        if(!_items) {
            amount = 0;
        }
        else {
            amount = _items.sum{ it.amount };
        }
        binding.refresh("amount");
    }
    
    public void beforeLoadList(def m) {
        m.orderBy = "item.sortorder";
    }
    
    public void afterLoadList() {
        calcAmount();
    }
    
    def addFee() {
        def m = [:];
        m.doctypeid = doctypeid;
        m.entity = [:];
        m.saveHandler = { o->
            o._schemaname = entitySchemaName;
            o.appid = appid;
            o.parentid = parentid;
            feeSvc.saveFee( o );
            listHandler.reload();  
        }
        return Inv.lookupOpener("application_fee", m );
    }
    
    void removeFee() {
        if(!selectedItem) throw new Exception("Please select an item");
        def v = [_schemaname:entitySchemaName];
        v.objid = selectedItem.objid;
        feeSvc.removeFee( v );
        listHandler.reload();
    }
    
    void clearFees() {
        def v = [_schemaname:entitySchemaName];
        v.parentid = parentid;
        v.appid = appid;
        feeSvc.clearFees( v );
        listHandler.reload();
    }
    
    def assess() {
        def f = [:];
        f.appid = appid;
        f.parentid = parentid;
        def h  = { u->
            def m1 = [appid: appid, parentid: parentid, items: u.items ];
            m1._schemaname = entitySchemaName;
            feeSvc.saveFees( m1 );
            listHandler.reload();
        }
        return Inv.lookupOpener( "obo_application_assessment", [params: f, handler: h,schemaName: entitySchemaName ] );
    }

    
}
