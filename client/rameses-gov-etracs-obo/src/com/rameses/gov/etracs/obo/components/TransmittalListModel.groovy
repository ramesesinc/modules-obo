package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class TransmittalListModel extends AbstractComponentModel {
    
    void beforeLoadList(def m) {
        m.orderBy = "dtcreated DESC";
    }
    
    /*
    def openItem(def o) {
        def idx = schemaName.lastIndexOf("_");
        def tname = schemaName.substring(0, idx) + "_" +  o.type.toLowerCase() + "_" + schemaName.substring(idx+1)+":open";
        def op = Inv.lookupOpener( tname, [entity: o] );
        if(op==null) {
            throw new Exception("opener " + tname + " not found");
        }
        return op;
    }
    */
    
}
