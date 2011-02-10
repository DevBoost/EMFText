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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.RegexComposite;
import org.emftext.sdk.concretesyntax.RegexPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regex Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.RegexCompositeImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.RegexCompositeImpl#getRegexParts <em>Regex Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RegexCompositeImpl extends EObjectImpl implements RegexComposite {
	/**
	 * The default value of the '{@link #getRegex() <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String REGEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegexParts() <em>Regex Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegexParts()
	 * @generated
	 * @ordered
	 */
	protected EList<RegexPart> regexParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegexCompositeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.REGEX_COMPOSITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegex() {
		
				 java.lang.StringBuilder result = new  java.lang.StringBuilder();
		
				for ( org.emftext.sdk.concretesyntax.RegexPart part : getRegexParts()) {
					result.append(part.getRegex());
				}
		
				return result.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegexPart> getRegexParts() {
		if (regexParts == null) {
			regexParts = new EObjectContainmentEList<RegexPart>(RegexPart.class, this, ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS);
		}
		return regexParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS:
				return ((InternalEList<?>)getRegexParts()).basicRemove(otherEnd, msgs);
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
			case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX:
				return getRegex();
			case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS:
				return getRegexParts();
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
			case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS:
				getRegexParts().clear();
				getRegexParts().addAll((Collection<? extends RegexPart>)newValue);
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
			case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS:
				getRegexParts().clear();
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
			case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX:
				return REGEX_EDEFAULT == null ? getRegex() != null : !REGEX_EDEFAULT.equals(getRegex());
			case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS:
				return regexParts != null && !regexParts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RegexCompositeImpl
