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

// A factory for ContextDependentURIFragments. Given a feasible reference resolver,
// the factory returns a matching fragment that used the resolver to resolver proxy
// objects.
//
// @param <ContainerType> the type of the class containing the reference to be resolved
// @param <ReferenceType> the type of the reference to be resolved
//
public class GeneratorconfigContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragmentFactory<ContainerType, ReferenceType> {

	private final org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolver<ContainerType, ReferenceType> resolver;

	public GeneratorconfigContextDependentURIFragmentFactory(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {

		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
