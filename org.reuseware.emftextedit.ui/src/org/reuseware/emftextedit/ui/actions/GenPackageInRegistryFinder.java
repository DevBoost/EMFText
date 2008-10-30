package org.reuseware.emftextedit.ui.actions;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.reuseware.emftextedit.GenPackageFinder;
import org.reuseware.emftextedit.IGenPackageFinderResult;
import org.reuseware.emftextedit.resource.TextResource;

public class GenPackageInRegistryFinder implements GenPackageFinder {
	
	private class GenPackageInRegistryFinderResult implements IGenPackageFinderResult {

		private GenPackage genPackage;
		
		public GenPackageInRegistryFinderResult(GenPackage genPackage) {
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