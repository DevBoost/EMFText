package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.Import;

public class ImportConcreteSyntaxReferenceResolver extends AbstractReferenceResolver<Import> {

	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override
	protected void doResolve(String identifier, Import container,
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult result) {
		
		EObject concreteSyntax = mmHelper.findConcreteSyntax(getOptions(), identifier, container,  
				container.getPackage(), (ITextResource) container.eResource());

		if (concreteSyntax == null) {
			result.setErrorMessage(createErrorMessage(identifier));
			return;
		}
		result.addMapping(identifier, concreteSyntax);
	}

	private String createErrorMessage(String identifier) {
		return "Concrete syntax definition for prefix \"" + identifier + "\" could not be resolved";
	}
}
