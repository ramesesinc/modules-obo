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

class BuildingApplicationRptModel  {
    
    @Caller 
    def caller;

    @Service("QueryService")
    def qryService;
    
    @Service("BuildingApplicationRptService")
    def rptService;
    
    def list;
    
    public def getEntityid() {
        return caller.entity.objid;
    }
    
    public void generateDocs() {
        def m = [appid: entityid]; 
        rptService.generateDocs( m );
        caller.reload();
        MsgBox.alert("RPT Docs generated successfully");
    }
 
    
    public def viewList() {
        def m = [_schemaname: "building_application_rpu"];
        m.findBy = [appid: entityid ];
        def vlist = qryService.getList( m );
        list = [];
        vlist.each {
            list << [ id: it.taxclearanceid, handler:'rpttaxclearance', tdno:it.tdno, description:'Lot No' + it.lotno, type:'Tax Clearance' ];
            list << [ id: it.truecopycertid, handler:'tdtruecopy', tdno:it.tdno, description:'Lot No '+ it.lotno, type:'Cert of True Copy' ];            
        }
        return "list";
    }
    
    def listHandler = [
        getColumns: {
            return [
                [name:'tdno', caption: 'TD No'],
                [name:'description', caption: 'Description'],
                [name:'type', caption: 'RPU Type'],
            ]
        },
        openItem: { itm, colName ->
            return openItem( itm );
        },
        fetchList: { o->
            return list;
        }
    ] as BasicListModel;
    
    def viewItem() {
        def itm = listHandler.getSelectedItem().item;
        if(itm==null) return null;
        return openItem( itm );
    }
    
    def openItem(def itm) {
        def op = Inv.lookupOpener(itm.handler + ":view", [entity: [objid: itm.id ]] );
        op.target = "popup";
        return op; 
    }
    
    /*
    def viewTaxClearance(def id) {
        if(!selectedRpu) throw new Exception("Please select an RPU Entry");
        if(!selectedRpu.taxclearanceid) throw new Exception("Please generate Tax Dec documents first");
        
        File f = new File("tdprint.pdf")
        op.handle.exportToPDF( f );
        op.target = "popup";
        return op;
    }
    
    def viewTrueCopy() {
        if(!selectedRpu) throw new Exception("Please select an RPU Entry");
        if(!selectedRpu.truecopycertid) throw new Exception("Please generate Tax Dec documents first");
        def op = Inv.lookupOpener(":view", [entity: [objid: selectedRpu. ]] );
        op.target = "popup";
        return op;
        File f = new File("tdprint.pdf")
        op.handle.report.exportToPDF( f );
        op.target = "popup";
        return op;
    }
    */
    
}