/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import junit.framework.TestCase;

/**
 *
 * @author elmonazareno
 */
public class NewEmptyJUnitTest extends TestCase {
    
    public NewEmptyJUnitTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    public void testHello() {
        try {
            URL u = new URL("http://192.168.254.12/files/pic.jpg");
            InputStream is = u.openStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            File f = new File("/Users/elmonazareno/Desktop/pic.jpg");
            FileOutputStream fos = new FileOutputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int b = -1;
            while((b=bis.read())!=-1) {
                bos.write(b);
            }
            bos.flush();
            bos.close();
            fos.close();
            bis.close();
            is.close();
            System.out.println("foinizhed");
        } catch (Exception e) {
        }
    }
}
