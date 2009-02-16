package org.emftext.runtime.resource.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.ITokenResolver;

/**
 * A base implementation for token resolvers. It tries to resolve lexems using java methods.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class JavaBasedTokenResolver implements ITokenResolver {
	
	private Map<?, ?> options;
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		if (value == null) {
			return "null";
		}
		return value.toString();
	}
	
	// TODO mseifert remove these two methods
	public Object resolve(String lexem, EStructuralFeature feature,
			EObject container, ITextResource resource) {

		ITokenResolveResult result = new TokenResolveResult();
		resolve(lexem, feature, result);
		return result.getResolvedToken();
	}

	public String getErrorMessage() {
		return null;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, ITokenResolveResult result) {
		
		if (feature instanceof EAttribute) {
			if (feature.getEType() instanceof EEnum) {
				EEnumLiteral literal = ((EEnum)feature.getEType()).getEEnumLiteralByLiteral(lexem); 
				if (literal!=null) {
					result.setResolvedToken(literal.getInstance());
					return;
				} else {
					result.setErrorMessage("Could not map lexem '"+lexem+"' to enum '"+feature.getEType().getName()+"'.");
					return;
				}
			} else {
				String typeName = feature.getEType().getInstanceClassName();
				try {
					if(typeName.equals(java.lang.String.class.getName())) {
						result.setResolvedToken(lexem);
						return;
					} else if(typeName.equals("char")) {
						if (lexem.length() != 1) {
							result.setErrorMessage("Can convert to single Character only.");
						} else {
							result.setResolvedToken(lexem.charAt(0));
							return;
						}
					}
					else if(typeName.equals("boolean")){
						result.setResolvedToken(Boolean.parseBoolean(lexem));
						return;
					}
					else if(typeName.equals("int")){
						result.setResolvedToken(Integer.parseInt(lexem));
						return;
					}
					else if(typeName.equals("long")){
						result.setResolvedToken(Long.parseLong(lexem));
						return;
					}
					else if(typeName.equals("double")){
						result.setResolvedToken(Double.parseDouble(lexem));
						return;
					}
					else if(typeName.equals("short")){
						result.setResolvedToken(Short.parseShort(lexem));
						return;
					}
					else if(typeName.equals("float")){
						result.setResolvedToken(Float.parseFloat(lexem));
						return;
					}
				}
				catch(NumberFormatException e){
					result.setErrorMessage("Could not convert '"+lexem+"' to "+typeName+".");
					return;
				}
				result.setErrorMessage("The type "+typeName+" is unknown.");
				return;
			}
		} else {
			result.setResolvedToken(lexem);
			return;
		}
	}

	public void setOptions(Map<?, ?> options) {
		this.options = options;
	}

	public Map<?, ?> getOptions() {
		return options;
	}
}
