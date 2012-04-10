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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines the concrete textual syntax for a metaclass.
 * <!-- end-model-doc -->
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations()) {\r\n\t\t\tif (annotation.getType() ==  org.emftext.sdk.concretesyntax.AnnotationType.OPERATOR) {\r\n\t\t\t\treturn annotation;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn null;\r\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.emftext.sdk.concretesyntax.Annotation operatorAnnotation = this.getOperatorAnnotation();\r\n\r\n\t\tif (operatorAnnotation != null) {\r\n\t\t\t java.lang.String ruleWeightString = operatorAnnotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.WEIGHT.toString());\r\n\t\t\tif (ruleWeightString != null) {\r\n\t\t\t\ttry {\r\n\t\t\t\t\treturn  java.lang.Integer.parseInt(ruleWeightString);\t\t\t\r\n\t\t\t\t} catch ( java.lang.NumberFormatException e) {\r\n\t\t\t\t\t// ignore exception. invalid numbers are signaled by\r\n\t\t\t\t\t// returning MIN_VALUE\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn  java.lang.Integer.MIN_VALUE;\r\n'"
	 * @generated
	 */
	int getOperatorWeight();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.SyntaxElement> children = getChildren();\r\n\r\n\t\t// there should be at most one child\r\n\t\tassert children == null || children.size() == 1;\r\n\r\n\t\t\r\n\t\tif (children.size() > 0) {\r\n\t\t\t org.emftext.sdk.concretesyntax.SyntaxElement firstChild = children.get(0);\r\n\t\t\tif (firstChild instanceof  org.emftext.sdk.concretesyntax.Choice) {\r\n\t\t\t\treturn ( org.emftext.sdk.concretesyntax.Choice) firstChild;\r\n\t\t\t} else {\r\n\t\t\t\t// there should be no element other than Choice\r\n\t\t\t\tassert false;\r\n\t\t\t\treturn null;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn null;\r\n'"
	 * @generated
	 */
	Choice getDefinition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Checks whether this rule is annotated with the given AnnotationType.
	 *  If a key and a value is given it is further checked whether the
	 *  annotation specifies this key and value. 
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tfor ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations()) {\r\n\t\t\tif (annotation.getType() == type) {\r\n\t\t\t\tif (key != null) {\r\n\t\t\t\t\tfor ( org.emftext.sdk.concretesyntax.KeyValuePair parameter : annotation.getParameters()) {\r\n\t\t\t\t\t\tif (key.equals(parameter.getKey())\r\n\t\t\t\t\t\t\t\t&& parameter.getValue().equals(value)) {\r\n\t\t\t\t\t\t\treturn true;\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t} else {\r\n\t\t\t\t\treturn true;\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn false;\r\n'"
	 * @generated
	 */
	boolean hasAnnotation(AnnotationType type, String key, String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Checks whether this rule is annotated with @Override(remove="true").
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t// TODO mseifert: use constant here\r\n\t\treturn hasAnnotation( org.emftext.sdk.concretesyntax.AnnotationType.OVERRIDE, \"remove\", \"true\");\r\n'"
	 * @generated
	 */
	boolean isOverrideRemoveRule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Checks whether this rule is annotated with @Override.
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t\t\tif (metaClass == null || getMetaclass() == metaClass) {\r\n\t\t\tif (hasAnnotation( org.emftext.sdk.concretesyntax.AnnotationType.OVERRIDE, null, null)) {\r\n\t\t\t\treturn true;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn false;\r\n'"
	 * @generated
	 */
	boolean isOverrideRule(GenClass metaClass);

} // Rule
