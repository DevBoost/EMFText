/**
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany 
 *       - initial API and implementation
 * 
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.SyntaxElement;

/**
 * This is the item provider adapter for a {@link org.emftext.sdk.concretesyntax.SyntaxElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SyntaxElementItemProvider
	extends ItemProviderAdapter
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
	public SyntaxElementItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_SyntaxElement_type");
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

		switch (notification.getFeatureID(SyntaxElement.class)) {
			case ConcretesyntaxPackage.SYNTAX_ELEMENT__CHILDREN:
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
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createRule()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createSequence()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createCsString()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createLineBreak()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createContainment()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createEnumTerminal()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.SYNTAX_ELEMENT__CHILDREN,
				 ConcretesyntaxFactory.eINSTANCE.createEnumLiteralTerminal()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ConcretesyntaxEditPlugin.INSTANCE;
	}

}
