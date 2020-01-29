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
import javax.swing.*;
import com.rameses.io.*;

class BuildingApplicationAncillaryModel extends CrudFormModel {

    
    @Service("BuildingApplicationInfoService")
    def infoSvc;
    
    /*
    def getHtmlInfo() {
        return TemplateProvider.instance.getResult( "com/rameses/gov/etracs/obo/templates/ancillaryinfo.gtpl", [info:[:] ] );
    }
    */
    def selectedInfo;
    def infos;
    boolean editable;
    
    void afterInit() {
        this.infos = infoSvc.getInfos([parentid: entity.objid ] );
        editable = false;
        def task = caller.task;
        if( task?.assignee?.objid == userid ) {
            editable = true;
        }
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
    
    def viewCalc() {
        def mm = [_schemaname:'vw_building_application'];
        mm.findBy =[objid: entity.appid];
        def zapp = queryService.findFirst(mm);
        def f = [:];
        f.app = [ 
            appid: zapp.objid,
            appno:zapp.appno, 
            appdate:zapp.appdate, 
            apptype:zapp.apptype, 
            projectcost: zapp.projectcost, 
            fixedcost: zapp.fixedcost,
            height: ((zapp.height == null)?0:zapp.height),
            numunits: zapp.numunits,
            totalfloorarea: zapp.totalfloorarea,
            zoneclass: zapp.zoneclass?.objid
        ];
        def occ = zapp.occupancytype;
        f.occupancytype = [division:occ.division.objid, group:occ.group.objid, type:occ.objid ];
        f.permits = [ [type: entity.type.objid ] ];
        f.sectionid = entity.type.objid;
        
        def h  = { list->
        }
        return Inv.lookupOpener("view_assessment", [params: f, handler: h] );
    }
    
    
}