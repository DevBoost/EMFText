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
 */
package org.emftext.sdk.concretesyntax.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.EnumTerminal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Terminal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.EnumTerminalImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumTerminalImpl extends TerminalImpl implements EnumTerminal {
	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumLiteralTerminal> literals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumTerminalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.ENUM_TERMINAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumLiteralTerminal> getLiterals() {
		if (literals == null) {
			literals = new EObjectContainmentEList<EnumLiteralTerminal>(EnumLiteralTerminal.class, this, ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS);
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsEmptyLiteral() {
		// TODO mseifert: move this method to EnumTerminal.ejava
		return !getEmptyLiterals().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EnumLiteralTerminal> getNonEmptyLiterals() {
		// TODO mseifert: move this method to EnumTerminal.ejava
		EList<EnumLiteralTerminal> nonEmptyLiterals = new BasicEList<EnumLiteralTerminal>();
		for (EnumLiteralTerminal literal : getLiterals()) {
			String text = literal.getText();
			if (text != null && !"".equals(text)) {
				nonEmptyLiterals.add(literal);
			}
		}
		return nonEmptyLiterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EnumLiteralTerminal> getEmptyLiterals() {
		// TODO mseifert: move this method to EnumTerminal.ejava
		EList<EnumLiteralTerminal> emptyLiterals = new BasicEList<EnumLiteralTerminal>();
		for (EnumLiteralTerminal literal : getLiterals()) {
			String text = literal.getText();
			if ("".equals(text)) {
				emptyLiterals.add(literal);
			}
		}
		return emptyLiterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS:
				return ((InternalEList<?>)getLiterals()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS:
				return getLiterals();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends EnumLiteralTerminal>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS:
				getLiterals().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS:
				return literals != null && !literals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnumTerminalImpl
