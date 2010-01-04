/*******************************************************************************
 * Copyright (c) 2006-2010 
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
