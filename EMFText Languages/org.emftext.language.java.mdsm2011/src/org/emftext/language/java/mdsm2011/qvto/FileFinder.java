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
package org.emftext.language.java.mdsm2011.qvto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {

	public List<File> findAllFilesInFolder(
			File file,
			String[] fileExtensionsToInclude,
			String[] fileExtensionsToExclude) {
		
		List<File> foundFiles = new ArrayList<File>();
		if (!file.exists()) {
			throw new RuntimeException("Folder " + file + " does not exist.");
		}
		// file
		if (file.isFile()) {
			if (!matches(file, fileExtensionsToExclude) &&
				matches(file, fileExtensionsToInclude)) {
				foundFiles.add(file);
			}
		}
		// directory
		else {
			for (File member : file.listFiles()) {
				if (member.getName().startsWith(".")) {
					continue;
				}
				foundFiles.addAll(findAllFilesInFolder(member, fileExtensionsToInclude, fileExtensionsToExclude));
			}
		}
		
		return foundFiles;
	}

	private boolean matches(File file, String[] fileExtensions) {
		for (String fileExtension : fileExtensions) {
			if (file.getName().endsWith(fileExtension)) {
				return true;
			}
		}
		return false;
	}
}
