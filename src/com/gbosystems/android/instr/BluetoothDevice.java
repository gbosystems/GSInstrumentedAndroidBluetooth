package com.gbosystems.android.instr;

import java.io.IOException;
import java.util.UUID;

/**
 * 
 * Instrumented version, containing only selected methods, of android.bluetooth.BluetoothDevice.
 * @author Geoff O'Donnell
 *
 */
public class BluetoothDevice {

    /* Declare class constants */
    public static final String ACTION_ACL_CONNECTED  = "android.bluetooth.device.action.ACL_CONNECTED";
    public static final String ACTION_ACL_DISCONNECTED  = "android.bluetooth.device.action.ACL_DISCONNECTED";
    public static final String ACTION_ACL_DISCONNECT_REQUESTED  = "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED";
    public static final String ACTION_BOND_STATE_CHANGED = "android.bluetooth.device.action.BOND_STATE_CHANGED" ;
    public static final String ACTION_CLASS_CHANGED  = "android.bluetooth.device.action.CLASS_CHANGED";
    public static final String ACTION_FOUND  = "android.bluetooth.device.action.FOUND";
    public static final String ACTION_NAME_CHANGED = "android.bluetooth.device.action.NAME_CHANGED";
    public static final String ACTION_UUID = "android.bluetooth.device.action.UUID";
    public static final int BOND_BONDED = 12;
    public static final int BOND_BONDING = 11;
    public static final int BOND_NONE = 10;
    public static final int ERROR = -2147483648;
    public static final String EXTRA_BOND_STATE = "android.bluetooth.device.extra.BOND_STATE";
    public static final String EXTRA_CLASS = "android.bluetooth.device.extra.CLASS";
    public static final String EXTRA_DEVICE = "android.bluetooth.device.extra.DEVICE";
    public static final String EXTRA_NAME = "android.bluetooth.device.extra.NAME";
    public static final String EXTRA_PREVIOUS_BOND_STATE = "android.bluetooth.device.extra.PREVIOUS_BOND_STATE";
    public static final String EXTRA_RSSI = "android.bluetooth.device.extra.RSSI";
    public static final String EXTRA_UUID = "android.bluetooth.device.extra.UUID";
	
    /* Declare class constants */
    public static final int MODE_SIMULATE = 0;
    public static final int MODE_LOOPBACK = 1;
    public static final int MODE_FILE = 2;
	
    /* Declare class members */
    private String mName;
    private String mAddress;
    private boolean mThrowIOException;
    private int mSocketMode;
	
    /**
     * Constructor. Instrumented version android.bluetooth.BluetoothDevice.
     */
    public BluetoothDevice(String name, String address, int socketMode){
        mName = name;
        mAddress = address;
        mThrowIOException = false;

        switch (socketMode){
        case MODE_SIMULATE:
            mSocketMode = BluetoothSocket.MODE_SIMULATE;
            break;
        case MODE_LOOPBACK:
            mSocketMode = BluetoothSocket.MODE_LOOPBACK;
            break;
        case MODE_FILE:
            mSocketMode = BluetoothSocket.MODE_FILE;
            break;
        }

        return;
    }
	
    public String getName(){
        return mName;
    }

    public String getAddress(){
        return mAddress;
    }

    public BluetoothSocket createInsecureRfcommSocketToServiceRecord(UUID uuid) throws IOException{
        if (mThrowIOException) { throw new IOException(); }
        return new BluetoothSocket(this, mSocketMode);
    }

    public BluetoothSocket createRfcommSocketToServiceRecord(UUID uuid) throws IOException{
        if (mThrowIOException) { throw new IOException(); }
        return new BluetoothSocket(this, mSocketMode);
    }
	
}
