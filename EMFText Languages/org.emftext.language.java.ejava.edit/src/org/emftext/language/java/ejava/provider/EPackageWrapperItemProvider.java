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
package org.emftext.language.java.ejava.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.emftext.language.java.containers.ContainersPackage;
import org.emftext.language.java.containers.provider.CompilationUnitItemProvider;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.ejava.EjavaFactory;
import org.emftext.language.java.ejava.EjavaPackage;

/**
 * This is the item provider adapter for a
 * {@link org.emftext.language.java.ejava.EPackageWrapper} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class EPackageWrapperItemProvider extends CompilationUnitItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EPackageWrapperItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addEPackagePropertyDescriptor(object);
      addGenPackagePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

	/**
	 * This adds a property descriptor for the EPackage feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addEPackagePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_EPackageWrapper_ePackage_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_EPackageWrapper_ePackage_feature", "_UI_EPackageWrapper_type"),
         EjavaPackage.Literals.EPACKAGE_WRAPPER__EPACKAGE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
	 * This adds a property descriptor for the Gen Package feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addGenPackagePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_EPackageWrapper_genPackage_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_EPackageWrapper_genPackage_feature", "_UI_EPackageWrapper_type"),
         EjavaPackage.Literals.EPACKAGE_WRAPPER__GEN_PACKAGE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

	/**
	 * This returns EPackageWrapper.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, EcoreEditPlugin.INSTANCE
				.getImage("full/obj16/EPackage"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		EPackageWrapper ePackageWrapper = (EPackageWrapper) object;
		if (ePackageWrapper.getEPackage() != null) {
			return  ePackageWrapper.getEPackage().getName();
		}
		return "";
	}

	/**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
   * @generated
   */
	@Override
	public void notifyChanged(Notification notification) {
    updateChildren(notification);
    super.notifyChanged(notification);
  }

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (ContainersPackage.Literals.COMPILATION_UNIT__CLASSIFIERS,
         EjavaFactory.eINSTANCE.createEClassifierClassWrapper()));

    newChildDescriptors.add
      (createChildParameter
        (ContainersPackage.Literals.COMPILATION_UNIT__CLASSIFIERS,
         EjavaFactory.eINSTANCE.createEClassifierInterfaceWrapper()));

    newChildDescriptors.add
      (createChildParameter
        (ContainersPackage.Literals.COMPILATION_UNIT__CLASSIFIERS,
         EjavaFactory.eINSTANCE.createEClassifierEnumerationWrapper()));
  }

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
    return EjavaEditPlugin.INSTANCE;
  }

}
