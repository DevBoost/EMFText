/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *  *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 *  
 * 
 */
package org.emftext.sdk.concretesyntax.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Placeholder In Quotes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.PlaceholderInQuotesImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.PlaceholderInQuotesImpl#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.PlaceholderInQuotesImpl#getEscapeCharacter <em>Escape Character</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlaceholderInQuotesImpl extends PlaceholderImpl implements PlaceholderInQuotes {
	/**
	 * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFIX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected String prefix = PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String SUFFIX_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuffix()
	 * @generated
	 * @ordered
	 */
	protected String suffix = SUFFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getEscapeCharacter() <em>Escape Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscapeCharacter()
	 * @generated
	 * @ordered
	 */
	protected static final String ESCAPE_CHARACTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEscapeCharacter() <em>Escape Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscapeCharacter()
	 * @generated
	 * @ordered
	 */
	protected String escapeCharacter = ESCAPE_CHARACTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceholderInQuotesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.PLACEHOLDER_IN_QUOTES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrefix(String newPrefix) {
		String oldPrefix = prefix;
		prefix = newPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX, oldPrefix, prefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuffix(String newSuffix) {
		String oldSuffix = suffix;
		suffix = newSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX, oldSuffix, suffix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEscapeCharacter() {
		return escapeCharacter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEscapeCharacter(String newEscapeCharacter) {
		String oldEscapeCharacter = escapeCharacter;
		escapeCharacter = newEscapeCharacter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER, oldEscapeCharacter, escapeCharacter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNormalizedPrefix() {
		
				 java.lang.String prefix = getPrefix();
		
				if (prefix == null) return prefix;
		
				if (prefix.length() == 0) return null;
		
				return prefix;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNormalizedSuffix() {
		
				 java.lang.String suffix = getSuffix();
		
				if (suffix == null) return suffix;
		
				if (suffix.length() == 0) return null;
		
				return suffix;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNormalizedEscapeCharacter() {
		
				 java.lang.String escapeCharacter = getEscapeCharacter();
		
				if (escapeCharacter == null) return escapeCharacter;
		
				if (escapeCharacter.length() == 0) return null;
		
				return escapeCharacter;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		
				if (eIsProxy()) return super.toString();
		
		
				 java.lang.StringBuffer result = new  java.lang.StringBuffer();
		
				 org.eclipse.emf.codegen.ecore.genmodel.GenFeature feature = getFeature();
		
				if (feature != null && feature.getEcoreFeature() != null) {
					result.append(feature.getName());
				}
		
				result.append("['");
		
				result.append(getPrefix());
		
				result.append("', '");
		
				result.append(getSuffix());
		
				result.append("']");
		
				return result.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX:
				return getPrefix();
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX:
				return getSuffix();
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER:
				return getEscapeCharacter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX:
				setPrefix((String)newValue);
				return;
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX:
				setSuffix((String)newValue);
				return;
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER:
				setEscapeCharacter((String)newValue);
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
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
				return;
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX:
				setSuffix(SUFFIX_EDEFAULT);
				return;
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER:
				setEscapeCharacter(ESCAPE_CHARACTER_EDEFAULT);
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
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX:
				return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX:
				return SUFFIX_EDEFAULT == null ? suffix != null : !SUFFIX_EDEFAULT.equals(suffix);
			case ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER:
				return ESCAPE_CHARACTER_EDEFAULT == null ? escapeCharacter != null : !ESCAPE_CHARACTER_EDEFAULT.equals(escapeCharacter);
		}
		return super.eIsSet(featureID);
	}

} //PlaceholderInQuotesImpl
