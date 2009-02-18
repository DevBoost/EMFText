package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.MetamodelHelper;

public class GenPackageDependentElementPackageReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.sdk.concretesyntax.GenPackageDependentElement> {
	
	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.sdk.concretesyntax.GenPackageDependentElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		GenPackage genPackage = mmHelper.findGenPackage(getOptions(), container, identifier, (ITextResource) container.eResource());
		if (genPackage == null) {
			result.setErrorMessage("Generator model \"" + identifier + "\" could not be resolved");
		} else {
			/*
			if (genPackage != null) {
				ConcreteSyntax cs = (ConcreteSyntax) container.eContainer();
				if(!cs.getPackage().equals(genPackage)&&!cs.getPackage().getNSURI().equals(genPackage.getNSURI())) {
					cs.getPackage().getGenModel().getUsedGenPackages().add(genPackage);
				}
			}
 			*/
			result.addMapping(identifier, genPackage);
		}
	}
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.emftext.sdk.concretesyntax.GenPackageDependentElement container, org.eclipse.emf.ecore.EReference reference) {
		GenPackage pck = (GenPackage)element;
		return pck.getNSURI();
	}
}
