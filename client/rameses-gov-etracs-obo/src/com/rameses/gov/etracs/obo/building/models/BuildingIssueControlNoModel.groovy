package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import com.rameses.enterprise.models.*;

public class BuildingIssueControlNoModel {
    
    def entity;
    def handler;
    boolean showcontrolno = true;
    
    void init() {
        entity = [:];
    }
    
    def doOk() {
        if(handler) handler(entity);
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}