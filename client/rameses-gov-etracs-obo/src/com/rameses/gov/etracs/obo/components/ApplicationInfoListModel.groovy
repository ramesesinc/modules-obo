package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class ApplicationInfoListModel extends AbstractComponentModel {
    
    def infos;
    
    /*
    def listHandler = [
        isMultiSelect: {
            return true;
        },
        fetchList: { o -> 
            if(!infos) infos = handler.getInfos();
            return infos;      
        }
    ] as EditorListModel;
    */
   
    public boolean isMultiSelect() {
        return true;
    }
   
    void afterLoadList() {
        def result = [];
        _items.each {
            if( it.datatype == 'date') it.value = it.datevalue;
            else if( it.datatype == 'decimal') it.value = it.decimalvalue;
            else if( it.datatype == 'integer') it.value = it.intvalue;
            else if( it.datatype == 'boolean')  it.value = ( (it.booleanvalue == 0) ? false: true);
            else it.value = it.stringvalue;
            result << it;
        }
        _items = result.sort{ it.sortorder };
        infos = _items;
    }   
    
    void saveInfos(def items) {
        def _infos = [];
        items.each { v->
            def existInfo = infos.find{it.name == v.name};
            if( !existInfo ) {
                v.objid = null;
                v.parentid = parentid;
                v.appid = appid;
                _infos << v;
            }
            else {
                existInfo.value =  v.value;
                _infos << existInfo;                    
            }
        }
        handler.saveInfos( _infos );
        listHandler.load();
    }
    
    
    def addInfos() {
        def p = [:];
        p.onselect = { o->
            saveInfos(o);
        }
        def filter = handler.getLookupFilter();
        if( filter ) p.putAll( filter );
        return Inv.lookupOpener( "obo_variable:picklist", p );
    }
    
    def editInfos() {
        def selectedItems = listHandler.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to edit");
        def h = { o->
            saveInfos(o);
        }
        def op= Inv.lookupOpener("obo_detail_info", [items: selectedItems, onselect: h ]);
        op.target = "popup";
        return op;
    }
    
    void removeInfos() {
        def selectedItems = listHandler.getSelectedValue();
        if( !selectedItems ) throw new Exception("Please select items to remove");
        handler.removeInfos( selectedItems );
        listHandler.load();
    }

    void editRemarks() {
        if( !selectedItem ) return;
        def msg = MsgBox.prompt("Enter Remarks");
        if(msg) {
            selectedItem.remarks = msg;
            def u = [_schemaname:schemaName];
            u.objid = selectedItem.objid;
            u.remarks = msg;
            persistenceService.update( u );
            refresh();
        }
    }
    
    
}
