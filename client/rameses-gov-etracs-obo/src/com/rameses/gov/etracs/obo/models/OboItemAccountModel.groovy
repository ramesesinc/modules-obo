package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*
import com.rameses.rcp.common.*
import com.rameses.osiris2.client.*
import com.rameses.osiris2.common.*
import java.rmi.server.*;
import com.rameses.gov.etracs.bpls.application.*;
import com.rameses.util.*;
import com.rameses.osiris2.reports.*;
import com.rameses.seti2.models.*;

public class OboItemAccountModel extends CrudFormModel {
    
    def selectedTag;
    
    def addTag() {
        def h = { o->
            if( entity.reporttags.find{it.objid == o.objid} ) return;
            def t = [objid:entity.objid+"-"+o.objid];
            t.tag = o.objid;
            t.itemid = entity.objid;
            addItem( "reporttags", t );
            //entity.reporttags << t;
            binding.refresh();
        }    
        return Inv.lookupOpener( "sys_report_tag:lookup", [onselect:h ] );
    }
    
    void removeTag() {
        removeItem("reporttags", selectedTag );
        entity.reporttags.remove( selectedTag );
    }
    
}