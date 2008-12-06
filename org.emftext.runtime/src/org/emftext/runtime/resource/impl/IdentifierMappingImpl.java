package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.IdentifierMapping;

public class IdentifierMappingImpl extends ReferenceMappingImpl implements IdentifierMapping {
	
	private String newIdentifier;
	
	public IdentifierMappingImpl(String identifier, String newIdentifier, String warning) {
		super(identifier, warning);
		this.newIdentifier = newIdentifier;
	}

	public String getTargetIdentifier() {
		return newIdentifier;
	}

}
