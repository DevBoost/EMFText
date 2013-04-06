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

package org.emftext.sdk.concretesyntax.resource.cs.util;


public class CsStreamUtil {
	
	private final static int IO_BUFFER_SIZE = 4 * 1024;
	
	public static void copy(java.io.InputStream in, java.io.OutputStream out) throws java.io.IOException {
		byte[] b = new byte[IO_BUFFER_SIZE];
		int read;
		while ((read = in.read(b)) != -1) {
			out.write(b, 0, read);
		}
		out.flush();
	}
	
	public static String getContent(java.io.InputStream inputStream) throws java.io.IOException {
		java.io.InputStreamReader reader = new java.io.InputStreamReader(inputStream);
		return getContent(reader);
	}
	
	public static String getContent(java.io.InputStream inputStream, String charset) throws java.io.IOException {
		java.io.InputStreamReader reader = new java.io.InputStreamReader(inputStream, charset);
		return getContent(reader);
	}
	
	public static String getContent(java.io.InputStreamReader reader) throws java.io.IOException {
		StringBuffer content = new StringBuffer();
		int next = -1;
		while ((next = reader.read()) >= 0) {
			content.append((char) next);
		}
		return content.toString();
	}
	
}
