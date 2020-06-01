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

class BuildingApplicationRptModel extends CrudFormModel {
    
    @Service("BuildingApplicationRptService")
    def rptService;
    
    
    def tdno;
    
    void lookupTD() {
        entity = rptService.findRpu( [refno: tdno ] );
        entity.appid = caller.entity.objid;
        entity.remove("objid");
        if( caller.entity.applicant.objid == entity.ownerid ) {
            entity.lotowned = 1;
        }
        else {
            entity.lotowned = 0;
        }
    }
    
    def doOk() {
        if(mode=="create") {
            save();
        }
        return "_close";
    } 
    
    def doCancel() {
        return "_close";
    }
    
    def viewTaxClearance() {
        if(!entity.taxclearanceid ) throw new Exception("Tax clearance not yet generated");
        return Inv.lookupOpener( 'rpttaxclearance:view', [entity: [objid: entity.taxclearanceid ]] );
    }
    
    def viewTrueCopy() {
        if(!entity.truecopycertid ) throw new Exception("Clearnace not yet generated");
        return Inv.lookupOpener( 'tdtruecopy:view', [entity: [objid: entity.truecopycertid ]] );
    }
    
    //Generate Docs
    void generateDocs() {
        def m = [appid: caller.entity.objid]; 
        rptService.generateDocs( m );
        caller.reload();
        MsgBox.alert("RPT Docs generated successfully");
    }
    
}