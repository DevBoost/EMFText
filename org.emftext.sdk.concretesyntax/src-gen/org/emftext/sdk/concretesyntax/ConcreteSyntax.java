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
 *
 * $Id$
 */
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
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getActiveTokens <em>Active Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getImports <em>Imports</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getOptions <em>Options</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getSyntheticTokens <em>Synthetic Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokenStyles <em>Token Styles</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokenStyles <em>All Token Styles</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokenDirectives <em>All Token Directives</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getRules <em>Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_operatorRules <em>operator Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_operatorRuleSubsets <em>operator Rule Subsets</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#is_operatorRulesInitialized <em>operator Rules Initialized</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_genClassCache <em>gen Class Cache</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax()
 * @model
 * @generated
 */
public interface ConcreteSyntax extends GenPackageDependentElement, Annotable {
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
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_Options()
	 * @model containment="true"
	 * @generated
	 */
	EList<Option> getOptions();

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
	 * Returns the value of the '<em><b>operator Rules</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>operator Rules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>operator Rules</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax__operatorRules()
	 * @model resolveProxies="false" transient="true" derived="true"
	 * @generated
	 */
	EList<Rule> get_operatorRules();

	/**
	 * Returns the value of the '<em><b>operator Rule Subsets</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>operator Rule Subsets</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>operator Rule Subsets</em>' attribute list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax__operatorRuleSubsets()
	 * @model default="" transient="true" derived="true"
	 * @generated
	 */
	EList<String> get_operatorRuleSubsets();

	/**
	 * Returns the value of the '<em><b>operator Rules Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>operator Rules Initialized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>operator Rules Initialized</em>' attribute.
	 * @see #set_operatorRulesInitialized(boolean)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax__operatorRulesInitialized()
	 * @model
	 * @generated
	 */
	boolean is_operatorRulesInitialized();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#is_operatorRulesInitialized <em>operator Rules Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>operator Rules Initialized</em>' attribute.
	 * @see #is_operatorRulesInitialized()
	 * @generated
	 */
	void set_operatorRulesInitialized(boolean value);

