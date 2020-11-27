package com.rameses.gov.etracs.obo.components;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.seti2.models.*;

class ProfessionalListModel extends AbstractComponentModel {

    def viewProfessional() {
        if(!selectedItem) throw new Exception("Please select an entry");
        return Inv.lookupOpener("vw_obo_professional:open", [entity: [objid: selectedItem.objid]]);
    }
    
    def listHandler = [ 
        fetchList: { o->
            return handler.getList(); 
        },
        openItem: { o,col->
            return Inv.lookupOpener("vw_obo_professional:open", [entity: [objid: o.objid]]);
        }
    ]as BasicListModel;
    
}
