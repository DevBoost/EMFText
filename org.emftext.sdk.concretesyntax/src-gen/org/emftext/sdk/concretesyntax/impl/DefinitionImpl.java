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
package org.emftext.sdk.concretesyntax.impl;

import org.eclipse.emf.ecore.EClass;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Definition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class DefinitionImpl extends SyntaxElementImpl implements Definition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasMinimalCardinalityOneOrHigher() {
		
				return true;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasNoOptionalPart() {
		
				return false;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String computeCardinalityString() {
		
				 org.emftext.sdk.concretesyntax.Cardinality cardinality =  org.emftext.sdk.concretesyntax.Cardinality.NONE;
		
				if (this instanceof  org.emftext.sdk.concretesyntax.CardinalityDefinition) {
					cardinality = (( org.emftext.sdk.concretesyntax.CardinalityDefinition) this).getCardinality();
				}
		
				if (cardinality ==  org.emftext.sdk.concretesyntax.Cardinality.NONE) {
					return "";
				} else if (cardinality ==  org.emftext.sdk.concretesyntax.Cardinality.PLUS) {
					return "+";
				} else if (cardinality ==  org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK) {
					return "?";
				} else {
					return "*";
				}
		
	}

} //DefinitionImpl
