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
	 * <!-- end-model-doc -->
	 * @model identifierRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Rule> subset = new org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Rule>();\nif (identifier == null) {\n\treturn subset;\n}\nfor ( org.emftext.sdk.concretesyntax.Rule rule : getOperatorRules()) {\n\torg.emftext.sdk.concretesyntax.Annotation annotation = rule.getOperatorAnnotation();\n\tjava.lang.String value = annotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.SUPERCLASS.toString());\n\tif (identifier.equals(value)) {\n\t\tsubset.add(rule);\n\t}\n}\nreturn subset;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> symbols = new org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\nsymbols.addAll(getStartSymbols());\nif (symbols.size() > 0) {\n\treturn symbols;\n}\n\norg.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Import> imports = getImports();\nfor ( org.emftext.sdk.concretesyntax.Import importedElement : imports) {\n\tfinal org.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();\n\tif (importedSyntax != null) {\n\t\tsymbols.addAll(importedSyntax.getActiveStartSymbols());\n\t}\n}\nreturn symbols;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='//EStructuralFeature eFeature = ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_RULES;\norg.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Rule> l = new org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Rule>(getRules().size());\nfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules()) {\n\t// don\'t add rules that are @override rules with remove=true\n\tif (!rule.isOverrideRemoveRule()) {\n\t\tl.add(rule);\n\t}\n}\nfor ( org.emftext.sdk.concretesyntax.Import aImport : getImports()) {\n\torg.emftext.sdk.concretesyntax.ConcreteSyntax importedCS = aImport.getConcreteSyntax();\n\tif (importedCS != null) {\n\t\touter: for ( org.emftext.sdk.concretesyntax.Rule importedRule : importedCS.getAllRules()) {\n\t\t\tfor ( org.emftext.sdk.concretesyntax.Rule rule : getRules()) {\n\t\t\t\t// don\'t add rules that have @override rules for same\n\t\t\t\t// meta-class\n\t\t\t\tif (rule.isOverrideRule(importedRule.getMetaclass())) {\n\t\t\t\t\tcontinue outer;\n\t\t\t\t}\n\t\t\t}\n\t\t\tl.add(importedRule);\n\t\t}\n\t}\n}\nreturn org.eclipse.emf.common.util.ECollections.unmodifiableEList(l);'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='initialiseAnnotatedOperatorRules();\nreturn get_operatorRules();'"
	 * @generated
	 */
	EList<Rule> getOperatorRules();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (is_operatorRulesInitialized()) {\n\treturn;\n}\nset_operatorRulesInitialized(true);\njava.util.List< org.emftext.sdk.concretesyntax.Rule> operatorRules = getOperatorRules();\njava.util.List< java.lang.String> operatorRuleSubsets = getOperatorRuleSubsets();\nfor ( org.emftext.sdk.concretesyntax.Rule rule : getAllRules()) {\n\torg.emftext.sdk.concretesyntax.Annotation operatorAnnotation = rule.getOperatorAnnotation();\n\tif (operatorAnnotation != null) {\n\t\tboolean added = false;\n\t\tfor ( java.util.ListIterator< org.emftext.sdk.concretesyntax.Rule> it = operatorRules.listIterator(); it.hasNext();) {\n\t\t\torg.emftext.sdk.concretesyntax.Rule expressionRule = it.next(); \n\t\t\tif (expressionRule.getOperatorWeight() > rule.getOperatorWeight()) {\n\t\t\t\toperatorRules.add(it.previousIndex(), rule);\n\t\t\t\tadded = true;\n\t\t\t\tbreak;\n\t\t\t}\t\t\t\n\t\t}\n\t\tif (!added) {\n\t\t\toperatorRules.add(rule);\n\t\t}\n\t\tjava.lang.String identifier = operatorAnnotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.SUPERCLASS.toString());\n\t\tif (identifier != null) {\n\t\t\toperatorRuleSubsets.add(identifier);\n\t\t}\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='initialiseAnnotatedOperatorRules();\nreturn get_operatorRuleSubsets();'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (get_genClassCache() == null) {\n\tset_genClassCache( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createGenClassCache());\n}\nreturn get_genClassCache();'"
	 * @generated
	 */
	GenClassCache getGenClassCache();

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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return rule.getSyntax() != this;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (get_eClassUtil() == null) {\n\tset_eClassUtil( org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEClassUtil());\n}\nreturn get_eClassUtil();'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='java.util.Collection< org.emftext.sdk.concretesyntax.Rule> rules = getAllRules();\norg.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> foundGenClasses = new org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\nfor ( org.emftext.sdk.concretesyntax.Rule rule : rules) {\n\tif (excludeOperatorRules && rule.getOperatorAnnotation() != null) {\n\t\tcontinue;\n\t}\n\torg.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand = rule.getMetaclass();\n\tfoundGenClasses.add(subClassCand);\n}\nreturn foundGenClasses;'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< org.eclipse.emf.codegen.ecore.genmodel.GenClass> subClasses = new org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.codegen.ecore.genmodel.GenClass>();\r\n\norg.eclipse.emf.ecore.EClass ecoreClass = superClass.getEcoreClass();\norg.emftext.sdk.concretesyntax.EClassUtil eClassUtil = getEClassUtil();\nfor ( org.eclipse.emf.codegen.ecore.genmodel.GenClass subClassCand : getClassesWithSyntax(excludeOperatorRules)) {\n\tif (eClassUtil.isSubClass(subClassCand.getEcoreClass(), ecoreClass)) {\n\t\tsubClasses.add(subClassCand);\n\t}\n}\nreturn subClasses;'"
	 * @generated
	 */
	EList<GenClass> getSubClassesWithSyntax(GenClass superClass, boolean excludeOperatorRules);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.TokenStyle> allStyles = new org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.TokenStyle>();\nallStyles.addAll(getTokenStyles());\naddImportedTokenStyles(allStyles);\norg.emftext.sdk.concretesyntax.DefaultTokenStyleAdder adder = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDefaultTokenStyleAdder();\nadder.addDefaultTokenStyles(this, allStyles);\nreturn allStyles;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for ( java.lang.String tokenName : newStyle.getTokenNames()) {\n\tboolean exists = containsTokenStyle(existingStyles, tokenName);\n\tif (!exists) {\n\t\torg.emftext.sdk.concretesyntax.TokenStyle newTokenStyle = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();\n\t\tnewTokenStyle.getTokenNames().add(tokenName);\n\t\tnewTokenStyle.setRgb(newStyle.getRgb());\n\t\tnewTokenStyle.getFontStyles().addAll(newStyle.getFontStyles());\n\t\texistingStyles.add(newTokenStyle);\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for ( org.emftext.sdk.concretesyntax.TokenStyle existingStyle : styles) {\n\tfor ( java.lang.String existingName : existingStyle.getTokenNames()) {\n\t\tif (existingName.equals(tokenName)) {\n\t\t\treturn true;\n\t\t}\n\t}\n}\nreturn false;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='// add the imported token styles\norg.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Import> imports = getImports();\nfor ( org.emftext.sdk.concretesyntax.Import importedElement : imports) {\n\torg.emftext.sdk.concretesyntax.ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();\n\tif (importedSyntax != null) {\n\t\torg.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.TokenStyle> importedStyles = importedSyntax.getAllTokenStyles();\n\t\tfor ( org.emftext.sdk.concretesyntax.TokenStyle importedStyle : importedStyles) {\n\t\t\taddTokenStyle(allStyles, importedStyle);\n\t\t}\n\t}\n}'"
	 * @generated
	 */
	void addImportedTokenStyles(EList<TokenStyle> allStyles);

} // ConcreteSyntax
