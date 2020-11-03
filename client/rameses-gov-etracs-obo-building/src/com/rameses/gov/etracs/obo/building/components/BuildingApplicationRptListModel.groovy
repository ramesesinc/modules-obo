package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class BuildingApplicationRptListModel extends AbstractComponentModel {

    @Service("BuildingApplicationRptService")
    def rptService;
    
    void afterLoadList() {
    }
    
    
    
     //Generate Docs
    void generateDocs() {
        def m = [appid: appid]; 
        rptService.generateDocs( m );
        refresh();
        MsgBox.alert("RPT Docs generated successfully");
    }
    
    def viewTaxClearance() {
        if(!selectedItem) throw new Exception("Please select an item");
        if(!selectedItem.taxclearanceid ) throw new Exception("Tax clearance not yet generated");
        return Inv.lookupOpener( 'rpttaxclearance:view', [entity: [objid: selectedItem.taxclearanceid ]] );
    }
    
    def viewTrueCopy() {
        if(!selectedItem) throw new Exception("Please select an item");
        if(!selectedItem.truecopycertid ) throw new Exception("Clearance not yet generated");
        return Inv.lookupOpener( 'tdtruecopy:view', [entity: [objid: selectedItem.truecopycertid ]] );
    }
    
}
