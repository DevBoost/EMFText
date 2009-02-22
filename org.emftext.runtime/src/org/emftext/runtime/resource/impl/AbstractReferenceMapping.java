package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.IReferenceMapping;

/**
 * A base class for all reference mappings. Instances store the identifier
 * that was resolves and a warning message.
 */
public abstract class AbstractReferenceMapping<ReferenceType> implements IReferenceMapping<ReferenceType> {

	private String identifier;
	private String warning;
	
	public AbstractReferenceMapping(String identifier, String warning) {
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
