/*******************************************************************************
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
 ******************************************************************************/
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
import org.emftext.sdk.concretesyntax.QuotedTokenDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quoted Token Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.QuotedTokenDefinitionImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.QuotedTokenDefinitionImpl#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.QuotedTokenDefinitionImpl#getEscapeCharacter <em>Escape Character</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.QuotedTokenDefinitionImpl#getSynthesizedRegex <em>Synthesized Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuotedTokenDefinitionImpl extends CompleteTokenDefinitionImpl implements QuotedTokenDefinition {
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
	 * The default value of the '{@link #getSynthesizedRegex() <em>Synthesized Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynthesizedRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNTHESIZED_REGEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSynthesizedRegex() <em>Synthesized Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynthesizedRegex()
	 * @generated
	 * @ordered
	 */
	protected String synthesizedRegex = SYNTHESIZED_REGEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuotedTokenDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.QUOTED_TOKEN_DEFINITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__PREFIX, oldPrefix, prefix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SUFFIX, oldSuffix, suffix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__ESCAPE_CHARACTER, oldEscapeCharacter, escapeCharacter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSynthesizedRegex() {
		return synthesizedRegex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynthesizedRegex(String newSynthesizedRegex) {
		String oldSynthesizedRegex = synthesizedRegex;
		synthesizedRegex = newSynthesizedRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SYNTHESIZED_REGEX, oldSynthesizedRegex, synthesizedRegex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegex() {
		
				return getSynthesizedRegex();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__PREFIX:
				return getPrefix();
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SUFFIX:
				return getSuffix();
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__ESCAPE_CHARACTER:
				return getEscapeCharacter();
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SYNTHESIZED_REGEX:
				return getSynthesizedRegex();
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
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__PREFIX:
				setPrefix((String)newValue);
				return;
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SUFFIX:
				setSuffix((String)newValue);
				return;
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__ESCAPE_CHARACTER:
				setEscapeCharacter((String)newValue);
				return;
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SYNTHESIZED_REGEX:
				setSynthesizedRegex((String)newValue);
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
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
				return;
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SUFFIX:
				setSuffix(SUFFIX_EDEFAULT);
				return;
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__ESCAPE_CHARACTER:
				setEscapeCharacter(ESCAPE_CHARACTER_EDEFAULT);
				return;
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SYNTHESIZED_REGEX:
				setSynthesizedRegex(SYNTHESIZED_REGEX_EDEFAULT);
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
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__PREFIX:
				return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SUFFIX:
				return SUFFIX_EDEFAULT == null ? suffix != null : !SUFFIX_EDEFAULT.equals(suffix);
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__ESCAPE_CHARACTER:
				return ESCAPE_CHARACTER_EDEFAULT == null ? escapeCharacter != null : !ESCAPE_CHARACTER_EDEFAULT.equals(escapeCharacter);
			case ConcretesyntaxPackage.QUOTED_TOKEN_DEFINITION__SYNTHESIZED_REGEX:
				return SYNTHESIZED_REGEX_EDEFAULT == null ? synthesizedRegex != null : !SYNTHESIZED_REGEX_EDEFAULT.equals(synthesizedRegex);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (prefix: ");
		result.append(prefix);
		result.append(", suffix: ");
		result.append(suffix);
		result.append(", escapeCharacter: ");
		result.append(escapeCharacter);
		result.append(", synthesizedRegex: ");
		result.append(synthesizedRegex);
		result.append(')');
		return result.toString();
	}

} //QuotedTokenDefinitionImpl
