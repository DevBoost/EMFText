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
package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * An interface for factories to create instances of IContextDependentURIFragment.
 *
 * @param <ContainerType> the type of the class containing the reference to be resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public interface IContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject> {

	/**
	 * Create a new instance of the IContextDependentURIFragment interface.
	 * 
	 * @param identifier the identifier that references an EObject
	 * @param container the object that contains the reference
	 * @param reference the reference itself
	 * @param positionInReference the position of the identifier (if the reference is multiple)
	 * @param proxy the proxy that will be resolved later to the actual EObject
	 * @return
	 */
	public IContextDependentURIFragment<?> create(
			String identifier, ContainerType container,
			EReference reference, int positionInReference, EObject proxy);
}
