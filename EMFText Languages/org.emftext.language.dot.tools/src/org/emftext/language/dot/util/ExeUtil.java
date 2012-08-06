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
package org.emftext.language.dot.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * A utility class that can be used to launch processes and capture their
 * output.
 */
public class ExeUtil {

	private static final String WINDOWS_CMD_ENCODING = "Cp850"; //$NON-NLS-1$

	private static class StreamReader implements Runnable {
		private final InputStream stream;

		private StringBuffer input = new StringBuffer();

		private String encoding;

		public StreamReader(InputStream stream, String encoding) {
			this.stream = stream;
			this.encoding = encoding;
		}

		public void run() {
			LineNumberReader reader;
			try {
				reader = new LineNumberReader(new InputStreamReader(stream,
						encoding));
				String line;
				while ((line = reader.readLine()) != null) {
					input.append(line);
					input.append(System.getProperty("line.separator")); //$NON-NLS-1$
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public StringBuffer getInput() {
			return input;
		}
	}

	public static void runExe(List<String> arguments, RunCallback callback,
			boolean waitFor) {
		runExe(arguments, callback, new File("."), waitFor); //$NON-NLS-1$
	}

	public static void runExe(List<String> arguments, RunCallback callback,
			File workingDirectory, boolean waitFor) {
		ProcessBuilder processBuilder = new ProcessBuilder(arguments);
		processBuilder.directory(workingDirectory);
		StreamReader inputReader = null;
		StreamReader errorReader = null;
		int result = -1;
		try {
			final Process process = processBuilder.start();
			inputReader = new StreamReader(process.getInputStream(),
					WINDOWS_CMD_ENCODING);
			errorReader = new StreamReader(process.getErrorStream(),
					WINDOWS_CMD_ENCODING);
			new Thread(inputReader).start();
			new Thread(errorReader).start();

			if (waitFor) {
				result = process.waitFor();
			}
		} catch (InterruptedException e) {
			callback.interrupted(e);
		} catch (IOException e) {
			callback.ioError(e);
		}
		if (inputReader != null && errorReader != null) {
			callback.result(new Pair<String, String>(inputReader.getInput()
					.toString(), errorReader.getInput().toString()));
			callback.exit(result);
		}
	}
}
