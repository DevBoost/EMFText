package org.emftext.sdk;

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

/**
 * A finder that looks up generator packages in the EMF package
 * registry.
 */
public class GenPackageInRegistryFinder implements IGenPackageFinder {
	
	/**
	 * An implementation of the IGenPackageFinderResult that is used to
	 * return generator package found in the EMF registry.
	 */
	private class GenPackageInRegistryFinderResult implements IGenPackageFinderResult {

		private GenPackage genPackage;
		private boolean foundMultiple;
		
		public GenPackageInRegistryFinderResult(GenPackage genPackage, boolean foundMultiple) {
			Assert.isNotNull(genPackage);
			
			this.genPackage = genPackage;
			this.foundMultiple = foundMultiple;
		}
		
		public boolean hasChanged() {
			return false;
		}

		public GenPackage getResult() {
			return genPackage;
		}

		public boolean foundMultiple() {
			return foundMultiple;
		}
	}

	public IGenPackageFinderResult findGenPackage(String nsURI, Resource resource) {
		//search all registered generator models
		GenPackage foundGenPackage = null;
        boolean foundMultiple = false;
		for (URI genModelURI : EcorePlugin.getEPackageNsURIToGenModelLocationMap().values()) {
        	try {
        		final ResourceSet rs = new ResourceSetImpl();
        		Resource genModelResource = rs.getResource(genModelURI, true);
            	final EList<EObject> contents = genModelResource.getContents();
            	if (contents == null || contents.size() == 0) {
            		continue;
            	}
				GenModel genModel = (GenModel) contents.get(0);
            	for(GenPackage genPackage : genModel.getGenPackages()) {
            		if (nsURI.equals(genPackage.getNSURI())) {
            			if (foundGenPackage != null) {
            				foundMultiple = true;
            			}
            			foundGenPackage = genPackage;
            		}
            	}
        	} catch (Exception e ) {
        		EMFTextPlugin.logError("Exception while looking up concrete syntaxes in the registry.", e);
        	}
        }
        if (foundGenPackage == null) {
            return null;
        }
		return new GenPackageInRegistryFinderResult(foundGenPackage, foundMultiple);
	}
}