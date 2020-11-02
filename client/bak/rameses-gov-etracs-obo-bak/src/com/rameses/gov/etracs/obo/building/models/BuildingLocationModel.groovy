package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.gov.etracs.obo.models.*;


class BuildingLocationModel  {

    def handler;
    def entity = [:];
    
    def doOk() {
        def sb = new StringBuilder();
        if(entity.lotno) sb.append( "Lot " + entity.lotno + " "  );
        if(entity.blockno) sb.append( "Blk " + entity.blockno + " " );
        if(entity.unitno) sb.append( entity.unitno + " " );
        if(entity.bldgno) sb.append( entity.bldgno + " " );
        if(entity.bldgname) sb.append( entity.bldgname + " " );
        if(entity.street) sb.append( entity.street + " " );
        if(entity.subdivision) sb.append( entity.subdivision + " " );
        sb.append( ", " + entity.barangay.name  );
        entity.text = sb.toString();
        handler( entity );
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
}


