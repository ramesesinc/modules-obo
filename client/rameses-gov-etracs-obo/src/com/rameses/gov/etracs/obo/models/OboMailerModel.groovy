package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.rcp.framework.*;

class OboMailerModel {

    def entity;
    def mail;
    def conf;
    def attachments = [];
    
    void init() {
        if( !entity ) throw new Exception("entity is required");
        if( !entity.contact?.email ) throw new Exception("Contact must have an email address");
        mail = [:];
        mail.to = entity.contact.email;
        conf = ClientContext.getCurrentContext().getAppEnv();
    }
    
    void addFile( String filename, String openerName, def data )  {
        def m = [:];
        m.filename = filename + ".pdf";
        m.opener = Inv.lookupOpener(openerName, data );
        m.file = new File( m.filename );
        attachments << m;
    }
    
    void initReqchecklist() {
        init();
        mail.subject = "Building Permit Requirement Verification";
        def fname = "bp-req-checklist-" + entity.reqtransmittalid;
        addFile( fname, "building_permit_requirement_checklist", ["query.transmittalid":entity.reqtransmittalid] );        
    }
    
    void initClaimstub() {
        init();
        mail.subject = "Building Permit Claim stub";
        def fname = "bp-claimstub-" + entity.appno;
        addFile(fname, "building_permit_claimstub", ["query.objid":entity.objid] );
    }
    
    void initFindingChecklist() {
        init();
        mail.subject = "Building Permit Findings";
        def fname = "bp-finding-checklist-" + entity.transmittalid;
        addFile(fname, "building_permit_finding_checklist", ["query.transmittalid":entity.transmittalid] );
    }
    
    def doOk() {
        try {
            mail.attachments = [];
            attachments.each { a->
                a.opener.handle.exportToPDF(a.file);
                mail.attachments << a.filename;
            }
            MailSender ms = new MailSender(conf);
            ms.send( mail );
            MsgBox.alert("Message sent!");
            return "_close";
        }
        catch(e) {
            throw e;
        }
        finally {
            //cleanup files after sending
            attachments.each {
                it.file.delete();
            }
        }
    }
    
    def doCancel() {
        return "_close";
    }
    
    
}