package com.gbosystems.android.instr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import android.os.Environment;

/**
 * 
 * Instrumented version of java.io.InputStream, allows for simulated reads, reads from a file,
 *  and accepts a LoopbackStream object used to create a loopback with a
 * 	com.gbosystems.android.instrumented.OutputStream object.
 * @author Geoff O'Donnell
 *
 */
public class InputStream {

    /* DEBUG */
    private static final String TAG = "InputStream";
    private static final boolean D = false;
	
    /* Declare class constants */
    public static final int MODE_BLOCK_FOREVER = 0;
    public static final int MODE_LOOPBACK = 1;
    public static final int MODE_FILE = 2;
	
    /* Declare class members */
    public boolean mThrowIOException;
    public boolean mReadReturn;
    public int mReadDelay;
    private String mFilePath;
    private String mFileName;
    public int mAvailableBytes;
    private boolean mReadFromFileSystem;
    private boolean mReadFromLoopback;
    private boolean mMarkSupported;
    private LoopbackStream mLoopbackStream;
	
	public InputStream(String id, LoopbackStream stream, int mode){
		
            /* Initialize class members */
            mThrowIOException = false;
            mReadReturn = false;
            mReadDelay = 500;
            //mFilePath = Environment.getExternalStorageDirectory() + "/" + getClass().getPackage().getName();
            mFilePath = "/";
            mFileName = id + "_" + getClass().getName() + ".txt";
            mAvailableBytes = 64;
            mLoopbackStream = stream;
            mMarkSupported = false;
		
            switch (mode){
            case MODE_BLOCK_FOREVER:
                mReadFromFileSystem = false;
                mReadFromLoopback = false;
                break;
            case MODE_LOOPBACK:
                mReadFromFileSystem = false;
                mReadFromLoopback = true;
                break;
            case MODE_FILE:
                mReadFromFileSystem = true;
                mReadFromLoopback = false;
                break;
            }

            return;
	}
	
	public InputStream(String id, int mode){
            this(id, null, mode);
	}
	
	public int available() throws IOException{
            if (mThrowIOException) { throw new IOException(); }
            return mAvailableBytes;
	}
	
	public void close() throws IOException{
            if (mThrowIOException) { throw new IOException(); }
            return;
	}
	
	public void mark(int readlimit){
            return;
	}
	
	public boolean markSupported(){
            return mMarkSupported;
	}
	
	public int read(byte[] buffer, int offset, int length) throws IOException{
		
            /* Declare local variables */
            int bytes = 0;

            while(true){
                if (mReadReturn) { break; }
                if (mThrowIOException) { throw new IOException(); }
                if (mReadFromFileSystem){
                    /* Read the file from the file system */
                    File mFileIn = new File (mFilePath, mFileName);
                    FileInputStream mStreamIn = null;
                    mFileIn.createNewFile();
                    mStreamIn = new FileInputStream(mFileIn);
                    bytes = mStreamIn.read(buffer, offset, buffer.length);
                    mStreamIn.close();
                } else if (mReadFromLoopback){
                    /* Read the buffer from the shared LoopbackStream class */
                    bytes = mLoopbackStream.read(buffer, offset, length);
                    break;
                }
            }

            return bytes;
	}
	
	public int read(byte[] buffer) throws IOException{
            return read(buffer, 0, buffer.length);
	}
	
	public int read() throws IOException{
		
            /* Declare local variables */
            byte[] tmp = new byte[4];
            int returnInt = 0;
            int bytes = -1;

            /* Read a single byte from the buffer */
            bytes = read(tmp, 0, 1);

            /* Throw an error if we get back more than a single byte */
            if (bytes == 1){
                    returnInt = (int) tmp[0];
            } else { throw new IOException(); }

            /* Cast the byte to an int and return */
            return returnInt;
	}
	
	public synchronized void reset() throws IOException{
            if (mThrowIOException) { throw new IOException(); }
            return;
	}
	
	public long skip(long byteCount) throws IOException{
            if (mThrowIOException) { throw new IOException(); }
            return 0;
	}
	
}
