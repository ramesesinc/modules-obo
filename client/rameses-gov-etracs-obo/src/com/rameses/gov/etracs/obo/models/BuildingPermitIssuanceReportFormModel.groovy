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
    
    String template;
    String id;
    
    String path = "com/rameses/gov/etracs/obo/reports/"
    
    public def getQuery() {
        return [objid: id ];
    }
    
    public String getReportName() {
        return path + template + ".jasper";
    }
    
}