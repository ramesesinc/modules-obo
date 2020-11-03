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
        if(!entity) entity = caller.entity;
        receipt = [:];
        receipt.type ="cashreceipt";
        receipt.amount = entity.amount;
        receipt.txntype = inv.properties.txntype;
        receipt.appid = entity.objid;
    }
    
    public def doOk() {
        if(!MsgBox.confirm("You are about to post this payment")) return;
        receipt.refid = receipt.receiptno;        
        postPaymentSvc.postPayment( receipt );
        caller.reload();
        return "_close";
    }
    
    public def doCancel() {
        return "_close";
    }
}