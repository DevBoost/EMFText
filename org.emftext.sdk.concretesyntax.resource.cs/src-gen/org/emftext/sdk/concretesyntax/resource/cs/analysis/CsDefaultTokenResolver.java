/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.analysis;

/**
 * A default implementation for token resolvers. It tries to resolve lexems using
 * Java methods.
 */
public class CsDefaultTokenResolver implements org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver {
	
	private java.util.Map<?, ?> options;
	private boolean escapeKeywords = true;
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (value == null) {
			return "null";
		}
		String text = value.toString();
		if (escapeKeywords) {
			// Escape keywords if required
			for (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword keyword : org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.KEYWORDS) {
				String keywordValue = keyword.getValue();
				if (text.endsWith(keywordValue)) {
					String prefix = text.substring(0, text.length() - keywordValue.length());
					if (prefix.matches("_*")) {
						text = "_" + text;
						break;
					}
				}
			}
		}
		return text;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result) {
		if (escapeKeywords && lexem.startsWith("_")) {
			// Unescape keywords if required
			for (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword keyword : org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.KEYWORDS) {
				String keywordValue = keyword.getValue();
				if (lexem.endsWith(keywordValue)) {
					String prefix = lexem.substring(0, lexem.length() - keywordValue.length());
					if (prefix.matches("_+")) {
						lexem = lexem.substring(1);
						break;
					}
				}
			}
		}
		
		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			if (feature.getEType() instanceof org.eclipse.emf.ecore.EEnum) {
				org.eclipse.emf.ecore.EEnumLiteral literal = ((org.eclipse.emf.ecore.EEnum) feature.getEType()).getEEnumLiteralByLiteral(lexem);
				if (literal != null) {
					result.setResolvedToken(literal.getInstance());
					return;
				} else {
					result.setErrorMessage("Could not map lexem '" + lexem + "' to enum '" + feature.getEType().getName() + "'.");
					return;
				}
			} else if (feature.getEType() instanceof org.eclipse.emf.ecore.EDataType) {
				try {
					result.setResolvedToken(org.eclipse.emf.ecore.util.EcoreUtil.createFromString((org.eclipse.emf.ecore.EDataType) feature.getEType(), lexem));
				} catch (Exception e) {
					result.setErrorMessage("Could not convert '" + lexem + "' to '" + feature.getEType().getName() + "'.");
				}
				String typeName = feature.getEType().getInstanceClassName();
				if (typeName.equals("boolean") || java.lang.Boolean.class.getName().equals(typeName)) {
					String featureName = feature.getName();
					boolean featureNameMatchesLexem = featureName.equals(lexem);
					if (featureName.length() > 2 && featureName.startsWith("is")) {
						featureNameMatchesLexem |= (featureName.substring(2, 3).toLowerCase() + featureName.substring(3)).equals(lexem);
					}
					result.setResolvedToken(Boolean.parseBoolean(lexem) || featureNameMatchesLexem);
					return;
				}
			} else {
				assert false;
			}
		} else {
			result.setResolvedToken(lexem);
			return;
		}
	}
	
	/**
	 * This method can be used to disable automatic escaping and unescaping of tokens
	 * that match keywords of the syntax.
	 */
	public void setEscapeKeywords(boolean escapeKeywords) {
		this.escapeKeywords = escapeKeywords;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		this.options = options;
	}
	
	public java.util.Map<?, ?> getOptions() {
		return options;
	}
	
}
