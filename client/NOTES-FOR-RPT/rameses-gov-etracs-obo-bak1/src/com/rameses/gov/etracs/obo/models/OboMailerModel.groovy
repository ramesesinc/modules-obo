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

    @Service("QueryService")
    def querySvc;
    
    def entity;
    def mail;
    def conf;
    def attachments = [];

    def buildMessage( def name )  {
        def m = [_schemaname: "sys_email_template" ];
        m.findBy = [objid: name ];
        def z = querySvc.findFirst( m );
        if(z) {
            //place here the template substitution
            def txt = z.message;
            def binding = [entity: entity];
            def engine = new groovy.text.SimpleTemplateEngine(); 
            def template = engine.createTemplate(txt).make(binding); 
            return template;
        }
        return null;
    }
    
    void init(name) {
        if( !entity ) throw new Exception("entity is required");
        if( !entity.contact?.email ) throw new Exception("Contact must have an email address");
        mail = [:];
        mail.to = entity.contact.email;
        mail.message = buildMessage( name );
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
        def name = "building_permit_requirement_checklist"
        init(name);
        mail.subject = "Building Permit Requirement Verification";
        def fname = name + "-" + entity.reqtransmittalid;
        addFile( fname, name, ["query.transmittalid":entity.reqtransmittalid] );        
    }
    
    void initClaimstub() {
        def name ="building_permit_claimstub"; 
        init(name);
        mail.subject = "Building Permit Claim stub";
        def fname = name + "-" + entity.appno;
        addFile(fname, name, ["query.objid":entity.objid] );
    }
    
    void initFindingChecklist() {
        def name = "building_permit_finding_checklist";
        init(name);
        mail.subject = "Building Permit Findings";
        def fname = name + "-" + entity.transmittalid;
        addFile(fname, name, ["query.transmittalid":entity.transmittalid] );
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