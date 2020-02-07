package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;

class OboIssuanceReportModel extends FormReportModel {

    def issuance;
    private String reportPath = "com/rameses/gov/etracs/obo/reports/";
    
    public String getReportName() {
        return reportPath + reportData.template + ".jasper"
    }
    
    def getQuery() {
        if( issuance == null ) issuance = caller.entity;
        return [objid: issuance.objid];
    }
    
}