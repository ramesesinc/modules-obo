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

class NewOboApplicationModel extends CrudPageFlowModel {
    
    def ruleExecutor;
    def appTypes = LOV.OBO_APP_TYPE;
    def orgType;
    
    void afterCreate() {
        entity.apptype = 'NEW';
    }
    
    @PropertyChangeListener
    def listener = [
        "entity.supervisor" : { o->
            entity.supervisor = o;
            entity.supervisor.objid = o.entity.objid;
            entity.supervisor.name = o.entity.name;
        },
        "entity.designer" : { o->
            entity.designer = o;
            entity.designer.objid = o.entity.objid;
            entity.designer.name = o.entity.name;
        },
        "entity.lotowner": { o->
            binding.refresh();
        }
    ];
    
    public def getLookupRpu() {
        def h = { o->
            entity.rptinfo = o;
            entity.lotowner = o.taxpayer;
            entity.lotowned = ( entity.lotowner?.objid == entity.owner.objid ); 
            binding.refresh();
        }
        return Inv.lookupOpener("faas:lookup", [onselect: h, rputype: 'land' ]);
    }
    
    
    /*
    void save() {
        formTitle = workunit.info.workunit_properties.title;
        if(!formTitle) formTitle = getTitle();
        vehicletype = workunit?.info?.workunit_properties?.vehicletype;
        ruleExecutor = new RuleProcessor(  { p-> return assessmentService.assess(p) } );
        entity = [:];
        entity.apptype = workunit?.info?.workunit_properties?.apptype;
        entity.txnmode = "ONLINE";
        entity.vehicletype = vehicletype;
    }

    void afterLoad() {
        
    }
        
    void assess() {
        def p = [:];
        p.putAll( entity );
        p.defaultinfos = p.remove("infos");

        def r = ruleExecutor.execute(p);
        if( !r) {
            throw new BreakException();
        }
        entity.billexpirydate = r.duedate;
        if( r.items ) {
            entity.fees = r.items;
            entity.amount = entity.fees.sum{ it.amount };
        }
        if( r.infos ) {
            entity.infos = r.infos;
        }
        else {
            entity.infos = [];
        }
        feeListModel.reload();
        infoListModel.reload();
    }
        
    def feeListModel = [
        fetchList: { o->
            return entity.fees;
        }
    ] as BasicListModel;
    
    def infoListModel = [
        fetchList: { o->
            return entity.infos;
        }
    ] as BasicListModel;
    */

    void viewTrackingno() {
        Modal.show( "show_trackingno", [trackingno: "51010:" + entity.appno ]);
    }
    
    
}