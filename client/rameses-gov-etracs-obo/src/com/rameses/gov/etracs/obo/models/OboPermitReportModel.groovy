package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;

class OboPermitReportModel extends FormReportModel {
    
    def permit;
    
    def getQuery() {
        if(permit==null) permit = caller.entity.permit;
        return [objid: permit.objid];
    }
    
}