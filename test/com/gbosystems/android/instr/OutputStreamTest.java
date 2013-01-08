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
public class OutputStreamTest {
    
    public OutputStreamTest() {
    }

    /**
     * Test of close method, of class OutputStream.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        OutputStream instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flush method, of class OutputStream.
     */
    @Test
    public void testFlush() throws Exception {
        System.out.println("flush");
        OutputStream instance = null;
        instance.flush();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class OutputStream.
     */
    @Test
    public void testWrite_3args() throws Exception {
        System.out.println("write");
        byte[] buffer = null;
        int offset = 0;
        int count = 0;
        OutputStream instance = null;
        instance.write(buffer, offset, count);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class OutputStream.
     */
    @Test
    public void testWrite_byteArr() throws Exception {
        System.out.println("write");
        byte[] buffer = null;
        OutputStream instance = null;
        instance.write(buffer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class OutputStream.
     */
    @Test
    public void testWrite_int() throws Exception {
        System.out.println("write");
        int oneByte = 0;
        OutputStream instance = null;
        instance.write(oneByte);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
