package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.*;
import com.rameses.util.*;
import com.rameses.gov.etracs.vehicle.models.*;
import java.text.*;

public class OboChecklistMasterModel extends CrudFormModel {
    
    def xtitle;
    
    public void afterCreate() {
        entity.system = 0;
        def parentSchema = caller.schemaName;
        if(parentSchema.matches(".*doctype.*")) {
            entity.doctypeid = caller.entity.objid;
        }
        else if( parentSchema.matches(".*evaluation.*")  ) {
            entity.evaltypeid = caller.entity.objid;
        }
    }
    
    public void afterOpen() {
        xtitle = entity.title;
        if(entity.params) {
            def v = new Object[ entity.params.size() ];
            for(int i=0; i< entity.params.size();i++) {
                v[i] = "{" + entity.params[i] + "}";
            }
            xtitle = MessageFormat.format( entity.title, v );
        }
    }
    
    public void beforeSave( def o ) {
        entity.title = xtitle;
    }
    
}