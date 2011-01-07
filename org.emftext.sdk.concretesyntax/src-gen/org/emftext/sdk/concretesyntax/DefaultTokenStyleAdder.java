/**
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany 
 *       - initial API and implementation
 * 
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Token Style Adder</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getDefaultTokenStyleAdder()
 * @model
 * @generated
 */
public interface DefaultTokenStyleAdder extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model allStylesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t// add default styles\r\n\t\taddTokenStylesForKeywords(syntax, allStyles);\r\n\r\n\t\taddTokenStylesForQuotedTokens(syntax, allStyles);\r\n\r\n\t\taddTokenStylesForComments(syntax, allStyles);\r\n'"
	 * @generated
	 */
	void addDefaultTokenStyles(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model allStylesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t/**\r\n\t\t * All CsStrings that match this regular expression will be recognized\r\n\t\t * as keywords and a default token style (purple and bold face font) \r\n\t\t * will be assigned.\r\n\t\t \052/\r\n\t\tfinal  java.lang.String KEYWORD_REGEX = \"([a-z]|[A-Z])|(([a-z]|[A-Z]|[_])([a-z]|[A-Z]|[:]|[-]|[_])+)\";\r\n\r\n\t\tfinal  java.util.regex.Pattern KEYWORD_PATTERN =  java.util.regex.Pattern.compile(KEYWORD_REGEX);\r\n\r\n\t\tfinal  java.lang.String KEYWORD_COLOR = \"800055\";\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : syntax.getAllRules()) {\r\n\t\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.CsString> csStrings = getAllKeywords(rule);\r\n\t\t\tfor ( org.emftext.sdk.concretesyntax.CsString csString : csStrings) {\r\n\t\t\t\tif (KEYWORD_PATTERN.matcher(csString.getValue()).matches()) {\r\n\t\t\t\t\t org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\r\n\t\t\t\t\tnewStyle.setRgb(KEYWORD_COLOR);\r\n\t\t\t\t\tnewStyle.getTokenNames().add(csString.getValue());\r\n\t\t\t\t\tnewStyle.getFontStyles().add( org.emftext.sdk.concretesyntax.FontStyle.BOLD);\r\n\t\t\t\t\tsyntax.addTokenStyle(allStyles, newStyle);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n'"
	 * @generated
	 */
	void addTokenStylesForKeywords(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model allStylesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t java.lang.String QUOTED_TOKEN_COLOR = \"2A00FF\";\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : syntax.getAllRules()) {\r\n\t\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes> placeholders = getAllPlaceholdersInQuotes(rule);\r\n\t\t\tfor ( org.emftext.sdk.concretesyntax.PlaceholderInQuotes placeholder : placeholders) {\r\n\t\t\t\t org.emftext.sdk.concretesyntax.ReferencableTokenDefinition token = placeholder.getToken();\r\n\t\t\t\tif (token == null) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\t\t\t\t java.lang.String tokenName = token.getName();\r\n\r\n\t\t\t\t org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\r\n\t\t\t\tnewStyle.setRgb(QUOTED_TOKEN_COLOR);\r\n\t\t\t\tnewStyle.getTokenNames().add(tokenName);\r\n\t\t\t\tsyntax.addTokenStyle(allStyles, newStyle);\r\n\t\t\t}\r\n\t\t}\r\n'"
	 * @generated
	 */
	void addTokenStylesForQuotedTokens(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tfinal  java.lang.String SL_COMMENT = \"\'//\'(~(\'\\n\'|\'\\r\'|\'\\uffff\'))*\";\r\n\r\n\t\tfinal  java.lang.String ML_COMMENT = \"\'/*\'.*\'\052/\'\";\r\n\r\n\t\treturn SL_COMMENT.equals(regex) || ML_COMMENT.equals(regex);\r\n'"
	 * @generated
	 */
	boolean isCommentPattern(String regex);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model allStylesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tfinal  java.lang.String COMMENT_COLOR = \"3F805D\";\r\n\r\n\t\t java.util.Collection< org.emftext.sdk.concretesyntax.CompleteTokenDefinition> tokens = syntax.getActiveTokens();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.CompleteTokenDefinition tokenDefinition : tokens) {\r\n\t\t\t java.lang.String regex = tokenDefinition.getRegex();\r\n\t\t\tif (isCommentPattern(regex)) {\r\n\t\t\t\t org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\r\n\t\t\t\tnewStyle.setRgb(COMMENT_COLOR);\r\n\t\t\t\tnewStyle.getTokenNames().add(tokenDefinition.getName());\r\n\t\t\t\tsyntax.addTokenStyle(allStyles, newStyle);\r\n\t\t\t}\r\n\t\t}\r\n'"
	 * @generated
	 */
	void addTokenStylesForComments(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.CsString> allKeywords = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.CsString>();\r\n\r\n\t\t org.eclipse.emf.common.util.TreeIterator< org.eclipse.emf.ecore.EObject> iterator = rule.eAllContents();\r\n\r\n\t\twhile (iterator.hasNext()) {\r\n\t\t\t org.eclipse.emf.ecore.EObject next = iterator.next();\r\n\t\t\tif (next instanceof  org.emftext.sdk.concretesyntax.CsString) {\r\n\t\t\t\tallKeywords.add(( org.emftext.sdk.concretesyntax.CsString) next);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn allKeywords;\r\n'"
	 * @generated
	 */
	EList<CsString> getAllKeywords(Rule rule);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes> allPlaceholders = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes>();\r\n\r\n\t\t org.eclipse.emf.common.util.TreeIterator< org.eclipse.emf.ecore.EObject> iterator = rule.eAllContents();\r\n\r\n\t\twhile (iterator.hasNext()) {\r\n\t\t\t org.eclipse.emf.ecore.EObject next = iterator.next();\r\n\t\t\tif (next instanceof  org.emftext.sdk.concretesyntax.PlaceholderInQuotes) {\r\n\t\t\t\tallPlaceholders.add(( org.emftext.sdk.concretesyntax.PlaceholderInQuotes) next);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn allPlaceholders;\r\n'"
	 * @generated
	 */
	EList<PlaceholderInQuotes> getAllPlaceholdersInQuotes(Rule rule);

} // DefaultTokenStyleAdder
