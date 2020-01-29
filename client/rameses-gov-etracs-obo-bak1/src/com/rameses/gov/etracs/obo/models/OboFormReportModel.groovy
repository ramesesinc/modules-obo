package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;

class OboFormReportModel extends FormReportModel {
    
    def entity;
    
    def getQuery() {
        if( !entity ) entity = caller.entity;
        return [objid: entity.objid];
    }
    
}