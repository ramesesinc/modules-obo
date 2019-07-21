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

class BuildingPermitAncillaryModel extends CrudFormModel {

    def selectedInfo;
    
    def infos;
    
    @Service("BuildingPermitInfoService")
    def infoSvc;
    
    /*
    def getHtmlInfo() {
        return TemplateProvider.instance.getResult( "com/rameses/gov/etracs/obo/templates/ancillaryinfo.gtpl", [info:[:] ] );
    }
    */
   
    void afterInit() {
        this.infos = infoSvc.getInfos([parentid: entity.objid ] );  
    }
   
    /* ************************************************************************
    * INFOS ADDED IN THE ANCILLARY 
    *************************************************************************/
    def infoListModel = [
        isMultiSelect: {
            return true;
        },
        fetchList: { o -> 
            return infos;      
        }
    ] as EditorListModel;
    
    void saveInfos(def items) {
        def _infos = [];
        items.each { v->
            def existInfo = infos.find{it.name == v.name};
            if( !existInfo ) {
                v.objid = null;
                v.parentid = entity.objid;
                v.appid = entity.appid;
                _infos << v;
            }
            else {
                existInfo.value =  v.value;
                _infos << existInfo;                    
            }
        }
        infoSvc.saveInfos( _infos );
        this.infos = infoSvc.getInfos([parentid: entity.objid ] ); 
        infoListModel.load();
    }
    
    
    def addInfos() {
        def h = { o->
            saveInfos(o);
        }
        return Inv.lookupOpener( "obo_variable:picklist", [typeid: entity.permittypeid, onselect: h ]);
    }
    
    def editInfos() {
        def selectedItems = infoListModel.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to edit");
        def h = { o->
            saveInfos(o);
        }
        def op= Inv.lookupOpener("obo_detail_info", [items: selectedItems, onselect: h ]);
        op.target = "popup";
        return op;
    }
    
    void removeInfos() {
        def selectedItems = infoListModel.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to remove");
        infoSvc.removeInfos( selectedItems );
        this.infos = infoSvc.getInfos([parentid: entity.objid ] ); 
        infoListModel.load();
    }

    void editRemarks() {
        if( !selectedInfo ) return;
        def msg = MsgBox.prompt("Enter Remarks");
        if(msg) {
            selectedInfo.remarks = msg;
            infoListModel.load();
        }
    }
    
   
    
    
}