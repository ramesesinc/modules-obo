package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import com.rameses.enterprise.models.*;

public class BuildingPermitEvaluationCheckListModel {
    
    @Service("QueryService")
    def querySvc;

    @Caller
    def caller;
    
    def checkList;
    def selectedItem;
    
    void init() {
        def m = [_schemaname: 'obo_evaluation_checklist'];
        m.orderBy = "objid";
        m.where = ["evaluationtypeid = :id", [id: caller.entity.typeid ] ];
        checkList = querySvc.getList(m);
    }
    
    def listHandler = [
        isMultiSelect: {
            return true;
        },
        fetchList: {
            return checkList;
        }
        
    ] as EditorListModel;
    
    def doCancel() {
        return "_close";
    }
    
}