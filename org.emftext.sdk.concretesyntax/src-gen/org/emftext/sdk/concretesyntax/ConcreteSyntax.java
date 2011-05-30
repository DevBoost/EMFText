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
 * <!-- begin-model-doc -->
 * A specification of the concrete syntax for an Ecore metamodel.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getStartSymbols <em>Start Symbols</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getActiveTokens <em>Active Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getImports <em>Imports</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getOptions <em>Options</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getSyntheticTokens <em>Synthetic Tokens</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokenStyles <em>Token Styles</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokenDirectives <em>All Token Directives</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getRules <em>Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_operatorRules <em>operator Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_operatorRuleSubsets <em>operator Rule Subsets</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#is_operatorRulesInitialized <em>operator Rules Initialized</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_genClassCache <em>gen Class Cache</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_eClassUtil <em>eClass Util</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#isAbstract <em>Abstract</em>}</li>
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
	 * <!-- begin-model-doc -->
	 * Contains all synthesized tokens. This includes the quoted tokens and the predefined tokens.
	 * <!-- end-model-doc -->
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Token Styles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.TokenStyle> allStyles = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.TokenStyle>();\r\n\r\n\t\tallStyles.addAll(getTokenStyles());\r\n\r\n\t\taddImportedTokenStyles(allStyles);\r\n\r\n\t\t org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder adder = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDefaultTokenStyleAdder();\r\n\r\n\t\tadder.addDefaultTokenStyles(this, allStyles);\r\n\r\n\t\treturn allStyles;\r\n'"
	 * @generated
	 */
	EList<TokenStyle> getAllTokenStyles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model existingStylesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tfor ( java.lang.String tokenName : newStyle.getTokenNames()) {\r\n\t\t\tboolean exists = containsTokenStyle(existingStyles, tokenName);\r\n\t\t\tif (!exists) {\r\n\t\t\t\t org.emftext.sdk.concretesyntax.TokenStyle newTokenStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\r\n\t\t\t\tnewTokenStyle.getTokenNames().add(tokenName);\r\n\t\t\t\tnewTokenStyle.setRgb(newStyle.getRgb());\r\n\t\t\t\tnewTokenStyle.getFontStyles().addAll(newStyle.getFontStyles());\r\n\t\t\t\texistingStyles.add(newTokenStyle);\r\n\t\t\t}\r\n\t\t}\r\n'"
	 * @generated
	 */
	void addTokenStyle(EList<TokenStyle> existingStyles, TokenStyle newStyle);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model stylesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tfor ( org.emftext.sdk.concretesyntax.TokenStyle existingStyle : styles) {\r\n\t\t\tfor ( java.lang.String existingName : existingStyle.getTokenNames()) {\r\n\t\t\t\tif (existingName.equals(tokenName)) {\r\n\t\t\t\t\treturn true;\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn false;\r\n'"
	 * @generated
	 */
	boolean containsTokenStyle(EList<TokenStyle> styles, String tokenName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Reads all token styles from imported syntaxes and
	 *  merges them with the styles defined in the current syntax. If a token
	 *  styles exists both in an imported and in the current syntax the one from
	 *  the current syntax overrides the imported one.
	 * 
	 * <!-- end-model-doc -->
	 * @model allStylesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t// add the imported token styles\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Import> imports = getImports();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Import importedElement : imports) {\r\n\t\t\t org.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();\r\n\t\t\tif (importedSyntax != null) {\r\n\t\t\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.TokenStyle> importedStyles = importedSyntax.getAllTokenStyles();\r\n\t\t\t\tfor ( org.emftext.sdk.concretesyntax.TokenStyle importedStyle : importedStyles) {\r\n\t\t\t\t\taddTokenStyle(allStyles, importedStyle);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n'"
	 * @generated
	 */
	void addImportedTokenStyles(EList<TokenStyle> allStyles);

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
	 * Returns the value of the '<em><b>eClass Util</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>eClass Util</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>eClass Util</em>' containment reference.
	 * @see #set_eClassUtil(EClassUtil)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax__eClassUtil()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EClassUtil get_eClassUtil();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_eClassUtil <em>eClass Util</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>eClass Util</em>' containment reference.
	 * @see #get_eClassUtil()
	 * @generated
	 */
	void set_eClassUtil(EClassUtil value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model identifierRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Rule> subset = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Rule>();\r\n\r\n\t\tif (identifier == null) {\r\n\t\t\treturn subset;\r\n\t\t}\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getOperatorRules()) {\r\n\t\t\t org.emftext.sdk.concretesyntax.Annotation annotation = rule.getOperatorAnnotation();\r\n\t\t\t java.lang.String value = annotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.SUPERCLASS.toString());\r\n\t\t\tif (identifier.equals(value)) {\r\n\t\t\t\tsubset.add(rule);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn subset;\r\n'"
	 * @generated
	 */
	EList<Rule> getOperatorRuleSubset(String identifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> symbols = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\r\n\t\tsymbols.addAll(getStartSymbols());\r\n\r\n\t\tif (symbols.size() > 0) {\r\n\t\t\treturn symbols;\r\n\t\t}\r\n\r\n\t\t\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Import> imports = getImports();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Import importedElement : imports) {\r\n\t\t\tfinal  org.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();\r\n\t\t\tif (importedSyntax != null) {\r\n\t\t\t\tsymbols.addAll(importedSyntax.getActiveStartSymbols());\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn symbols;\r\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t//EStructuralFeature eFeature = ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_RULES;\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Rule> l = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Rule>(getRules().size());\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules()) {\r\n\t\t\t// don\'t add rules that are @override rules with remove=true\r\n\t\t\tif (!rule.isOverrideRemoveRule()) {\r\n\t\t\t\tl.add(rule);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Import aImport : getImports()) {\r\n\t\t\t org.emftext.sdk.concretesyntax.ConcreteSyntax importedCS = aImport.getConcreteSyntax();\r\n\t\t\tif (importedCS != null) {\r\n\t\t\t\touter: for ( org.emftext.sdk.concretesyntax.Rule importedRule : importedCS.getAllRules()) {\r\n\t\t\t\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules()) {\r\n\t\t\t\t\t\t// don\'t add rules that have @override rules for same\r\n\t\t\t\t\t\t// meta-class\r\n\t\t\t\t\t\tif (rule.isOverrideRule(importedRule.getMetaclass())) {\r\n\t\t\t\t\t\t\tcontinue outer;\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t\tl.add(importedRule);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn  org.eclipse.emf.common.util.ECollections.unmodifiableEList(l);\r\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tinitialiseAnnotatedOperatorRules();\r\n\r\n\t\treturn get_operatorRules();\r\n'"
	 * @generated
	 */
	EList<Rule> getOperatorRules();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tif (is_operatorRulesInitialized()) {\r\n\t\t\treturn;\r\n\t\t}\r\n\r\n\t\tset_operatorRulesInitialized(true);\r\n\r\n\t\t java.util.List< org.emftext.sdk.concretesyntax.Rule> operatorRules = getOperatorRules();\r\n\r\n\t\t java.util.List< java.lang.String> operatorRuleSubsets = getOperatorRuleSubsets();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getAllRules()) {\r\n\t\t\t org.emftext.sdk.concretesyntax.Annotation operatorAnnotation = rule.getOperatorAnnotation();\r\n\t\t\tif (operatorAnnotation != null) {\r\n\t\t\t\tboolean added = false;\r\n\t\t\t\tfor ( java.util.ListIterator< org.emftext.sdk.concretesyntax.Rule> it = operatorRules.listIterator(); it.hasNext();) {\r\n\t\t\t\t\t org.emftext.sdk.concretesyntax.Rule expressionRule = it.next(); \r\n\t\t\t\t\tif (expressionRule.getOperatorWeight() > rule.getOperatorWeight()) {\r\n\t\t\t\t\t\toperatorRules.add(it.previousIndex(), rule);\r\n\t\t\t\t\t\tadded = true;\r\n\t\t\t\t\t\tbreak;\r\n\t\t\t\t\t}\t\t\t\r\n\t\t\t\t}\r\n\t\t\t\tif (!added) {\r\n\t\t\t\t\toperatorRules.add(rule);\r\n\t\t\t\t}\r\n\t\t\t\t java.lang.String identifier = operatorAnnotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.SUPERCLASS.toString());\r\n\t\t\t\tif (identifier != null) {\r\n\t\t\t\t\toperatorRuleSubsets.add(identifier);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tinitialiseAnnotatedOperatorRules();\r\n\r\n\t\treturn get_operatorRuleSubsets();\r\n'"
	 * @generated
	 */
	EList<String> getOperatorRuleSubsets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tif (get_genClassCache() == null) {\r\n\t\t\tset_genClassCache( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createGenClassCache());\r\n\t\t}\r\n\r\n\t\treturn get_genClassCache();\r\n'"
	 * @generated
	 */
	GenClassCache getGenClassCache();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A flag that is used to tag syntax definitions as abstract.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getConcreteSyntax_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Returns true if the given rule was defined in the given syntax.
	 *  If the rule is defined in an imported syntax, this method returns
	 *  false.
	 *  
	 *  @param syntax the syntax that refers to the rule
	 *  @param rule the rule to check
	 *  @return true if the rule is contained, false if it is imported
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\treturn rule.getSyntax() != this;\r\n'"
	 * @generated
	 */
	boolean isImportedRule(Rule rule);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tif (get_eClassUtil() == null) {\r\n\t\t\tset_eClassUtil( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEClassUtil());\r\n\t\t}\r\n\r\n\t\treturn get_eClassUtil();\r\n'"
	 * @generated
	 */
	EClassUtil getEClassUtil();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Collects all the subclasses for which concrete syntax is defined.
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t java.util.Collection< org.emftext.sdk.concretesyntax.Rule> rules = getAllRules();\r\n\r\n\t\t org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> foundGenClasses = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : rules) {\r\n\t\t\tif (excludeOperatorRules && rule.getOperatorAnnotation() != null) {\r\n\t\t\t\tcontinue;\r\n\t\t\t}\r\n\t\t\t org.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand = rule.getMetaclass();\r\n\t\t\tfoundGenClasses.add(subClassCand);\r\n\t\t}\r\n\r\n\t\treturn foundGenClasses;\r\n'"
	 * @generated
	 */
	EList<GenClass> getClassesWithSyntax(boolean excludeOperatorRules);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Collects all the subclasses for which concrete syntax is defined.
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> subClasses = new  org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\r\n\r\n\t\t org.eclipse.emf.ecore.EClass ecoreClass = superClass.getEcoreClass();\r\n\r\n\t\t org.emftext.sdk.concretesyntax.EClassUtil eClassUtil = getEClassUtil();\r\n\r\n\t\tfor ( org.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand : getClassesWithSyntax(excludeOperatorRules)) {\r\n\t\t\tif (eClassUtil.isSubClass(subClassCand.getEcoreClass(), ecoreClass)) {\r\n\t\t\t\tsubClasses.add(subClassCand);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn subClasses;\r\n'"
	 * @generated
	 */
	EList<GenClass> getSubClassesWithSyntax(GenClass superClass, boolean excludeOperatorRules);

} // ConcreteSyntax
