package org.emftext.sdk.concretesyntax.resource.cs;

public class CsResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public CsResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.sdk.concretesyntax.resource.cs.CsResource(uri);
	}
}
