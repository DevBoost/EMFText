/*******************************************************************************
 * Copyright (c) 2006-2014
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

package org.emftext.sdk.concretesyntax.resource.cs;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public interface ICsReferenceCache {
	
	/**
	 * Returns all EObjects of the given type.
	 */
	public Set<EObject> getObjects(EClass type);
	
	/**
	 * Initializes the cache with the object tree that is rooted at <code>root</code>.
	 * The cache allows to retrieve of objects of a given type or a given name. If the
	 * cache was already initialized, no action is performed.
	 */
	public void initialize(EObject root);
	
	/**
	 * Returns the map from object names to objects that was created when the cache
	 * was initialized.
	 */
	public Map<String, Set<EObject>> getNameToObjectsMap();
	
	/**
	 * Clears the cache.
	 */
	public void clear();
	
}
