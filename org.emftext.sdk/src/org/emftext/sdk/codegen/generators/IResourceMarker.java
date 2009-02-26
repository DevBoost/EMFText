package org.emftext.sdk.codegen.generators;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Implementation of this interface can process the warning and
 * errors attached to the given resource.
 */
public interface IResourceMarker {

	public void mark(Resource resource) throws CoreException;
	public void unmark(Resource resource) throws CoreException;
}
