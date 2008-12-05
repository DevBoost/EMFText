package org.reuseware.emftextedit.runtime.resource.impl;

import org.reuseware.emftextedit.runtime.resource.IdentifierMapping;

public class IdentifierMappingImpl implements IdentifierMapping {
	
	private String identifier;
	private String newIdentifier;
	
	public IdentifierMappingImpl(String identifier, String newIdentifier) {
		super();
		this.identifier = identifier;
		this.newIdentifier = newIdentifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getTargetIdentifier() {
		return newIdentifier;
	}

}
