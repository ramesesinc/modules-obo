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
import com.rameses.gov.etracs.obo.models.*;

class BuildingEvaluationModel extends AbstractApplicationSubTaskModel {
    

    
    public String getCaption() {
        return "Building Evaluation";
    }
    
    public String getPrefix() {
        return "BE";
    }
    
    def addFinding() {
        return super.addFinding( "building_evaluation_finding");
    }

    
}