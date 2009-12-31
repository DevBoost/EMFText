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
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A finder that looks up generator packages in the EMF package
 * registry. This implementation queries the registry once at its first usage
 * and loads and caches all valid generator packages.
 */
public class GenPackageInRegistryFinder implements IGenPackageFinder {
	
	private static final Map<String, GenPackageInRegistryFinderResult> cache = new HashMap<String, GenPackageInRegistryFinderResult>();
	private static boolean isInitialized = false;
	
	private static void init() {
		synchronized (GenPackageInRegistryFinder.class) {
			if (!isInitialized) {
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
			    		// ignore FileNotFoundException caused by the org.eclipse.m2m.qvt.oml plug-in
			    		// this plug-in does not contain the generator models it registers
			    		// this is a workaround for Eclipse Bug 288208
			    		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=288208
			    		if (!genModelURI.toString().startsWith("platform:/plugin/org.eclipse.m2m.qvt.oml")) {
				    		EMFTextSDKPlugin.logWarning("Exception while looking up generator model (" + nextNS + ") in the registry.", e);
			    		}
			    	}
		        }
				isInitialized = true;
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
	
	public IGenPackageFinderResult findGenPackage(String nsURI, String locationHint, GenPackageDependentElement container, Resource resource) {
		init();
		if (cache.containsKey(nsURI)) {
			return cache.get(nsURI);
		}
		return null;
	}
}
