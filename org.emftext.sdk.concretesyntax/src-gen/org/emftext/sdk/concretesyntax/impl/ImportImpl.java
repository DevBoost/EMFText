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
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Import;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ImportImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ImportImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.ImportImpl#getCsLocationHint <em>Cs Location Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportImpl extends GenPackageDependentElementImpl implements Import {
	/**
   * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getPrefix()
   * @generated
   * @ordered
   */
	protected static final String PREFIX_EDEFAULT = null;

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
   * The cached value of the '{@link #getConcreteSyntax() <em>Concrete Syntax</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getConcreteSyntax()
   * @generated
   * @ordered
   */
	protected ConcreteSyntax concreteSyntax;

	/**
   * The default value of the '{@link #getCsLocationHint() <em>Cs Location Hint</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCsLocationHint()
   * @generated
   * @ordered
   */
	protected static final String CS_LOCATION_HINT_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getCsLocationHint() <em>Cs Location Hint</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCsLocationHint()
   * @generated
   * @ordered
   */
	protected String csLocationHint = CS_LOCATION_HINT_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ImportImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ConcretesyntaxPackage.Literals.IMPORT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.IMPORT__PREFIX, oldPrefix, prefix));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ConcreteSyntax getConcreteSyntax() {
    if (concreteSyntax != null && concreteSyntax.eIsProxy())
    {
      InternalEObject oldConcreteSyntax = (InternalEObject)concreteSyntax;
      concreteSyntax = (ConcreteSyntax)eResolveProxy(oldConcreteSyntax);
      if (concreteSyntax != oldConcreteSyntax)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
      }
    }
    return concreteSyntax;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ConcreteSyntax basicGetConcreteSyntax() {
    return concreteSyntax;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setConcreteSyntax(ConcreteSyntax newConcreteSyntax) {
    ConcreteSyntax oldConcreteSyntax = concreteSyntax;
    concreteSyntax = newConcreteSyntax;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getCsLocationHint() {
    return csLocationHint;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setCsLocationHint(String newCsLocationHint) {
    String oldCsLocationHint = csLocationHint;
    csLocationHint = newCsLocationHint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT, oldCsLocationHint, csLocationHint));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case ConcretesyntaxPackage.IMPORT__PREFIX:
        return getPrefix();
      case ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX:
        if (resolve) return getConcreteSyntax();
        return basicGetConcreteSyntax();
      case ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT:
        return getCsLocationHint();
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
    switch (featureID)
    {
      case ConcretesyntaxPackage.IMPORT__PREFIX:
        setPrefix((String)newValue);
        return;
      case ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX:
        setConcreteSyntax((ConcreteSyntax)newValue);
        return;
      case ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT:
        setCsLocationHint((String)newValue);
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
    switch (featureID)
    {
      case ConcretesyntaxPackage.IMPORT__PREFIX:
        setPrefix(PREFIX_EDEFAULT);
        return;
      case ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX:
        setConcreteSyntax((ConcreteSyntax)null);
        return;
      case ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT:
        setCsLocationHint(CS_LOCATION_HINT_EDEFAULT);
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
    switch (featureID)
    {
      case ConcretesyntaxPackage.IMPORT__PREFIX:
        return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
      case ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX:
        return concreteSyntax != null;
      case ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT:
        return CS_LOCATION_HINT_EDEFAULT == null ? csLocationHint != null : !CS_LOCATION_HINT_EDEFAULT.equals(csLocationHint);
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
    result.append(", csLocationHint: ");
    result.append(csLocationHint);
    result.append(')');
    return result.toString();
  }

} //ImportImpl
