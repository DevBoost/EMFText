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
package org.emftext.sdk.concretesyntax.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenStyle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Token Style Adder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DefaultTokenStyleAdderImpl extends EObjectImpl implements DefaultTokenStyleAdder
{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultTokenStyleAdderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.DEFAULT_TOKEN_STYLE_ADDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addDefaultTokenStyles(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		
				// add default styles
				addTokenStylesForKeywords(syntax, allStyles);
		
				addTokenStylesForQuotedTokens(syntax, allStyles);
		
				addTokenStylesForComments(syntax, allStyles);
		
				addTokenStyleForTaskItems(syntax, allStyles);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addTokenStylesForKeywords(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		
				/**
				 * All CsStrings that match this regular expression will be recognized
				 * as keywords and a default token style (purple and bold face font) 
				 * will be assigned.
				 */
				final  java.util.regex.Pattern KEYWORD_PATTERN =  java.util.regex.Pattern.compile(getKeywordRegex());
		
				final  java.lang.String KEYWORD_COLOR = "800055";
		
				for ( org.emftext.sdk.concretesyntax.Rule rule : syntax.getAllRules()) {
					 org.eclipse.emf.common.util.EList< java.lang.String> keywords = getAllKeywords(rule);
					for ( java.lang.String keyword : keywords) {
						if (KEYWORD_PATTERN.matcher(keyword).matches()) {
							 org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
							newStyle.setRgb(KEYWORD_COLOR);
							newStyle.getTokenNames().add(keyword);
							newStyle.getFontStyles().add( org.emftext.sdk.concretesyntax.FontStyle.BOLD);
							syntax.addTokenStyle(allStyles, newStyle);
						}
					}
				}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addTokenStylesForQuotedTokens(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		
				 java.lang.String QUOTED_TOKEN_COLOR = "2A00FF";
		
				for ( org.emftext.sdk.concretesyntax.Rule rule : syntax.getAllRules()) {
					 org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes> placeholders = getAllPlaceholdersInQuotes(rule);
					for ( org.emftext.sdk.concretesyntax.PlaceholderInQuotes placeholder : placeholders) {
						 org.emftext.sdk.concretesyntax.ReferencableTokenDefinition token = placeholder.getToken();
						if (token == null) {
							continue;
						}
						 java.lang.String tokenName = token.getName();
		
						 org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
						newStyle.setRgb(QUOTED_TOKEN_COLOR);
						newStyle.getTokenNames().add(tokenName);
						syntax.addTokenStyle(allStyles, newStyle);
					}
				}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCommentPattern(String regex) {
		
				final  java.lang.String SL_COMMENT = "'//'(~('\n'|'\r'|'?'))*";
		
				final  java.lang.String ML_COMMENT = "'/*'.*'*/'";
		
				return SL_COMMENT.equals(regex) || ML_COMMENT.equals(regex);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addTokenStylesForComments(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		
				final  java.lang.String COMMENT_COLOR = "3F805D";
		
				 java.util.Collection< org.emftext.sdk.concretesyntax.CompleteTokenDefinition> tokens = syntax.getActiveTokens();
		
				for ( org.emftext.sdk.concretesyntax.CompleteTokenDefinition tokenDefinition : tokens) {
					 java.lang.String regex = tokenDefinition.getRegex();
					if (isCommentPattern(regex)) {
						 org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
						newStyle.setRgb(COMMENT_COLOR);
						newStyle.getTokenNames().add(tokenDefinition.getName());
						syntax.addTokenStyle(allStyles, newStyle);
					}
				}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAllKeywords(Rule rule) {
		
				 org.eclipse.emf.common.util.EList< java.lang.String> allKeywords = new  org.eclipse.emf.common.util.BasicEList< java.lang.String>();
		
				 org.eclipse.emf.common.util.TreeIterator< org.eclipse.emf.ecore.EObject> iterator = rule.eAllContents();
		
				while (iterator.hasNext()) {
					 org.eclipse.emf.ecore.EObject next = iterator.next();
					if (next instanceof  org.emftext.sdk.concretesyntax.CsString) {
						allKeywords.add((( org.emftext.sdk.concretesyntax.CsString) next).getValue());
					} else if (next instanceof  org.emftext.sdk.concretesyntax.BooleanTerminal) {
						allKeywords.add((( org.emftext.sdk.concretesyntax.BooleanTerminal) next).getTrueLiteral());
						allKeywords.add((( org.emftext.sdk.concretesyntax.BooleanTerminal) next).getFalseLiteral());
					} else if (next instanceof  org.emftext.sdk.concretesyntax.EnumTerminal) {
						 org.emftext.sdk.concretesyntax.EnumTerminal enumTerminal = ( org.emftext.sdk.concretesyntax.EnumTerminal) next;
						for ( org.emftext.sdk.concretesyntax.EnumLiteralTerminal literal : enumTerminal.getLiterals()) {
							allKeywords.add(literal.getText());
						}
					}
				}
		
				return allKeywords;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PlaceholderInQuotes> getAllPlaceholdersInQuotes(Rule rule) {
		
				 org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes> allPlaceholders = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.PlaceholderInQuotes>();
		
				 org.eclipse.emf.common.util.TreeIterator< org.eclipse.emf.ecore.EObject> iterator = rule.eAllContents();
		
				while (iterator.hasNext()) {
					 org.eclipse.emf.ecore.EObject next = iterator.next();
					if (next instanceof  org.emftext.sdk.concretesyntax.PlaceholderInQuotes) {
						allPlaceholders.add(( org.emftext.sdk.concretesyntax.PlaceholderInQuotes) next);
					}
				}
		
				return allPlaceholders;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeywordRegex() {
		
				final  java.lang.String KEYWORD_REGEX = "([a-z]|[A-Z])|(([a-z]|[A-Z]|[_])([a-z]|[A-Z]|[:]|[-]|[_])+)";
		
				return KEYWORD_REGEX;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addTokenStyleForTaskItems(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		
				final  java.lang.String TASK_ITEM_COLOR = "7F9FBF";
		
		
				 org.emftext.sdk.concretesyntax.TokenStyle newStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
		
				newStyle.setRgb(TASK_ITEM_COLOR);
		
				newStyle.getFontStyles().add( org.emftext.sdk.concretesyntax.FontStyle.BOLD);
		
				newStyle.getTokenNames().add("TASK_ITEM");
		
				syntax.addTokenStyle(allStyles, newStyle);
		
	}

} //DefaultTokenStyleAdderImpl