package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.IURIMapping;

/**
 * A basic implementation of the IURIMapping interface that can
 * map identifiers to URIs.
 */
public class URIMapping extends AbstractReferenceMapping implements IURIMapping {
	
	private URI uri;

	public URIMapping(String identifier, URI newIdentifier, String warning) {
		super(identifier, warning);
		this.uri = newIdentifier;
	}

	public URI getTargetIdentifier() {
		return uri;
	}
}
