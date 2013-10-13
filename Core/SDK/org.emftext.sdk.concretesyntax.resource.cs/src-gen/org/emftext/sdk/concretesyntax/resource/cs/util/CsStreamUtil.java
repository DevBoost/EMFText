/*******************************************************************************
 * Copyright (c) 2006-2013
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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class CsStreamUtil {
	
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
