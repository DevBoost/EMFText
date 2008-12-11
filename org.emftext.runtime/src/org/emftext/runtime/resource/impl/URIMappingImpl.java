package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.URIMapping;

public class URIMappingImpl extends ReferenceMappingImpl implements URIMapping {
	
	private URI uri;

	public URIMappingImpl(String identifier, URI newIdentifier, String warning) {
		super(identifier, warning);
		this.uri = newIdentifier;
	}

	public URI getTargetIdentifier() {
		return uri;
	}

}
