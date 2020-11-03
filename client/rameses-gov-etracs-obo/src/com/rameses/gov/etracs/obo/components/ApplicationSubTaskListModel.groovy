package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class ApplicationSubTaskListModel extends AbstractComponentModel {

    def viewType = "all";
    
    @PropertyChangeListener
    def listener = [
        "viewType": {
            listHandler.reload();
        }
    ];
    
    void beforeLoadList( def m ) {
        if( viewType == "open" ) {
            m.where = [" NOT(task.state = 'end')"];
        }
        else if( viewType == "completed") {
            m.where = [ " task.state = 'end' "];
        }
    }
    
}
