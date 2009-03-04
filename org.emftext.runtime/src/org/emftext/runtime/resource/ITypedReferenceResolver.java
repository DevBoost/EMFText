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
package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EReference;

/**
 * A reference resolver that can resolve references that are 
 * contained in objects of a given class.
 *
 * @param <ContainerType> the type of the container that has the references
 * @param <ReferenceType> the type of the reference itself
 */
public interface ITypedReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Attempts to resolve a reference string.
	 *
	 * @param identifier The identifier for the reference.
	 * @param container The object that contains the reference.
	 * @param reference The reference that points to the target of the reference.
	 * @param resolveFuzzy return objects that do not match exactly
	 *
	 * @return an object that contains the result of the resolve operation.
	 */
	public void resolve(String identifier, ContainerType container,
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceType> result);

	/**
	 * Reverse of the resolve operation: constructs a representing String of the given
	 * object.
	 *
	 * @param element The referenced model element.
	 * @param container The object referencing the element.
	 * @param reference The reference that holds the element.
	 * 
	 * @return The identification string for the reference
	 */
	public String deResolve(ReferenceType element, ContainerType container, EReference reference);
}
