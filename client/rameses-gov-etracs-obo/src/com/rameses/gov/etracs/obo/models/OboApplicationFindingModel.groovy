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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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

    void addAttachment() {
        def jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
        jfc.setFileSelectionMode( JFileChooser.FILES_ONLY );
        int retval = jfc.showOpenDialog(null); 
        if (retval == JFileChooser.APPROVE_OPTION) {
            def bytes = com.rameses.io.IOStream.toByteArray( jfc.selectedFile );
            entity.attachment = (new Base64Cipher().encode(  bytes ));
            binding.refresh();
        } 
    }
    
    def viewAttachment() {
        if(!entity.attachment) throw new Exception("There must be an attachment");
        return Inv.lookupOpener("obo_finding_attachment:view", [image: entity.attachment]);
    }
    
    def removeAttachment() {
        entity.attachment = null;
        binding.refresh();
    }


}