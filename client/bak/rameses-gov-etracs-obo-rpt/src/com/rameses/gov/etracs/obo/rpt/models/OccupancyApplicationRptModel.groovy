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
import javax.swing.*;
import com.rameses.io.*;
import com.rameses.gov.etracs.obo.models.*;

class OccupancyApplicationRptModel {

    @Caller
    def caller;
    
    def selectedItem;
    
    @Service("OccupancyPermitRptService")
    def occupancyPermitSvc;
    
    void loadRptUnits() {
        //sMsgBox.alert( caller.entity.app.bldgpermitid );
        occupancyPermitSvc.loadRptUnits( [permitno: caller.entity.app.bldgpermit.permitno] );
    }
    
    def listHandler = [
        fetchList: {
            return [];
        }
    ] as BasicListModel;
}


