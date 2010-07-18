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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.sdk.concretesyntax.Annotable;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.RegexComposite;
import org.emftext.sdk.concretesyntax.RegexPart;
import org.emftext.sdk.concretesyntax.TokenRedefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token Redefinition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenRedefinitionImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenRedefinitionImpl#getRegexParts <em>Regex Parts</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenRedefinitionImpl#getRedefinedToken <em>Redefined Token</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TokenRedefinitionImpl extends CompleteTokenDefinitionImpl implements TokenRedefinition {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

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
	 * The cached value of the '{@link #getRedefinedToken() <em>Redefined Token</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefinedToken()
	 * @generated
	 * @ordered
	 */
	protected CompleteTokenDefinition redefinedToken;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TokenRedefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.TOKEN_REDEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegex() {
		org.emftext.sdk.concretesyntax.RegexComposer composer = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexComposer(); 
		return composer .getComposedRegex ( this , new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > ( ) ) ; 
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegexPart> getRegexParts() {
		if (regexParts == null) {
			regexParts = new EObjectContainmentEList<RegexPart>(RegexPart.class, this, ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS);
		}
		return regexParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteTokenDefinition getRedefinedToken() {
		if (redefinedToken != null && redefinedToken.eIsProxy()) {
			InternalEObject oldRedefinedToken = (InternalEObject)redefinedToken;
			redefinedToken = (CompleteTokenDefinition)eResolveProxy(oldRedefinedToken);
			if (redefinedToken != oldRedefinedToken) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN, oldRedefinedToken, redefinedToken));
			}
		}
		return redefinedToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteTokenDefinition basicGetRedefinedToken() {
		return redefinedToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedefinedToken(CompleteTokenDefinition newRedefinedToken) {
		CompleteTokenDefinition oldRedefinedToken = redefinedToken;
		redefinedToken = newRedefinedToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN, oldRedefinedToken, redefinedToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS:
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
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS:
				return getAnnotations();
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS:
				return getRegexParts();
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN:
				if (resolve) return getRedefinedToken();
				return basicGetRedefinedToken();
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
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS:
				getRegexParts().clear();
				getRegexParts().addAll((Collection<? extends RegexPart>)newValue);
				return;
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN:
				setRedefinedToken((CompleteTokenDefinition)newValue);
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
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS:
				getRegexParts().clear();
				return;
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN:
				setRedefinedToken((CompleteTokenDefinition)null);
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
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS:
				return regexParts != null && !regexParts.isEmpty();
			case ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN:
				return redefinedToken != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Annotable.class) {
			switch (derivedFeatureID) {
				case ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS: return ConcretesyntaxPackage.ANNOTABLE__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == RegexComposite.class) {
			switch (derivedFeatureID) {
				case ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS: return ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Annotable.class) {
			switch (baseFeatureID) {
				case ConcretesyntaxPackage.ANNOTABLE__ANNOTATIONS: return ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == RegexComposite.class) {
			switch (baseFeatureID) {
				case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS: return ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //TokenRedefinitionImpl
