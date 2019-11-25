package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;
import javax.swing.*;
import com.rameses.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.rameses.io.StreamUtil;
import java.io.FileInputStream;   

class OboSignatureModel extends CrudFormModel {

    @Binding
    def binding;

    def handler;
    
    @PropertyChangeListener
    def listener = [
        "entity.user" : { o->
            entity.objid = o.objid;
            entity.user = [name: entity.lastname + ", " + entity.firstname];
            entity.displayname = o.firstname;
            if( o.middlename ) entity.displayname + " "+ o.middlename.substring(0,1) + ".";
            entity.displayname += " " + o.lastname;
            if( o.jobtitle ) {
                entity.position = o.jobtitle;
            }
            binding.refresh("entity.(displayname|position|user.name)");
        }
    ]
   
    
    void crop( def data ) {         /*
        def h = { o-> 
            entity.signature = o;
            binding.refresh("entity.signature");
        } 
        ImageCropper.show([ image: data, handler: h ]);  
        */
    } 
    
    def changePhoto() {
        def jfc = new JFileChooser();
        int retval = jfc.showOpenDialog(null); 
        if (retval == JFileChooser.APPROVE_OPTION) {
            def file = jfc.getSelectedFile();
            entity.signature = com.rameses.io.IOStream.toByteArray(file);
            binding.refresh("entity.signature");
        } 
    }
    
}


