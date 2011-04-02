/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.codegen;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.emftext.sdk.EMFTextSDKPlugin;

public abstract class AbstractCreatePluginJob {

	protected void refresh(IProgressMonitor monitor, IProject project, String name) throws CoreException {
		monitor.beginTask("Refreshing project", 1);
		if (project != null) {
			project.refreshLocal(IProject.DEPTH_INFINITE, monitor);
			project.touch(new NullProgressMonitor());
		} else {
			EMFTextSDKPlugin.logWarning("Project (" + project + ") does not exist, can't refresh.", null);
		}
		monitor.worked(1);
	}

}
