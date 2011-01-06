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

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
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
	
	private static final Map<String, GenPackageInRegistry> cache = new HashMap<String, GenPackageInRegistry>();
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
			            		final GenPackageInRegistry result = new GenPackageInRegistry(genPackage);
								cache.put(nsURI, result);
								registerSubGenPackages(genPackage);
		        			}
		            	}
			    	} catch (Exception e) {
			    		String uriString = genModelURI.toString();
			    		// ignore FileNotFoundException caused by the org.eclipse.m2m.qvt.oml plug-in
			    		// this plug-in does not contain the generator models it registers
			    		// this is a workaround for Eclipse Bug 288208
			    		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=288208
			    		//
			    		// do also ignore FileNotFoundException caused by some ATL plug-ins
			    		// this is a workaround for Eclipse Bug 315376
			    		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=315376
			    		//
			    		// do also ignore FileNotFoundException caused by some xText plug-ins
			    		// this is a workaround for Eclipse Bug 315986
			    		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=315986
			    		//
			    		// do also ignore FileNotFoundException caused by CDO
			    		// this is a workaround for Eclipse Bug 317821
			    		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=317821
			    		//
			    		// do also ignore FileNotFoundException caused by MOFScript
			    		// This is a workaround for Eclipse Bug 322642
			    		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=322642
			    		//
			    		// do also ignore FileNotFoundException caused by OCL Tools
			    		// This is a workaround for Eclipse Bug 322886
			    		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=322886
			    		//
			    		// do also ignore FileNotFoundException caused by some pure::variants plug-ins
						if (!uriString.startsWith("platform:/plugin/com.ps.consul.eclipse.ecore/src/pvmeta.genmodel") &&
							!uriString.startsWith("platform:/plugin/com.ps.consul.eclipse.ecore/src/pvmodel.genmodel") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.emf.cdo/model/resource.genmodel") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.emf.mwe2.language/model/Mwe2.genmodel") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.m2m.qvt.oml") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.m2m.atl.profiler.exportmodel/model/exportmodel.genmodel") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.m2m.atl.profiler.model/model/ATL-Profiler.genmodel") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.mofscript.model/src/model/mofscriptmodel.genmodel") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.ocl.examples.xtext.completeocl/org.eclipse.ocl.examples.xtext.completeocl/model/CompleteOCLCST.genmodel") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.xtext/model/xtext.genmodel") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.xtext.builder/model/BuilderState.genmodel") &&
							!uriString.startsWith("platform:/plugin/org.eclipse.xtext.xbase/org/eclipse/xtext/xbase/Xbase.genmodel")
							) {
				    		EMFTextSDKPlugin.logWarning("Exception while looking up generator model (" + nextNS + ") at " + uriString + " in the registry.", e);
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
        		final GenPackageInRegistry result = new GenPackageInRegistry(genPackage);
				cache.put(nsURI, result);
				registerSubGenPackages(genPackage);
			}
		}
	}
	
	/**
	 * An implementation of the IResolvedGenPackage that is used to
	 * return generator package found in the EMF registry.
	 */
	private static class GenPackageInRegistry implements IResolvedGenPackage {

		private GenPackage genPackage;
		
		public GenPackageInRegistry(GenPackage genPackage) {
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
	
	public GenPackageResolveResult findGenPackages(String nsURI, String locationHint, GenPackageDependentElement container, Resource resource, boolean resolveFuzzy) {
		init();
		Collection<IResolvedGenPackage> result = new LinkedHashSet<IResolvedGenPackage>();
		for (String nextNsURI : cache.keySet()) {
			if (nextNsURI == null) {
				continue;
			}
			if (nextNsURI.equals(nsURI) || resolveFuzzy) {
				result.add(cache.get(nextNsURI));
			}
		}
		return new GenPackageResolveResult(result);
	}
}
