package org.emftext.runtime.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IResolveResult;

/**
 * An implementation of the ResolveResult interface that delegates 
 * all method calls to another ResolveResult. Client may subclass 
 * this class to easily create custom ResolveResults.
 */
public class DelegatingResolveResult implements IResolveResult {
	
	private IResolveResult delegate;

	public DelegatingResolveResult(IResolveResult delegate) {
		this.delegate = delegate;
	}

	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}

	public Collection<IReferenceMapping> getMappings() {
		return delegate.getMappings();
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

	public void addMapping(String identifier, EObject target) {
		delegate.addMapping(identifier, target);
	}

	public void addMapping(String identifier, URI uri) {
		delegate.addMapping(identifier, uri);
	}

	public void addMapping(String identifier, EObject target, String warning) {
		delegate.addMapping(identifier, target, warning);
	}

	public void addMapping(String identifier, URI uri,
			String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
}
