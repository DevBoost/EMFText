/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis;

// A default implementation for token resolvers. It tries to resolve lexems using Java methods.
public class GeneratorconfigDefaultTokenResolver implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver {

	private java.util.Map<?, ?> options;

	public String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (value == null) {
			return "null";
		}
		return value.toString();
	}

	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result) {

		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			if (feature.getEType() instanceof org.eclipse.emf.ecore.EEnum) {
				org.eclipse.emf.ecore.EEnumLiteral literal = ((org.eclipse.emf.ecore.EEnum)feature.getEType()).getEEnumLiteralByLiteral(lexem);
				if (literal != null) {
					result.setResolvedToken(literal.getInstance());
					return;
				} else {
					result.setErrorMessage("Could not map lexem '"+lexem+"' to enum '"+feature.getEType().getName()+"'.");
					return;
				}
			} else {
				String typeName = feature.getEType().getInstanceClassName();
				try {
					if (typeName.equals(java.lang.String.class.getName())) {
						result.setResolvedToken(lexem);
						return;
					} else if (typeName.equals("char") || java.lang.Character.class.getName().equals(typeName)) {
						if (lexem.length() != 1) {
							result.setErrorMessage("Can convert to single Character only.");
						} else {
							result.setResolvedToken(lexem.charAt(0));
							return;
						}
					}
					else if (typeName.equals("boolean") || java.lang.Boolean.class.getName().equals(typeName)){
						result.setResolvedToken(Boolean.parseBoolean(lexem) || feature.getName().equals(lexem));
						return;
					}
					else if (typeName.equals("int") || java.lang.Integer.class.getName().equals(typeName)){
						result.setResolvedToken(Integer.parseInt(lexem));
						return;
					}
					else if (typeName.equals("long") || java.lang.Long.class.getName().equals(typeName)){
						result.setResolvedToken(Long.parseLong(lexem));
						return;
					}
					else if (typeName.equals("double") || java.lang.Double.class.getName().equals(typeName)){
						result.setResolvedToken(Double.parseDouble(lexem));
						return;
					}
					else if (typeName.equals("short") || java.lang.Short.class.getName().equals(typeName)){
						result.setResolvedToken(Short.parseShort(lexem));
						return;
					}
					else if (typeName.equals("float") || java.lang.Float.class.getName().equals(typeName)){
						result.setResolvedToken(Float.parseFloat(lexem));
						return;
					}
				} catch (NumberFormatException e) {
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

	public void setOptions(java.util.Map<?, ?> options) {
		this.options = options;
	}

	public java.util.Map<?, ?> getOptions() {
		return options;
	}
}
