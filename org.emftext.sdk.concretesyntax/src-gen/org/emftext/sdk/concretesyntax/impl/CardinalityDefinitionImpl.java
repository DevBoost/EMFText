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
package org.emftext.sdk.concretesyntax.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cardinality Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.CardinalityDefinitionImpl#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CardinalityDefinitionImpl extends DefinitionImpl implements CardinalityDefinition
{
  /**
	 * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
  protected Cardinality cardinality;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CardinalityDefinitionImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return ConcretesyntaxPackage.Literals.CARDINALITY_DEFINITION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Cardinality getCardinality()
  {
		return cardinality;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetCardinality(Cardinality newCardinality, NotificationChain msgs)
  {
		Cardinality oldCardinality = cardinality;
		cardinality = newCardinality;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY, oldCardinality, newCardinality);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCardinality(Cardinality newCardinality)
  {
		if (newCardinality != cardinality) {
			NotificationChain msgs = null;
			if (cardinality != null)
				msgs = ((InternalEObject)cardinality).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY, null, msgs);
			if (newCardinality != null)
				msgs = ((InternalEObject)newCardinality).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY, null, msgs);
			msgs = basicSetCardinality(newCardinality, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY, newCardinality, newCardinality));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY:
				return basicSetCardinality(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY:
				return getCardinality();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY:
				setCardinality((Cardinality)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY:
				setCardinality((Cardinality)null);
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY:
				return cardinality != null;
		}
		return super.eIsSet(featureID);
	}

} //CardinalityDefinitionImpl
