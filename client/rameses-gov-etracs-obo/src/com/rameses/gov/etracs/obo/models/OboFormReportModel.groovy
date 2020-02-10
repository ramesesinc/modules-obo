package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.util.*;
import com.rameses.common.*;
import com.rameses.rcp.constant.*;

class OboFormReportModel extends FormReportModel {
    
    def entity;
    private String reportPath = "com/rameses/gov/etracs/obo/reports/";
    
    boolean allowSave = false;
    boolean allowPrint = false;
    
    public String getReportName() {
        if( invoker.properties.reportName !=null ) {
            return invoker.properties.reportName;
        }
        else {
            return reportPath + reportData.template + ".jasper"            
        }
    }    
    
    def getQuery() {
        return [objid: entity.objid];
    }
    
    def preview(def inv) {
        if( !entity ) entity = caller.entity;        
        if( inv.properties.allowPrint ) {
            def a = ExpressionResolver.getInstance().evalBoolean(inv.properties.allowPrint,[entity:entity, caller:caller]);
            allowPrint = a;
        }
        return super.preview();
    }    
    
}