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

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.emftext.language.prolog.MULTIPLICATIVE_OPERATOR;
import org.emftext.language.prolog.Multiplicative;
import org.emftext.language.prolog.PrologFactory;
import org.emftext.language.prolog.PrologPackage;

/**
 * This is the item provider adapter for a {@link org.emftext.language.prolog.Multiplicative} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiplicativeItemProvider
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
	public MultiplicativeItemProvider(AdapterFactory adapterFactory) {
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

			addOperatorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Operator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOperatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Multiplicative_operator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Multiplicative_operator_feature", "_UI_Multiplicative_type"),
				 PrologPackage.Literals.MULTIPLICATIVE__OPERATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(PrologPackage.Literals.MULTIPLICATIVE__LEFT);
			childrenFeatures.add(PrologPackage.Literals.MULTIPLICATIVE__RIGHT);
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
	 * This returns Multiplicative.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Multiplicative"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		MULTIPLICATIVE_OPERATOR labelValue = ((Multiplicative)object).getOperator();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_Multiplicative_type") :
			getString("_UI_Multiplicative_type") + " " + label;
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

		switch (notification.getFeatureID(Multiplicative.class)) {
			case PrologPackage.MULTIPLICATIVE__OPERATOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case PrologPackage.MULTIPLICATIVE__LEFT:
			case PrologPackage.MULTIPLICATIVE__RIGHT:
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
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createNumeral()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createSmallAtom()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createString()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createList()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createVariableReference()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createAnonymousVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createAdditive()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createMultiplicative()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createPower()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createNegation()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__LEFT,
				 PrologFactory.eINSTANCE.createBracketExpression()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createNumeral()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createSmallAtom()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createString()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createList()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createVariableReference()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createAnonymousVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createAdditive()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createMultiplicative()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createPower()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
				 PrologFactory.eINSTANCE.createNegation()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.MULTIPLICATIVE__RIGHT,
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
			childFeature == PrologPackage.Literals.MULTIPLICATIVE__LEFT ||
			childFeature == PrologPackage.Literals.MULTIPLICATIVE__RIGHT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
