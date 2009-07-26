package org.emftext.sdk.concretesyntax.resource.cs;

// A basic implementation of the IElementMapping interface.
//
// @param <ReferenceType> the type of the reference that can be mapped to
//
public class CsElementMapping<ReferenceType> extends org.emftext.runtime.resource.impl.AbstractReferenceMapping<ReferenceType> implements org.emftext.runtime.resource.IElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public CsElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
}
