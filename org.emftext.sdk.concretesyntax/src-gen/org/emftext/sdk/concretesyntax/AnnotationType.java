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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Annotation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getAnnotationType()
 * @model
 * @generated
 */
public enum AnnotationType implements Enumerator {
	/**
	 * The '<em><b>OVERRIDE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE(0, "OVERRIDE", "Override"),

	/**
	 * The '<em><b>SUPPRESS WARNINGS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPPRESS_WARNINGS_VALUE
	 * @generated
	 * @ordered
	 */
	SUPPRESS_WARNINGS(1, "SUPPRESS_WARNINGS", "SuppressWarnings"), /**
	 * The '<em><b>FOLDABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLDABLE_VALUE
	 * @generated
	 * @ordered
	 */
	FOLDABLE(2, "FOLDABLE", "Foldable"), /**
	 * The '<em><b>OP LEFTASSOC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_LEFTASSOC_VALUE
	 * @generated
	 * @ordered
	 */
	OP_LEFTASSOC(3, "OP_LEFTASSOC", "Leftassoc"), /**
	 * The '<em><b>OP RIGHTASSOC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_RIGHTASSOC_VALUE
	 * @generated
	 * @ordered
	 */
	OP_RIGHTASSOC(4, "OP_RIGHTASSOC", "Rightassoc"), /**
	 * The '<em><b>OP UNARY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_UNARY_VALUE
	 * @generated
	 * @ordered
	 */
	OP_UNARY(5, "OP_UNARY", "Unary"), /**
	 * The '<em><b>OP PRIMITIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OP_PRIMITIVE_VALUE
	 * @generated
	 * @ordered
	 */
	OP_PRIMITIVE(6, "OP_PRIMITIVE", "Primitive");

	/**
	 * The '<em><b>OVERRIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE
	 * @model literal="Override"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_VALUE = 0;

	/**
	 * The '<em><b>SUPPRESS WARNINGS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUPPRESS WARNINGS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUPPRESS_WARNINGS
	 * @model literal="SuppressWarnings"
	 * @generated
	 * @ordered
	 */
	public static final int SUPPRESS_WARNINGS_VALUE = 1;

	/**
	 * The '<em><b>FOLDABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOLDABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLDABLE
	 * @model literal="Foldable"
	 * @generated
	 * @ordered
	 */
	public static final int FOLDABLE_VALUE = 2;

	/**
	 * The '<em><b>OP LEFTASSOC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OP LEFTASSOC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OP_LEFTASSOC
	 * @model literal="Leftassoc"
	 * @generated
	 * @ordered
	 */
	public static final int OP_LEFTASSOC_VALUE = 3;

	/**
	 * The '<em><b>OP RIGHTASSOC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OP RIGHTASSOC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OP_RIGHTASSOC
	 * @model literal="Rightassoc"
	 * @generated
	 * @ordered
	 */
	public static final int OP_RIGHTASSOC_VALUE = 4;

	/**
	 * The '<em><b>OP UNARY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OP UNARY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OP_UNARY
	 * @model literal="Unary"
	 * @generated
	 * @ordered
	 */
	public static final int OP_UNARY_VALUE = 5;

	/**
	 * The '<em><b>OP PRIMITIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OP PRIMITIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OP_PRIMITIVE
	 * @model literal="Primitive"
	 * @generated
	 * @ordered
	 */
	public static final int OP_PRIMITIVE_VALUE = 6;

	/**
	 * An array of all the '<em><b>Annotation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AnnotationType[] VALUES_ARRAY =
		new AnnotationType[] {
			OVERRIDE,
			SUPPRESS_WARNINGS,
			FOLDABLE,
			OP_LEFTASSOC,
			OP_RIGHTASSOC,
			OP_UNARY,
			OP_PRIMITIVE,
		};

	/**
	 * A public read-only list of all the '<em><b>Annotation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AnnotationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Annotation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnnotationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnnotationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Annotation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnnotationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnnotationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Annotation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnnotationType get(int value) {
		switch (value) {
			case OVERRIDE_VALUE: return OVERRIDE;
			case SUPPRESS_WARNINGS_VALUE: return SUPPRESS_WARNINGS;
			case FOLDABLE_VALUE: return FOLDABLE;
			case OP_LEFTASSOC_VALUE: return OP_LEFTASSOC;
			case OP_RIGHTASSOC_VALUE: return OP_RIGHTASSOC;
			case OP_UNARY_VALUE: return OP_UNARY;
			case OP_PRIMITIVE_VALUE: return OP_PRIMITIVE;
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
	private AnnotationType(int value, String name, String literal) {
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
	
} //AnnotationType
