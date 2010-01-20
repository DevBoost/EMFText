/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.PartialToken;
import org.emftext.sdk.concretesyntax.RegexComposite;
import org.emftext.sdk.concretesyntax.RegexOwner;
import org.emftext.sdk.concretesyntax.RegexPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partial Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.PartialTokenImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.PartialTokenImpl#getRegexParts <em>Regex Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartialTokenImpl extends TokenDirectiveImpl implements PartialToken {
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
	protected PartialTokenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.PARTIAL_TOKEN;
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
	public EList<RegexPart> getRegexParts() {
		if (regexParts == null) {
			regexParts = new EObjectContainmentEList<RegexPart>(RegexPart.class, this, ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX_PARTS);
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
			case ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX_PARTS:
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
			case ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX:
				return getRegex();
			case ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX_PARTS:
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
			case ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX_PARTS:
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
			case ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX_PARTS:
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
			case ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX:
				return REGEX_EDEFAULT == null ? getRegex() != null : !REGEX_EDEFAULT.equals(getRegex());
			case ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX_PARTS:
				return regexParts != null && !regexParts.isEmpty();
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
		if (baseClass == RegexOwner.class) {
			switch (derivedFeatureID) {
				case ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX: return ConcretesyntaxPackage.REGEX_OWNER__REGEX;
				default: return -1;
			}
		}
		if (baseClass == RegexComposite.class) {
			switch (derivedFeatureID) {
				case ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX_PARTS: return ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS;
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
		if (baseClass == RegexOwner.class) {
			switch (baseFeatureID) {
				case ConcretesyntaxPackage.REGEX_OWNER__REGEX: return ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX;
				default: return -1;
			}
		}
		if (baseClass == RegexComposite.class) {
			switch (baseFeatureID) {
				case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS: return ConcretesyntaxPackage.PARTIAL_TOKEN__REGEX_PARTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //PartialTokenImpl
