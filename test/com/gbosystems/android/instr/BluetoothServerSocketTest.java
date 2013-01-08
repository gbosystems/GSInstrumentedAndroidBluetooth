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
public class BluetoothServerSocketTest {
    
    public BluetoothServerSocketTest() {
    }

    /**
     * Test of accept method, of class BluetoothServerSocket.
     */
    @Test
    public void testAccept_0args() throws Exception {
        System.out.println("accept");
        BluetoothServerSocket instance = null;
        BluetoothSocket expResult = null;
        BluetoothSocket result = instance.accept();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accept method, of class BluetoothServerSocket.
     */
    @Test
    public void testAccept_int() throws Exception {
        System.out.println("accept");
        int timeout = 0;
        BluetoothServerSocket instance = null;
        BluetoothSocket expResult = null;
        BluetoothSocket result = instance.accept(timeout);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class BluetoothServerSocket.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        BluetoothServerSocket instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
