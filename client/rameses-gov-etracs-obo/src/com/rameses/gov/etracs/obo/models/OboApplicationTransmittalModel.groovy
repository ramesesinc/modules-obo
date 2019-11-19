package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;
import javax.swing.*;
import com.rameses.io.*;

/*******
* There are two types of transmittals: 
* 1. Requirement
* 2. Findings
*******/
class OboApplicationTransmittalModel extends FormReportModel {

    @Service("OboApplicationTransmittalService")
    def transmittalSvc;
    
    def entity;
    def type;

    //entity is the application. It should have a transmittalid field. 
    def getQuery() {
        if(!entity) entity = caller.entity;
        return [transmittalid: entity.transmittalid ];
    }
    
    public def create(inv) {
        type = inv.properties.txntype;
        if( !MsgBox.confirm("You are about to finalize the requirement checklist. You cannot undo this transaction. Proceed?") ) {
            throw new BreakException();
        }
        entity = caller.entity;
        def task = caller.task;
        String id = (reportId == "building_permit_transmittal")?"building_permit":"occupancy_permit";
        def t = transmittalSvc.create( [appid: entity.objid, taskid: task.taskid, schemaname: id, type: type ]);
        entity.transmittalid = t.objid;
        caller.reload();        
        return super.preview();
    }
    
    void sendEmail() {
        MsgBox.alert("send email " + entity );
    }
    
    /*
        void buildRequirementChecklist() {
        if( !MsgBox.confirm("You are about to finalize the requirement checklist. You cannot undo this transaction. Proceed?") ) return;
        def t = reqSvc.buildCheckList( [appid: entity.objid, taskid: task.taskid, schemaname: getPermitName() ]);
        entity.reqtransmittalid = t.objid;
    }
    
    void removeChecklist() {
        if( !MsgBox.confirm("You are about to remove this checklist. Proceed?") ) return;
        def t = reqSvc.removeCheckList( [transmittalid: entity.reqtransmittalid, schemaname: getPermitName() ]);
        entity.reqtransmittalid = null;        
    }
    
    
    def sendReqChecklist() {
        return Inv.lookupOpener("obo_mailer:reqchecklist", [entity:entity]);
    }
    
    void buildFindingChecklist() {
        if( !MsgBox.confirm("You are about to finalize the findings checklist. You cannot undo this transaction. Proceed?") ) return;
        def t = findingSvc.buildCheckList( [appid: entity.objid, taskid: task.taskid, schemaname: getPermitName() ]);
        entity.transmittalid = t.objid;
    }
    
    def printFindingChecklist() {
        def p = [:];
        p.put("query.transmittalid", entity.transmittalid );
        return Inv.lookupOpener("building_permit_finding_checklist", p );
    }
    
    def sendFindingChecklist() {
        return Inv.lookupOpener("obo_mailer:findingchecklist", [entity:entity]);
    }
    */

    
    
}


