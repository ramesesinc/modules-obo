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

class OboIssuePermitModel extends FormReportModel {

    def entity;
    def txntype;
    
    //entity is the application. It should have a transmittalid field. 
    def getQuery() {
        if(!entity) entity = caller.entity;
        return [id: entity.objid ];
    }
    
    void create(inv) {
        txntype = inv.properties.txntype;
        Modal.show( "obo:permit_issuance", [entity: entity] );
        if(!pass) throw new BreakException();
        
        /*
        if(!p) {
            entity = [_schemaname:schemaname];
            entity.appid = appid;
            entity.sectionid = sectionid;
            entity.txnmode = "CAPTURE";
            boolean pass = false;
            def h = { o->
                entity = o;
                pass=  true;
            }
            Modal.show( "obo:permit_issuance", [entity: entity] );
            if(!pass) throw new BreakException();
        }
        else {
            entity = p;
        }
        */
        return super.preview();
    }
    
    void sendEmail() {
        MsgBox.alert("send email " + entity );
    }
    
}


