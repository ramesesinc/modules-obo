package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class BuildingPermitCaptureModel extends CrudFormModel {
    
    def appTypes = ["NEW", "RENEW","ADDITIONAL"];
    
    String title = "Capture Building Permit";
    
    public String getSchemaName() {
        return "building_permit";
    }
    
    void afterCreate() {
        entity.numunits = 1;
        entity.professionals = [];
        entity.worktypes = [];
        entity.location = [:];
        entity.txnmode = "CAPTURE";
    }
    
    public def onComplete() {
        MsgBox.alert("Saved success")
        def op =  Inv.lookupOpener("vw_building_permit:open", [entity: entity ] );
        op.target = "topwindow";
        return op;
    }
    
}