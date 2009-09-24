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
import org.emftext.sdk.concretesyntax.Import;

/**
 * IConcreteSyntaxFinder is an interface for finders that can locate concrete
 * syntax definitions.
 */
public interface IConcreteSyntaxFinder {
	
	/**
	 * Searches for a syntax definition with the given URI.
	 * 
	 * @param csURI the URI to look for
	 * @param resource the resource that triggered the search
	 * @return
	 */
	public IConcreteSyntaxFinderResult findConcreteSyntax(String csURI, String locationHint,  Import container, Resource resource);
}
