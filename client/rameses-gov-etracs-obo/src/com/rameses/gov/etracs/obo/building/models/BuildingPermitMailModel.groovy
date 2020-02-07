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
        
        def permitno = entity.permit.permitno;
        def parms = [permit: [objid: entity.permit.objid]];
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
        def p = [_schemaname:"vw_building_issuance"];
        p.findBy = [appid: entity.objid];
        def list = querySvc.getList(p);
        list.each {
            attachments << [
                filename : it.sectionid + "-" + it.controlno + ".pdf",
                handler : "building_issuance:attachment",
                params: [issuance: [objid: it.objid] ]
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