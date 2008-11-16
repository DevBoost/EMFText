package org.reuseware.emftextedit.sdk;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.reuseware.emftextedit.runtime.resource.TextResource;

public class GenPackageInRegistryFinder implements IGenPackageFinder {
	
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

	public IGenPackageFinderResult findGenPackage(String nsURI, TextResource resource) {
		final ResourceSet rs = new ResourceSetImpl();
		//search all registered generator models
        for(URI genModelURI : EcorePlugin.getEPackageNsURIToGenModelLocationMap().values()) {
        	try {
        		Resource genModelResource = rs.getResource(genModelURI, true);
            	GenModel genModel = (GenModel) genModelResource.getContents().get(0);
            	for(GenPackage genPackage : genModel.getGenPackages()) {
            		if (nsURI.equals(genPackage.getNSURI())) {
            			return new GenPackageInRegistryFinderResult(genPackage);
            		}
            	}
        	} catch (Exception e ) {
        		//FIXME print exception into error log
        	}
        }
        return null;
	}
}