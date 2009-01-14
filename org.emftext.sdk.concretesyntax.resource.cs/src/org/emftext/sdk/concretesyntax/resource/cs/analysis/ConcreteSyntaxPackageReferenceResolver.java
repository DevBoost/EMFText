package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.MetamodelHelper;

public class ConcreteSyntaxPackageReferenceResolver extends AbstractReferenceResolver {

	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, IResolveResult result) {
		GenPackage genPackage = mmHelper.findGenPackage(getOptions(), identifier, (ITextResource) container.eResource());
		if (genPackage == null) {
			result.setErrorMessage("Generator model \"" + identifier + "\" could not be resolved");
		} else {
			result.addMapping(identifier, genPackage);
		}
	}

	@Override
	public String deResolve(EObject element, EObject container,EReference reference){
		GenPackage pck = (GenPackage)element;
		return pck.getNSURI();
	}
}
