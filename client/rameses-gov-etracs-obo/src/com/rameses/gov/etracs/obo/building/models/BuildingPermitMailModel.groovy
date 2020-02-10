package com.rameses.gov.etracs.obo.building.models;

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
import com.rameses.gov.etracs.obo.models.*;

import com.rameses.email.models.*;

class BuildingPermitMailModel extends MailSenderModel {

    void init() {
        if(!entity) entity = caller.entity;
        name = "building_permit_transmittal";
        mailto = entity.contact.email;
        
        def permitno = entity.permitno;
        def parms = [entity: entity];
        attachments << [
            filename:"building-permit-" + permitno + ".pdf",
            handler: "building_permit:attachment", 
            params: parms
        ];
        attachments << [ 
            filename:"building-permit-signboard-" + permitno + ".pdf",
            handler: "building_permit_signboard:attachment", 
            params: parms
        ];    
        
        //load issuances
        def p = [_schemaname:"vw_building_application_subdoc"];
        p.findBy = [appid: entity.objid];
        p.where = ["NOT(template IS NULL)"];
        def list = querySvc.getList(p);
        list.each {
            attachments << [
                filename : it.doctypeid + "-" + it.controlno + ".pdf",
                handler : "vw_building_application_subdoc:attachment",
                params: [entity: it ]
            ];
        };
        
        //load tax declarations
        p = [_schemaname: "building_application_rpu"];
        p.findBy = [appid: entity.objid ];
        def vlist = querySvc.getList( p );
        vlist.each {
            attachments << [ 
                filename: "taxclearance-" + it.tdno + ".pdf", 
                handler:'rpttaxclearance:view', 
                params: [entity: [objid: it.taxclearanceid ]] 
            ];
            attachments<< [ 
                filename: "truecopycert-" + it.tdno + ".pdf",
                handler: "tdtruecopy:view",
                params: [entity: [objid: it.truecopycertid ]]
            ];    
        } 
        
        super.init();
    }
    
}