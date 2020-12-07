package com.rameses.gov.etracs.obo.building.models;

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

class BuildingPermitRpuModel extends CrudFormModel {
    
    @Service("BuildingPermitRpuService")
    def rptService;
    
    def tdno;
    def appid;
    def applicant;
    def handler;
    def editable;
    
    void lookupTD() {
        entity = rptService.findRpu( [refno: tdno, appid: appid ] );
    }
    
    public void generateDocs() {
        def m = [objid: entity.objid]; 
        rptService.generateDocs( m );
        reloadEntity();
        if(handler) handler();
        binding.refresh();
        MsgBox.alert("RPT Docs generated successfully");
    }
    
    def viewTaxClearance() {
        if(!entity.taxclearanceid ) throw new Exception("Tax clearance not yet generated");
        return Inv.lookupOpener( 'rpttaxclearance:view', [entity: [objid: entity.taxclearanceid ]] );
    }
    
    def viewTrueCopy() {
        if(!entity.truecopycertid ) throw new Exception("Clearance not yet generated");
        return Inv.lookupOpener( 'tdtruecopy:view', [entity: [objid: entity.truecopycertid ]] );
    }
    
    def doOk() {
        if(mode=="create") {
            save();
            if(handler) handler();
        }
        return "_close";
    } 
    
    def doCancel() {
        return "_close";
    }
    
   
    
}