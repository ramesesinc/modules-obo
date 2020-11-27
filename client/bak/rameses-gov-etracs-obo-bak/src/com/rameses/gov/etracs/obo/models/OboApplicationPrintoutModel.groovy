package com.rameses.gov.etracs.obo.models;


import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*; 
import com.rameses.treasury.common.models.*; 
import com.rameses.osiris2.client.*
import com.rameses.osiris2.common.*
import com.rameses.seti2.models.*;
import com.rameses.rcp.framework.ClientContext;
import com.rameses.util.*;
import com.rameses.common.*;
import com.rameses.rcp.constant.*;

class OboApplicationPrintoutModel extends FormReportModel {

    def entity;
    def task;
    boolean allowSave = false;
    boolean allowPrint = true;
    
    //entity is the application. It should have a transmittalid field. 
    def getQuery() {
        if(!entity) entity = caller.entity;
        return [id: entity.objid ];
    }
    
    def preview(def inv) {
        task = caller.task;
        if( inv.properties.allowPrint ) {
            def a = ExpressionResolver.getInstance().evalBoolean(inv.properties.allowPrint,[entity:entity, task:caller.task]);
            allowPrint = a;
        }
        return super.preview();
    }
    
    def sendEmail(def inv) {
        String tname = inv.properties.fileid;        
        if( !tname) throw new Exception("fileid must not be null");
        def fname = tname + ".pdf";
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
        return Inv.lookupOpener("mail_sender", m );
    }
    
}


