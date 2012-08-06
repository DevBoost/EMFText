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
 * An IReferenceResolverSwitch is a object that holds references to multiple
 * other reference resolvers and delegates requests to the appropriate resolver.
 */
public interface IReferenceResolverSwitch extends IConfigurable {
	
	/**
	 * Attempts to resolve a reference string fuzzy (returning objects that do not match exactly).
	 *
	 * @param identifier The identifier for the reference.
	 * @param container The object that contains the reference.
	 * @param reference The reference that points to the target of the reference.
	 * @param result an object to store the result of the resolve operation.
	 */
	public void resolveFuzzy(
			String identifier, 
			EObject container, 
			int position, 
			IReferenceResolveResult<EObject> result);
}
