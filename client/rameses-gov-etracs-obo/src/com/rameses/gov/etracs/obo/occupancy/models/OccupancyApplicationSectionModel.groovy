package com.rameses.gov.etracs.obo.occupancy.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.common.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.enterprise.models.*;
import com.rameses.gov.etracs.obo.models.*;

class OccupancyApplicationSectionModel extends AbstractApplicationSectionModel {
    
    
    public String getPermitName() {
        return "occupancy_application";
    }
    
    public String getCaption() {
        return "Occupancy Application";
    }
    
    public String getPrefix() {
        return "OP";
    }
    
}