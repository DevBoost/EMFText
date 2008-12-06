package org.emftext.sdk;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * An GenPackageFinder that searches for the generator model by removing the
 * file extension ('.cs') from the syntax definition and adding '.genmodel'.
 */
public class GenPackageByNameFinder implements IGenPackageFinder {
	public IGenPackageFinderResult findGenPackage(String nsURI,
			Resource resource) {
		ResourceSet rs = new ResourceSetImpl();
		URI resourceURI = resource.getURI();
		resourceURI = resourceURI.trimFileExtension();
		URI genModelURI = resourceURI.appendFileExtension("genmodel");
		Resource genModelResource = rs.getResource(genModelURI, true);
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		Map<String, GenPackage> genPackages = MetamodelManager
				.getGenPackages(genModel);
		final GenPackage result = genPackages.get(nsURI);

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