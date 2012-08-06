/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

// A basic implementation of IResolveResult interface
// that collects mappings in a list.
//
// @param <ReferenceType> the type of the references that can be contained in this result
//
public class GeneratorconfigReferenceResolveResult<ReferenceType> implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolveResult<ReferenceType> {

	private java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;

	public GeneratorconfigReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceMapping<ReferenceType>> getMappings() {
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
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}

	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceMapping<ReferenceType>>();
		}
		mappings.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}

	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}

	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceMapping<ReferenceType>>();
		}
		mappings.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
