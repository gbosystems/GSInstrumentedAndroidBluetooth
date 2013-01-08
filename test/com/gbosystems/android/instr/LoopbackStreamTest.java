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
public class LoopbackStreamTest {
    
    public LoopbackStreamTest() {
    }

    /**
     * Test of write method, of class LoopbackStream.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        byte[] buffer = null;
        int offset = 0;
        int count = 0;
        LoopbackStream instance = new LoopbackStream();
        instance.write(buffer, offset, count);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toByteArray method, of class LoopbackStream.
     */
    @Test
    public void testToByteArray() {
        System.out.println("toByteArray");
        LoopbackStream instance = new LoopbackStream();
        byte[] expResult = null;
        byte[] result = instance.toByteArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class LoopbackStream.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        byte[] buffer = null;
        int offset = 0;
        int length = 0;
        LoopbackStream instance = new LoopbackStream();
        int expResult = 0;
        int result = instance.read(buffer, offset, length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
