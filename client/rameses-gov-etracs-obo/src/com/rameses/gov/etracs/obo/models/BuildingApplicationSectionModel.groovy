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

class BuildingApplicationSectionModel extends WorkflowTaskModel {

    @Service("OboBuildingApplicationSectionService")
    def appSvc;
    
    def infos;
    
    String getFormName() {
        return getSchemaName() + ":form";
    }
    
    /*
    String getBarcodeFieldname() {
        return "appno";
    }
    */
   
    public String getTitle() {
        return entity.appno;
        //return entity.appno + "[ " +  task?.title + "]" ;
    }
    
    public String getWindowTitle() {
        return entity.appno;
    }
    
    public String getFormId() {
        return entity.objid;
    }
  
    def infoListModel = [
        isMultiSelect: {
            return true;
        },
        fetchList: {
            def m = [subappid : entity.objid ];
            infos = appSvc.getInfos(m);
            return infos;
        }
    ] as BasicListModel;
    
    def addItem() {
        def h = { o->
            o.each {
                it.remove("objid");
                it.appid = entity.appid;
                it.subappid = entity.objid;
            }
            appSvc.saveInfos( o );
            infoListModel.load();
        }
        return Inv.lookupOpener( "obo_variable:picklist", [typeid: entity.typeid, onselect: h ]);
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
    
    
    
    def itemListModel = [
        fetchList: { o->
            return [];
        }
    ] as BasicListModel;
    
    def viewAssessment() {
        def f = [:];
        f.app = [ 
            appno:entity.appno, 
            appdate:entity.appdate, 
            apptype:entity.apptype, 
            projectcost: entity.projectcost, 
            height: ((entity.height == null)?0:entity.height),
            numunits: entity.numunits,
            floorarea: entity.floorarea
        ];
        f.occupancytype = [division:entity.occupancytypeid, group:entity.occupancytypegroup ];
        f.infos = infos;
        f.permits = [ [type: entity.typeid ] ];
        return Inv.lookupOpener("view_assessment", [params: f] );
    }
    
    def addFinding() {
        def m = [:];
        m.appid = entity.appid;
        m.subappid = entity.objid;
        m.handler = {
            findingListHandler.reload();
        }
        return Inv.lookupOpener("obo_building_application_finding:create", m);
    }
    
    def viewApplication() {
        def op = Inv.lookupOpener("vw_obo_building_application:open", [entity: [objid: entity.appid ] ] );
        op.target = "popup";
        return op;
    }
}