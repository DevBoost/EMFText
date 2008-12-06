package org.emftext.runtime.resource.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ReferenceMapping;
import org.emftext.runtime.resource.ResolveResult;

/**
 * An implementation of the ResolveResult interface that delegates 
 * all method calls to another ResolveResult. Client may subclass 
 * this class to easily create custom ResolveResults.
 */
public class DelegatingResolveResultImpl implements ResolveResult {
	
	private ResolveResult delegate;

	public DelegatingResolveResultImpl(ResolveResult delegate) {
		this.delegate = delegate;
	}

	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}

	public Collection<ReferenceMapping> getMappings() {
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

	public void addMapping(String identifier, String newIdentifier) {
		delegate.addMapping(identifier, newIdentifier);
	}

	public void addMapping(String identifier, EObject target, String warning) {
		delegate.addMapping(identifier, target, warning);
	}

	public void addMapping(String identifier, String newIdentifier,
			String warning) {
		delegate.addMapping(identifier, newIdentifier, warning);
	}
}
