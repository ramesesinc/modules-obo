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

class BuildingPermitCaptureModel extends CrudFormModel {
    
    @Service("BuildingPermitService")
    def appService;
    
    def appTypes = ["NEW", "RENEW","ADDITIONAL"];
    
    void afterCreate() {
        entity = [numunits: 1, professionals: [], worktypes: [] ];
        entity.txnmode = "CAPTURE";
    }
    
    public def onComplete() {
        return "_close";
    }
    
    /*
    public def onComplete() {
        def op =  Inv.lookupOpener("vw_building_permit:open", [entity: entity ] );
        op.target = "topwindow";
        return op;
    }
    */
    
}