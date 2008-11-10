package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.Import;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ProxyResolverImpl;

public class ConcreteSyntaxStartSymbolsProxyResolver extends ProxyResolverImpl {

	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {

		ConcreteSyntax cs = (ConcreteSyntax) container;
		String   classRef = proxy.eProxyURI().fragment();
		
		if (cs.getPackage().eIsProxy()) return null;
		
		if (classRef.contains(".")) {
			String p = classRef.split("\\.")[0];
			String c = classRef.split("\\.")[1];
			
			for (Import aImport : cs.getImports()) {
				if (aImport.getPrefix().equals(p)) {
					for(GenClass genClass : aImport.getPackage().getGenClasses()) {
						if (genClass.getName().equals(c)) {
							return genClass;
						}
					}				
				}
			}
		} 
		else {
			for(GenClass genClass : cs.getPackage().getGenClasses()) {
				if (genClass.getName().equals(proxy.eProxyURI().fragment())) {
					return genClass;
				}
			}
		}
		
		return null;
	}

	@Override
	protected String produceResolveErrorMessage(InternalEObject proxy,
			EObject container, EReference reference, TextResource resource) {
		String message = "EClass \"" + proxy.eProxyURI().fragment() + "\" does not exist";
		return message;
	}
	public String deResolve(EObject element, EObject container,EReference reference){
		GenClass genClass = (GenClass)element;
		genClass.getGenPackage().getNSName();
		ConcreteSyntax cs = (ConcreteSyntax) container;
		if(cs.getPackage().getNSName().equals(genClass.getGenPackage().getNSName()))
			return genClass.getName();
		else{
			String prefix = "";
			for (Import aImport : cs.getImports()) {
				if(aImport.getPackage().getNSName().equals(genClass.getGenPackage().getNSName())){
					prefix = aImport.getPrefix()+".";					
				}

			}
			return prefix+genClass.getName();
		}

	}
}
