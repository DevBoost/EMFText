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

// A FuzzyResolveResult is an implementation of the IReferenceResolveResult
// interface that delegates all method calls to a given IReferenceResolveResult
// with ReferenceType EObject. It is used by reference resolver switches to
// collect results from different reference resolvers in a type safe manner.
//
// @param <ReferenceType> the type of the reference that is resolved
//
public class GeneratorconfigFuzzyResolveResult<ReferenceType extends org.eclipse.emf.ecore.EObject> implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolveResult<ReferenceType> {

	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate;

	public GeneratorconfigFuzzyResolveResult(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate) {
		this.delegate = delegate;
	}

	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}

	public java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceMapping<ReferenceType>> getMappings() {
		return null;
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
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target);
	}

	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		delegate.addMapping(identifier, uri);
	}

	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target, warning);
	}

	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
}
