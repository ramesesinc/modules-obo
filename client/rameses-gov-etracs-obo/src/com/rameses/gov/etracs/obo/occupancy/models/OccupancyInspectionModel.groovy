package com.rameses.gov.etracs.obo.occupancy.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;
import com.rameses.gov.etracs.obo.models.*;

class OccupancyInspectionModel extends AbstractApplicationSectionModel {
    
    
    public String getCaption() {
        return "Occupancy Inspection";
    }
    
    public String getPrefix() {
        return "OI";
    }
    
    def viewApplication() {
        String s = "vw_occupancy_application:open"; 
        def op = Inv.lookupOpener(s, [entity: [objid: entity.appid ] ] );
        op.target = "popup";
        return op;
    }
    
    def assess() {
        return super.assess("occupancy_inspection:assessment");    
    }

    def addFee() {
        return super.addFee( "occupancy_application_fee");
    }
    
    def addFinding() {
        return super.addFinding( "occupancy_inspection_finding");
    }
    
}