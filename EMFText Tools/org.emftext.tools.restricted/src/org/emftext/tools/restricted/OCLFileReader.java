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
package org.emftext.tools.restricted;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;

public class OCLFileReader {

	private static final String GLOBAL_RESTRICTIONS_OCL_FILE = "restrictions.ocl";
	private static final String RESTRICTIONS_OCL_FILE_EXTENSION = ".restrictions.ocl";

	public List<RestrictedExpression> read(final IFile file) {
		List<RestrictedExpression> expressions = new ArrayList<RestrictedExpression>();
		tryToLoadFileRestrictions(file, expressions);
		
		IContainer parent = file.getParent();
		if (parent instanceof IFolder) {
			expressions.addAll(read((IFolder) parent));
		}
		
		return expressions;
	}

	private Collection<? extends RestrictedExpression> read(IFolder folder) {
		List<RestrictedExpression> expressions = new ArrayList<RestrictedExpression>();
		tryToLoadFolderRestrictions(folder, expressions);
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			expressions.addAll(read((IFolder) parent));
		}
		return expressions;
	}

	private void tryToLoadFolderRestrictions(IFolder parentFolder,
			List<RestrictedExpression> expressions) {
		// TODO use platform independent separator
		String restrictionsFilename = parentFolder.getLocation().toOSString() + "\\" + GLOBAL_RESTRICTIONS_OCL_FILE;
		tryToLoadRestrictions(expressions, restrictionsFilename);
	}

	private void tryToLoadFileRestrictions(final IFile file,
			List<RestrictedExpression> expressions) {
		String restrictionsFilename = getRestrictionsFilename(file);
		tryToLoadRestrictions(expressions, restrictionsFilename);
	}

	private void tryToLoadRestrictions(List<RestrictedExpression> expressions,
			String restrictionsFilename) {
		File restrictionsFile = new File(restrictionsFilename);
		if (restrictionsFile.exists()) {
			expressions.addAll(readConstraintsFromFile(restrictionsFilename));
		}
	}

	private String getRestrictionsFilename(IFile file) {
		String activeFilename = file.getLocation().toOSString();
		String restrictionsFilename = activeFilename + RESTRICTIONS_OCL_FILE_EXTENSION;
		return restrictionsFilename;
	}

	private List<RestrictedExpression> readConstraintsFromFile(String path) {

		List<RestrictedExpression> constraints = new ArrayList<RestrictedExpression>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String line;
			while ((line = in.readLine()) != null) {
				constraints.add(new RestrictedExpression(line));
			}
			in.close();
		} catch (IOException ioe) {
			return null;
		}
		return constraints;
	}

}
