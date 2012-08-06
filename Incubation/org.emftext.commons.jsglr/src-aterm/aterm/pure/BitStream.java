/**
 * 
 */
package aterm.pure;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Reads bits from any InputStream. 
 * 
 * @author Karl Trygve Kalleberg &lt; karltk near strategoxt dot org &gt;
 *
 */
public class BitStream {

    private final InputStream stream;
    private int bitsInBuffer;
    private int bitBuffer;

    public BitStream(InputStream inputStream) {
        stream = inputStream;
        bitsInBuffer = 0;
        bitBuffer = 0;
    }

    public int readInt() throws IOException {
        int buf0 = readByte();
        
        // Check if 1st character is enough
        if((buf0 & 0x80) == 0)
            return buf0;

        int buf1  = readByte();
        
        // Check if 2nd character is enough
        if((buf0 & 0x40) == 0)
            return buf1 + ((buf0 & ~0xc0) << 8);

        int buf2 = readByte();

        // Check if 3rd character is enough
        if((buf0 & 0x20) == 0 )
            return buf2 + (buf1 << 8) + ((buf0 & ~0xe0) << 16);

        int buf3 = readByte();
        
        // Check if 4th character is enough
        if((buf0 & 0x10) == 0 )
            return buf3 + (buf2 << 8) + (buf1 << 16) +
              ((buf0 & ~0xf0) << 24);
        
        int buf4 = readByte();

        return buf4 + (buf3 << 8) + (buf2 << 16) + (buf1 << 24);
    }

    protected int readByte() throws IOException {
        int c = stream.read();
        if(c == -1)
            throw new EOFException();
        return c;
    }

    public String readString() throws IOException {
        int l = readInt();
        byte[] b = new byte[l];
        int v = 0;
        while(v < b.length) {
            v += stream.read(b, v, b.length - v);
        }
        return new String(b);
    }

    public int readBits(int nrBits) throws IOException {
        int mask = 1;
        int val = 0;
        
        for (int i=0; i<nrBits; i++) {
          if (bitsInBuffer == 0) {
            int v = readByte();
            if (v == -1)
              return -1;
            bitBuffer = v;
            bitsInBuffer = 8;
          }
          val |= (((bitBuffer & 0x80) != 0) ? mask : 0);
          mask <<= 1;
          bitBuffer <<= 1;
          bitsInBuffer--;
        }
        
        return val;
    }

    public void flushBitsFromReader() {
        bitsInBuffer = 0;
    }
}