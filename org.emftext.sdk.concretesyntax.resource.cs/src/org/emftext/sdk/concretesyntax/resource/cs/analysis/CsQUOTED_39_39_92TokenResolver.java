package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver;

public class CsQUOTED_39_39_92TokenResolver implements ICsTokenResolver {
	
	private CsDefaultTokenResolver defaultTokenResolver = new CsDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result = result.replace("\\", "\\\\");
		result = result.replace("'", "\\'");
		result += "'";
		result = "'" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ICsTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		lexem = lexem.replace("\\'", "'");
		lexem = lexem.replace("\\\\", "\\");
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
