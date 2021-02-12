package obo.util;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.seti2.models.*;
import com.rameses.osiris2.common.*;
import com.rameses.util.*;
import com.rameses.osiris2.client.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


class XlsUtil {
    
    def HSSFWorkbook workbook;
    def HSSFSheet worksheet;
    def columns = [];
    private def file;
    def schema = [];

    private void extractCols() {
        def row = worksheet.getRow(0);
        def cellIter =row.cellIterator(); 
        while(cellIter.hasNext()) {
            def cell = cellIter.next();
            if( cell.toString().trim() == "" ) break;
            columns << cell.toString();
        }
    }
    
    private void putData( def model, def colName, def value ) {
        def arr = colName.split("_");
        int i = 0;
        def p = model;
        if( arr.length > 1 ) {
            for( i=0; i<arr.length-1; i++ ) {
                if( !p.containsKey( arr[i] )) {
                    p.put( arr[i], [:] ); 
                }
                p = p.get( arr[i] ); 
            }
        }
        p.put( arr[i], value ); 
    }
    
    public def getTotalRows() {
        return worksheet.getLastRowNum();
    }
    
    private void fetchRows(def handler) {
        int lastRow = getTotalRows();
        for( int i=1; i<lastRow; i++) {
            def m = getRowData( i );
            handler( m );
        }
    } 
    
    public def getRowData( int i ) {
        def row = worksheet.getRow( i );
        int colCount = columns.size();
        def m = [:];
        for( int j=0; j<colCount; j++) {
            def colName = columns[j];
            def value = row.getCell((short)j);
            if(value.toString().trim()!="") {
                def dtype = schema.find{ it.name == colName }?.type;
                if(dtype?.matches("decimal|integer")) {
                    value = value.getNumericCellValue();
                }
                else {
                    value = value.toString();
                }
                putData(m, colName, value );
            }
        }
        return m;
    }
    
    
    public XlsUtil( def f ) {
        setFile( f );
    }
    
    public XlsUtil() {
    }

    public void setFile( f ) {
        file = f;
        def fis = new FileInputStream(file);
        try {
            workbook = new HSSFWorkbook(fis);
            worksheet = workbook.getSheetAt(0);
            extractCols();
        }
        catch(ex) {
            throw ex;
        }
        finally {
            fis.close();                
        }
    }
    
    public void start( def h ) {
        if(h==null) throw new Exception("Please specify handler");
        fetchRows(h);
    }
    
    
}