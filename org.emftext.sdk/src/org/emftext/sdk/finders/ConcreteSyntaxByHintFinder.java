/*******************************************************************************
 * Copyright (c) 2006-2011
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

/**
 * A finder that searches in the current Eclipse workspace for concrete
 * syntax definitions.
 */
public class ConcreteSyntaxByHintFinder implements IConcreteSyntaxFinder {

	public IConcreteSyntaxFinderResult findConcreteSyntax(String csURI, String locationHint, Import container, Resource resource) {
		ResourceSet rs = resource.getResourceSet();
		
		if (locationHint == null) {
			return null;
		}
		URI hintURI = new LocationHintResolver().getLocationHintURI(locationHint, container);
		if ("cs".equals(hintURI.fileExtension())) {
			Resource csResource = null;
			
			try {
				csResource = rs.getResource(hintURI, true);
			} catch (Exception e) {}
			
			EList<EObject> contents = null; 
			if (csResource != null) {
				contents = csResource.getContents();	
			}
			if (contents != null && contents.size() > 0) {
				if(contents.get(0) instanceof ConcreteSyntax) {
					return new ConcreteSyntaxFinderResult((ConcreteSyntax)contents.get(0));
				}
			}
		}
       	return null;
	}
}
