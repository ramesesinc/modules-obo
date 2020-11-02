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
import com.rameses.gov.etracs.obo.models.*;

class ApplicationChecklistItemModel  {

    def entity;
    def handler;
    def bean = [:];
    
    def formControls = [];
    
    def formPanel = [
        getControlList: {
            return formControls;
        }
    ] as FormPanelModel;
    
    void init() {
        if(!entity.params) return;
        formControls = [];
        def arr = entity.params.split(",");
        def values = entity.values;
        if( values!=null && values.size() != arr.length ) values = null;
        for( int i=0; i < arr.length; i++) {
            def fldname = "t"+i;
            if( values !=null ) {
                bean.put(fldname, values[i] );
            }
            //form control
            def fc = [caption: "[" + i +"]" ];
            fc.type = (arr[i] == "d")? "decimal" : "text";
            if( arr[i] == "s") fc.textCase = "NONE";
            fc.name = "bean."+ fldname;
            formControls << fc;
        }    
    }
    
    def doOk() {
        def list = bean.collect{ [id:it.key, val:it.value]  };
        def z = list.sort{ it.id }.collect{ it.val };
        handler([objid:entity.objid, values:z] );
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}