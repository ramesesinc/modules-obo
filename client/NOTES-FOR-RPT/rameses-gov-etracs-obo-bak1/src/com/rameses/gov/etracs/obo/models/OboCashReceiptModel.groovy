package com.rameses.gov.etracs.bpls2.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.util.*;
import com.rameses.treasury.common.models.*;

public class OboCashReceiptModel extends CommonCashReceiptModel {
    
    public String getCashReceiptServiceName() {
        return "OboCashReceiptService";
    }

}