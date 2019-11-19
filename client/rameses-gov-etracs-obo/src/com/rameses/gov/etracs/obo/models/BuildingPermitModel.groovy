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


class BuildingPermitModel extends AbstractOboApplicationModel {

    @Service("BuildingPermitRptService")
    def rptSvc;
    
    def ancillaryListModel;
    
    public String getPermitName() {
        return "building_permit";   
    }
    
    public String getTitle() {
        return "Building Permit " + (entity.appno==null? 'Tracking No '+ entity.trackingno: 'App No ' + entity.appno) + " [" +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return "Bldg "+ (entity.appno==null? entity.trackingno : entity.appno);
    }
    
    public boolean getShowAssessAction() {
        return true;
    }
    
    def lookupAncillary() {
        def h = { o->
            def v = [appid: entity.objid, items: o*.objid ]
            bldgSvc.addAncillary( v );
            ancillaryListModel.reload();
        }
        return Inv.lookupOpener("obo_ancillary:lookup", [onselect: h]);
    }

    /**************
    * RPT Clearances
    **************/
    def selectedRpu;
    void issueTDDocs() {
        rptSvc.issueTDDocs([appid: entity.objid] );
        MsgBox.alert("Tax Declaration docs generated");
    }

    def viewTaxClearance() {
        if(!selectedRpu) throw new Exception("Please select an RPU Entry");
        if(!selectedRpu.taxclearanceid) throw new Exception("Please generate Tax Dec documents first");
        def op = Inv.lookupOpener("rpttaxclearance:view", [entity: [objid: selectedRpu.taxclearanceid ]] );
        op.target = "popup";
        return op;
        /*
        File f = new File("tdprint.pdf")
        op.handle.exportToPDF( f );
        op.target = "popup";
        return op;
        */
    }
    
    def viewTrueCopy() {
        if(!selectedRpu) throw new Exception("Please select an RPU Entry");
        if(!selectedRpu.truecopycertid) throw new Exception("Please generate Tax Dec documents first");
        def op = Inv.lookupOpener("tdtruecopy:view", [entity: [objid: selectedRpu.truecopycertid ]] );
        op.target = "popup";
        return op;
        /*
        File f = new File("tdprint.pdf")
        op.handle.report.exportToPDF( f );
        op.target = "popup";
        return op;
        */
    }
    
}


