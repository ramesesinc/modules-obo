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

class BuildingPermitRequirementModel {

    @Service("PersistenceService")
    def persistenceSvc;

    @Binding
    def binding;
    
    @Caller
    def caller;

    def entity;

    String title = "Requirement"
    
    boolean getShowNavigation() {
        return true;
    }
    
    void open() {
       
    }

    def moveUp() {
        def handler = caller.reqListHandler;
        handler.moveBackRecord();
        entity = handler.getSelectedItem()?.item;
        int idx  = handler.getSelectedItem().index;
        int maxRow = handler.getMaxRows();
        if( idx == 0 && handler.pageIndex != 1 ) {
            handler.moveBackPage();
            handler.setSelectedItem( maxRow - 1 );
            entity = handler.getSelectedItem()?.item;
        }
        return null;
    }
    
    def moveDown() {
        def handler = caller.reqListHandler;
        handler.moveNextRecord();
        entity = handler.getSelectedItem()?.item;
        int idx = handler.getSelectedItem().index;
        int maxRow = handler.getMaxRows();
        if( idx == (maxRow-1) ) {
            handler.moveNextPage();
            handler.setSelectedItem( 0 );
            entity = handler.getSelectedItem()?.item;
        }
        return null;
    }
    
    def updateState( int state ) {
        entity.checked = state;
        def m  = [ state: state, remarks: entity.remarks ];
        m._schemaname = "building_permit_requirement";
        m.findBy = [objid: entity.objid];
        def e = persistenceSvc.update( m );    
        caller.reqListHandler.getSelectedItem().item.putAll( e );
        def r = moveDown();
        binding.refresh();
        return r;
    }
    
    def accept() {
        return updateState(1); 
    }
    def revise() {
        if(!entity.remarks) throw new Exception("Please specify remarks")
        return updateState(2);         
    }
    def na() {
        return updateState(3) 
    }
    
    
}