package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*; 
import com.rameses.treasury.common.models.*; 
import com.rameses.osiris2.client.*
import com.rameses.osiris2.common.*
import com.rameses.util.*;
import com.rameses.seti2.models.*;
import com.rameses.rcp.framework.ClientContext;


public class BuildingPermitIssuanceReportFormModel extends FormReportModel {
    
    def entity;
    def permit;
    
    public def getQuery() {
        return [objid: entity?.objid ];
    }
    
    public String getReportName() {
        if( super.getReportId() == "building_permit") {
            return super.getReportName();    
        }
        else {
            if( permit == null ) permit = caller.entity.issuance;
            def type = permit.typeid?.toLowerCase();
            return "com/rameses/gov/etracs/obo/reports/building_permit_" + type +  ".jasper"
        }
    }
    
}