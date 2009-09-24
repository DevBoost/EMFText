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
