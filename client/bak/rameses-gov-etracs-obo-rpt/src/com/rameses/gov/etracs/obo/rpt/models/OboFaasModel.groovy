package com.rameses.gov.etracs.obo.rpt.models;

import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import com.rameses.enterprise.models.*;

import com.rameses.rcp.common.*;
import com.rameses.rcp.jfx.WebViewPane
import com.rameses.rcp.annotations.*;

public class OboFaasModel {
    
    @Caller
    def caller;
    
    public void createFaas() {
        MsgBox.alert( "entity " + caller.entity.objid);
    }
    
    def menuHtml = "https://mgimo.ru/upload/iblock/e67/MPECCOL_Local%20Government.pdf";
    
    /*
    def menuHtml = [
        getValue: {
            return "www.google.com"; 
        }
    ] as HtmlViewModel; 
    */
}