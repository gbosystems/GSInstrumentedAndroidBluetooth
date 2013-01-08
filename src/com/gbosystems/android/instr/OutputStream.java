package com.gbosystems.android.instr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//import android.os.Environment;

/**
 * 
 * Instrumented version of java.io.OutputStream, allows for simulated writes,
 * writes to a file, and accepts a LoopbackStream object used to create a
 * loopback with a com.gbosystems.android.instrumented.InputStream object.
 * 
 * @author Geoff O'Donnell
 */
public class OutputStream {

    /* DEBUG */
    private static final String TAG = "OutputStream";
    private static final boolean D = false;
    
    /* Declare class constants */
    public static final int MODE_SIMULATE_DELAY = 0;
    public static final int MODE_LOOPBACK = 1;
    public static final int MODE_FILE = 2;
	
    /* Declare class members */
    private boolean mThrowIOException;
    private boolean mThrowIndexOutOfBoundsException;
    private boolean mWriteToFileSystem;
    private boolean mWriteToLoopback;
    private int mWriteDelay;
    private String mFilePath;
    private String mFileName;
    private LoopbackStream mLoopbackStream;
	
    public OutputStream(String id, LoopbackStream stream, int mode){
		
        /* Initialize member variables */
        mLoopbackStream = stream;
        mThrowIOException = false;
        mThrowIndexOutOfBoundsException = false;
        mWriteDelay = 1000;
        //mFilePath = Environment.getExternalStorageDirectory() + "/" + getClass().getPackage().getName();
        mFilePath = "/";
        mFileName = id + "_" + getClass().getName() + ".txt";

        switch (mode){
        case MODE_SIMULATE_DELAY:
            mWriteToFileSystem = false;
            mWriteToLoopback = false;
            break;
        case MODE_LOOPBACK:
            mWriteToFileSystem = false;
            mWriteToLoopback = true;
            break;
        case MODE_FILE:
            mWriteToFileSystem = true;
            mWriteToLoopback = false;
            break;
        }
		
        /* Ensure the file write directory exists */
        File d = new File(mFilePath);
        boolean writeDirectoryExists = false;
        if(!d.exists()) {
            writeDirectoryExists = d.mkdir();
        } else {writeDirectoryExists = true;}
        
        if ( writeDirectoryExists ){
            if (D) { System.out.println(TAG + ": Write Directory Exists"); }
        } else{
            if (D) { System.out.println(TAG + ": Write Directory DOES NOT Exist"); }
        }

        return;
    }
	
    public OutputStream(String id, int mode){
        this(id, null, mode);
        return;
    }
	
    public void close() throws IOException{
        if (mThrowIOException) { throw new IOException(); }
        return;
    }

    public void flush() throws IOException{
        if (mThrowIOException) { throw new IOException(); }
        return;
    }
	
    public void write(byte[] buffer, int offset, int count) throws IOException, IndexOutOfBoundsException{

        if (mThrowIOException) { throw new IOException(); }
        if (mThrowIndexOutOfBoundsException) { throw new IndexOutOfBoundsException(); }
        if (mWriteToFileSystem) {
            /* Write the file to the filesystem */
            File mFileOut = new File (mFilePath, mFileName);
            FileOutputStream mStreamOut = null;
            mFileOut.createNewFile();
            mStreamOut = new FileOutputStream(mFileOut, true); //Append to file
            mStreamOut.write(buffer, offset, buffer.length);
            mStreamOut.close();
        } else if (mWriteToLoopback){
            mLoopbackStream.write(buffer, offset, buffer.length);
        } else {
            /* Since the real function has some non-zero delay which blocks the execution, simulate that here. */
            try {
                    Thread.sleep(mWriteDelay);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }

        return;
    }

    public void write(byte[] buffer) throws IOException{
        write(buffer, 0, buffer.length);
        return;
    }

    public void write(int oneByte) throws IOException{
        write(new byte[]{(byte) oneByte});
        return;
    }
}
