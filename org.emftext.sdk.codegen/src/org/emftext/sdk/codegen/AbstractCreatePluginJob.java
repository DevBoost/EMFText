package org.emftext.sdk.codegen;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public abstract class AbstractCreatePluginJob {

	protected void refresh(IProgressMonitor monitor, IProject project) throws CoreException {
		if (project != null) {
			project.refreshLocal(IProject.DEPTH_INFINITE, monitor);
		}
	}

}
