package org.reuseware.emftextedit.sdk;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.reuseware.emftextedit.runtime.GenPackageFinder;
import org.reuseware.emftextedit.runtime.IGenPackageFinderResult;
import org.reuseware.emftextedit.runtime.MetamodelManager;
import org.reuseware.emftextedit.runtime.resource.TextResource;

/**
 * An GenPackageFinder that searches for the generator model by removing the
 * file extension ('.cs') from the syntax definition and adding '.genmodel'.
 */
public class GenPackageByNameFinder implements GenPackageFinder {
	public IGenPackageFinderResult findGenPackage(String nsURI,
			TextResource resource) {
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