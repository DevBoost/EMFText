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

import java.util.HashSet;
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
	
	private Set<String> faultyHints = new HashSet<String>();
	
	public IGenPackageFinderResult findGenPackage(String nsURI, String locationHint, GenPackageDependentElement container, Resource resource) {
		if (locationHint == null) {
			return null;
		}
		if (faultyHints.contains(locationHint)) {
			return null;
		}
		return findGenPackageUsingHint(nsURI, locationHint, container, resource);
	}

	/**
	 * Search the current project generator models.
	 * 
	 * @param nsURI
	 * @param rs
	 * @param platformString
	 * @return
	 */
	private IGenPackageFinderResult findGenPackageUsingHint(String nsURI, String locationHint, GenPackageDependentElement container, Resource resource) {
		if (resource == null) {
			return null;
		}
		ResourceSet rs = resource.getResourceSet();
		if (rs == null) {
			return null;
		}
		try {
			URI hintURI = new LocationHintResolver().getLocationHintURI(locationHint, container);
			if ("genmodel".equals(hintURI.fileExtension())) {
				return findGenPackage(getSyntax(container), nsURI, rs, hintURI);
			}
		} catch (Exception e) {
			e.printStackTrace();
			EMFTextSDKPlugin.logError("Exception while looking for generator package.", e);
		}
		
		return null;
	}
}
