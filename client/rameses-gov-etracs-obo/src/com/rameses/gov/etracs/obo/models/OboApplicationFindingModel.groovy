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

/******
* state is similar to the requirements
* 1 = pass or closed
* 2 = for revision  
******/

class OboApplicationFindingModel {

    @Service("PersistenceService")
    def persistenceSvc;
    
    @Service("QueryService")
    def querySvc;
    
    @Service("Var")
    def varSvc;
    
    @Caller
    def caller;
    
    @Binding
    def binding;
    
    @Controller
    def workunit;

    @Script("User")
    def user;
    
    def appid;
    def sectionid;
    def entity;
    def section;
    
    def pagename = "view";
    def editmode;
    
    boolean editable;
    boolean overridable;
    
    public String getSchemaName() {
        return workunit?.info?.workunit_properties?.schemaName;
    }
    
    void init() {
        editable = false;
        overridable = false;
        def task = caller.task;
        //if current task assignee
        if( task.assignee.objid == user.userid ) {
            if( entity.transmittalid !=null ) {
                overridable = true;
            }
            else if( entity.createdby?.objid == null  ) {
                editable = true;
            }            
            else if( entity.createdby.objid != user.userid ) {
                overridable = true;
            }
            else if( entity.createdby.objid == user.userid ) {
                editable = true;
            }
        }
    }

    void create() {
        init();
        entity = [:];
        entity.section = section;
        entity.appid = appid;
        entity.parentid = sectionid;
        entity.state = 2;
        editmode = "create";
    }
    
    void open() {
        init();
        editmode = (editable==true? "edit" : "read");
    }
    
    
    def save() {
        entity._schemaname = schemaName;
        if(editmode=="create") {
            persistenceSvc.create( entity );
        }
        else {
            persistenceSvc.update( entity );            
        }
        caller.findingListHandler.reload();
        return "_close";
    }
    
    void supersede() {
        def preventity = entity;
        entity = [:];
        entity.section = preventity.section;
        entity.objid = null;
        entity.previd = preventity.objid;
        entity.appid = preventity.appid;
        entity.parentid = preventity.parentid;
        entity.rootid = preventity.rootid;        
        entity.particulars = preventity.particulars;
        entity.state = 2;
        editmode = "create";
        init();
    }
    
    def closeIssue() {
        if(!MsgBox.confirm("This will close this finding. Proceed?")) return;
        
        def preventity = entity;
        entity = [:];
        entity.section = preventity.section;
        entity.objid = null;
        entity.previd = preventity.objid;
        entity.appid = preventity.appid;
        entity.parentid = preventity.parentid;
        entity.rootid = preventity.rootid;        
        entity.particulars = preventity.particulars;
        entity.state = 1;
        entity._schemaname = schemaName;
        persistenceSvc.create( entity );
        caller.findingListHandler.reload();
        return "_close";
    }
    
    /*
    void viewHistory() {
        pagename = "hist";
    }
    
    void viewBack() {
        pagename = "view";
    }
    
    def listModel = [
        fetchList: { o->
            def m = [_schemaname: entity.schemaname + "_finding"];
            m.findBy = [rootid: entity.rootid];
            m.orderBy ="dtcreated";
            return querySvc.getList(m)
        }
    ] as BasicListModel;
    */
   
    void addAttachment() {
        def rp = varSvc.get("file_attachment_filepath");
        if(!rp) 
            throw new Exception("Please specify the attachments location-> file_attachment_filepath in sysvar");
        
        boolean pass = false;
        def s  = { o->
           def a = [:];
           a.fileid = o.fileid.replace(rp+"/", "");
           a.title = a.fileid;
           entity.attachment = a;
           pass = true;
        }
        Modal.show( "webfile_chooser", [onselect:s, filePath: rp] );
        /*
        if(!pass ) return;
        def t = MsgBox.prompt("Enter tag name" );
        if( t ) {
            def ext = entity.attachment.fileid.substring( entity.attachment.fileid.indexOf(".") );
            entity.attachment.title = t + ext;
        }
        */
    }
    
    def removeAttachment() {
        entity.attachment = null;
        binding.refresh();
    }

    def viewAttachment() {
        def rp = varSvc.get("file_attachment_filepath");
        if(!rp) 
            throw new Exception("Please specify the attachments location-> file_attachment_filepath in sysvar");
        rp += "/" + entity.attachment.fileid;    
        Modal.show( "webfile_chooser", [filePath:rp] );   
    }

}