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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * A LocationHintResolver can be used to convert location hints to 
 * URIs.
 */
public class LocationHintResolver {


	public URI getLocationHintURI(String locationHint, EObject container) {
		URI hintURI;
		if (locationHint.contains(":")) {
			// locationHint is an absolute path - we can use it as it is
			hintURI = URI.createURI(locationHint);
		} else {
			// locationHint is an relative path - we must resolve it
			URI containerURI = container.eResource().getURI();
			hintURI = URI.createURI(locationHint).resolve(containerURI);
		}
		return hintURI;
	}
}
