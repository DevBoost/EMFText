package org.emftext.sdk.finders;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A finder that looks up generator packages in the EMF package
 * registry.
 * 
 * TODO this finder does not work properly
 */
public class GenPackageInRegistryFinder implements IGenPackageFinder {
	
	private Map<String, GenPackageInRegistryFinderResult> cache = new HashMap<String, GenPackageInRegistryFinderResult>();
	private Set<URI> defectGenModelURIs = new HashSet<URI>();
	
	/**
	 * An implementation of the IGenPackageFinderResult that is used to
	 * return generator package found in the EMF registry.
	 */
	private class GenPackageInRegistryFinderResult implements IGenPackageFinderResult {

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
		//search all registered generator models
		final Map<String, URI> packageNsURIToGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		for (String nextNS : packageNsURIToGenModelLocationMap.keySet()) {
			URI genModelURI = packageNsURIToGenModelLocationMap.get(nextNS);
			if (defectGenModelURIs.contains(genModelURI)) {
				continue;
			}
	    	try {
	    		final ResourceSet rs = new ResourceSetImpl();
        		Resource genModelResource = rs.getResource(genModelURI, false);
        		if (genModelResource == null) {
        			defectGenModelURIs.add(genModelURI);
        			continue;
        		}
            	final EList<EObject> contents = genModelResource.getContents();
            	if (contents == null || contents.size() == 0) {
            		continue;
            	}
				GenModel genModel = (GenModel) contents.get(0);
            	for (GenPackage genPackage : genModel.getGenPackages()) {
        			if (genPackage != null) {
	            		if (nsURI.equals(genPackage.getNSURI())) {
	            			final GenPackageInRegistryFinderResult result = new GenPackageInRegistryFinderResult(genPackage);
							cache.put(nsURI, result);
							return result;
	            		}
        			}
            	}
	    	} catch (Exception e ) {
	    		defectGenModelURIs.add(genModelURI);
	    		EMFTextPlugin.logError("Exception while looking up concrete syntaxes in the registry.", e);
	    	}
        }
		cache.put(nsURI, null);
		return null;
	}
}