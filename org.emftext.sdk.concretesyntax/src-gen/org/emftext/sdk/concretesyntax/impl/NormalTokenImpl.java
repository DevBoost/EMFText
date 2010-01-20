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
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.sdk.concretesyntax.AbstractTokenDefinition;
import org.emftext.sdk.concretesyntax.Annotable;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.NormalToken;
import org.emftext.sdk.concretesyntax.RegexComposite;
import org.emftext.sdk.concretesyntax.RegexOwner;
import org.emftext.sdk.concretesyntax.RegexPart;
import org.emftext.sdk.concretesyntax.RegexReference;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Normal Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.NormalTokenImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.NormalTokenImpl#getRegexParts <em>Regex Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NormalTokenImpl extends CompleteTokenDefinitionImpl implements NormalToken {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NormalTokenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.NORMAL_TOKEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRegex() {
		return getRegex(this, new LinkedHashSet<AbstractTokenDefinition>());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRegex(AbstractTokenDefinition token, Set<AbstractTokenDefinition> visitedTokens) {
		visitedTokens.add(token);

		StringBuilder result = new StringBuilder();
		if (token instanceof RegexComposite) {
			RegexComposite composite = (RegexComposite) token;
			for (RegexPart part : composite.getRegexParts()) {
				if (part instanceof AtomicRegex) {
					result.append(part.getRegex());
				} else if (part instanceof RegexReference) {
					RegexReference reference = (RegexReference) part;
					AbstractTokenDefinition target = reference.getTarget();
					if (target == null) {
						continue;
					}
					if (target.eIsProxy()) {
						continue;
					}
					if (visitedTokens.contains(target)) {
						continue;
					}
					Set<AbstractTokenDefinition> subVisitedTokens = new LinkedHashSet<AbstractTokenDefinition>();
					subVisitedTokens.addAll(visitedTokens);
					result.append(getRegex(target, subVisitedTokens));
				}
			}
		} else if (token instanceof RegexOwner) {
			RegexOwner owner = (RegexOwner) token;
			result.append(owner.getRegex());
		}
		return result.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegexPart> getRegexParts() {
		if (regexParts == null) {
			regexParts = new EObjectContainmentEList<RegexPart>(RegexPart.class, this, ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS);
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
			case ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS:
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
			case ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS:
				return getAnnotations();
			case ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS:
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
			case ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS:
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
			case ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS:
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
			case ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS:
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
		if (baseClass == Annotable.class) {
			switch (derivedFeatureID) {
				case ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS: return ConcretesyntaxPackage.ANNOTABLE__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == RegexComposite.class) {
			switch (derivedFeatureID) {
				case ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS: return ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS;
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
				case ConcretesyntaxPackage.ANNOTABLE__ANNOTATIONS: return ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == RegexComposite.class) {
			switch (baseFeatureID) {
				case ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS: return ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
} //NormalTokenImpl
