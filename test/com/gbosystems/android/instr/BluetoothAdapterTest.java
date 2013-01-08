/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gbosystems.android.instr;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit test class for com.gbosystems.android.instr.BluetoothAdapter.
 * 
 * @author Geoff O'Donnell
 */
public class BluetoothAdapterTest {
    
    public BluetoothAdapterTest() {
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

    /**
     * Test of getBondedDevices method. Checks name of first bonded device.
     */
    @Test
    public void testFirstBondedDevice() {
        System.out.println("FirstBondedDevice");
        
        /* Get the adapter */
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        /* Get the device list */
        Set<BluetoothDevice> deviceSet = mBluetoothAdapter.getBondedDevices();
        
        /* Search for the first known device */
        for (BluetoothDevice d : deviceSet){
            if (d.getName().equals("DEVICE_NAME_ONE")){
                assert(d.getAddress().equals("00:11:22:33:44:55"));
            }
        }

    }

    /**
     * Test of getBondedDevices method. Checks name of second bonded device.
     */
    @Test
    public void testSecondBondedDevice() {
        System.out.println("SecondBondedDevice");
        
        /* Get the adapter */
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        /* Get the device list */
        Set<BluetoothDevice> deviceSet = mBluetoothAdapter.getBondedDevices();
        
        /* Search for the first known device */
        for (BluetoothDevice d : deviceSet){
            if (d.getName().equals("DEVICE_NAME_TWO")){
                assert(d.getAddress().equals("66:77:88:99:AA:BB"));
            }
        }

    }

    /**
     * Test of cancelDiscovery method.
     */
    @Test
    public void testCancelDiscovery(){
        System.out.println("CancelDiscovery");
        
        /* Get the adapter */
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        
        assert( mBluetoothAdapter.cancelDiscovery() == true );
    }
    
    /**
     * Test of isEnabled method.
     */
    @Test
    public void testIsEnabled(){
        System.out.println("IsEnabled");
        
        /* Get the adapter */
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        
        assert( mBluetoothAdapter.isEnabled() == true );
    }
    
    /**
     * Test of getAddress method.
     */
    @Test
    public void testGetAddress(){
        System.out.println("GetAddress");
        
        /* Get the adapter */
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        
        assert( mBluetoothAdapter.getAddress().equals("ff:ff:ff:ff:ff:ff") );
    }

    /**
     * Test of listenUsingRfcommWithServiceRecord method.
     */
    @Test
    public void testListenUsingRfcommWithServiceRecord(){
        try {
            System.out.println("ListenUsingRfcommWithServiceRecord");
            
            /* Get the adapter */
            BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            
            /* New server socket, inputs are null as they are not used in the implementation */
            BluetoothServerSocket tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(null, null);
            
            assert( tmp != null );
            
        } catch (IOException ex) {
            Logger.getLogger(BluetoothAdapterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Test of listenUsingInsecureRfcommWithServiceRecord method.
     */
    @Test
    public void testListenUsingInsecureRfcommWithServiceRecord(){
        try {
            System.out.println("ListenUsingInsecureRfcommWithServiceRecord");
            
            /* Get the adapter */
            BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            
            /* New server socket, inputs are null as they are not used in the implementation */
            BluetoothServerSocket tmp = mBluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(null, null);
            
            assert( tmp != null );
            
        } catch (IOException ex) {
            Logger.getLogger(BluetoothAdapterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
