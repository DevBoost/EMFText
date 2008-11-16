package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ProxyResolverImpl;
import org.reuseware.emftextedit.sdk.MetamodelHelper;
import org.reuseware.emftextedit.sdk.concretesyntax.Import;

public class ImportConcreteSyntaxProxyResolver extends ProxyResolverImpl {

	private MetamodelHelper mmHelper = new MetamodelHelper();

	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		return mmHelper.findConcreteSyntax(getOptions(), proxy.eProxyURI().fragment(), 
				((Import)proxy.eContainer()).getPackage(), resource);
	}

	@Override
	protected String produceResolveErrorMessage(InternalEObject proxy,
			EObject container, EReference reference, TextResource resource) {
		String message = "Concrete syntax definition \"" + proxy.eProxyURI().fragment() + "\" for \"" + 
		((Import)proxy.eContainer()).getPackage().getNSURI() + "\" could not be resolved";
		
		return message;
	}
}
