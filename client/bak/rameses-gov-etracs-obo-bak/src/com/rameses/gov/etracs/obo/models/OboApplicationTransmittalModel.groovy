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
import com.rameses.email.models.*;

/*******
* There are two types of transmittals: 
* 1. Requirement
* 2. Findings
*******/
class OboApplicationTransmittalModel extends FormReportModel {

    @Service("Var")
    def varSvc;
    
    def entity;
    def type;
    def transmittalid;

    //entity is the application. It should have a transmittalid field. 
    def getQuery() {
        return [transmittalid: transmittalid ];
    }
    
    def preview() {
        entity = caller.entity;
        if(!entity.transmittalid ) throw new Exception("Error transmittal. There must be transmittalid");
        transmittalid = entity.transmittalid;
        return super.preview();
    }
    
    //This is called when opening the file and from the transmittal list
    def openPreview() {
        transmittalid = entity.objid;
        entity = caller.entity;
        return super.preview();
    }
    
    //called inside the print preview.
    def sendEmail(def inv) {
        String tname = inv.properties.fileid;        
        if( !tname) throw new Exception("fileid must not be null");
        def fname = tname + "-" + transmittalid + ".pdf";
        def fileExporter = { ofile ->
            this.exportToPDF( ofile );
        }
        def m = [
            name: tname,
            mailto: entity.contact.email,
            entity: entity,
            attachments: [
                [filename: fname , exportToFile: fileExporter ] 
            ],
            caller: caller
        ];
        
        //check if there are additional links
        def extlinks = reportData.items.findAll{ it.attachment?.fileid }*.attachment;
        if(extlinks) {
            def filePath = varSvc.get("file_attachment_filepath");
            if(!filePath) 
                throw new Exception("Please specify the attachments location-> file_attachment_filepath in sysvar");
            extlinks.each { att->
                def ef = {file->
                    FileDownloader.download( filePath + "/" + att.fileid, file );
                };
                m.attachments << [filename: att.title, exportToFile: ef];
            }
        }
        return Inv.lookupOpener("mail_sender", m );
    }
    
    
}


