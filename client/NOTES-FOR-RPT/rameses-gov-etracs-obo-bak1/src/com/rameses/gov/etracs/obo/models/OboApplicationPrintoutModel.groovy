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

class OboApplicationPrintoutModel extends FormReportModel {

    def entity;
    
    //entity is the application. It should have a transmittalid field. 
    def getQuery() {
        if(!entity) entity = caller.entity;
        return [id: entity.objid ];
    }
    
    void sendEmail() {
        MsgBox.alert("send email " + entity );
    }
    
}


