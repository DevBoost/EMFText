package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class CsTEXTTokenResolver extends JavaBasedTokenResolver implements ITokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, ITextResource resource) {
		return super.resolve(lexem,feature,container,resource);
	}
}
