package org.emftext.sdk.concretesyntax.resource.cs.mopp;

// A basic implementation of the IURIMapping interface that can
// map identifiers to URIs.
//
// @param <ReferenceType> unused type parameter which is needed to implement IURIMapping.
//
public class CsURIMapping<ReferenceType> implements org.emftext.sdk.concretesyntax.resource.cs.ICsURIMapping<ReferenceType> {
	
	private org.eclipse.emf.common.util.URI uri;
	private String identifier;
	private String warning;
	
	public CsURIMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public org.eclipse.emf.common.util.URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
