package org.emftext.sdk.ui.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.runtime.MarkerHelper;
import org.emftext.sdk.codegen.generators.IResourceMarker;

/**
 * Adds errors and warning contained in the given resource as
 * workspace markers so they appear in the Eclipse problems
 * view.
 */
public class WorkspaceMarker implements IResourceMarker {

	public void mark(Resource resource) throws CoreException {
		MarkerHelper.mark(resource);
	}

	public void unmark(Resource resource) throws CoreException {
		MarkerHelper.unmark(resource);
	}
}
