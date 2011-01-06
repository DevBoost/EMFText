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

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A finder that searches in the current project in the Eclipse workspace
 * for files that contain generator packages.
 */
public class GenPackageByHintFinder extends GenPackageInFileFinder {
	
	private Set<String> faultyHints = new LinkedHashSet<String>();
	
	public GenPackageResolveResult findGenPackages(String nsURI, String locationHint, GenPackageDependentElement container, Resource resource, boolean resolveFuzzy) {
		if (locationHint == null) {
			return new GenPackageResolveResult(); // empty
		}
		if (faultyHints.contains(locationHint)) {
			return new GenPackageResolveResult(); // empty
		}
		return findGenPackagesUsingHint(nsURI, locationHint, container, resource, resolveFuzzy);
	}

	/**
	 * Search in the current project for generator models.
	 * 
	 * @param nsURI
	 * @param rs
	 * 
	 * @return
	 */
	private GenPackageResolveResult findGenPackagesUsingHint(String nsURI, String locationHint, GenPackageDependentElement container, Resource resource, boolean resolveFuzzy) {
		if (resource == null) {
			return new GenPackageResolveResult(); // empty
		}
		ResourceSet rs = resource.getResourceSet();
		if (rs == null) {
			return new GenPackageResolveResult(); // empty
		}
		try {
			URI hintURI = new LocationHintResolver().getLocationHintURI(locationHint, container);
			if ("genmodel".equals(hintURI.fileExtension())) {
				return findGenPackages(getSyntax(container), nsURI, rs, hintURI, resolveFuzzy);
			}
		} catch (Exception e) {
			EMFTextSDKPlugin.logError("Exception while looking for generator package.", e);
		}
		
		return new GenPackageResolveResult(); // empty
	}
}
