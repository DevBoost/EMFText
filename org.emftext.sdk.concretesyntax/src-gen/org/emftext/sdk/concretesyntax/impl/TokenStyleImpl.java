/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.TokenStyle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenStyleImpl#getTokenName <em>Token Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenStyleImpl#getRgb <em>Rgb</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.TokenStyleImpl#getFontStyles <em>Font Styles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TokenStyleImpl extends EObjectImpl implements TokenStyle {
	/**
	 * The default value of the '{@link #getTokenName() <em>Token Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokenName()
	 * @generated
	 * @ordered
	 */
	protected static final String TOKEN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTokenName() <em>Token Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokenName()
	 * @generated
	 * @ordered
	 */
	protected String tokenName = TOKEN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRgb() <em>Rgb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRgb()
	 * @generated
	 * @ordered
	 */
	protected static final String RGB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRgb() <em>Rgb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRgb()
	 * @generated
	 * @ordered
	 */
	protected String rgb = RGB_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFontStyles() <em>Font Styles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontStyles()
	 * @generated
	 * @ordered
	 */
	protected EList<FontStyle> fontStyles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TokenStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.TOKEN_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTokenName() {
		return tokenName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTokenName(String newTokenName) {
		String oldTokenName = tokenName;
		tokenName = newTokenName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME, oldTokenName, tokenName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRgb() {
		return rgb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRgb(String newRgb) {
		String oldRgb = rgb;
		rgb = newRgb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.TOKEN_STYLE__RGB, oldRgb, rgb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FontStyle> getFontStyles() {
		if (fontStyles == null) {
			fontStyles = new EDataTypeUniqueEList<FontStyle>(FontStyle.class, this, ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES);
		}
		return fontStyles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME:
				return getTokenName();
			case ConcretesyntaxPackage.TOKEN_STYLE__RGB:
				return getRgb();
			case ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES:
				return getFontStyles();
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
			case ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME:
				setTokenName((String)newValue);
				return;
			case ConcretesyntaxPackage.TOKEN_STYLE__RGB:
				setRgb((String)newValue);
				return;
			case ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES:
				getFontStyles().clear();
				getFontStyles().addAll((Collection<? extends FontStyle>)newValue);
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
			case ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME:
				setTokenName(TOKEN_NAME_EDEFAULT);
				return;
			case ConcretesyntaxPackage.TOKEN_STYLE__RGB:
				setRgb(RGB_EDEFAULT);
				return;
			case ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES:
				getFontStyles().clear();
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
			case ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME:
				return TOKEN_NAME_EDEFAULT == null ? tokenName != null : !TOKEN_NAME_EDEFAULT.equals(tokenName);
			case ConcretesyntaxPackage.TOKEN_STYLE__RGB:
				return RGB_EDEFAULT == null ? rgb != null : !RGB_EDEFAULT.equals(rgb);
			case ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES:
				return fontStyles != null && !fontStyles.isEmpty();
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
		result.append(" (tokenName: ");
		result.append(tokenName);
		result.append(", rgb: ");
		result.append(rgb);
		result.append(", fontStyles: ");
		result.append(fontStyles);
		result.append(')');
		return result.toString();
	}

} //TokenStyleImpl
