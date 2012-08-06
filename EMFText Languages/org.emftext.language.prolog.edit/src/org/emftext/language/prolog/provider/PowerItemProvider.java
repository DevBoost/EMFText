/*******************************************************************************
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
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.prolog.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.emftext.language.prolog.Power;
import org.emftext.language.prolog.PrologFactory;
import org.emftext.language.prolog.PrologPackage;

/**
 * This is the item provider adapter for a {@link org.emftext.language.prolog.Power} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PowerItemProvider
	extends TermItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(PrologPackage.Literals.POWER__BASE);
			childrenFeatures.add(PrologPackage.Literals.POWER__EXPONENT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Power.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Power"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Power_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Power.class)) {
			case PrologPackage.POWER__BASE:
			case PrologPackage.POWER__EXPONENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createNumeral()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createSmallAtom()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createString()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createList()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createVariableReference()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createAnonymousVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createAdditive()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createMultiplicative()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createPower()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createNegation()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__BASE,
				 PrologFactory.eINSTANCE.createBracketExpression()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createNumeral()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createSmallAtom()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createString()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createList()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createVariableReference()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createAnonymousVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createAdditive()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createMultiplicative()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createPower()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createNegation()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.POWER__EXPONENT,
				 PrologFactory.eINSTANCE.createBracketExpression()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == PrologPackage.Literals.POWER__BASE ||
			childFeature == PrologPackage.Literals.POWER__EXPONENT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
