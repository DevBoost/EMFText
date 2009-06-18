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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A GenPackageFinder that searches for generator models by removing the
 * file extension ('.cs') from the syntax definition and adding '.genmodel'.
 */
public class GenPackageByNameFinder extends GenPackageInFileFinder {
	
	public IGenPackageFinderResult findGenPackage(String nsURI,
			String locationHint, GenPackageDependentElement container, ITextResource resource) {
		
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
    		EMFTextRuntimePlugin.logError("Error searching for generator model " + nsURI, e);
		}
		
		return null;
	}
}
