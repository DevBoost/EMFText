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
package org.emftext.sdk.concretesyntax.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.RegexOwner;
import org.emftext.sdk.concretesyntax.TokenDirective;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.CompleteTokenDefinitionImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.CompleteTokenDefinitionImpl#getAttributeReferences <em>Attribute References</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.CompleteTokenDefinitionImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.CompleteTokenDefinitionImpl#isHidden <em>Hidden</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.CompleteTokenDefinitionImpl#isUsed <em>Used</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompleteTokenDefinitionImpl extends AbstractTokenDefinitionImpl implements CompleteTokenDefinition {
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
	 * The cached value of the '{@link #getAttributeReferences() <em>Attribute References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Placeholder> attributeReferences;

	/**
	 * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isHidden() <em>Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHidden()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDDEN_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isUsed() <em>Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteTokenDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.COMPLETE_TOKEN_DEFINITION;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegex() {
		// TODO: implement this method to return the 'Regex' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Placeholder> getAttributeReferences() {
		if (attributeReferences == null) {
			attributeReferences = new EObjectWithInverseResolvingEList<Placeholder>(Placeholder.class, this, ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES, ConcretesyntaxPackage.PLACEHOLDER__TOKEN);
		}
		return attributeReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeName(String newAttributeName) {
		String oldAttributeName = attributeName;
		attributeName = newAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME, oldAttributeName, attributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isHidden() {
		boolean isReferenced = !getAttributeReferences().isEmpty();
		boolean isCollectInToken = getAttributeName() != null;
		return !isReferenced || isCollectInToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isUsed() {
		boolean isReferenced = !getAttributeReferences().isEmpty();
		boolean isCollectInToken = getAttributeName() != null;
		return isReferenced || isCollectInToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributeReferences()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				return ((InternalEList<?>)getAttributeReferences()).basicRemove(otherEnd, msgs);
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
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__REGEX:
				return getRegex();
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				return getAttributeReferences();
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME:
				return getAttributeName();
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__HIDDEN:
				return isHidden();
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__USED:
				return isUsed();
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
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				getAttributeReferences().clear();
				getAttributeReferences().addAll((Collection<? extends Placeholder>)newValue);
				return;
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
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
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				getAttributeReferences().clear();
				return;
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME:
				setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
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
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__REGEX:
				return REGEX_EDEFAULT == null ? getRegex() != null : !REGEX_EDEFAULT.equals(getRegex());
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				return attributeReferences != null && !attributeReferences.isEmpty();
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME:
				return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__HIDDEN:
				return isHidden() != HIDDEN_EDEFAULT;
			case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__USED:
				return isUsed() != USED_EDEFAULT;
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
		if (baseClass == TokenDirective.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == RegexOwner.class) {
			switch (derivedFeatureID) {
				case ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__REGEX: return ConcretesyntaxPackage.REGEX_OWNER__REGEX;
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
		if (baseClass == TokenDirective.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == RegexOwner.class) {
			switch (baseFeatureID) {
				case ConcretesyntaxPackage.REGEX_OWNER__REGEX: return ConcretesyntaxPackage.COMPLETE_TOKEN_DEFINITION__REGEX;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (attributeName: ");
		result.append(attributeName);
		result.append(')');
		return result.toString();
	}

} //TokenDefinitionImpl
