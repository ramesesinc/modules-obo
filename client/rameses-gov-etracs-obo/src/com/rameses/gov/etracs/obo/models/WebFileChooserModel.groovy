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

class WebFileChooserModel  {
    
    @Binding
    def binding;
    
    def onselect; 
    def attachment = [:];
    def mode = "initial";
    def filePath;
    
    void init() {
        if(!filePath) 
            throw new Exception("filepath is required in WebFileChooserModel");
    }  
    
    def htmlModel = [
         getValue: {
             return filePath;
         }, 
         onClick: {e->
             if(!e.location?.endsWith("/")) {
                attachment.fileid = e.location;
                if(onselect) onselect(attachment);
                binding.fireNavigation("_close");
             }
         }
     ] as HtmlViewModel; 
    
}


