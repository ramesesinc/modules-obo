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

class OboCapturePaymentModel  {

    @Binding
    def binding;
    
    @Caller
    def caller;
    
    @Service("OboPaymentService")
    def postPaymentSvc;
    
    def entity;
    def receipt;
    def txntype;
    
    void init(inv) {
        txntype = inv.properties.txntype;
        if(!entity) entity = caller.entity;
        receipt = [:];
        receipt.type ="cashreceipt";
        receipt.amount = entity.amount;
    }
    
    public def doOk() {
        if(!MsgBox.confirm("You are about to post this payment")) return;
        
        receipt.objid = receipt.receiptno; 
        def m = [:];
        m.refid = entity.objid;
        m.receipt = receipt;
        m.txntype = txntype;
        postPaymentSvc.postPayment( m );
        caller.reload();
        return "_close";
    }
    
    public def doCancel() {
        return "_close";
    }
}