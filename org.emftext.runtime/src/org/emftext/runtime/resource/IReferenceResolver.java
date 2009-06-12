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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * A reference resolver tries to resolve a reference to one or many model elements (EObjects).
 * It is called by the EMF proxy resolution mechanism.
 *
 * @param <ContainerType> the type of the container that contains
 * the reference that is resolved by this resolver
 * 
 * @param <ReferenceType> the type of the reference that is
 * resolved by this resolver
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public interface IReferenceResolver<ContainerType extends EObject, ReferenceType extends EObject> extends IConfigurable {
	/**
	 * Attempts to resolve a reference string.
	 *
	 * @param identifier The identifier for the reference.
	 * @param container The object that contains the reference.
	 * @param reference The reference that points to the target of the reference.
	 * @param position The index of the reference (if it has an upper bound greater than 1).
	 * @param resolveFuzzy return objects that do not match exactly
	 * @param result an object that can be sued to store the result of the resolve operation.
	 */
	public void resolve(
			String identifier, 
			ContainerType container,
			EReference reference, 
			int position, 
			boolean resolveFuzzy, 
			IReferenceResolveResult<ReferenceType> result);

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
