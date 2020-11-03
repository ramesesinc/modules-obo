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

class ApplicationFindingModel {

    @Binding
    def binding;
    
    @Script("User")
    def user;
    
    String title;
    String sectiontitle;
    boolean editable;
    def editmode;
    boolean superseded;

    def entity;
    def section;
    
    def handler;
    
    boolean showSave;
    boolean showSupersede;
    boolean showCloseIssue;
    
    //determine what buttons to display
    void init() {
        if(!editable) return;        
        if(entity.supersederid !=null || entity.state != 2 ) {
            editable = false;
            return;
        }        
        
        showSave = false;
        showSupersede = false;
        showCloseIssue = false;            
        
        if( entity.createdby?.objid == null ) {
            //new entry
            showSave = true;
        }
        else if( entity.createdby.objid == user.userid ) {
            if( entity.transmittalid !=null) {
                editable = false;
                showSupersede = true;
                showCloseIssue = true;
            }
            else {
                showSave = true;
            }
        }
        else if( entity.createdby.objid != user.userid ) {
            editable = false;
            showSupersede = true;
            showCloseIssue = true;
        }
    }

    void create() {
        entity = [:];
        entity.state = 2;
        editmode = "create";
        init();        
    }
    
    void open() {
        editmode = "edit";        
        init();        
    }
    
    def save() {
        handler.save(entity);
        return "_close";
    }
    
    void supersede() {
        def preventity = entity;
        entity = [:];
        entity.state = 2;
        editmode = "create";
        editable = true;
        entity.previd = preventity.objid;
        entity.particulars = preventity.particulars;
        entity.attachment = preventity.attachment;
        superseded = true;
        init();
    }
    
    def closeIssue() {
        if(!MsgBox.confirm("This will close this finding. Proceed?")) return;
        def preventity = entity;
        entity = [:];
        entity.objid = null;
        entity.previd = preventity.objid;
        entity.appid = preventity.appid;
        entity.parentid = preventity.parentid;
        entity.rootid = preventity.rootid;        
        entity.particulars = preventity.particulars;
        entity.state = 1;
        handler.save(entity);
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
        return Inv.lookupOpener("application_finding_attachment:view", [image: entity.attachment]);
    }
    
    def removeAttachment() {
        entity.attachment = null;
        binding.refresh();
    }


}