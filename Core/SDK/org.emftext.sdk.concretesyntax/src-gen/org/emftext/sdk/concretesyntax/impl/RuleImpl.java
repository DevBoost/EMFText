/**
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
 *  
 */
package org.emftext.sdk.concretesyntax.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.SyntaxElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.RuleImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.RuleImpl#getMetaclass <em>Metaclass</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.RuleImpl#getSyntax <em>Syntax</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleImpl extends AnnotableImpl implements Rule {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<SyntaxElement> children;

	/**
	 * The cached value of the '{@link #getMetaclass() <em>Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaclass()
	 * @generated
	 * @ordered
	 */
	protected GenClass metaclass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SyntaxElement> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<SyntaxElement>(SyntaxElement.class, this, ConcretesyntaxPackage.RULE__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenClass getMetaclass() {
		if (metaclass != null && metaclass.eIsProxy()) {
			InternalEObject oldMetaclass = (InternalEObject)metaclass;
			metaclass = (GenClass)eResolveProxy(oldMetaclass);
			if (metaclass != oldMetaclass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConcretesyntaxPackage.RULE__METACLASS, oldMetaclass, metaclass));
			}
		}
		return metaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenClass basicGetMetaclass() {
		return metaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaclass(GenClass newMetaclass) {
		GenClass oldMetaclass = metaclass;
		metaclass = newMetaclass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.RULE__METACLASS, oldMetaclass, metaclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntax getSyntax() {
		if (eContainerFeatureID() != ConcretesyntaxPackage.RULE__SYNTAX) return null;
		return (ConcreteSyntax)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSyntax(ConcreteSyntax newSyntax, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSyntax, ConcretesyntaxPackage.RULE__SYNTAX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyntax(ConcreteSyntax newSyntax) {
		if (newSyntax != eInternalContainer() || (eContainerFeatureID() != ConcretesyntaxPackage.RULE__SYNTAX && newSyntax != null)) {
			if (EcoreUtil.isAncestor(this, newSyntax))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSyntax != null)
				msgs = ((InternalEObject)newSyntax).eInverseAdd(this, ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, ConcreteSyntax.class, msgs);
			msgs = basicSetSyntax(newSyntax, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.RULE__SYNTAX, newSyntax, newSyntax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation getOperatorAnnotation() {
		for ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations()) {
			if (annotation.getType() == org.emftext.sdk.concretesyntax.AnnotationType.OPERATOR) {
				return annotation;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOperatorWeight() {
		org.emftext.sdk.concretesyntax.Annotation operatorAnnotation = this.getOperatorAnnotation();
		if (operatorAnnotation != null) {
			java.lang.String ruleWeightString = operatorAnnotation.getValue( org.emftext.sdk.concretesyntax.OperatorAnnotationProperty.WEIGHT.toString());
			if (ruleWeightString != null) {
				try {
					return java.lang.Integer.parseInt(ruleWeightString);			
				} catch ( java.lang.NumberFormatException e) {
					// ignore exception. invalid numbers are signaled by
					// returning MIN_VALUE
				}
			}
		}
		return java.lang.Integer.MIN_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice getDefinition() {
		org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.SyntaxElement> children = getChildren();
		// there should be at most one child
		assert children == null || children.size() == 1;
		
		if (children.size() > 0) {
			org.emftext.sdk.concretesyntax.SyntaxElement firstChild = children.get(0);
			if (firstChild instanceof org.emftext.sdk.concretesyntax.Choice) {
				return ( org.emftext.sdk.concretesyntax.Choice) firstChild;
			} else {
				// there should be no element other than Choice
				assert false;
				return null;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasAnnotation(final AnnotationType type, final String key, final String value) {
		for ( org.emftext.sdk.concretesyntax.Annotation annotation : getAnnotations()) {
			if (annotation.getType() == type) {
				if (key != null) {
					for ( org.emftext.sdk.concretesyntax.KeyValuePair parameter : annotation.getParameters()) {
						if (key.equals(parameter.getKey())
								&& parameter.getValue().equals(value)) {
							return true;
						}
					}
				} else {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverrideRemoveRule() {
		// TODO mseifert: use constant here
		return hasAnnotation( org.emftext.sdk.concretesyntax.AnnotationType.OVERRIDE, "remove", "true");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverrideRule(final GenClass metaClass) {
		if (metaClass == null || getMetaclass() == metaClass) {
			if (hasAnnotation( org.emftext.sdk.concretesyntax.AnnotationType.OVERRIDE, null, null)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getContainingRule() {
		org.emftext.sdk.concretesyntax.Rule rule = null;
		org.eclipse.emf.ecore.EObject o = this;
		do {
			if (o instanceof org.emftext.sdk.concretesyntax.Rule) {
				rule = ( org.emftext.sdk.concretesyntax.Rule) o;
			}
			else {
				o = o.eContainer();
			}
		} while (rule == null && o != null);
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConcretesyntaxPackage.RULE__SYNTAX:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSyntax((ConcreteSyntax)otherEnd, msgs);
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
			case ConcretesyntaxPackage.RULE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case ConcretesyntaxPackage.RULE__SYNTAX:
				return basicSetSyntax(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ConcretesyntaxPackage.RULE__SYNTAX:
				return eInternalContainer().eInverseRemove(this, ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, ConcreteSyntax.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.RULE__CHILDREN:
				return getChildren();
			case ConcretesyntaxPackage.RULE__METACLASS:
				if (resolve) return getMetaclass();
				return basicGetMetaclass();
			case ConcretesyntaxPackage.RULE__SYNTAX:
				return getSyntax();
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
			case ConcretesyntaxPackage.RULE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends SyntaxElement>)newValue);
				return;
			case ConcretesyntaxPackage.RULE__METACLASS:
				setMetaclass((GenClass)newValue);
				return;
			case ConcretesyntaxPackage.RULE__SYNTAX:
				setSyntax((ConcreteSyntax)newValue);
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
			case ConcretesyntaxPackage.RULE__CHILDREN:
				getChildren().clear();
				return;
			case ConcretesyntaxPackage.RULE__METACLASS:
				setMetaclass((GenClass)null);
				return;
			case ConcretesyntaxPackage.RULE__SYNTAX:
				setSyntax((ConcreteSyntax)null);
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
			case ConcretesyntaxPackage.RULE__CHILDREN:
				return children != null && !children.isEmpty();
			case ConcretesyntaxPackage.RULE__METACLASS:
				return metaclass != null;
			case ConcretesyntaxPackage.RULE__SYNTAX:
				return getSyntax() != null;
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
		if (baseClass == SyntaxElement.class) {
			switch (derivedFeatureID) {
				case ConcretesyntaxPackage.RULE__CHILDREN: return ConcretesyntaxPackage.SYNTAX_ELEMENT__CHILDREN;
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
		if (baseClass == SyntaxElement.class) {
			switch (baseFeatureID) {
				case ConcretesyntaxPackage.SYNTAX_ELEMENT__CHILDREN: return ConcretesyntaxPackage.RULE__CHILDREN;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //RuleImpl
