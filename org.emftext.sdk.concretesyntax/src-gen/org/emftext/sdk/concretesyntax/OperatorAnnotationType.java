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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operator Annotation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getOperatorAnnotationType()
 * @model
 * @generated
 */
public enum OperatorAnnotationType implements Enumerator {
	/**
	 * The '<em><b>Binary left associative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY_LEFT_ASSOCIATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_LEFT_ASSOCIATIVE(0, "binary_left_associative", "binary_left_associative"),

	/**
	 * The '<em><b>Binary right associative</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY_RIGHT_ASSOCIATIVE_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_RIGHT_ASSOCIATIVE(1, "binary_right_associative", "binary_right_associative"),

	/**
	 * The '<em><b>Unary prefix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNARY_PREFIX_VALUE
	 * @generated
	 * @ordered
	 */
	UNARY_PREFIX(2, "unary_prefix", "unary_prefix"), /**
	 * The '<em><b>Unary postfix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNARY_POSTFIX_VALUE
	 * @generated
	 * @ordered
	 */
	UNARY_POSTFIX(3, "unary_postfix", "unary_postfix"), /**
	 * The '<em><b>Primitive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIMITIVE_VALUE
	 * @generated
	 * @ordered
	 */
	PRIMITIVE(4, "primitive", "primitive");

	/**
	 * The '<em><b>Binary left associative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Binary left associative</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BINARY_LEFT_ASSOCIATIVE
	 * @model name="binary_left_associative"
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_LEFT_ASSOCIATIVE_VALUE = 0;

	/**
	 * The '<em><b>Binary right associative</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Binary right associative</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BINARY_RIGHT_ASSOCIATIVE
	 * @model name="binary_right_associative"
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_RIGHT_ASSOCIATIVE_VALUE = 1;

	/**
	 * The '<em><b>Unary prefix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unary prefix</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNARY_PREFIX
	 * @model name="unary_prefix"
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_PREFIX_VALUE = 2;

	/**
	 * The '<em><b>Unary postfix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unary postfix</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNARY_POSTFIX
	 * @model name="unary_postfix"
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_POSTFIX_VALUE = 3;

	/**
	 * The '<em><b>Primitive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Primitive</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIMITIVE
	 * @model name="primitive"
	 * @generated
	 * @ordered
	 */
	public static final int PRIMITIVE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Operator Annotation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OperatorAnnotationType[] VALUES_ARRAY =
		new OperatorAnnotationType[] {
			BINARY_LEFT_ASSOCIATIVE,
			BINARY_RIGHT_ASSOCIATIVE,
			UNARY_PREFIX,
			UNARY_POSTFIX,
			PRIMITIVE,
		};

	/**
	 * A public read-only list of all the '<em><b>Operator Annotation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OperatorAnnotationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operator Annotation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatorAnnotationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperatorAnnotationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator Annotation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatorAnnotationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperatorAnnotationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator Annotation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatorAnnotationType get(int value) {
		switch (value) {
			case BINARY_LEFT_ASSOCIATIVE_VALUE: return BINARY_LEFT_ASSOCIATIVE;
			case BINARY_RIGHT_ASSOCIATIVE_VALUE: return BINARY_RIGHT_ASSOCIATIVE;
			case UNARY_PREFIX_VALUE: return UNARY_PREFIX;
			case UNARY_POSTFIX_VALUE: return UNARY_POSTFIX;
			case PRIMITIVE_VALUE: return PRIMITIVE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private OperatorAnnotationType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //OperatorAnnotationType
