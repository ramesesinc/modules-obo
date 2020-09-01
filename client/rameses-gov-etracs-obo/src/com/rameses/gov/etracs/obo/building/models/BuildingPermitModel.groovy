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
import javax.swing.*;
import com.rameses.io.*;
import com.rameses.gov.etracs.obo.models.*;

class BuildingPermitModel extends CrudFormModel  {

    def task = [:]; //dummy only so that subdoc will not error
    
    def getAppQry() {
        return [appid: entity.appid];
    }
    
    def viewApp() {
        def op = Inv.lookupOpener( "vw_building_application:open", [entity: [objid: entity.appid ]] );
        op.target = "popup";
        return op;
    }
    
}