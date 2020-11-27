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

class OboVariableModel extends CrudFormModel {
    
    def datatypes = ['integer','decimal','boolean','string','date']
        
    void afterCreate() {
        entity.doctypeid =  caller.selectedNode.id;
    }
    
    @PropertyChangeListener
    def listener = [
        "entity.name" : { o->
            entity.objid = o;
        }
    ];
    
}