package org.emftext.sdk.concretesyntax.resource.cs.mopp;

// A basic implementation of the IElementMapping interface.
//
// @param <ReferenceType> the type of the reference that can be mapped to
//
public class CsElementMapping<ReferenceType> implements org.emftext.sdk.concretesyntax.resource.cs.ICsElementMapping<ReferenceType> {
	
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
