package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.IURIMapping;

public class URIMappingImpl extends ReferenceMappingImpl implements IURIMapping {
	
	private URI uri;

	public URIMappingImpl(String identifier, URI newIdentifier, String warning) {
		super(identifier, warning);
		this.uri = newIdentifier;
	}

	public URI getTargetIdentifier() {
		return uri;
	}

}
