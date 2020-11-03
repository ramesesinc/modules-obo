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
class OboApplicationClaimStubModel extends FormReportModel {
    
    def entity;

    //entity is the application. It should have a transmittalid field. 
    def getQuery() {
        if(!entity) entity = caller.entity;
        return [objid: entity.objid ];
    }
    
    def sendEmail() {
        def fileid = reportId;
        def fileName = fileid + "-"+ entity.appno + ".pdf";
        def exportFile = { ofile ->
            this.exportToPDF(ofile);
        }
        def m = [
            name: fileid,
            mailto: entity.contact.email,
            entity: entity,
            attachments: [
                [filename: fileName , exportToFile:exportFile]
            ],
            caller: this
        ]
        return Inv.lookupOpener("mail_sender", m );
    }
    
}


