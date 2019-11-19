package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.util.*;

public class BuildingPermitCashReceiptModel extends com.rameses.treasury.common.models.BasicBillingCashReceiptModel {
    
    @Service("BuildingPermitBillingService")
    def cashRctSvc;
    
    def loadInfo( def p ) {
        p.collectiontype = entity.collectiontype;
        p.billdate = entity.receiptdate;
        def info = null;
        try {
            p.refno = p.id;
            info = cashRctSvc.getPaymentOrderInfo(p);
        }
        catch(serverErr) {
            if ( p.action == "barcode" ) super.doClose(); 
            //log the errors starting from here 
            new RuntimeException( serverErr ).printStackTrace(); 
            //throw the actual error
            throw serverErr; 
        } 
        
        def warning = info?._warning; 
        if ( warning instanceof com.rameses.util.Warning ) {
            MsgBox.warn( warning.message ); 
        } 
        
        if ( !info.items ) { 
            throw new Exception("No items found"); 
        }
        entity.putAll( info ); 
        entity.amount = NumberUtil.round( entity.items.sum{ it.amount } );
        return super.start("entry");
    }    
    
    //override again
    def itemListModel = [
        fetchList: { o->
            return entity.items;
        }
    ] as BasicListModel;
}
