package org.emftext.sdk.codegen;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.emftext.sdk.EMFTextSDKPlugin;

public abstract class AbstractCreatePluginJob {

	protected void refresh(IProgressMonitor monitor, IProject project, String name) throws CoreException {
		monitor.beginTask("Refreshing project", 1);
		if (project != null) {
			project.refreshLocal(IProject.DEPTH_INFINITE, monitor);
			project.touch(new NullProgressMonitor());
			EMFTextSDKPlugin.logProblem(Status.INFO, "Project (" + project + ") was refreshed and touched.", null);
		} else {
			EMFTextSDKPlugin.logWarning("Project (" + project + ") does not exist, can't refresh.", null);
		}
		monitor.worked(1);
	}

}
