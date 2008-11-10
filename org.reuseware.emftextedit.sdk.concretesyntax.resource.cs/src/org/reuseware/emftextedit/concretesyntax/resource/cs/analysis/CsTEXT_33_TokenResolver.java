package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.TokenResolver;
import org.reuseware.emftextedit.runtime.resource.impl.JavaBasedTokenResolver;

public class CsTEXT_33_TokenResolver extends JavaBasedTokenResolver implements TokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		result = "!" + result;
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, TextResource resource) {
		lexem = lexem.substring(1);
		return super.resolve(lexem,feature,container,resource);
	}
}
