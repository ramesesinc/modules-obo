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
    def workTypes = ["NEW CONSTRUCTION", "ADDITION", "RENOVATION", "ALTERATION", "DEMOLITION", "OTHER"];
    def subApplication;
    
    void init() {
        entity = [subapplications:[], numunits: 1, floorarea: 0, height: 0];
    }
    
    @PropertyChangeListener
    def propListener = [ 
        "entity.(numunits|height|floorarea|apptype|occupancytypeid|constructiontypeid)" : { v->
            entity.projectcost = 0;
            if( entity.height == null ) {};
            else if( !entity.floorarea ) {
                println "entity floor area " + entity.floorarea;
            };
            else if( !entity.apptype ) {
                println "entity app type " + entity.apptype;
            };
            else if( !entity.occupancytype ) {
                println "occupancy type " + entity.occupancytype.objid;
            };
            else if( !entity.constructiontypeid ) {
                println "work type " + entity.constructiontypeid
            };            
            else {
                def req = buildBasicParams();
                entity.projectcost = costSvc.calc(req); 
            }
            binding.refresh("entity.projectcost");
        }
    ];
    
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
            floorarea: entity.floorarea
        ];
        f.occupancytype = [division:entity.occupancytype.objid, group:entity.occupancytype.parentid ]; 
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
        return Inv.lookupOpener("obo_subapplication_type:lookup", [onselect:h, multiSelect: true ]);    
    }
    
    void removeSubApp() {
        if(!subApplication) throw new Exception("Please select a subapplication");
        entity.subapplications.remove( subApplication );
    }
    
    def addInfos() {
        def h = { o->
            o.each { v->
                if (!subApplication.infos.find{it.objid == v.objid}) {
                    subApplication.infos << v;
                }
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

}