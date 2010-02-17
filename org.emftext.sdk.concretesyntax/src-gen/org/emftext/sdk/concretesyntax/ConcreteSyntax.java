/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Syntax</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getModifier <em>Modifier</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getStartSymbols <em>Start Symbols</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getActiveStartSymbols <em>Active Start Symbols</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getActiveTokens <em>Active Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllStartSymbols <em>All Start Symbols</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getImports <em>Imports</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getOptions <em>Options</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getSyntheticTokens <em>Synthetic Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokenStyles <em>Token Styles</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokenStyles <em>All Token Styles</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokenDirectives <em>All Token Directives</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getRules <em>Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllRules <em>All Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getOperatorRules <em>Operator Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getOperatorRuleSubsets <em>Operator Rule Subsets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax()
 * @model
 * @generated
 */
public interface ConcreteSyntax extends GenPackageDependentElement, Annotable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Start Symbols</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Symbols</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Symbols</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_StartSymbols()
	 * @model
	 * @generated
	 */
	EList<GenClass> getStartSymbols();

	/**
	 * Returns the value of the '<em><b>Active Start Symbols</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Start Symbols</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Start Symbols</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_ActiveStartSymbols()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<GenClass> getActiveStartSymbols();

	/**
	 * Returns the value of the '<em><b>Active Tokens</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Tokens</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Tokens</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_ActiveTokens()
	 * @model transient="true"
	 * @generated
	 */
	EList<CompleteTokenDefinition> getActiveTokens();

	/**
	 * Returns the value of the '<em><b>All Start Symbols</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Start Symbols</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Start Symbols</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_AllStartSymbols()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<GenClass> getAllStartSymbols();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.Rule}.
	 * It is bidirectional and its opposite is '{@link org.emftext.sdk.concretesyntax.Rule#getSyntax <em>Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_Rules()
	 * @see org.emftext.sdk.concretesyntax.Rule#getSyntax
	 * @model opposite="syntax" containment="true" required="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>All Rules</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Rules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Rules</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_AllRules()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Rule> getAllRules();

	/**
	 * Returns the value of the '<em><b>Operator Rules</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Rules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Rules</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_OperatorRules()
	 * @model resolveProxies="false" transient="true" derived="true"
	 * @generated
	 */
	EList<Rule> getOperatorRules();

	/**
	 * Returns the value of the '<em><b>Operator Rule Subsets</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Subsets</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Rule Subsets</em>' attribute list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_OperatorRuleSubsets()
	 * @model default="" transient="true" derived="true"
	 * @generated
	 */
	EList<String> getOperatorRuleSubsets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model identifierRequired="true"
	 * @generated
	 */
	EList<Rule> getOperatorRuleSubset(String identifier);

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' containment reference.
	 * @see #setModifier(Abstract)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_Modifier()
	 * @model containment="true"
	 * @generated
	 */
	Abstract getModifier();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getModifier <em>Modifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modifier</em>' containment reference.
	 * @see #getModifier()
	 * @generated
	 */
	void setModifier(Abstract value);

	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.TokenDirective}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_Tokens()
	 * @model containment="true"
	 * @generated
	 */
	EList<TokenDirective> getTokens();

	/**
	 * Returns the value of the '<em><b>Token Styles</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.TokenStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token Styles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Styles</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_TokenStyles()
	 * @model containment="true"
	 * @generated
	 */
	EList<TokenStyle> getTokenStyles();

	/**
	 * Returns the value of the '<em><b>All Token Styles</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.TokenStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Token Styles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Token Styles</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_AllTokenStyles()
	 * @model transient="true"
	 * @generated
	 */
	EList<TokenStyle> getAllTokenStyles();

	/**
	 * Returns the value of the '<em><b>All Token Directives</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.TokenDirective}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Token Directives</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Token Directives</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_AllTokenDirectives()
	 * @model transient="true"
	 * @generated
	 */
	EList<TokenDirective> getAllTokenDirectives();

	/**
	 * Returns the value of the '<em><b>Synthetic Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synthetic Tokens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synthetic Tokens</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_SyntheticTokens()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<CompleteTokenDefinition> getSyntheticTokens();

	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_Options()
	 * @model containment="true"
	 * @generated
	 */
	EList<Option> getOptions();

} // ConcreteSyntax
