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
* This has two functions: 
* 1. Generate Application No if not yet exist.
* 2. Print Claim Stub if already exist.
*******/
class OboApplicationAppNoModel extends FormReportModel {

    @Service("OboApplicationService")
    def appSvc;
    
    def entity;

    //entity is the application. It should have a transmittalid field. 
    def getQuery() {
        if(!entity) entity = caller.entity;
        return [objid: entity.objid ];
    }
    
    public def create() {
        if( !MsgBox.confirm("You are about to generate the application no. for this application. Proceed?") ) {
            throw new BreakException();
        }
        String id = reportId;
        entity = caller.entity;
        String permitName = (id == "building_permit_claimstub") ? "building_permit" : "occupancy_permit";
        def o = appSvc.accept( [appid: entity.objid, schemaname: permitName ] );
        MsgBox.alert("App no " + o.appno + " is successfully generated");
        caller.reload();
        return super.preview();
    }
    
    def sendEmail(inv) {
        def fileid = inv.properties.reportId;
        def fileName = inv.properties.fileName;
        def m = [
            name: fileid,
            mailto: entity.contact.email,
            entity: entity,
            attachments: [
                [filename: fileName , handler:fileid]
            ],
            caller: this
        ]
        return Inv.lookupOpener("mail_sender", m );
    }
    
}


