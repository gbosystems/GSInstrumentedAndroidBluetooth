/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gbosystems.android.instr;

import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Geoff O'Donnell
 */
public class BluetoothDeviceTest {
    
    public BluetoothDeviceTest() {
    }

    /**
     * Test of createInsecureRfcommSocketToServiceRecord method, of class BluetoothDevice.
     */
    @Test
    public void testCreateInsecureRfcommSocketToServiceRecord() throws Exception {
        System.out.println("CreateInsecureRfcommSocketToServiceRecord");
        
        /* Get the adapter */
        BluetoothDevice mBluetoothDevice = new BluetoothDevice("NAME", "ADDRESS", BluetoothDevice.MODE_SIMULATE);
        
        /* New socket, input is null as they are not used in the implementation */
        BluetoothSocket tmp = mBluetoothDevice.createInsecureRfcommSocketToServiceRecord(null);
        
        assert( tmp != null ); 
    }

    /**
     * Test of createRfcommSocketToServiceRecord method, of class BluetoothDevice.
     */
    @Test
    public void testCreateRfcommSocketToServiceRecord() throws Exception {
        System.out.println("CreateRfcommSocketToServiceRecord");
        
        /* Get the adapter */
        BluetoothDevice mBluetoothDevice = new BluetoothDevice("NAME", "ADDRESS", BluetoothDevice.MODE_SIMULATE);
        
        /* New socket, input is null as they are not used in the implementation */
        BluetoothSocket tmp = mBluetoothDevice.createRfcommSocketToServiceRecord(null);
        
        assert( tmp != null ); 
    }
}
