package org.reuseware.emftextedit.runtime.resource.impl;

import org.reuseware.emftextedit.runtime.resource.ReferenceMapping;

public abstract class ReferenceMappingImpl implements ReferenceMapping {

	private String identifier;
	private String warning;
	
	public ReferenceMappingImpl(String identifier, String warning) {
		super();
		this.identifier = identifier;
		this.warning = warning;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getWarning() {
		return warning;
	}

}
