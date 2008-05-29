package org.reuseware.emftextedit.resource.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.resource.TokenResolver;
import org.reuseware.emftextedit.resource.TextResource;

/**
 * A base implementation for token resolvers. It tries to resolve lexems by java methods.
 * 
 * @author skarol
 *
 */

public class JavaBasedTokenResolver implements TokenResolver {
	
	private String message = null;
	
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		return value.toString();
	}
	
	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, TextResource resource) {
		
		if(feature instanceof EAttribute){
			if(feature.getEType() instanceof EEnum){
				EEnumLiteral literal = ((EEnum)feature.getEType()).getEEnumLiteralByLiteral(lexem); 
				if(literal!=null){
					return literal.getInstance();					
				}
				else{
					resource.addError("Could not map lexem '"+lexem+"' to enum '"+feature.getEType().getName()+"'." ,container );
					return null;
				}
			}
			else{
				String typeName = feature.getEType().getInstanceClassName();
				try{
					if(typeName.equals("java.lang.String")){
						return lexem;
					}
					else if(typeName.equals("char")){
						if(lexem.length()!=1)
							throw new NumberFormatException("Can convert to single Character only.");
						else
							return lexem.charAt(0);
					}
					else if(typeName.equals("boolean")){
						return Boolean.parseBoolean(lexem);
					}
					else if(typeName.equals("int")){
						return Integer.parseInt(lexem);
					}
					else if(typeName.equals("long")){
						return Long.parseLong(lexem);
					}
					else if(typeName.equals("double")){
						return Double.parseDouble(lexem);
					}
					else if(typeName.equals("short")){
						return Short.parseShort(lexem);
					}
				}
				catch(NumberFormatException e){
					message = "Could not convert '"+lexem+"' to "+typeName+".";
					return null;
				}
				message = "The type "+typeName+" is unknown.";
				return null;
			}

		}
		else{
			return lexem;
		}
		
	}

	@Override
	public String getErrorMessage() {
		return message;
	}

}
