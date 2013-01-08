package com.gbosystems.android.instr;

import java.io.IOException;

/**
 * 
 * Instrumented version of android.bluetooth.BluetoothSocket
 * @author Geoff O'Donnell
 *
 */

public class BluetoothSocket {
	
    /* DEBUG */
    private static final String TAG = "BluetoothSocket";
    private static final boolean D = false;
	
    /* Declare class constants */
    public static final int MODE_SIMULATE = 0;
    public static final int MODE_LOOPBACK = 1;
    public static final int MODE_FILE = 2;
	
    /* Declare class members */
    private BluetoothDevice mDevice;
    private boolean mConnected;
    private boolean mThrowIOException;
    private OutputStream mOutputStream;
    private InputStream mInputStream;
    private LoopbackStream mLoopbackStream;
	
    public BluetoothSocket(BluetoothDevice device, int mode){

        /* Initialize member variables */
        mDevice = device;
        mConnected = true;
        mThrowIOException = false;
        mLoopbackStream = new LoopbackStream();

        /* Construct new Input and Output Streams. */
        switch (mode){
        case MODE_SIMULATE:
            mOutputStream = new OutputStream(device.getName(), OutputStream.MODE_SIMULATE_DELAY);
            mInputStream = new InputStream(device.getName(), InputStream.MODE_BLOCK_FOREVER);
            break;
        case MODE_LOOPBACK:
            mOutputStream = new OutputStream(device.getName(), mLoopbackStream, OutputStream.MODE_LOOPBACK);
            mInputStream = new InputStream(device.getName(), mLoopbackStream, InputStream.MODE_LOOPBACK);
            break;
        case MODE_FILE:
            mOutputStream = new OutputStream(device.getName(), OutputStream.MODE_FILE);
            mInputStream = new InputStream(device.getName(), InputStream.MODE_FILE);
            break;
        }

    }
	
    public void close() throws IOException{
        if (mThrowIOException) { throw new IOException(); }
        mConnected = false;
    }

    public void connect() throws IOException{
        if (mThrowIOException) { throw new IOException(); }
        mConnected = true;
    }

    public BluetoothDevice getRemoteDevice(){
        return mDevice;
    }
	
    public InputStream getInputStream() throws IOException{
        if (mThrowIOException) { throw new IOException(); }
        return mInputStream;
    }

    public OutputStream getOutputStream() throws IOException{
        if (mThrowIOException) { throw new IOException(); }
        return mOutputStream;
    }

    public boolean isConnected(){
        return mConnected;
    }
	
}
