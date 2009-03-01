package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

public class GenPackageDependentElementPackageReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.sdk.concretesyntax.GenPackageDependentElement, GenPackage> {
	
	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override	
	protected void doResolve(String nsURI, GenPackageDependentElement container, EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<GenPackage> result) {
		String locationHint = container.getPackageLocationHint();
		GenPackage genPackage = mmHelper.findGenPackage(getOptions(), container, nsURI, locationHint, (ITextResource) container.eResource());
		if (genPackage == null) {
			result.setErrorMessage("Generator model \"" + nsURI + "\" could not be resolved." + 
					(locationHint == null ? "" : " Maybe " + locationHint + " is wrong?")
			);
		} else {
			result.addMapping(nsURI, genPackage);
		}
	}
	
	@Override	
	protected String doDeResolve(GenPackage element, GenPackageDependentElement container, EReference reference) {
		return element.getNSURI();
	}
}
