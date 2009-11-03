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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A GenPackageFinder that searches for generator models by removing the
 * file extension ('.cs') from the syntax definition and adding '.genmodel'.
 */
public class GenPackageByNameFinder extends GenPackageInFileFinder {
	
	public IGenPackageFinderResult findGenPackage(String nsURI,
			String locationHint, GenPackageDependentElement container, Resource resource) {
		
		if (resource == null) {
			return null;
		}
		ResourceSet rs = resource.getResourceSet();
		if (rs == null) {
			return null;
		}
		URI resourceURI = resource.getURI();
		resourceURI = resourceURI.trimFileExtension();
		URI genModelURI = resourceURI.appendFileExtension("genmodel");
		try {
			return findGenPackage(getSyntax(container), nsURI, rs, genModelURI);
		} catch (Exception e) {
    		EMFTextSDKPlugin.logError("Error searching for generator model " + nsURI, e);
		}
		
		return null;
	}
}
