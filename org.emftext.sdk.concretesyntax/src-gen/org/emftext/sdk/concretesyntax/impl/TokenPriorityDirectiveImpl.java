/*******************************************************************************
 * Copyright (c) 2006-2009 
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
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token Priority Directive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenPriorityDirectiveImpl#getToken <em>Token</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TokenPriorityDirectiveImpl extends TokenDirectiveImpl implements TokenPriorityDirective {
	/**
	 * The cached value of the '{@link #getToken() <em>Token</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToken()
	 * @generated
	 * @ordered
	 */
	protected TokenDefinition token;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TokenPriorityDirectiveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.TOKEN_PRIORITY_DIRECTIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TokenDefinition getToken() {
		if (token != null && token.eIsProxy()) {
			InternalEObject oldToken = (InternalEObject)token;
			token = (TokenDefinition)eResolveProxy(oldToken);
			if (token != oldToken) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN, oldToken, token));
			}
		}
		return token;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TokenDefinition basicGetToken() {
		return token;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToken(TokenDefinition newToken) {
		TokenDefinition oldToken = token;
		token = newToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN, oldToken, token));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN:
				if (resolve) return getToken();
				return basicGetToken();
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
			case ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN:
				setToken((TokenDefinition)newValue);
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
			case ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN:
				setToken((TokenDefinition)null);
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
			case ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN:
				return token != null;
		}
		return super.eIsSet(featureID);
	}

} //TokenPriorityDirectiveImpl
