/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class Cct5StreamUtil {
	
	private final static int IO_BUFFER_SIZE = 4 * 1024;
	
	public static void copy(InputStream in, OutputStream out) throws IOException {
		byte[] b = new byte[IO_BUFFER_SIZE];
		int read;
		while ((read = in.read(b)) != -1) {
			out.write(b, 0, read);
		}
		out.flush();
	}
	
	public static String getContent(InputStream inputStream) throws IOException {
		InputStreamReader reader = new InputStreamReader(inputStream);
		return getContent(reader);
	}
	
	public static String getContent(InputStream inputStream, String charset) throws IOException {
		InputStreamReader reader = new InputStreamReader(inputStream, charset);
		return getContent(reader);
	}
	
	public static String getContent(InputStreamReader reader) throws IOException {
		StringBuffer content = new StringBuffer();
		int next = -1;
		while ((next = reader.read()) >= 0) {
			content.append((char) next);
		}
		return content.toString();
	}
	
}
