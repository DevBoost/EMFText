package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.IURIMapping;

/**
 * A basic implementation of the IURIMapping interface that can
 * map identifiers to URIs.
 */
public class URIMapping<ReferenceType> extends AbstractReferenceMapping<ReferenceType> implements IURIMapping<ReferenceType> {
	
	private URI uri;

	public URIMapping(String identifier, URI newIdentifier, String warning) {
		super(identifier, warning);
		this.uri = newIdentifier;
	}

	public URI getTargetIdentifier() {
		return uri;
	}
}
