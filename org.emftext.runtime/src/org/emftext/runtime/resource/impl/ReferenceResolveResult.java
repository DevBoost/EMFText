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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolveResult;

/**
 * A basic implementation of IResolveResult interface
 * that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this result
 * 
 * @deprecated This class will be removed for release 1.3 of EMFText
 */
public class ReferenceResolveResult<ReferenceType> implements IReferenceResolveResult<ReferenceType> {
	
	private Collection<IReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;

	public ReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Collection<IReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new ArrayList<IReferenceMapping<ReferenceType>>();
		}
		mappings.add(new ElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}

	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<IReferenceMapping<ReferenceType>>();
		}
		mappings.add(new URIMapping<ReferenceType>(identifier, uri, warning));
	}
}
