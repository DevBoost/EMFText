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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations()) {\n\tif (annotation.getType() == org.emftext.sdk.concretesyntax.AnnotationType.OPERATOR) {\n\t\treturn annotation;\n\t}\n}\nreturn null;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.emftext.sdk.concretesyntax.Annotation operatorAnnotation = this.getOperatorAnnotation();\nif (operatorAnnotation != null) {\n\tjava.lang.String ruleWeightString = operatorAnnotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.WEIGHT.toString());\n\tif (ruleWeightString != null) {\n\t\ttry {\n\t\t\treturn java.lang.Integer.parseInt(ruleWeightString);\t\t\t\n\t\t} catch ( java.lang.NumberFormatException e) {\n\t\t\t// ignore exception. invalid numbers are signaled by\n\t\t\t// returning MIN_VALUE\n\t\t}\n\t}\n}\nreturn java.lang.Integer.MIN_VALUE;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.SyntaxElement> children = getChildren();\n// there should be at most one child\nassert children == null || children.size() == 1;\n\nif (children.size() > 0) {\n\torg.emftext.sdk.concretesyntax.SyntaxElement firstChild = children.get(0);\n\tif (firstChild instanceof org.emftext.sdk.concretesyntax.Choice) {\n\t\treturn ( org.emftext.sdk.concretesyntax.Choice) firstChild;\n\t} else {\n\t\t// there should be no element other than Choice\n\t\tassert false;\n\t\treturn null;\n\t}\n}\nreturn null;'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations()) {\n\tif (annotation.getType() == type) {\n\t\tif (key != null) {\n\t\t\tfor ( org.emftext.sdk.concretesyntax.KeyValuePair parameter : annotation.getParameters()) {\n\t\t\t\tif (key.equals(parameter.getKey())\n\t\t\t\t\t\t&& parameter.getValue().equals(value)) {\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t}\n\t\t} else {\n\t\t\treturn true;\n\t\t}\n\t}\n}\nreturn false;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='// TODO mseifert: use constant here\nreturn hasAnnotation( org.emftext.sdk.concretesyntax.AnnotationType.OVERRIDE, \"remove\", \"true\");'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (metaClass == null || getMetaclass() == metaClass) {\n\tif (hasAnnotation( org.emftext.sdk.concretesyntax.AnnotationType.OVERRIDE, null, null)) {\n\t\treturn true;\n\t}\n}\nreturn false;'"
	 * @generated
	 */
	boolean isOverrideRule(GenClass metaClass);

} // Rule
