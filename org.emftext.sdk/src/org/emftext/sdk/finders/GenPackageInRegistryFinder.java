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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A finder that looks up generator packages in the EMF package
 * registry. This implementation queries the registry once at its first usage
 * and loads and caches all valid generator packages.
 */
public class GenPackageInRegistryFinder implements IGenPackageFinder {
	
	private static final Map<String, GenPackageInRegistryFinderResult> cache = new HashMap<String, GenPackageInRegistryFinderResult>();
	
	static { init(); }
	
	private static void init() {
		//search all registered generator models
		final Map<String, URI> packageNsURIToGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		for (String nextNS : packageNsURIToGenModelLocationMap.keySet()) {
			URI genModelURI = packageNsURIToGenModelLocationMap.get(nextNS);
	    	try {
	    		final ResourceSet rs = new ResourceSetImpl();
        		Resource genModelResource = rs.getResource(genModelURI, true);
        		if (genModelResource == null) {
        			continue;
        		}
            	final EList<EObject> contents = genModelResource.getContents();
            	if (contents == null || contents.size() == 0) {
            		continue;
            	}
				GenModel genModel = (GenModel) contents.get(0);
            	for (GenPackage genPackage : genModel.getGenPackages()) {
        			if (genPackage != null && !genPackage.eIsProxy()) {
	            		String nsURI = genPackage.getNSURI();
	            		final GenPackageInRegistryFinderResult result = new GenPackageInRegistryFinderResult(genPackage);
						cache.put(nsURI, result);
						registerSubGenPackages(genPackage);
        			}
            	}
	    	} catch (Exception e ) {
	    		EMFTextRuntimePlugin.logError("Exception while looking up concrete syntaxes in the registry.", e);
	    	}
        }
	}
	
	private static void registerSubGenPackages(GenPackage parentPackage) {
		for(GenPackage genPackage : parentPackage.getSubGenPackages()) {
			if (genPackage != null && !genPackage.eIsProxy()) {
        		String nsURI = genPackage.getNSURI();
        		final GenPackageInRegistryFinderResult result = new GenPackageInRegistryFinderResult(genPackage);
				cache.put(nsURI, result);
				registerSubGenPackages(genPackage);
			}
		}
	}
	
	/**
	 * An implementation of the IGenPackageFinderResult that is used to
	 * return generator package found in the EMF registry.
	 */
	private static class GenPackageInRegistryFinderResult implements IGenPackageFinderResult {

		private GenPackage genPackage;
		
		public GenPackageInRegistryFinderResult(GenPackage genPackage) {
			Assert.isNotNull(genPackage);
			
			this.genPackage = genPackage;
		}
		
		public boolean hasChanged() {
			return false;
		}

		public GenPackage getResult() {
			return genPackage;
		}
	}
	



	public IGenPackageFinderResult findGenPackage(String nsURI, String locationHint, GenPackageDependentElement container, ITextResource resource) {
		if (cache.containsKey(nsURI)) {
			return cache.get(nsURI);
		}
		return null;
	}
}
