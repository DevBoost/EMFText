package org.emftext.sdk.concretesyntax.resource.cs.mopp;

// A basic implementation of IResolveResult interface
// that collects mappings in a list.
//
// @param <ReferenceType> the type of the references that can be contained in this result
//
public class CsReferenceResolveResult<ReferenceType> implements org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	
	public CsReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<ReferenceType>>();
		}
		mappings.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<ReferenceType>>();
		}
		mappings.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
