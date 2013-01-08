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
public class BluetoothSocketTest {
    
    public BluetoothSocketTest() {
    }

    /**
     * Test of close method, of class BluetoothSocket.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        BluetoothSocket instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connect method, of class BluetoothSocket.
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        BluetoothSocket instance = null;
        instance.connect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRemoteDevice method, of class BluetoothSocket.
     */
    @Test
    public void testGetRemoteDevice() {
        System.out.println("getRemoteDevice");
        BluetoothSocket instance = null;
        BluetoothDevice expResult = null;
        BluetoothDevice result = instance.getRemoteDevice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInputStream method, of class BluetoothSocket.
     */
    @Test
    public void testGetInputStream() throws Exception {
        System.out.println("getInputStream");
        BluetoothSocket instance = null;
        InputStream expResult = null;
        InputStream result = instance.getInputStream();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutputStream method, of class BluetoothSocket.
     */
    @Test
    public void testGetOutputStream() throws Exception {
        System.out.println("getOutputStream");
        BluetoothSocket instance = null;
        OutputStream expResult = null;
        OutputStream result = instance.getOutputStream();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isConnected method, of class BluetoothSocket.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        BluetoothSocket instance = null;
        boolean expResult = false;
        boolean result = instance.isConnected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
