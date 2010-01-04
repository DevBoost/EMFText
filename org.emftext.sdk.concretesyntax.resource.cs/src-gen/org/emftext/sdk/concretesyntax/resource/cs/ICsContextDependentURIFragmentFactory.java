/*******************************************************************************
 * Copyright (c) 2006-2010 
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

package org.emftext.sdk.concretesyntax.resource.cs;

// An interface for factories to create instances of org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment.
//
// @param <ContainerType> the type of the class containing the reference to be resolved
// @param <ReferenceType> the type of the reference to be resolved
//
public interface ICsContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> {
	
	// Create a new instance of the org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment interface.
	//
	// @param identifier the identifier that references an org.eclipse.emf.ecore.EObject
	// @param container the object that contains the reference
	// @param reference the reference itself
	// @param positionInReference the position of the identifier (if the reference is multiple)
	// @param proxy the proxy that will be resolved later to the actual org.eclipse.emf.ecore.EObject
	// @return
	public org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy);
}
