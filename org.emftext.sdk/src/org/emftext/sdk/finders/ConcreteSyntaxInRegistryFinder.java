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

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

/**
 * A finder that searches in the registry for concrete
 * syntax definitions.
 */
public class ConcreteSyntaxInRegistryFinder implements IConcreteSyntaxFinder {
	
	public IConcreteSyntaxFinderResult findConcreteSyntax(String csURI, String locationHint, Import container, Resource resource) {
		ResourceSet rs = resource.getResourceSet();
		
		//find all registered concrete syntax definitions
		try {
	        final Map<String, URI> uriToCSLocationMap = EMFTextAccessPlugin.getURIToConcreteSyntaxLocationMap();
			for (String candCsURI : uriToCSLocationMap.keySet()) {
	        	URI csLocation = uriToCSLocationMap.get(csURI);
	        	if (csLocation == null) {
	        		continue;
	        	}
	        	Resource csResource = rs.getResource(csLocation, true);
	        	ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource.getContents().get(0);
	        	if (csURI.equals(candCsURI)) {
	        		return new ConcreteSyntaxFinderResult(concreteSyntax);
	        	}
	        }
		} catch (NoClassDefFoundError e) {
			//if the access plugin is not available!
		}
		return null;
	}
}