	/**
	 * Returns the value of the '<em><b>gen Class Cache</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>gen Class Cache</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>gen Class Cache</em>' containment reference.
	 * @see #set_genClassCache(GenClassCache)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax__genClassCache()
	 * @model containment="true" required="true" transient="true"
	 * @generated
	 */
	GenClassCache get_genClassCache();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_genClassCache <em>gen Class Cache</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>gen Class Cache</em>' containment reference.
	 * @see #get_genClassCache()
	 * @generated
	 */
	void set_genClassCache(GenClassCache value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model identifierRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Rule > subset = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.Rule > ( ) ; \r\nif ( identifier == null ) { \r\n\treturn subset ; \r\n} \r\nfor ( org.emftext.sdk.concretesyntax.Rule rule : getOperatorRules ( ) ) { \r\n\torg.emftext.sdk.concretesyntax.Annotation annotation = rule .getOperatorAnnotation ( ) ; \r\n\tjava.lang.String value = annotation .getValue ( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty .IDENTIFIER .toString ( ) ) ; \r\n\tif ( identifier .equals ( value ) ) { \r\n\t\tsubset .add ( rule ) ; \r\n\t} \r\n} \r\nreturn subset ; \r\n'"
	 * @generated
	 */
	EList<Rule> getOperatorRuleSubset(String identifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for ( org.emftext.sdk.concretesyntax.Annotation annotation : rule .getAnnotations ( ) ) { \r\n\tif ( annotation .getType ( ) == type ) { \r\n\t\tif ( key != null ) { \r\n\t\t\tfor ( org.emftext.sdk.concretesyntax.KeyValuePair parameter : annotation .getParameters ( ) ) { \r\n\t\t\t\tif ( key .equals ( parameter .getKey ( ) ) && parameter .getValue ( ) .equals ( value ) ) { \r\n\t\t\t\t\treturn true ; \r\n\t\t\t\t} \r\n\t\t\t} \r\n\t\t} else { \r\n\t\t\treturn true ; \r\n\t\t} \r\n\t} \r\n} \r\nreturn false ; \r\n'"
	 * @generated
	 */
	boolean hasAnnotation(Rule rule, AnnotationType type, String key, String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > symbols = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > ( ) ; \r\nsymbols .addAll ( getStartSymbols ( ) ) ; \r\nif ( symbols .size ( ) > 0 ) { \r\n\treturn symbols ; \r\n} \r\norg.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Import > imports = getImports ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.Import importedElement : imports ) { \r\n\tfinal org.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement .getConcreteSyntax ( ) ; \r\n\tif ( importedSyntax != null ) { \r\n\t\tsymbols .addAll ( importedSyntax .getActiveStartSymbols ( ) ) ; \r\n\t} \r\n} \r\nreturn symbols ; \r\n'"
	 * @generated
	 */
	EList<GenClass> getActiveStartSymbols();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > symbols = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.codegen.ecore.genmodel.GenClass > ( ) ; \r\nsymbols .addAll ( getStartSymbols ( ) ) ; \r\norg.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Import > imports = getImports ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.Import importedElement : imports ) { \r\n\tfinal org.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement .getConcreteSyntax ( ) ; \r\n\tif ( importedSyntax != null ) { \r\n\t\tsymbols .addAll ( importedSyntax .getAllStartSymbols ( ) ) ; \r\n\t} \r\n} \r\nreturn symbols ; \r\n'"
	 * @generated
	 */
	EList<GenClass> getAllStartSymbols();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='//EStructuralFeature eFeature = ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_RULES;\norg.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Rule > l = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.Rule > ( getRules ( ) .size ( ) ) ; \r\nfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules ( ) ) { \r\n\t// don\'t add rules that are @override rules with remove=true\nif ( ! isOverrideRemoveRule ( rule ) ) { \r\n\t\tl .add ( rule ) ; \r\n\t} \r\n} \r\nfor ( org.emftext.sdk.concretesyntax.Import aImport : getImports ( ) ) { \r\n\torg.emftext.sdk.concretesyntax.ConcreteSyntax importedCS = aImport .getConcreteSyntax ( ) ; \r\n\tif ( importedCS != null ) { \r\n\t\touter : for ( org.emftext.sdk.concretesyntax.Rule importedRule : importedCS .getAllRules ( ) ) { \r\n\t\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules ( ) ) { \r\n\t\t\t\t// don\'t add rules that have @override rules for same\n// meta-class\nif ( isOverrideRule ( rule , importedRule .getMetaclass ( ) ) ) { \r\n\t\t\t\t\tcontinue outer ; \r\n\t\t\t\t} \r\n\t\t\t} \r\n\t\t\tl .add ( importedRule ) ; \r\n\t\t} \r\n\t} \r\n} \r\nreturn org.eclipse.emf.common.util.ECollections .unmodifiableEList ( l ) ; \r\n'"
	 * @generated
	 */
	EList<Rule> getAllRules();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='initialiseAnnotatedOperatorRules ( ) ; \r\nreturn get_operatorRules ( ) ; \r\n'"
	 * @generated
	 */
	EList<Rule> getOperatorRules();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if ( is_operatorRulesInitialized ( ) ) { \r\n\treturn ; \r\n} \r\nset_operatorRulesInitialized ( true ) ; \r\njava.util.List < org.emftext.sdk.concretesyntax.Rule > operatorRules = getOperatorRules ( ) ; \r\njava.util.List < java.lang.String > operatorRuleSubsets = getOperatorRuleSubsets ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.Rule rule : getAllRules ( ) ) { \r\n\torg.emftext.sdk.concretesyntax.Annotation operatorAnnotation = rule .getOperatorAnnotation ( ) ; \r\n\tif ( operatorAnnotation != null ) { \r\n\t\tboolean added = false ; \r\n\t\tfor ( java.util.ListIterator < org.emftext.sdk.concretesyntax.Rule > it = operatorRules .listIterator ( ) ; it .hasNext ( ) ; ) { \r\n\t\t\torg.emftext.sdk.concretesyntax.Rule expressionRule = it .next ( ) ; \r\n\t\t\tif ( expressionRule .getOperatorWeight ( ) > rule .getOperatorWeight ( ) ) { \r\n\t\t\t\toperatorRules .add ( it .previousIndex ( ) , rule ) ; \r\n\t\t\t\tadded = true ; \r\n\t\t\t\tbreak ; \r\n\t\t\t} \r\n\t\t} \r\n\t\tif ( ! added ) { \r\n\t\t\toperatorRules .add ( rule ) ; \r\n\t\t} \r\n\t\tjava.lang.String identifier = operatorAnnotation .getValue ( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty .IDENTIFIER .toString ( ) ) ; \r\n\t\toperatorRuleSubsets .add ( identifier ) ; \r\n\t} \r\n} \r\n'"
	 * @generated
	 */
	void initialiseAnnotatedOperatorRules();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='initialiseAnnotatedOperatorRules ( ) ; \r\nreturn get_operatorRuleSubsets ( ) ; \r\n'"
	 * @generated
	 */
	EList<String> getOperatorRuleSubsets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// TODO mseifert: use constant here, move method to class \'Rule\'\nreturn hasAnnotation ( rule , org.emftext.sdk.concretesyntax.AnnotationType .OVERRIDE , \"remove\" , \"true\" ) ; \r\n'"
	 * @generated
	 */
	boolean isOverrideRemoveRule(Rule rule);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// TODO figure out why \'metaClass == null\' is needed\nif ( metaClass == null || rule .getMetaclass ( ) == metaClass ) { \r\n\tif ( hasAnnotation ( rule , org.emftext.sdk.concretesyntax.AnnotationType .OVERRIDE , null , null ) ) { \r\n\t\treturn true ; \r\n\t} \r\n} \r\nreturn false ; \r\n'"
	 * @generated
	 */
	boolean isOverrideRule(Rule rule, GenClass metaClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ( get_genClassCache ( ) == null ) { \r\n\tset_genClassCache ( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createGenClassCache()) ; \r\n} \r\nreturn get_genClassCache ( ) ; \r\n'"
	 * @generated
	 */
	GenClassCache getGenClassCache();

} // ConcreteSyntax
