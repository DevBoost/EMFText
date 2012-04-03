/**
 * Copyright (c) 2006-2011 
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='addTokenStylesForKeywords(syntax,allStyles);\r\naddTokenStylesForQuotedTokens(syntax,allStyles);\r\naddTokenStylesForComments(syntax,allStyles);\r\naddTokenStyleForTaskItems(syntax,allStyles);\r\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.util.regex.Pattern KEYWORD_PATTERN = java.util.regex.Pattern .compile(getKeywordRegex());\r\nfinal java.lang.String KEYWORD_COLOR = \"800055\";\r\nfor ( org.emftext.sdk.concretesyntax.Rule rule:syntax.getAllRules()) {\r\n\torg.eclipse.emf.common.util.EList < java.lang.String >keywords = getAllKeywords(rule);\r\n\tfor ( java.lang.String keyword:keywords) {\r\n\t\tif (KEYWORD_PATTERN.matcher(keyword).matches()) {\r\n\t\t\torg.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle() ;\r\n\t\t\tnewStyle.setRgb(KEYWORD_COLOR);\r\n\t\t\tnewStyle.getTokenNames().add(keyword);\r\n\t\t\tnewStyle.getFontStyles().add( org.emftext.sdk.concretesyntax.FontStyle .BOLD);\r\n\t\t\tsyntax.addTokenStyle(allStyles,newStyle);\r\n\t\t}\r\n\t}\r\n}\r\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='java.lang.String QUOTED_TOKEN_COLOR = \"2A00FF\";\r\nfor ( org.emftext.sdk.concretesyntax.Rule rule:syntax.getAllRules()) {\r\n\torg.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.PlaceholderInQuotes >placeholders = getAllPlaceholdersInQuotes(rule);\r\n\tfor ( org.emftext.sdk.concretesyntax.PlaceholderInQuotes placeholder:placeholders) {\r\n\t\torg.emftext.sdk.concretesyntax.ReferencableTokenDefinition token = placeholder.getToken();\r\n\t\tif (token == null) {\r\n\t\t\tcontinue;\r\n\t\t}\r\n\t\tjava.lang.String tokenName = token.getName();\r\n\t\torg.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle() ;\r\n\t\tnewStyle.setRgb(QUOTED_TOKEN_COLOR);\r\n\t\tnewStyle.getTokenNames().add(tokenName);\r\n\t\tsyntax.addTokenStyle(allStyles,newStyle);\r\n\t}\r\n}\r\n'"
	 * @generated
	 */
	void addTokenStylesForQuotedTokens(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.lang.String SL_COMMENT = \"\\\'//\\\'(~(\\\'\\n\\\'|\\\'\\r\\\'|\\\'\357\277\277\\\'))*\";\r\nfinal java.lang.String ML_COMMENT = \"\\\'/*\\\'.*\\\'\052/\\\'\";\r\nreturn SL_COMMENT.equals(regex)||ML_COMMENT.equals(regex);\r\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.lang.String COMMENT_COLOR = \"3F805D\";\r\njava.util.Collection < org.emftext.sdk.concretesyntax.CompleteTokenDefinition >tokens = syntax.getActiveTokens();\r\nfor ( org.emftext.sdk.concretesyntax.CompleteTokenDefinition tokenDefinition:tokens) {\r\n\tjava.lang.String regex = tokenDefinition.getRegex();\r\n\tif (isCommentPattern(regex)) {\r\n\t\torg.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle() ;\r\n\t\tnewStyle.setRgb(COMMENT_COLOR);\r\n\t\tnewStyle.getTokenNames().add(tokenDefinition.getName());\r\n\t\tsyntax.addTokenStyle(allStyles,newStyle);\r\n\t}\r\n}\r\n'"
	 * @generated
	 */
	void addTokenStylesForComments(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < java.lang.String >allKeywords = new org.eclipse.emf.common.util.BasicEList < java.lang.String >();\r\norg.eclipse.emf.common.util.TreeIterator < org.eclipse.emf.ecore.EObject >iterator = rule.eAllContents();\r\nwhile (iterator.hasNext()) {\r\n\torg.eclipse.emf.ecore.EObject next = iterator.next();\r\n\tif (next instanceof org.emftext.sdk.concretesyntax.CsString ) {\r\n\t\tallKeywords.add((( org.emftext.sdk.concretesyntax.CsString ) next).getValue());\r\n\t}else if (next instanceof org.emftext.sdk.concretesyntax.BooleanTerminal ) {\r\n\t\tallKeywords.add((( org.emftext.sdk.concretesyntax.BooleanTerminal ) next).getTrueLiteral());\r\n\t\tallKeywords.add((( org.emftext.sdk.concretesyntax.BooleanTerminal ) next).getFalseLiteral());\r\n\t}else if (next instanceof org.emftext.sdk.concretesyntax.EnumTerminal ) {\r\n\t\torg.emftext.sdk.concretesyntax.EnumTerminal enumTerminal = ( org.emftext.sdk.concretesyntax.EnumTerminal ) next;\r\n\t\tfor ( org.emftext.sdk.concretesyntax.EnumLiteralTerminal literal:enumTerminal.getLiterals()) {\r\n\t\t\tallKeywords.add(literal.getText());\r\n\t\t}\r\n\t}\r\n}\r\nreturn allKeywords;\r\n'"
	 * @generated
	 */
	EList<String> getAllKeywords(Rule rule);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.PlaceholderInQuotes >allPlaceholders = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.PlaceholderInQuotes >();\r\norg.eclipse.emf.common.util.TreeIterator < org.eclipse.emf.ecore.EObject >iterator = rule.eAllContents();\r\nwhile (iterator.hasNext()) {\r\n\torg.eclipse.emf.ecore.EObject next = iterator.next();\r\n\tif (next instanceof org.emftext.sdk.concretesyntax.PlaceholderInQuotes ) {\r\n\t\tallPlaceholders.add(( org.emftext.sdk.concretesyntax.PlaceholderInQuotes ) next);\r\n\t}\r\n}\r\nreturn allPlaceholders;\r\n'"
	 * @generated
	 */
	EList<PlaceholderInQuotes> getAllPlaceholdersInQuotes(Rule rule);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.lang.String KEYWORD_REGEX = \"([a-z]|[A-Z])|(([a-z]|[A-Z]|[_])([a-z]|[A-Z]|[:]|[-]|[_][\\\\s])+)\";\r\nreturn KEYWORD_REGEX;\r\n'"
	 * @generated
	 */
	String getKeywordRegex();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model allStylesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.lang.String TASK_ITEM_COLOR = \"7F9FBF\";\r\norg.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle() ;\r\nnewStyle.setRgb(TASK_ITEM_COLOR);\r\nnewStyle.getFontStyles().add( org.emftext.sdk.concretesyntax.FontStyle .BOLD);\r\nnewStyle.getTokenNames().add(\"TASK_ITEM\");\r\nsyntax.addTokenStyle(allStyles,newStyle);\r\n'"
	 * @generated
	 */
	void addTokenStyleForTaskItems(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

} // DefaultTokenStyleAdder
