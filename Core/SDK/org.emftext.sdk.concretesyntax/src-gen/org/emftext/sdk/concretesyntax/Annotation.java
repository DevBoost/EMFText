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
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Annotation#getType <em>Type</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Annotation#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emftext.sdk.concretesyntax.AnnotationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.emftext.sdk.concretesyntax.AnnotationType
	 * @see #setType(AnnotationType)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getAnnotation_Type()
	 * @model required="true"
	 * @generated
	 */
	AnnotationType getType();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Annotation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.emftext.sdk.concretesyntax.AnnotationType
	 * @see #getType()
	 * @generated
	 */
	void setType(AnnotationType value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.KeyValuePair}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getAnnotation_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyValuePair> getParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Returns the annotation value for the given key.
	 * 
	 * <!-- end-model-doc -->
	 * @model keyRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for ( org.emftext.sdk.concretesyntax.KeyValuePair parameter : getParameters()) {\n\tif (key.equals(parameter.getKey())){\n\t\tjava.lang.String value = parameter.getValue();\n\t\treturn value;\n\t}\n}\nreturn null;'"
	 * @generated
	 */
	String getValue(String key);

} // Annotation
