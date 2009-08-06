package org.emftext.sdk.concretesyntax.resource.cs.analysis;

public class CsQUOTED_60_62TokenResolver extends org.emftext.runtime.resource.impl.AbstractTokenResolver {
	
	private org.emftext.sdk.concretesyntax.resource.cs.CsDefaultTokenResolver defaultTokenResolver = new org.emftext.sdk.concretesyntax.resource.cs.CsDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result = result.replaceAll(java.util.regex.Pattern.quote("\\"), "\\\\\\\\");
		result = result.replaceAll(java.util.regex.Pattern.quote(">"), "\\\\>");
		result += ">";
		result = "<" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		lexem = lexem.replaceAll(java.util.regex.Pattern.quote("\\>"), ">");
		lexem = lexem.replace("\\\\", "\\");
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
