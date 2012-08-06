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
package org.emftext.language.dot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.emftext.language.dot.util.ExeUtil;
import org.emftext.language.dot.util.Pair;

public class DotRunner {

	private static final String dotExecutable = getDOTExecutable();
	
	public String runDOT(List<String> argumentList, String dotModel) {
		try {
			File tempFile = File.createTempFile(this.getClass().getName(), "");
			FileWriter fileWriter = new FileWriter(tempFile);
			fileWriter.append(dotModel);
			fileWriter.close();
			
			List<String> fullArgumentList = new ArrayList<String>();
			fullArgumentList.addAll(argumentList);
			fullArgumentList.add(tempFile.getAbsolutePath());
			return runDOT(".", fullArgumentList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String convertDotToPDF(String outputFile, String workingDir) {
		return runDOT(workingDir, Arrays.asList(new String[] {"-Tpdf", "-O", outputFile}));
	}

	public String runDOT(String workingDir, List<String> argumentList) {
		List<String> arguments = new ArrayList<String>();
		arguments.add(dotExecutable);
		arguments.addAll(argumentList);

		RunCallback callback = new RunCallback();
		ExeUtil.runExe(arguments, callback, new File(workingDir), true);

		if (callback.getExit() != 0) {
			return callback.getStderr();
		}

		return callback.getStdout();
	}

	private static String getDOTExecutable() {
		String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH); //$NON-NLS-1$
		if (os.startsWith("windows")) { //$NON-NLS-1$
			return "dot.exe"; //$NON-NLS-1$
		}
		return "dot"; //$NON-NLS-1$
	}

	public boolean testDOT() {
		List<String> arguments = new ArrayList<String>();

		arguments.add(dotExecutable);
		arguments.add("-V");//$NON-NLS-1$

		RunCallback callback = new RunCallback();
		ExeUtil.runExe(arguments, callback, true);

		return !callback.isError();
	}

	private class RunCallback implements
			org.emftext.language.dot.util.RunCallback {

		private int exit;
		private boolean error = false;

		private String stderr;
		private String stdout;

		public void exit(int exitCode) {
			exit = exitCode;
		}

		public void interrupted(InterruptedException ie) {
			error = true;
		}

		public void ioError(IOException ioe) {
			error = true;
		}

		public void result(Pair<String, String> pair) {
			stdout = pair.getLeft();
			stderr = pair.getRight();
		}

		public int getExit() {
			return exit;
		}

		public boolean isError() {
			return error;
		}

		public String getStderr() {
			return stderr;
		}

		public String getStdout() {
			return stdout;
		}
	}
}
