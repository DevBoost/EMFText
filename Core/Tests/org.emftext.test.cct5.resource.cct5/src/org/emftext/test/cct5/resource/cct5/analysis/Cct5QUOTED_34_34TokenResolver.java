/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Cct5QUOTED_34_34TokenResolver implements org.emftext.test.cct5.resource.cct5.ICct5TokenResolver {
	
	private org.emftext.test.cct5.resource.cct5.analysis.Cct5DefaultTokenResolver defaultTokenResolver = new org.emftext.test.cct5.resource.cct5.analysis.Cct5DefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, org.emftext.test.cct5.resource.cct5.ICct5TokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
