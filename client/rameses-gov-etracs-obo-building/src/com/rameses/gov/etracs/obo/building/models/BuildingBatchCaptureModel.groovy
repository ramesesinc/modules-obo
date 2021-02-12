package com.rameses.gov.etracs.obo.building.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import obo.util.*;

class BuildingBatchCaptureModel {
    
    @Service("PersistenceService")
    def persistenceSvc;
    
    @Binding
    def binding;
    
    def columns;
    def excelFile;
    def pageMode = "init";
    int procState = 0;
    
    def fixedcols = [
        "title",
        "description",
        "location.text",
        "applicant.name",
        "applicant.lastname",
        "applicant.firstname",
        "applicant.middlenbame",
        "numunits",
        "numfloors",
        "floorarea",
        "height",
        "projectcost",
        "dtproposedconstruction",
        "dtexpectedcompletion",
        "occupancytype.division.objid",
        "appno",
        "trackingno",
        "txntype",
        "apptype",
        "permitno",
        "permitdtissued",
        "permitexpirydate",
        "receiptno",
        "receiptdate",
        "amtpaid",
        "zone",
        "zoneclass.title"
    ]; 
    
    def schema = [
        [name:"projectcost", type: "decimal"],
        [name:"numunits", type: "integer"],
        [name:"numfloors", type: "integer"],
        [name:"amtpaid", type: "decimal"]
    ]
    
    public void init() {
        def jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Xls Files", "xls"));
        jfc.setFileSelectionMode( JFileChooser.FILES_ONLY );
        int retval = jfc.showOpenDialog(null); 
        if (retval == JFileChooser.APPROVE_OPTION) {
            excelFile = new XlsUtil( jfc.selectedFile );
            excelFile.schema = schema;
            columns = excelFile.columns;
        } 
        else {
            throw new BreakException();
        }
    }
    
    int counter = 0;
    
    def progress = [
        getTotalCount : {
            return excelFile.getTotalRows();
        },
        getRows: {
            return 1;
        },
        fetchList: { o->
            def m = excelFile.getRowData( o._start + 1 );
            return [ m ];
        },
        processItem: { o->
            if(o) {
                println "processing data " + o;
                println "last " + o.applicant?.lastname;
                println "cost " + o.projectcost * 1.0;
                counter++;
            }
            Thread.sleep(100);
            binding.refresh("progress.*");
        },
        onFinished: {
            binding.refresh();
        }
    ] as BatchProcessingModel;
    
    def doNext() {
        return "processing";
    }
 
}