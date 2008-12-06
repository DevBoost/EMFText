package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.TextResource;
import org.emftext.runtime.resource.TokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class CsQUOTED_60_62TokenResolver extends JavaBasedTokenResolver implements TokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		result = result.replaceAll(java.util.regex.Pattern.quote(">"),"\\\\>");
		result += ">";
		result = "<" + result;
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, TextResource resource) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0,lexem.length()-1);
		lexem = lexem.replaceAll("\\\\"+java.util.regex.Pattern.quote(">"),">");
		return super.resolve(lexem,feature,container,resource);
	}
}
