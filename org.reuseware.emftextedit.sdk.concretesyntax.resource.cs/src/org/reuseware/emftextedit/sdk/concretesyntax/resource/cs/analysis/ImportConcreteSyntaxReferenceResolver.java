package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.reuseware.emftextedit.runtime.resource.ResolveResult;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ReferenceResolverImpl;
import org.reuseware.emftextedit.sdk.MetamodelHelper;
import org.reuseware.emftextedit.sdk.concretesyntax.Import;

public class ImportConcreteSyntaxReferenceResolver extends ReferenceResolverImpl {

	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, ResolveResult result) {
		
		if (!(container instanceof Import)) {
			result.addError(createErrorMessage(identifier));
			return;
		}
		EObject concreteSyntax = mmHelper.findConcreteSyntax(getOptions(), identifier, 
				((Import) container).getPackage(), (TextResource) container.eResource());

		if (concreteSyntax == null) {
			result.addError(createErrorMessage(identifier));
			return;
		}
		result.addMapping(identifier, concreteSyntax);
	}

	private String createErrorMessage(String identifier) {
		return "Concrete syntax definition for prefix \"" + identifier + "\" could not be resolved";
	}
}
