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
        infos = infoSvc.getInfos([parentid: entity.objid ] );
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
    
    def addInfos() {
        def h = { o->
            o.each { v->
                if( !infos.find{it.name == v.name} ) {
                    infos << v;                    
                }
            }
            infoListModel.load();
        }
        return Inv.lookupOpener( "obo_variable:picklist", [typeid: entity.permittypeid, onselect: h ]);
    }
    
    def editInfos() {
        def selectedItems = infoListModel.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to edit");
        def h = { v->
            infoListModel.load();
        }
        def op= Inv.lookupOpener("obo_detail_info", [items: selectedItems, onselect: h ]);
        op.target = "popup";
        return op;
    }
    
    void removeInfos() {
        def selectedItems = infoListModel.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to remove");
        selectedItems.each {
            infos.remove( it );
        }
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