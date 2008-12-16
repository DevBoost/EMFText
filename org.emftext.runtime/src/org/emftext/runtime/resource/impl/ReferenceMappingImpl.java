package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.IReferenceMapping;

public abstract class ReferenceMappingImpl implements IReferenceMapping {

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
