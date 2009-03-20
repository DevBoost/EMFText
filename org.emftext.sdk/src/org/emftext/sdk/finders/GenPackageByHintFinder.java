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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A finder that searches in the current project in the Eclipse workspace
 * for files that contain generator packages.
 */
public class GenPackageByHintFinder extends GenPackageInFileFinder {
	
	private Set<String> faultyHints = new HashSet<String>();
	
	public IGenPackageFinderResult findGenPackage(String nsURI, String locationHint, GenPackageDependentElement container, ITextResource resource) {
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
	private IGenPackageFinderResult findGenPackageUsingHint(String nsURI, String locationHint, GenPackageDependentElement container, ITextResource resource) {
		ResourceSet rs = resource.getResourceSet();
		try {
			URI hintURI = new LocationHintResolver().getLocationHintURI(locationHint, container);
			if ("genmodel".equals(hintURI.fileExtension())) {
				return findGenPackage(getSyntax(container), nsURI, rs, hintURI);
			}
		} catch (Exception e) {
			e.printStackTrace();
			EMFTextRuntimePlugin.logError("Exception while looking for generator package.", e);
		}
		
		return null;
	}
}
