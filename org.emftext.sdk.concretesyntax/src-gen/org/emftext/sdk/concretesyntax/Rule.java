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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Rule#getMetaclass <em>Metaclass</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Rule#getSyntax <em>Syntax</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends Annotable, SyntaxElement {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.SyntaxElement > children = getChildren ( ) ; \r\n// there should be at most one child\nassert children == null || children .size ( ) == 1 ; \r\nif ( children .size ( ) > 0 ) { \r\n\torg.emftext.sdk.concretesyntax.SyntaxElement firstChild = children .get ( 0 ) ; \r\n\tif ( firstChild instanceof org.emftext.sdk.concretesyntax.Choice ) { \r\n\t\treturn ( org.emftext.sdk.concretesyntax.Choice ) firstChild ; \r\n\t} else { \r\n\t\t// there should be no element other than Choice\nassert false ; \r\n\t\treturn null ; \r\n\t} \r\n} \r\nreturn null ; \r\n'"
	 * @generated
	 */
	Choice getDefinition();

	/**
	 * Returns the value of the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metaclass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metaclass</em>' reference.
	 * @see #setMetaclass(GenClass)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRule_Metaclass()
	 * @model required="true"
	 * @generated
	 */
	GenClass getMetaclass();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Rule#getMetaclass <em>Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metaclass</em>' reference.
	 * @see #getMetaclass()
	 * @generated
	 */
	void setMetaclass(GenClass value);

	/**
	 * Returns the value of the '<em><b>Syntax</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntax</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syntax</em>' container reference.
	 * @see #setSyntax(ConcreteSyntax)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRule_Syntax()
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getRules
	 * @model opposite="rules" required="true" transient="false"
	 * @generated
	 */
	ConcreteSyntax getSyntax();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Rule#getSyntax <em>Syntax</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Syntax</em>' container reference.
	 * @see #getSyntax()
	 * @generated
	 */
	void setSyntax(ConcreteSyntax value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations ( ) ) { \r\n\tif ( annotation .getType ( ) == org.emftext.sdk.concretesyntax.AnnotationType .OPERATOR ) { \r\n\t\treturn annotation ; \r\n\t} \r\n} \r\nreturn null ; \r\n'"
	 * @generated
	 */
	Annotation getOperatorAnnotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Returns the weight of this rule if it is an operator rule.
	 *  If the rule is not an operator rule or the specified weight
	 *  in the operator annotation is not a number, Integer.MIN_VALUE 
	 *  is returned.
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.emftext.sdk.concretesyntax.Annotation operatorAnnotation = this .getOperatorAnnotation ( ) ; \r\nif ( operatorAnnotation != null ) { \r\n\tjava.lang.String ruleWeightString = operatorAnnotation .getValue ( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty .WEIGHT .toString ( ) ) ; \r\n\tif ( ruleWeightString != null ) { \r\n\t\ttry { \r\n\t\t\treturn java.lang.Integer .parseInt ( ruleWeightString ) ; \r\n\t\t} // ignore exception. invalid numbers are signaled by\n// returning MIN_VALUE\ncatch ( java.lang.NumberFormatException e ) { \r\n\t\t} \r\n\t} \r\n} \r\nreturn java.lang.Integer .MIN_VALUE ; \r\n'"
	 * @generated
	 */
	int getOperatorWeight();

} // Rule
