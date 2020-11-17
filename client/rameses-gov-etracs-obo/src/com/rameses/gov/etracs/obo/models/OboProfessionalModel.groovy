package com.rameses.gov.etracs.obo.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;

class OboProfessionalModel extends CrudFormModel  {
    
    def idTypes;

    void afterInit() {
        def m = [_schemaname: "idtype"];
        m._limit = 100;
        idTypes = queryService.getList( m );
    }
    
    void afterOpen() {
        entity.id.type = idTypes.find{ it.name == entity.id?.type?.name };
    }
    
}