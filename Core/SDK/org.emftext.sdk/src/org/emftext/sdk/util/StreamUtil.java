/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * A collection of methods to work with streams and files.
 */
public class StreamUtil {
	
	private final static int IO_BUFFER_SIZE = 4 * 1024;
	   
	/**
	 * Copies the content of the input stream to the output stream.
	 * 
	 * @param input the stream to read from
	 * @param output the stream to write to
	 * 
	 * @throws IOException if reading or writing one of the streams fails
	 */
	public static void copy(InputStream input, OutputStream output) throws IOException {
		byte[] b = new byte[IO_BUFFER_SIZE];
		int read;
		while ((read = input.read(b)) != -1) {
			output.write(b, 0, read);
		}
		output.flush();
	}

	/**
	 * Returns the content of the file as string.
	 * 
	 * @param file the file to read from
	 * 
	 * @return the file's content as string
	 * 
	 * @throws IOException if reading the file fails
	 */
	public static String getContentAsString(File file) throws IOException {
		return getContentAsString(new FileInputStream(file));
	}
	
	/**
	 * Returns the content of the stream as string.
	 * 
	 * @param inputStream the stream to read from
	 * 
	 * @return the stream's content as string
	 * 
	 * @throws IOException if reading the stream fails
	 */
	public static String getContentAsString(InputStream inputStream) throws IOException {
		StringBuffer content = new StringBuffer();
		InputStreamReader reader = new InputStreamReader(inputStream);
		int next = -1;
		while ((next = reader.read()) >= 0) {
			content.append((char) next);
		}
		reader.close();
		return content.toString();
	}

	/**
	 * Stores the content of the input stream to the target file if the
	 * content has changed. If the file contains exactly the bytes found
	 * in the input stream, the file is not touched.
	 * 
	 * @param target the file to write to
	 * @param input the stream to read the new content from
	 * 
	 * @return true if the file was changed, otherwise false
	 * 
	 * @throws IOException if reading input or writing the target file fails
	 */
	public static boolean storeContentIfChanged(File target, InputStream input) throws IOException {
		target.getParentFile().mkdirs();
		long currentSize = target.length();
		if (!target.exists()) {
			currentSize = -1;
		}
		
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		StreamUtil.copy(input, buffer);
		buffer.close();
		long newSize = buffer.size();
		byte[] newContent = buffer.toByteArray();
		
		if (newSize != currentSize) {
			setContent(target, newContent);
			return true;
		} else {
			// size is equal, check content
			byte[] currentContent = getContent(target);
			boolean contentIsEqual = Arrays.equals(currentContent, newContent);
			if (contentIsEqual) {
				// do nothing - the new content is the same as the old one
				return false;
			} else {
				setContent(target, newContent);
				return true;
			}
		}
	}

	/**
	 * Returns the content of the file as array of bytes.
	 * 
	 * @param file the file to read
	 * 
	 * @return the file's contents as array of bytes
	 *  
	 * @throws IOException if reading the file fails
	 */
	public static byte[] getContent(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		StreamUtil.copy(in, buffer);
		in.close();
		buffer.close();
		return buffer.toByteArray();
	}

	/**
	 * Stores the given content to the target file.
	 * 
	 * @param target the file to write to
	 * @param content the content to store in the file
	 * 
	 * @throws IOException if writing the file fails
	 */
	public static void setContent(File target, byte[] content) throws IOException {
		FileOutputStream fos = new FileOutputStream(target);
		fos.write(content);
		fos.close();
	}
}
