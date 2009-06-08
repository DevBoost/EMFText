/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
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
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.TokenDefinition;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl#getAttributeReferences <em>Attribute References</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl#isHidden <em>Hidden</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl#isUsed <em>Used</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TokenDefinitionImpl extends TokenDirectiveImpl implements TokenDefinition {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #getRegex() <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String REGEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegex() <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegex()
	 * @generated
	 * @ordered
	 */
	protected String regex = REGEX_EDEFAULT;

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
	protected TokenDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.TOKEN_DEFINITION;
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.TOKEN_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Placeholder> getAttributeReferences() {
		if (attributeReferences == null) {
			attributeReferences = new EObjectWithInverseResolvingEList<Placeholder>(Placeholder.class, this, ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_REFERENCES, ConcretesyntaxPackage.PLACEHOLDER__TOKEN);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_NAME, oldAttributeName, attributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegex() {
		return regex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegex(String newRegex) {
		String oldRegex = regex;
		regex = newRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.TOKEN_DEFINITION__REGEX, oldRegex, regex));
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
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
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
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
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
			case ConcretesyntaxPackage.TOKEN_DEFINITION__NAME:
				return getName();
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				return getAttributeReferences();
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_NAME:
				return getAttributeName();
			case ConcretesyntaxPackage.TOKEN_DEFINITION__REGEX:
				return getRegex();
			case ConcretesyntaxPackage.TOKEN_DEFINITION__HIDDEN:
				return isHidden() ? Boolean.TRUE : Boolean.FALSE;
			case ConcretesyntaxPackage.TOKEN_DEFINITION__USED:
				return isUsed() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConcretesyntaxPackage.TOKEN_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				getAttributeReferences().clear();
				getAttributeReferences().addAll((Collection<? extends Placeholder>)newValue);
				return;
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
				return;
			case ConcretesyntaxPackage.TOKEN_DEFINITION__REGEX:
				setRegex((String)newValue);
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
			case ConcretesyntaxPackage.TOKEN_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				getAttributeReferences().clear();
				return;
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_NAME:
				setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
				return;
			case ConcretesyntaxPackage.TOKEN_DEFINITION__REGEX:
				setRegex(REGEX_EDEFAULT);
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
			case ConcretesyntaxPackage.TOKEN_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_REFERENCES:
				return attributeReferences != null && !attributeReferences.isEmpty();
			case ConcretesyntaxPackage.TOKEN_DEFINITION__ATTRIBUTE_NAME:
				return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
			case ConcretesyntaxPackage.TOKEN_DEFINITION__REGEX:
				return REGEX_EDEFAULT == null ? regex != null : !REGEX_EDEFAULT.equals(regex);
			case ConcretesyntaxPackage.TOKEN_DEFINITION__HIDDEN:
				return isHidden() != HIDDEN_EDEFAULT;
			case ConcretesyntaxPackage.TOKEN_DEFINITION__USED:
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", attributeName: ");
		result.append(attributeName);
		result.append(", regex: ");
		result.append(regex);
		result.append(')');
		return result.toString();
	}

} //TokenDefinitionImpl
