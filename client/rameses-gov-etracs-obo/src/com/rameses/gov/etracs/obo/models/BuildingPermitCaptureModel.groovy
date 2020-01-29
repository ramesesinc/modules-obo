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

class BuildingPermitCaptureModel  {
    
    @Service("BuildingPermitService")
    def appService;
    
    def appTypes = ["NEW", "RENEW","ADDITIONAL"];
    def entity;
    
    boolean saveAllowed = true;
    
    String title = "Capture Building Permit";
    
    def create() {
        entity = [numunits: 1, professionals: [], worktypes: [], location: [:] ];
        entity.txnmode = "CAPTURE";
        return null;
    }
    
    def save() {
        appService.saveCapture( entity );
        if(!MsgBox.confirm("Saved successfully. Add another record?")) {
            return "_close";
        }
        else {
            create();
        }
    }
    
    
    /*
    public def onComplete() {
        def op =  Inv.lookupOpener("vw_building_application:open", [entity: entity ] );
        op.target = "topwindow";
        return op;
    }
    */
    
}