/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
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
public class DelegatingResolveResult<ReferenceType> implements IReferenceResolveResult<ReferenceType> {
	
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
