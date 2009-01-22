package org.emftext.runtime.resource;

import org.eclipse.emf.common.util.URI;

/**
 * Implementors of this interface map identifiers to URIs.
 * This is sometime necessary when resolving references depends 
 * on the resolution of others.
 */
public interface IURIMapping extends IReferenceMapping {
	public URI getTargetIdentifier();
}
