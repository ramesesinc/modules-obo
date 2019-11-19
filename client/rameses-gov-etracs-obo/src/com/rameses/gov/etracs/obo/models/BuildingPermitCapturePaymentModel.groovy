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

class BuildingPermitCapturePaymentModel  {

    @Binding
    def binding;
    
    @Caller
    def caller;
    
    @Service("BuildingPermitPaymentService")
    def postPaymentSvc;
    
    def entity;
    def receipt;
    
    void init() {
        if(!entity) entity = caller.entity;
        if( caller.task.state != 'payment')
            throw new Exception("This can only be invoked in payment state");
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
        
        postPaymentSvc.postPayment( m );
        caller.reload();
        return "_close";
    }
    
    public def doCancel() {
        return "_close";
    }
}