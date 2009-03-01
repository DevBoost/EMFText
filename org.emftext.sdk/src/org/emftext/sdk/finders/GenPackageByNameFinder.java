package org.emftext.sdk.finders;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
		
		ResourceSet rs = new ResourceSetImpl();
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