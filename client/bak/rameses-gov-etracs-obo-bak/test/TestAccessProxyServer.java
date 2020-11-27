/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.rameses.service.DefaultScriptServiceProxy;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author elmonazareno
 */
public class TestAccessProxyServer {
    
    public TestAccessProxyServer() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() throws Exception {
        
        // /cloud-server/services/obo 
        Map conf = new HashMap();
        conf.put("app.host", "localhost");
        conf.put("app.cluster", "cloud-server");
        conf.put("app.context", "obo");
        conf.put("debug", true);
        DefaultScriptServiceProxy df = new DefaultScriptServiceProxy("DateService", conf, null);
        System.out.println("test->"+df.invoke("getServerDate"));
    }
}
