package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.ResolveResult;
import org.emftext.runtime.resource.TextResource;
import org.emftext.runtime.resource.impl.ReferenceResolverImpl;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

public class ImportPackageReferenceResolver extends ReferenceResolverImpl {

	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy,
			ResolveResult result) {
		GenPackage genPackage = mmHelper.findGenPackage(getOptions(), identifier, (TextResource) container.eResource());
		if (genPackage != null) {
			ConcreteSyntax cs = (ConcreteSyntax)((Import)container).eContainer();
			if(!cs.getPackage().equals(genPackage)&&!cs.getPackage().getNSURI().equals(genPackage.getNSURI()))
				cs.getPackage().getGenModel().getUsedGenPackages().add(genPackage);
			
		}
		if (genPackage == null) {
			result.setErrorMessage("Genarator model \"" + identifier + "\" could not be resolved");
			return;
		}
		result.addMapping(identifier, genPackage);
	}
	
	@Override
	public String deResolve(EObject element, EObject container,EReference reference){
		GenPackage pck = (GenPackage)element;
		return pck.getNSURI();
	}
}
