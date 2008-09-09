package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.MetamodelManager;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.Import;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

public class ImportPackageProxyResolver extends ProxyResolverImpl {
	
	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		GenPackage p = MetamodelManager.INSTANCE.findGenPackage(proxy.eProxyURI().fragment(), resource);
		ConcreteSyntax cs = (ConcreteSyntax)((Import)container).eContainer();
		cs.getPackage().getGenModel().getUsedGenPackages().add(p);
		return p;
	}
	

	@Override
	protected String produceResolveErrorMessage(InternalEObject proxy,
			EObject container, EReference reference, TextResource resource) {
		String message = "Genarator model \"" + proxy.eProxyURI().fragment() + "\" could not be resolved";
		return message;
	}
	
	public String deResolve(EObject element, EObject container,EReference reference){
		GenPackage pck = (GenPackage)element;
		return pck.getNSURI();
	}

}
