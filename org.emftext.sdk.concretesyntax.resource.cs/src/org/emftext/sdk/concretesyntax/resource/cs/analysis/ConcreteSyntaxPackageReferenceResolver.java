package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class ConcreteSyntaxPackageReferenceResolver extends AbstractReferenceResolver<ConcreteSyntax> {

	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override
	protected void doResolve(String identifier, ConcreteSyntax container,
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult result) {
		GenPackage genPackage = mmHelper.findGenPackage(getOptions(), container, identifier, (ITextResource) container.eResource());
		if (genPackage == null) {
			result.setErrorMessage("Generator model \"" + identifier + "\" could not be resolved");
		} else {
			result.addMapping(identifier, genPackage);
		}
	}

	@Override
	public String deResolve(EObject element, ConcreteSyntax container,EReference reference){
		GenPackage pck = (GenPackage)element;
		return pck.getNSURI();
	}
}
