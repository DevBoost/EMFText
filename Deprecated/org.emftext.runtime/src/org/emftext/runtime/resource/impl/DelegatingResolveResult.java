/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolveResult;

/**
 * An implementation of the ResolveResult interface that delegates 
 * all method calls to another ResolveResult. Client may subclass 
 * this class to easily create custom ResolveResults.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this result
 */
@Deprecated public class DelegatingResolveResult<ReferenceType> implements IReferenceResolveResult<ReferenceType> {
	
	private IReferenceResolveResult<ReferenceType> delegate;

	public DelegatingResolveResult(IReferenceResolveResult<ReferenceType> delegate) {
		this.delegate = delegate;
	}

	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}

	public Collection<IReferenceMapping<ReferenceType>> getMappings() {
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

	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, target);
	}

	public void addMapping(String identifier, URI uri) {
		delegate.addMapping(identifier, uri);
	}

	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, target, warning);
	}

	public void addMapping(String identifier, URI uri,
			String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
}
