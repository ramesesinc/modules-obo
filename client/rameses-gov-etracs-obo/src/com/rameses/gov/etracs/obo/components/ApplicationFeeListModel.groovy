package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class ApplicationFeeListModel extends AbstractComponentModel {
    
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
        m.handler = handler;
        m.entity = [:];
        m.saveHandler = { o->
            o.appid = appid;
            o.parentid = parentid;
            handler.saveFee( o );
            listHandler.reload();  
        }
        return Inv.lookupOpener("application_fee", m );
    }
    
    void removeFee() {
        if(!selectedItem) throw new Exception("Please select an item");
        handler.removeFee( selectedItem );
        listHandler.reload();
    }
    
    void clearFees() {
        handler.clearFees();
        listHandler.reload();
    }
    
    def assess() {
        def assHandler = handler.getAssessHandlerName();
        if(!assHandler) throw new Exception("Assessment Handler not found ");
        def f = [:];
        f.appid = appid;
        f.parentid = parentid;
        def h  = { u->
            def m1 = [appid: appid, parentid: parentid, items: u.items];
            handler.saveFees( m1 );
            listHandler.reload();
        }
        return Inv.lookupOpener( assHandler, [params: f, handler: h ] );
    }

    
}
