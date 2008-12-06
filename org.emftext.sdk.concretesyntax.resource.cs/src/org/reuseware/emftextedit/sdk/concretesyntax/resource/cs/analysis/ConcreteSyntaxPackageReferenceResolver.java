package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.reuseware.emftextedit.runtime.resource.ResolveResult;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ReferenceResolverImpl;
import org.reuseware.emftextedit.sdk.MetamodelHelper;

public class ConcreteSyntaxPackageReferenceResolver extends ReferenceResolverImpl {

	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, ResolveResult result) {
		GenPackage genPackage = mmHelper.findGenPackage(getOptions(), identifier, (TextResource) container.eResource());
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
