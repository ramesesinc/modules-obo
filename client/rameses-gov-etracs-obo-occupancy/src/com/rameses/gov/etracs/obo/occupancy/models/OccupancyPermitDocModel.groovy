package com.rameses.gov.etracs.obo.occupancy.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class OccupancyPermitDocModel extends CrudFormModel {
    
    @FormId
    public String getFormid() {
        return "occupancy_doc:" + entity.objid;
    }
    
    boolean editable;
    boolean showInfos;
    boolean showChecklist;
    boolean showFees;
    boolean currentOrg = false;
    
    def docList;
    boolean showDocList;
    def selectedRefDoc;
    
    
    public String getTitle() {
        return entity.doctype.title;
    }
    
    void checkCurrentOrg( def orgid ) {
        currentOrg = false;
        if(  orgid == userInfo.env.ORGID ) currentOrg = true;
        else if( orgid ==null && userInfo.env.ORGROOT == 1 ) currentOrg = true;
    }
    
    void afterOpen() {
        //showChecklist = entity.showchecklist;
        //showInfos = entity.showinfo;
        //showFees = entity.showfees;
        
        showChecklist = true;
        showInfos = true;
        showFees = true;
        reloadRefDocList();
    }
    
    public void checkCanIssue() {
        if(docList.findAll{ it.controlid==null} ) {
            throw new Exception("This document cannot be issued because there are unissued reference documents");
        }
    }
    
    void reloadRefDocList() {
        def m = [_schemaname: "vw_occupancy_permit_doc"];
        m.findBy = [ appid: entity.appid ];
        m.where = ["doctype.refdoc = :refdoc", [refdoc: entity.doctype.objid ]];
        docList = queryService.getList( m );
        if( docList ) showDocList = true;
    }
    
    def openRefDoc() {
        if(!selectedRefDoc) return null;
         def op = Inv.lookupOpener( "vw_occupancy_permit_doc:open", [entity: selectedRefDoc] );
         op.target = "popup";
         return op;
    }
    
    def docListHandler = [
        fetchList: { o->
            return docList;
        },
        openItem: { o,col->
            return openRefDoc();
        }
    ] as BasicListModel;
    
    def reloadEntity() {
        def r = super.reloadEntity();
        reloadRefDocList();
        docListHandler.reload();
        return r;
    }
    
    
}