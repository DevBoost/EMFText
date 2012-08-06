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
public interface IReferenceResolver<ContainerType extends EObject, ReferenceType extends EObject> extends ITypedReferenceResolver<ContainerType, ReferenceType>, IConfigurable {
}
