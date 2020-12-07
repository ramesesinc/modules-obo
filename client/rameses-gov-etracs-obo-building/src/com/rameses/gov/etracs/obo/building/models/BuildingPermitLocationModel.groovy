package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;

class BuildingPermitLocationModel  {
    
    def entity;
    def handler;
    
    void init() {
       
    }

    def formatAddress( def addr ) {
        def lst = [];
        lst << [addr.unitno, addr.bldgno, addr.bldgname ].findAll{it!=null}.join(" ");
        
        def ml = [];
        if( addr.lotno ) ml << "Lot." + addr.lotno;
        if( addr.blockno ) ml << "Blk." + addr.blockno;
        if(ml) {
            lst << ml.join(" ");
        }
        lst << [addr.street, addr.subdivision ].findAll{it!=null}.join(",");
        lst << [addr.barangay?.name, addr.citymunicipality, addr.province ].findAll{it!=null}.join(",");
        return lst.findAll{it}.join("\n");		
    }
    
    def doOk() {
        entity.text = formatAddress( entity );
        if(handler) handler(entity);
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}