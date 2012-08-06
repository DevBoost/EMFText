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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis;

public class ImportConcreteSyntaxReferenceResolver implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolver<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax> {

	private org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver delegate = new org.emftext.sdk.concretesyntax.resource.cs.analysis.ImportConcreteSyntaxReferenceResolver();

	public void resolve(java.lang.String identifier, org.emftext.sdk.concretesyntax.Import container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolveResult<org.emftext.sdk.concretesyntax.ConcreteSyntax> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult<org.emftext.sdk.concretesyntax.ConcreteSyntax>() {

			public boolean wasResolvedUniquely() {
				return result.wasResolvedUniquely();
			}

			public boolean wasResolvedMultiple() {
				return result.wasResolvedMultiple();
			}

			public boolean wasResolved() {
				return result.wasResolved();
			}

			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}

			public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<org.emftext.sdk.concretesyntax.ConcreteSyntax>> getMappings() {
				throw new UnsupportedOperationException();
			}

			public String getErrorMessage() {
				return result.getErrorMessage();
			}

			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier) {
				result.addMapping(identifier, newIdentifier);
			}

			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
				result.addMapping(identifier, newIdentifier, warning);
			}

			public void addMapping(String identifier, org.emftext.sdk.concretesyntax.ConcreteSyntax target) {
				result.addMapping(identifier, target);
			}

			public void addMapping(String identifier, org.emftext.sdk.concretesyntax.ConcreteSyntax target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});

	}

	public java.lang.String deResolve(org.emftext.sdk.concretesyntax.ConcreteSyntax element, org.emftext.sdk.concretesyntax.Import container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
