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

public class OboItemAccountModel extends CrudFormModel {
    
    def docTypeList;
    def feeGroupList = [ "BFP", "ZONING", "RPT"];
    
    public void afterInit() {
        def m = [_schemaname: "vw_obo_doctype"];
        m.where = ["1=1"];
        docTypeList = queryService.getList(m);
    }
}