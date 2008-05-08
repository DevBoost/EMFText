package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.concretesyntax.Import;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;

public class ImportConcreteSyntaxProxyResolver extends ProxyResolverImpl {

	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		return MetamodelManager.INSTANCE.findConcreteSyntax(proxy.eProxyURI().fragment(), 
				((Import)proxy.eContainer()).getPackage(), resource);
	}

	@Override
	protected String produceErrorMessage(InternalEObject proxy,
			EObject container, EReference reference, TextResource resource) {
		String message = "Concrete syntax definition \"" + proxy.eProxyURI().fragment() + "\" for \"" + 
		((Import)proxy.eContainer()).getPackage().getNSURI() + "\" could not be resolved";
		
		return message;
	}
}
