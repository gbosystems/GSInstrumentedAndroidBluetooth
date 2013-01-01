package com.gbosystems.android.instr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Instrumented version, containing only selected methods, of android.bluetooth.BluetoothAdapter.
 * Devices and local adapter address are hard coded in this file.
 * @author Geoff O'Donnell
 */
public class BluetoothAdapter {

	/* Declare class constants */
	public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";
	public static final String ACTION_DISCOVERY_FINISHED = "android.bluetooth.adapter.action.DISCOVERY_FINISHED";
	public static final String ACTION_DISCOVERY_STARTED = "android.bluetooth.adapter.action.DISCOVERY_STARTED";
	public static final String ACTION_LOCAL_NAME_CHANGED = "android.bluetooth.adapter.action.LOCAL_NAME_CHANGED";
	public static final String ACTION_REQUEST_DISCOVERABLE = "android.bluetooth.adapter.action.REQUEST_DISCOVERABLE";	
	public static final String ACTION_REQUEST_ENABLE = "android.bluetooth.adapter.action.REQUEST_ENABLE";
	public static final String ACTION_SCAN_MODE_CHANGED = "android.bluetooth.adapter.action.SCAN_MODE_CHANGED";
	public static final String ACTION_STATE_CHANGED = "android.bluetooth.adapter.action.STATE_CHANGED";
	public static final int ERROR = -2147483648;
	public static final String EXTRA_CONNECTION_STATE = "android.bluetooth.adapter.extra.CONNECTION_STATE";
	public static final String EXTRA_DISCOVERABLE_DURATION = "android.bluetooth.adapter.extra.DISCOVERABLE_DURATION";
	public static final String EXTRA_LOCAL_NAME = "android.bluetooth.adapter.extra.LOCAL_NAME";
	public static final String EXTRA_PREVIOUS_CONNECTION_STATE = "android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE";
	public static final String EXTRA_PREVIOUS_SCAN_MODE = "android.bluetooth.adapter.extra.PREVIOUS_SCAN_MODE";
	public static final String EXTRA_PREVIOUS_STATE = "android.bluetooth.adapter.extra.PREVIOUS_STATE";
	public static final String EXTRA_SCAN_MODE = "android.bluetooth.adapter.extra.SCAN_MODE";
	public static final String EXTRA_STATE = "android.bluetooth.adapter.extra.STATE";
	public static final int SCAN_MODE_CONNECTABLE = 21;
	public static final int SCAN_MODE_CONNECTABLE_DISCOVERABLE = 23;
	public static final int SCAN_MODE_NONE = 20;
	public static final int STATE_CONNECTED = 2;
	public static final int STATE_CONNECTING = 1;
	public static final int STATE_DISCONNECTED = 0;
	public static final int STATE_DISCONNECTING = 3;
	public static final int STATE_OFF = 10;
	public static final int STATE_ON = 12;
	public static final int STATE_TURNING_OFF = 13;
	public static final int STATE_TURNING_ON = 11;

	/* Instrumentation constants */
	private static String ADAPTER_ADDRESS = "ff:ff:ff:ff:ff:ff";
    public static final int MODE_SIMULATE = 0; // Simulate reads and writes
    public static final int MODE_LOOPBACK = 1; // Everything written to the sockets OutputStream can be read on the InputStream
    public static final int MODE_FILE = 2;     // Send OutputStream writes on a file on the External Storage directory, read from file
    										   // in same directory.
    
	/* Member variables */
	private int mState;
	private ArrayList<BluetoothDevice> mDevices;
	private int deviceCount;
	private int nextDeviceToConnect;
	private boolean mThrowIOException;
	private boolean mSecure;
	private int mSocketMode;
	private int mDeviceSocketMode;
	private int mServerSocketMode;

	private BluetoothAdapter(){
		
		/* Initialize member variables */
		mState = STATE_ON;
		mThrowIOException = false;
		mSecure = true;
		mDevices = new ArrayList<BluetoothDevice>();
		nextDeviceToConnect = 0;
		mSocketMode = MODE_SIMULATE;
		
		/* Set modes for creating connections using a BluetoothDevice or BluetoothServerSocket */
		switch (mSocketMode){
		case MODE_SIMULATE:
			mDeviceSocketMode = BluetoothSocket.MODE_SIMULATE;
			mServerSocketMode = BluetoothServerSocket.MODE_SIMULATE;
			break;
		case MODE_LOOPBACK:
			mDeviceSocketMode = BluetoothSocket.MODE_LOOPBACK;
			mServerSocketMode = BluetoothServerSocket.MODE_LOOPBACK;
			break;
		case MODE_FILE:
			mDeviceSocketMode = BluetoothSocket.MODE_FILE;
			mServerSocketMode = BluetoothServerSocket.MODE_FILE;
			break;
		}
		
		/* Populate device array */
		mDevices.add(new BluetoothDevice("DEVICE_NAME_ONE", "00:11:22:33:44:55", mDeviceSocketMode));
		mDevices.add(new BluetoothDevice("DEVICE_NAME_TWO", "66:77:88:99:AA:BB", mDeviceSocketMode));
		//mDevices.add(new BluetoothDevice("DEVICE_NAME_THREE", "01:23:45:67:89:AB", mDeviceSocketMode));
		
		deviceCount = mDevices.size();
		
		return;
	}
	
	/**
	 * Get a handle to the instrumented Bluetooth adapter.
	 * @return new BluetoothAdapter
	 */
	public static BluetoothAdapter getDefaultAdapter(){
		return new BluetoothAdapter();
	}
	
	public boolean cancelDiscovery(){
		if (mState != STATE_ON) return false;
		else return true;
	}
	
	public boolean isEnabled(){
		return true;
	}
	
	public String getAddress(){
		return ADAPTER_ADDRESS;
	}
	
	public Set<BluetoothDevice> getBondedDevices(){
		
		/* Declare local variables */
		Set<BluetoothDevice> tmp = new HashSet<BluetoothDevice>();
		
		/* Add devices to set */
		for(int i = 0; i < mDevices.size(); i++){
			tmp.add( mDevices.get(i) );
		}
		
		/* Return set of BluetoothDevice's */
		return tmp;
	}
	
	public BluetoothServerSocket listenUsingRfcommWithServiceRecord(String name, UUID uuid) throws IOException{
		if (mThrowIOException) throw new IOException();
		
		/* Declare local variables */
		BluetoothServerSocket tmp;
		
		/* If secure mode, get the next device to connect */
		if (mSecure) tmp = getNextDevice();
		else tmp = new BluetoothServerSocket(null, mServerSocketMode);
		
		return tmp;
	}
	
	public BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(String name, UUID uuid) throws IOException{
		if (mThrowIOException) throw new IOException();
		
		/* Declare local variables */
		BluetoothServerSocket tmp;
		
		/* If insecure mode, get the next device to connect */
		if (!mSecure) tmp = getNextDevice();
		else tmp = new BluetoothServerSocket(null, mServerSocketMode);
		
		return tmp;
	}
	
	private BluetoothServerSocket getNextDevice(){
		
		/* Declare local variables */
		BluetoothServerSocket tmp;
		
		if (nextDeviceToConnect < deviceCount){
			tmp = new BluetoothServerSocket(mDevices.get(nextDeviceToConnect), mServerSocketMode);
			nextDeviceToConnect++;
		}
		else{
			tmp = new BluetoothServerSocket(null, mServerSocketMode);
		}
		
		/* Return BluetoothServerSocket with next 'connected' BluetoothDevice (or null if they've all been returned) */
		return tmp;
	}
	
}
