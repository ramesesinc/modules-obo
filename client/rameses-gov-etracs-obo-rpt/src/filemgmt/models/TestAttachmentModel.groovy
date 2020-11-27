package filemgmt.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;

class TestAttachmentModel {

    @Service('QueryService')
    def querySvc; 
    
    def files;
    
    def entity = [:];
    
    void init() {
        files = querySvc.getList([_schemaname: 'sys_file', where:['1=0']]); 
    }
    
    def fileHandler = [
        fetchList: { o-> 
            return files;
        }        
    ] as FileViewModel; 
    
    void setSelectedAlbum( album ) {
        entity.album = album;
    }
    
    void reload() {
        querySvc.getList([_schemaname: 'sys_file', where:['1=1']]).each{
            files << it; 
        }
        fileHandler.reload();
    }
}
