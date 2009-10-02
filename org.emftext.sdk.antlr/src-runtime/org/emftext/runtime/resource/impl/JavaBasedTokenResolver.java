/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.resource.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.ITokenResolver;

/**
 * A base implementation for token resolvers. It tries to resolve lexems using java methods.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 * 
 * @deprecated This class will be removed for release 1.3 of EMFText
 */
public class JavaBasedTokenResolver implements ITokenResolver {
	
	private Map<?, ?> options;
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		if (value == null) {
			return "null";
		}
		return value.toString();
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
					} else if(typeName.equals("char") || java.lang.Character.class.getName().equals(typeName)) {
						if (lexem.length() != 1) {
							result.setErrorMessage("Can convert to single Character only.");
						} else {
							result.setResolvedToken(lexem.charAt(0));
							return;
						}
					}
					else if(typeName.equals("boolean") || java.lang.Boolean.class.getName().equals(typeName)){
						result.setResolvedToken(Boolean.parseBoolean(lexem));
						return;
					}
					else if(typeName.equals("int") || java.lang.Integer.class.getName().equals(typeName)){
						result.setResolvedToken(Integer.parseInt(lexem));
						return;
					}
					else if(typeName.equals("long") || java.lang.Long.class.getName().equals(typeName)){
						result.setResolvedToken(Long.parseLong(lexem));
						return;
					}
					else if(typeName.equals("double") || java.lang.Double.class.getName().equals(typeName)){
						result.setResolvedToken(Double.parseDouble(lexem));
						return;
					}
					else if(typeName.equals("short") || java.lang.Short.class.getName().equals(typeName)){
						result.setResolvedToken(Short.parseShort(lexem));
						return;
					}
					else if(typeName.equals("float") || java.lang.Float.class.getName().equals(typeName)){
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
