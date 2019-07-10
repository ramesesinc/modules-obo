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

    def infoList = [
        fetchList: { o->
            return [];
        }
    ] as BasicListModel;
 
    def getHtmlInfo() {
        return TemplateProvider.instance.getResult( "com/rameses/gov/etracs/obo/templates/ancillaryinfo.gtpl", [info:[:] ] );
    }
    
    def infoListModel = [
        isMultiSelect: {
            return true;
        },
        fetchList: {
            def m = [parebn : entity.objid ];
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
    
}