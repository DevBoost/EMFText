package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

public class ImportPackageReferenceResolver extends AbstractReferenceResolver<Import> {

	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override
	protected void doResolve(String identifier, Import container,
			EReference reference, int position, boolean resolveFuzzy,
			IReferenceResolveResult result) {
		GenPackage genPackage = mmHelper.findGenPackage(getOptions(), identifier, (ITextResource) container.eResource());
		if (genPackage != null) {
			ConcreteSyntax cs = (ConcreteSyntax) container.eContainer();
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
	public String deResolve(EObject element, Import container,EReference reference){
		GenPackage pck = (GenPackage)element;
		return pck.getNSURI();
	}
}
