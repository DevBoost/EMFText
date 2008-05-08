package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.concretesyntax.Import;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;

public class RuleMetaclassProxyResolver extends ProxyResolverImpl {
	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {

		Rule rule       = (Rule) container;
		String classRef = proxy.eProxyURI().fragment();
		
		if (classRef.contains(".")) {
			String p = classRef.split("\\.")[0];
			String c = classRef.split("\\.")[1];
			
			for (Import aImport : rule.getSyntax().getImports()) {
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
			for(GenClass genClass : rule.getSyntax().getPackage().getGenClasses()) {
				if (genClass.getName().equals(classRef)) {
					return genClass;
				}
			}
		}
		return null;
	}

	@Override
	protected String produceErrorMessage(InternalEObject proxy,
			EObject container, EReference reference, TextResource resource) {
		String message = "EClass \"" + proxy.eProxyURI().fragment() + "\" does not exist";
		return message;
	}

}
