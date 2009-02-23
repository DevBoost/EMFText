package org.emftext.runtime.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolveResult;

public class FuzzyResolveResult<ReferenceType extends EObject> implements IReferenceResolveResult<ReferenceType> {
	
	private IReferenceResolveResult<EObject> delegate;

	public FuzzyResolveResult(IReferenceResolveResult<EObject> delegate) {
		this.delegate = delegate;
	}

	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}

	public Collection<IReferenceMapping<ReferenceType>> getMappings() {
		throw new RuntimeException("Method not implemented.");
	}

	public boolean wasResolved() {
		return delegate.wasResolved();
	}

	public boolean wasResolvedMultiple() {
		return delegate.wasResolvedMultiple();
	}

	public boolean wasResolvedUniquely() {
		return delegate.wasResolvedUniquely();
	}

	public void setErrorMessage(String message) {
		delegate.setErrorMessage(message);
	}

	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, (EObject) target);
	}

	public void addMapping(String identifier, URI uri) {
		delegate.addMapping(identifier, uri);
	}

	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, (EObject) target, warning);
	}

	public void addMapping(String identifier, URI uri,
			String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
}
