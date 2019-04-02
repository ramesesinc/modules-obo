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

class OboBuildingApplicationWorkitemModel extends WorkflowTaskModel {

    @Service("OboBuildingApplicationService")
    def appSvc;
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    String getBarcodeFieldname() {
        return "appno";
    }
    
    public String getTitle() {
        return entity.appno + "[ " +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return entity.appno;
    }
    
    public String getFormId() {
        return entity.objid;
    }
  
    def addItem() {
        def h = { o->
            o.each {
                it.remove("objid");
                it.appid = entity.appid;
            }
            appSvc.saveInfos( o );
            infoListModel.load();
        }
        return Inv.lookupOpener( "obo_variable:picklist", [typeid: entity.workitem.objid, onselect: h ]);
    }
    
    def editItems() {
        def selectedItems = infoListModel.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to edit");
        def h = { v->
            appSvc.saveInfos( v );
            infoListModel.load();
        }
        def op= Inv.lookupOpener("obo_detail_info", [items: selectedItems, onselect: h ]);
        op.target = "popup";
        return op;
    }
    
    void removeItems() {
        def selectedItems = infoListModel.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to remove");
        appSvc.removeInfos( selectedItems );
        infoListModel.load();
    }
    
    def infoListModel = [
        isMultiSelect: {
            return true;
        },
        fetchList: {
            def m = [appid : entity.appid, typeid: entity.workitem.objid ];
            return appSvc.getInfos(m);
        }
    ] as BasicListModel;
    
    def itemListModel = [
        fetchList: { o->
            return [];
        }
    ] as BasicListModel;
    
    
    /*
    void addAttachment()  {
        def p = [:];
        p.appid = entity.objid;
        p._schemaname = 'obo_building_application_attachment';
        
        def h = { o->
            attachmentListModel.reload();
        }
        Modal.show( "obo_application_attachment:create", [info:p, handler: h] );
    }

    def attachmentListModel = [
        fetchList: { o->
            def m = [_schemaname: 'obo_building_application_attachment'];
            m.findBy = [appid: entity.objid];
            return queryService.getList( m );
        },
        onOpenItem: { o,colName->
            def opener = Inv.lookupOpener("sys_file:open", [entity: [objid: o.fileid]] );
            opener.target = 'popup'; 
            return opener; 
        }
    ] as BasicListModel;
    */
    
    def viewAssessment() {
        MsgBox.alert("view assessment");
    }
    
}