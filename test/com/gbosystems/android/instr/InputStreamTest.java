/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gbosystems.android.instr;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Geoff O'Donnell
 */
public class InputStreamTest {
    
    public InputStreamTest() {
    }

    /**
     * Test of available method, of class InputStream.
     */
    @Test
    public void testAvailable() throws Exception {
        System.out.println("available");
        InputStream instance = null;
        int expResult = 0;
        int result = instance.available();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class InputStream.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        InputStream instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mark method, of class InputStream.
     */
    @Test
    public void testMark() {
        System.out.println("mark");
        int readlimit = 0;
        InputStream instance = null;
        instance.mark(readlimit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of markSupported method, of class InputStream.
     */
    @Test
    public void testMarkSupported() {
        System.out.println("markSupported");
        InputStream instance = null;
        boolean expResult = false;
        boolean result = instance.markSupported();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class InputStream.
     */
    @Test
    public void testRead_3args() throws Exception {
        System.out.println("read");
        byte[] buffer = null;
        int offset = 0;
        int length = 0;
        InputStream instance = null;
        int expResult = 0;
        int result = instance.read(buffer, offset, length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class InputStream.
     */
    @Test
    public void testRead_byteArr() throws Exception {
        System.out.println("read");
        byte[] buffer = null;
        InputStream instance = null;
        int expResult = 0;
        int result = instance.read(buffer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class InputStream.
     */
    @Test
    public void testRead_0args() throws Exception {
        System.out.println("read");
        InputStream instance = null;
        int expResult = 0;
        int result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class InputStream.
     */
    @Test
    public void testReset() throws Exception {
        System.out.println("reset");
        InputStream instance = null;
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of skip method, of class InputStream.
     */
    @Test
    public void testSkip() throws Exception {
        System.out.println("skip");
        long byteCount = 0L;
        InputStream instance = null;
        long expResult = 0L;
        long result = instance.skip(byteCount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
