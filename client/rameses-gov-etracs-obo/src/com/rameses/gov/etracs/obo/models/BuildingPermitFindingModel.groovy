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

class BuildingPermitFindingModel extends CrudFormModel {

    
    void afterCreate() {
        entity.appid = caller.entity.appid;
        entity.parentid = caller.entity.objid;
        entity.checked = 0;
    }
    
    void afterSave(def o ) {
        if(caller) {
            caller.reqListHandler.reload();
        }
    }
    
    
    
}