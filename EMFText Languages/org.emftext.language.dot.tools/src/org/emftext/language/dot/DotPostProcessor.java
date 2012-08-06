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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.dot.resource.dot.DotEProblemType;
import org.emftext.language.dot.resource.dot.IDotResourcePostProcessor;
import org.emftext.language.dot.resource.dot.mopp.DotResource;

// TODO this should rather be a builder
public class DotPostProcessor implements IDotResourcePostProcessor {
	
	private DotRunner dotRunner = new DotRunner();

	public void process(DotResource resource) {
		if (!dotRunner.testDOT()) {
			String path = System.getenv("PATH"); //$NON-NLS-1$
			resource.addError("Cannot run DOT executable. Please make sure that it is contained in your PATH variable (" + path +").", DotEProblemType.ANALYSIS_PROBLEM, null); //$NON-NLS-1$
			return;
		}

		IFile file = WorkspaceSynchronizer.getFile(resource);
		String filePath = file.getProjectRelativePath().toOSString();
		String projectPath = file.getProject().getLocation().toOSString();
		String message = dotRunner.convertDotToPDF(filePath, projectPath);

		if (message != null) {
			resource.addError("DOT finished with \"" + message + "\"", DotEProblemType.ANALYSIS_PROBLEM, null); //$NON-NLS-1$
		} else {
			try {
				file.getProject().refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				// Do nothing
			}
		}
	}

	public void terminate() {
		// do nothing
	}
}
