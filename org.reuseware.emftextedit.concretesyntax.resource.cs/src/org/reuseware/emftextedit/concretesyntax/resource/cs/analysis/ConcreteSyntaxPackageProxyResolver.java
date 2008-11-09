package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.runtime.MetamodelManager;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ProxyResolverImpl;

public class ConcreteSyntaxPackageProxyResolver extends ProxyResolverImpl {


	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		return MetamodelManager.INSTANCE.findGenPackage(proxy.eProxyURI().fragment(), resource);
	}

	@Override
	protected String produceResolveErrorMessage(InternalEObject proxy,
			EObject container, EReference reference, TextResource resource) {
		String message = "Generator model \"" + proxy.eProxyURI().fragment() + "\" could not be resolved";
		return message;
	}
	
	public String deResolve(EObject element, EObject container,EReference reference){
		GenPackage pck = (GenPackage)element;
		return pck.getNSURI();
	}
}
