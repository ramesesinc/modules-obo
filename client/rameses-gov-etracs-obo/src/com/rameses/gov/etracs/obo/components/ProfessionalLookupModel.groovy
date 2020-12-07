package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;
import com.rameses.rcp.framework.*;

class ProfessionalLookupModel extends ComponentBean {

    @Binding
    def binding;
    
    def _persistenceSvc = null;
    def getPersistenceSvc() {
        if(!_persistenceSvc) {
            _persistenceSvc= InvokerProxy.getInstance().create("PersistenceService", null, "obo");
        }
        return _persistenceSvc;
    }
    
    def onselect; 
    def onempty;
    
    boolean allowCreate = true;
    boolean allowOpen = true;
    
    public def getEntity() {
        return getValue();
    }
    
    public void setEntity(def o) {
        setValue( o );
    }

    def viewProfessional() {
        def p = [:];
        p.entity = entity;
        return Inv.lookupOpener("vw_obo_professional:open", p);
    }

    public def addProfessional() {
        MsgBox.alert("add professional");
    } 
    
    
} 
