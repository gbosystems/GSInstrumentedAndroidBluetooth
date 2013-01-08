package com.gbosystems.android.instr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Stream class containing a byte buffer that can be written to and read from.
 * 
 * @author Geoff O'Donnell
 */
public class LoopbackStream {

    /* DEBUG */
    private static final String TAG = "LoopbackStream";
    private static final boolean D = false;
	
    /* Declare class members */
    private ByteArrayOutputStream mByteArrayOutputStream;

    public LoopbackStream(){

        /* Initialize class members */
        mByteArrayOutputStream = new ByteArrayOutputStream();
        return;
    }
	
    public synchronized void write(byte[] buffer, int offset, int count) throws IndexOutOfBoundsException{		
        mByteArrayOutputStream.write(buffer, offset, count);
        return;
    }

    public synchronized byte[] toByteArray(){
        return mByteArrayOutputStream.toByteArray();
    }
	
    public int read(byte[] buffer, int offset, int length) throws IOException{

        /* Declare local variables */
        int bytes = 0;

        /* Wait for bytes to be returned from syncedRead */
        while (true){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if( (bytes = syncedRead(buffer, offset, length)) > 0 ){
                break;
            }
        }

        /* Return number of bytes read */
        return bytes;
    }
	
    private synchronized int syncedRead(byte[] buffer, int offset, int length) throws IOException{

        /* Declare local variables */
        byte[] tmp = mByteArrayOutputStream.toByteArray();
        int bytes = -1;

        /* Determine length of output buffer */
        if (tmp.length == 0){
            bytes = -1; // Nothing in buffer
        }
        else if (tmp.length > length){
            bytes = length; // more in buffer than requested
        } else {
            bytes = tmp.length; // less in buffer than requested
        }

        /* If there's something to read, read it and remove it from the OutputStream */
        if (bytes > 0){

            /* Write to buffer ByteArrayOutputStream */
            for (int i = 0; i < bytes; i++){
                buffer[i] = tmp[i];
            }

            /* Save remainder in OutputStream */
            mByteArrayOutputStream.reset();
            if ((tmp.length - length) > 0){
                mByteArrayOutputStream.write(tmp, length, (tmp.length - length));
            }
        }

        /* Return number of bytes read */
        return bytes;
    }
}
