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
package org.emftext.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.emftext.sdk.util.StreamUtil;

// TODO mseifert: search for other test cases that can benefit from using the index
public class WorkspaceIndexer {
	
	public static final String INDEX_PATH = 
			".." + File.separator + "org.emftext.test" + File.separator +
			"workspace-index" + File.separator + "workspaceindex.txt";
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	private void createIndex() {
		List<File> files = getFiles();
		StringBuilder text = new StringBuilder();
		for (File file : files) {
			text.append(file.getPath());
			text.append(LINE_SEPARATOR);
		}
		try {
			File targetFile = getIndexFile();

			StreamUtil.setContent(targetFile, text.toString().getBytes());
			System.out.println("Workspace index successfully created.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Can't create workspace index: "
					+ e.getMessage());
		}
	}

	private File getIndexFile() {
		return new File(INDEX_PATH);
	}

	public List<File> getFilesFromIndex(String fileExtension) {
		File workspaceRoot = new File("..");
		return getFiles(workspaceRoot, fileExtension);
	}

	private List<File> getFiles(File root, final String fileExtension) {
		
		File indexFile = getIndexFile();
		boolean makeIndex = false;
		if (!indexFile.exists()) {
			makeIndex = true;
		} else {
			// index file exists, check its modification time
			long indexAge = System.currentTimeMillis() - indexFile.lastModified();
			long thirtyMinutes = 1000 * 60 * 30;
			if (indexAge > thirtyMinutes) {
				makeIndex = true;
			}
		}
		if (makeIndex) {
			createIndex();
		}
		String index = null;
		try {
			index = StreamUtil.getContentAsString(indexFile);
		} catch (IOException e) {
			throw new RuntimeException(
					"Can't find workspace index. Please ensure to run "
							+ this.getClass().getName()
							+ ".main() before running test cases.");
		}

		List<File> matchingFiles = new ArrayList<File>();

		String[] paths = index.split(LINE_SEPARATOR);
		for (String path : paths) {
			if (path.endsWith(fileExtension)) {
				File file = new File(path);
				matchingFiles.add(file);
			}
		}
		return matchingFiles;
	}

	private List<File> getFiles() {
		File workspaceRoot = new File("..");
		return getFiles(workspaceRoot);
	}

	private List<File> getFiles(File root) {

		List<File> allFiles = new ArrayList<File>();

		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				String name = file.getName();
				if (name.equals(".metadata") ||
					name.equals(".indexes")) {
					continue;
				}
				allFiles.addAll(getFiles(file));
			} else {
				allFiles.add(file);
			}
		}
		return allFiles;
	}
}
