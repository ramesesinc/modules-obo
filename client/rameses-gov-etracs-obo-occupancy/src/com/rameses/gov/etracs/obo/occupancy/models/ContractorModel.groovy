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

class ContractorModel  {

    def entity;
    def handler;
    
    void init() {
        if( entity == null ) {
            entity = [pcab: [:], manager: [:] ];
        }
    }
    
    def doOk() {
        handler( entity );
        return "_close";
    }
    
    def doCancel() {
        return "_close";
    }
    
    
}