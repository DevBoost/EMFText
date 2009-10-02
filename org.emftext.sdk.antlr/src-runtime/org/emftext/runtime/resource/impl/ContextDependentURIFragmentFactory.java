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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.IContextDependentURIFragmentFactory;
import org.emftext.runtime.resource.IReferenceResolver;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference resolver,
 * the factory returns a matching fragment that used the resolver to resolver proxy
 * objects.
 * 
 * @deprecated This class will be removed for release 1.3 of EMFText
 *
 * @param <ContainerType> the type of the class containing the reference to be resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class ContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject>  implements IContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final IReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public ContextDependentURIFragmentFactory(IReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}

	public IContextDependentURIFragment<?> create(
			String identifier,
			ContainerType container, EReference reference, int positionInReference,
			EObject proxy) {

		return new ContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {

			@Override
			public IReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
