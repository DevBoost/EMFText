package org.emftext.sdk.finders;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.MetamodelManager;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A GenPackageFinder that searches for generator models by removing the
 * file extension ('.cs') from the syntax definition and adding '.genmodel'.
 */
public class GenPackageByNameFinder implements IGenPackageFinder {
	
	public IGenPackageFinderResult findGenPackage(String nsURI,
			String locationHint, GenPackageDependentElement container, ITextResource resource) {
		ResourceSet rs = new ResourceSetImpl();
		URI resourceURI = resource.getURI();
		resourceURI = resourceURI.trimFileExtension();
		URI genModelURI = resourceURI.appendFileExtension("genmodel");
		GenPackage genPackage = null;
		try {
			Resource genModelResource = rs.getResource(genModelURI, true);
			GenModel genModel = (GenModel) genModelResource.getContents().get(0);
			Map<String, GenPackage> genPackages = MetamodelManager
					.getGenPackages(genModel);
			genPackage = genPackages.get(nsURI);
		} catch (Exception e) {}
		
		final GenPackage result = genPackage;

		return new IGenPackageFinderResult() {

			public GenPackage getResult() {
				return result;
			}

			public boolean hasChanged() {
				return false;
			}
		};
	}
}