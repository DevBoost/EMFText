package aterm.pure;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


/**
 * Reads bits from a FileInputStream using memory mapping. At least 2x 
 * faster than BitStream.
 * 
 * @author karltk
 *
 */
public class MemoryMappedBitStream extends BitStream {

	private FileChannel channel; 
	private MappedByteBuffer byteBuffer;
	private int offset;
	
	public MemoryMappedBitStream(FileInputStream inputStream) throws IOException {
		super(inputStream);
		this.channel = inputStream.getChannel();
		byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
		offset = 0;
	}
	
    protected int readByte() throws IOException {
    	return byteBuffer.get() & 0xFF; 
    }
    
    public String readString() throws IOException {
        final int l = readInt();
        byte[] b = new byte[l];
        //byteBuffer.position(offset);
        byteBuffer.get(b);
        offset += l;
        return new String(b);
    }
}
