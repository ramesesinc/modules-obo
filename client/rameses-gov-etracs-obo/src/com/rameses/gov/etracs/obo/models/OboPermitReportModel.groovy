package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;

class OboPermitReportModel extends FormReportModel {
    
    def getQuery() {
        return [objid: caller.entity.permit.objid];
    }
    
}