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
package org.emftext.sdk.finders;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * An IGenPackageFinder can be used to look up the EMF generator package for
 * a given URI.
 */
public interface IGenPackageFinder {

	/**
	 * Searches for all generator packages that match the given nsURI.
	 * 
	 * @param nsURI the URI of the generator package we search for
	 * @param locationHint a URL of a location where the generator package might be (can be null)
	 * @param resource the resource that contains a link to the generator package
	 *                 (needed if generator packages that reside in the same folder 
	 *                 shall be preferred)
	 * @return
	 */
	public IGenPackageFinderResult findGenPackage(String nsURI, String locationHint, GenPackageDependentElement container, Resource resource);
}
