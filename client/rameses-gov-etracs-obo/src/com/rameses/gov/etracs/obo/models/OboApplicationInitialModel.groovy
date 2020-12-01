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
import com.rameses.gov.etracs.obo.models.*;

class OboApplicationInitialModel  {

    @Invoker
    def invoker;

    @Service("OboApplicationCloudInitialService")
    def downloadSvc;
    
    @Service("PersistenceService")
    def persistenceSvc;
    
    @Service("QueryService")
    def querySvc;
    
    def trackingno;
    def txnmode = "ONLINE";
    def txnModes = ["ONLINE", "CAPTURE"];
    def source = "capture";
    def taskStates;
    def taskstate;
    

    @FormTitle
    public String getTitle() {
        return "New Application (" + invoker.properties.title + ")";
    }
    
    public String getPermitType() {
        return invoker.properties.permitType;
    }
    
    void init() {
        def m = [_schemaname: "sys_wf_node"];
        m.select = "name";
        m.where = [ "processname = :procname AND tracktime = 1 ", [procname: getPermitType() ]  ];
        m.orderBy = "idx";
        taskStates = querySvc.getList( m )*.name + ["end"];
    }
    
    def next() {
        if(source==null) source = "capture";
        
        if(source.matches("web|local")) {
            def v = downloadSvc.getApplication( [trackingno: trackingno, permittype: permitType ]  );
            if(!MsgBox.confirm("You are about to upload this application. Proceed?")) {
                return null;
            };
            v.txnmode = "ONLINE";
            v._schemaname = getPermitType();
            v = persistenceSvc.create( v );
            def entity = [objid: v.objid ];            
            def op = Inv.lookupOpener("vw_" + getPermitType() + ":open", [entity:entity] );  
            op.target = "topwindow";
            return op;
        }
        else if( source == "capture") {
            def p = [txnmode: txnmode ];
            if( txnmode == "CAPTURE" ) p.taskstate = taskstate;
            return Inv.lookupOpener( getPermitType() + ":create", p );
        }
        else {
            throw new Exception("File option not yet accepted!");
        }
    }
    
}