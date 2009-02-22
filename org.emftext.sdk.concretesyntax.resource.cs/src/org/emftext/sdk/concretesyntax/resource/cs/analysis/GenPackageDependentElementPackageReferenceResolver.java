package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.MetamodelHelper;

public class GenPackageDependentElementPackageReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.sdk.concretesyntax.GenPackageDependentElement, GenPackage> {
	
	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override	
	protected void doResolve(java.lang.String nsURI, org.emftext.sdk.concretesyntax.GenPackageDependentElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		String locationHint = container.getPackageLocationHint();
		GenPackage genPackage = mmHelper.findGenPackage(getOptions(), container, nsURI, locationHint, (ITextResource) container.eResource());
		if (genPackage == null) {
			result.setErrorMessage("Generator model \"" + nsURI + "\" could not be resolved");
		} else {
			/*
			if (genPackage != null) {
				ConcreteSyntax cs = (ConcreteSyntax) container.eContainer();
				if(!cs.getPackage().equals(genPackage)&&!cs.getPackage().getNSURI().equals(genPackage.getNSURI())) {
					cs.getPackage().getGenModel().getUsedGenPackages().add(genPackage);
				}
			}
 			*/
			result.addMapping(nsURI, genPackage);
		}
	}
	
	@Override	
	protected java.lang.String doDeResolve(GenPackage element, org.emftext.sdk.concretesyntax.GenPackageDependentElement container, org.eclipse.emf.ecore.EReference reference) {
		return element.getNSURI();
	}
}
