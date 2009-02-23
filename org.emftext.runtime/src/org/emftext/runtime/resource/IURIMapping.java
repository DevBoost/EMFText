package org.emftext.runtime.resource;

import org.eclipse.emf.common.util.URI;

/**
 * Implementors of this interface map identifiers to URIs.
 * This is sometime necessary when resolving references depends 
 * on the resolution of others.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement IReferenceMapping.
 */
public interface IURIMapping<ReferenceType> extends IReferenceMapping<ReferenceType> {
	public URI getTargetIdentifier();
}
