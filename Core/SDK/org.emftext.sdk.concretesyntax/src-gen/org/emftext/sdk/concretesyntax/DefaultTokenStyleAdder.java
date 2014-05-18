/**
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='// add default styles\naddTokenStylesForKeywords(syntax, allStyles);\naddTokenStylesForQuotedTokens(syntax, allStyles);\naddTokenStylesForComments(syntax, allStyles);\naddTokenStyleForTaskItems(syntax, allStyles);'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.util.regex.Pattern KEYWORD_PATTERN = java.util.regex.Pattern.compile(getKeywordRegex());\nfinal java.lang.String KEYWORD_COLOR = \"800055\";\n\nfor ( org.emftext.sdk.concretesyntax.Rule rule : syntax.getAllRules()) {\n\torg.eclipse.emf.common.util.EList< java.lang.String> keywords = getAllKeywords(rule);\n\t\n\tfor ( java.lang.String keyword : keywords) {\n\t\tif (KEYWORD_PATTERN.matcher(keyword).matches()) {\n\t\t\t//TODO CS: Replace by rule if required\n\t\t\tboolean caseInsensitiveTokens = true;\n\t\t\t//TODO: This doubles logic of ANTLRGrammarGenerator.getKeywordPseudoTokenName()\tbut cannot reference class\n\t\t\tjava.lang.String keywordName = caseInsensitiveTokens ? \"KEYWORD_\" + keyword.toUpperCase() : keyword;\n\t\t\t\n\t\t\torg.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\n\t\t\tnewStyle.setRgb(KEYWORD_COLOR);\n\t\t\tnewStyle.getTokenNames().add(keywordName);\n\t\t\tnewStyle.getFontStyles().add( org.emftext.sdk.concretesyntax.FontStyle.BOLD);\n\t\t\tsyntax.addTokenStyle(allStyles, newStyle);\n\t\t}\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='java.lang.String QUOTED_TOKEN_COLOR = \"2A00FF\";\nfor ( org.emftext.sdk.concretesyntax.Rule rule : syntax.getAllRules()) {\n\torg.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes> placeholders = getAllPlaceholdersInQuotes(rule);\n\tfor ( org.emftext.sdk.concretesyntax.PlaceholderInQuotes placeholder : placeholders) {\n\t\torg.emftext.sdk.concretesyntax.ReferencableTokenDefinition token = placeholder.getToken();\n\t\tif (token == null) {\n\t\t\tcontinue;\n\t\t}\n\t\tjava.lang.String tokenName = token.getName();\r\n\n\t\torg.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\n\t\tnewStyle.setRgb(QUOTED_TOKEN_COLOR);\n\t\tnewStyle.getTokenNames().add(tokenName);\n\t\tsyntax.addTokenStyle(allStyles, newStyle);\n\t}\n}'"
	 * @generated
	 */
	void addTokenStylesForQuotedTokens(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.lang.String SL_COMMENT = \"\'//\'(~(\'\\n\'|\'\\r\'|\'\" + ((char) 0xffff) + \"\'))*\";\nfinal java.lang.String ML_COMMENT = \"\'/*\'.*\'\052/\'\";\nreturn SL_COMMENT.equals(regex) || ML_COMMENT.equals(regex);'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.lang.String COMMENT_COLOR = \"3F805D\";\njava.util.Collection< org.emftext.sdk.concretesyntax.CompleteTokenDefinition> tokens = syntax.getActiveTokens();\nfor ( org.emftext.sdk.concretesyntax.CompleteTokenDefinition tokenDefinition : tokens) {\n\tjava.lang.String regex = tokenDefinition.getRegex();\n\tif (isCommentPattern(regex)) {\n\t\torg.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\n\t\tnewStyle.setRgb(COMMENT_COLOR);\n\t\tnewStyle.getTokenNames().add(tokenDefinition.getName());\n\t\tsyntax.addTokenStyle(allStyles, newStyle);\n\t}\n}'"
	 * @generated
	 */
	void addTokenStylesForComments(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< java.lang.String> allKeywords = new org.eclipse.emf.common.util.BasicEList< java.lang.String>();\norg.eclipse.emf.common.util.TreeIterator< org.eclipse.emf.ecore.EObject> iterator = rule.eAllContents();\nwhile (iterator.hasNext()) {\n\torg.eclipse.emf.ecore.EObject next = iterator.next();\n\tif (next instanceof org.emftext.sdk.concretesyntax.CsString) {\n\t\tallKeywords.add((( org.emftext.sdk.concretesyntax.CsString) next).getValue());\n\t} else if (next instanceof org.emftext.sdk.concretesyntax.BooleanTerminal) {\n\t\tallKeywords.add((( org.emftext.sdk.concretesyntax.BooleanTerminal) next).getTrueLiteral());\n\t\tallKeywords.add((( org.emftext.sdk.concretesyntax.BooleanTerminal) next).getFalseLiteral());\n\t} else if (next instanceof org.emftext.sdk.concretesyntax.EnumTerminal) {\n\t\torg.emftext.sdk.concretesyntax.EnumTerminal enumTerminal = ( org.emftext.sdk.concretesyntax.EnumTerminal) next;\n\t\tfor ( org.emftext.sdk.concretesyntax.EnumLiteralTerminal literal : enumTerminal.getLiterals()) {\n\t\t\tallKeywords.add(literal.getText());\n\t\t}\n\t}\n}\nreturn allKeywords;'"
	 * @generated
	 */
	EList<String> getAllKeywords(Rule rule);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes> allPlaceholders = new org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes>();\norg.eclipse.emf.common.util.TreeIterator< org.eclipse.emf.ecore.EObject> iterator = rule.eAllContents();\nwhile (iterator.hasNext()) {\n\torg.eclipse.emf.ecore.EObject next = iterator.next();\n\tif (next instanceof org.emftext.sdk.concretesyntax.PlaceholderInQuotes) {\n\t\tallPlaceholders.add(( org.emftext.sdk.concretesyntax.PlaceholderInQuotes) next);\n\t}\n}\nreturn allPlaceholders;'"
	 * @generated
	 */
	EList<PlaceholderInQuotes> getAllPlaceholdersInQuotes(Rule rule);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  All CsStrings that match the regular expression returned by this method will 
	 *  be recognized as keywords and a default token style (purple and bold face font) 
	 *  will be assigned.
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.lang.String KEYWORD_REGEX = \"([a-z]|[A-Z])|(([a-z]|[A-Z]|[_])([a-z]|[A-Z]|[0-9]|[:]|[-]|[_]|\\\\s)+)\";\nreturn KEYWORD_REGEX;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final java.lang.String TASK_ITEM_COLOR = \"7F9FBF\";\r\n\norg.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\nnewStyle.setRgb(TASK_ITEM_COLOR);\nnewStyle.getFontStyles().add( org.emftext.sdk.concretesyntax.FontStyle.BOLD);\nnewStyle.getTokenNames().add(\"TASK_ITEM\");\nsyntax.addTokenStyle(allStyles, newStyle);'"
	 * @generated
	 */
	void addTokenStyleForTaskItems(ConcreteSyntax syntax, EList<TokenStyle> allStyles);

} // DefaultTokenStyleAdder
