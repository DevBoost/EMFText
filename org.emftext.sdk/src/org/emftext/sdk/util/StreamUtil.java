/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
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

public class StreamUtil {
	
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
		StringBuffer content = new StringBuffer();
		InputStreamReader reader = new InputStreamReader(inputStream);
		int next = -1;
		while ((next = reader.read()) >= 0) {
			content.append((char) next);
		}
		return content.toString();
	}

	public static boolean setContentIfChanged(File target, InputStream in) throws IOException {
		target.getParentFile().mkdirs();
		long currentSize = target.length();
		if (!target.exists()) {
			currentSize = -1;
		}
		
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		StreamUtil.copy(in, buffer);
		buffer.close();
		long newSize = buffer.size();
		byte[] newContent = buffer.toByteArray();
		
		if (newSize != currentSize) {
			writeBuffer(target, newContent);
			return true;
		} else {
			// size is equal, check content
			byte[] currentContent = getContent(target);
			boolean contentIsEqual = Arrays.equals(currentContent, newContent);
			if (contentIsEqual) {
				// do nothing - the new content is the same as the old one
				return false;
			} else {
				writeBuffer(target, newContent);
				return true;
			}
		}
	}

	public static byte[] getContent(File target) throws IOException {
		FileInputStream in = new FileInputStream(target);
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		StreamUtil.copy(in, buffer);
		in.close();
		buffer.close();
		return buffer.toByteArray();
	}

	public static void writeBuffer(File target, byte[] buffer) throws IOException {
		FileOutputStream fos = new FileOutputStream(target);
		fos.write(buffer);
		fos.close();
	}
}
