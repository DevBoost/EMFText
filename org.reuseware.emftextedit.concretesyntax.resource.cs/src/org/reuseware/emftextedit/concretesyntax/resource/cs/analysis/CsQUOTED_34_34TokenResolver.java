package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.resource.TokenResolver;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.JavaBasedTokenResolver;

public class CsQUOTED_34_34TokenResolver extends JavaBasedTokenResolver implements TokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		result = "\"" + result;
		result += "\"";
		result = result.replaceAll(java.util.regex.Pattern.quote("\""),"\\\\\"");
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, TextResource resource) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0,lexem.length()-1);
		lexem = lexem.replaceAll("\\\\"+java.util.regex.Pattern.quote("\""),"\"");
		return super.resolve(lexem,feature,container,resource);
	}
}
