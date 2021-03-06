package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*
import com.rameses.rcp.common.*
import com.rameses.osiris2.client.*
import com.rameses.osiris2.common.*
import java.rmi.server.*;
import com.rameses.gov.etracs.bpls.application.*;
import com.rameses.util.*;
import com.rameses.osiris2.reports.*;
import com.rameses.seti2.models.*;

public class OboSectionModel extends CrudFormModel {
    
    @Service("OboMiscListService")
    def svc;

    def buildingPermitStates;
    def occupancyPermitStates;

    void afterCreate() {
        entity.permit = [:];
        entity.optional = 1;
    }
    
    void afterInit() {
        buildingPermitStates = svc.getBuildingPermitStates()*.name;
        occupancyPermitStates = svc.getOccupancyPermitStates()*.name;       
    }
    
    
}