package com.gbosystems.android.instr;

import java.io.IOException;

/**
 * 
 * Instrumented version of android.bluetooth.BluetoothServerSocket
 * @author Geoff O'Donnell
 *
 */
public class BluetoothServerSocket {
	
    /* Declare class constants */
    public static final int MODE_SIMULATE = 0;
    public static final int MODE_LOOPBACK = 1;
    public static final int MODE_FILE = 2;
	
    /* Declare class members */
    public BluetoothDevice mDevice;
    private boolean mThrowIOException;
    private int mSocketMode;
	
    public BluetoothServerSocket(BluetoothDevice device, int mode){

        /* Initialize member variables */
        mDevice = device;
        mThrowIOException = false;

        switch (mode){
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

    }
	
    public BluetoothSocket accept() throws IOException{
        
        if (mThrowIOException) { throw new IOException(); }

        while(true){
            if (mDevice != null) { break; }
        }

        return new BluetoothSocket(mDevice, mSocketMode);
    }
	
    public BluetoothSocket accept(int timeout) throws IOException{
        return accept();
    }

    public void close() throws IOException{
        if (mThrowIOException) { throw new IOException(); }
    }
}
