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

    def selectedSubApplication;
    
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
    
    def subApplicationListModel = [
        fetchList: { o->
            def m = [_schemaname: "obo_building_subapplication" ];
            m.findBy = [appid: entity.objid];
            return queryService.getList( m );
        }
    ] as BasicListModel;

    def addItem() {
        def h = { o->
            if(entity.infos==null) entity.infos = [];
            o.each {
                entity.infos << it;
            }
            infoListModel.reload();
        }
        return Inv.lookupOpener( "obo_variable:picklist", [typeid: entity.reqtype.objid, onselect: h ]);
    }
    
    def editItems() {
        def selectedItems = infoListModel.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to edit");
        def sitems = [];
        selectedItems.each {
            def m = [:];
            m.putAll(it);
            sitems << m;
        }
        def h = { v->
            v.each { zz->
                entity.infos.find{ it.name == zz.name }.value = zz.value;                
            }
            infoListModel.reload();
        }
        def op= Inv.lookupOpener("obo_detail_info", [items: sitems, onselect: h ]);
        op.target = "popup";
        return op;
    }
    
    def infoListModel = [
        isMultiSelect: {
            return true;
        },
        fetchList: {
            return entity.infos;
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
    
}