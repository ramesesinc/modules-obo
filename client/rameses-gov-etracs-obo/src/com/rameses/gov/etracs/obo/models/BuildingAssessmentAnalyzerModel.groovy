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

class BuildingAssessmentAnalyzerModel  {

    @Binding
    def binding;
    
    @Service("OboConstructionCostService")
    def costSvc;
    
    def entity;
    def appTypes = ["NEW", "RENEW","ADDITIONAL"];
    def subApplication;
    def selectedInfo;
    
    void init() {
        entity = [subapplications:[], numunits: 1, floorarea: 0, height: 0, totalfloorarea: 0, projectcost: 0];
    }
    
    def buildBasicParams() {
        def dt = null;
        if( entity.appdate ) {
            dt = (new java.text.SimpleDateFormat("yyyy-MM-dd")).parse(entity.appdate);
        }
        def f = [:];
        f.app = [ 
            appdate:dt, 
            apptype:entity.apptype, 
            projectcost: entity.projectcost, 
            height: ((entity.height == null)?0:entity.height),
            numunits: entity.numunits,
            totalfloorarea: entity.totalfloorarea,
            worktype : entity.worktype.objid
        ];
        def v = entity.occupancytype;
        def occ = [:];
        occ.division = v.division.objid;
        occ.group = v.group.objid;
        occ.id = v.objid; 
        f.occupancytype =  occ;
        return f;
    }
    
    def assess() {
        def f = buildBasicParams();
        def infos = [];
        entity.subapplications.each {
            infos.addAll( it.infos ); 
        }
        f.infos = infos;
        f.permits = entity.subapplications.collect{ [type: it.objid] };
        return Inv.lookupOpener("view_assessment", [params: f] );
    }
    
    def addSubApp() {
        def h = { items->
            items.each { o->
                if (!entity.subapplications.find{it.objid == o.objid}) {
                    o.infos = [];
                    entity.subapplications << o;
                }
            }
            binding.refresh("subApplication");
        }
        return Inv.lookupOpener("obo_permit_type:ancillary:lookup", [onselect:h, multiSelect: true ]);    
    }
    
    void removeSubApp() {
        if(!subApplication) throw new Exception("Please select a subapplication");
        entity.subapplications.remove( subApplication );
    }
    
    def addInfos() {
        def h = { o->
            o.each { v->
                subApplication.infos << v;
            }
            infoListModel.load();
        }
        return Inv.lookupOpener( "obo_variable:picklist", [typeid: subApplication.objid, onselect: h ]);
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
            subApplication.infos.remove( it );
        }
        infoListModel.load();
    }
    
    def infoListModel = [
        isMultiSelect: {
            return true;
        },
        fetchList: { o -> 
            if(!subApplication) return [];
            return subApplication.infos;
        }
    ] as EditorListModel;

    void editRemarks() {
        if( !selectedInfo ) return;
        def msg = MsgBox.prompt("Enter Remarks");
        if(msg) {
            selectedInfo.remarks = msg;
            infoListModel.load();
        }
    }
    
    def computeCost() {
        def req = buildBasicParams();
        entity.projectcost = costSvc.calc(req); 
    }
    
}