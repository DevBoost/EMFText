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
package org.emftext.language.java.properties.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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

import org.emftext.language.java.arrays.ArraysFactory;
import org.emftext.language.java.arrays.ArraysPackage;
import org.emftext.language.java.members.provider.MemberItemProvider;

import org.emftext.language.java.properties.PropertiesPackage;
import org.emftext.language.java.properties.Property;

import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.emftext.language.java.properties.Property} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertyItemProvider
  extends MemberItemProvider
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addReadonlyPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Readonly feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addReadonlyPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Property_readonly_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Property_readonly_feature", "_UI_Property_type"),
         PropertiesPackage.Literals.PROPERTY__READONLY,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE);
      childrenFeatures.add(ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_BEFORE);
      childrenFeatures.add(ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_AFTER);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns Property.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public Object getImage(Object object)
  {
	  if (object instanceof Property) {
		  Property property = (Property) object;
		  if (property != null && property.isReadonly()) {
			    return overlayImage(object, getResourceLocator().getImage("full/obj16/Property_RO"));
		  }
	  }
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Property"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    String label = ((Property)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_Property_type") :
      getString("_UI_Property_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(Property.class))
    {
      case PropertiesPackage.PROPERTY__READONLY:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case PropertiesPackage.PROPERTY__TYPE_REFERENCE:
      case PropertiesPackage.PROPERTY__ARRAY_DIMENSIONS_BEFORE:
      case PropertiesPackage.PROPERTY__ARRAY_DIMENSIONS_AFTER:
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
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createClassifierReference()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createNamespaceClassifierReference()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createBoolean()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createByte()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createChar()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createDouble()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createFloat()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createInt()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createLong()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createShort()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE,
         TypesFactory.eINSTANCE.createVoid()));

    newChildDescriptors.add
      (createChildParameter
        (ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_BEFORE,
         ArraysFactory.eINSTANCE.createArrayDimension()));

    newChildDescriptors.add
      (createChildParameter
        (ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_AFTER,
         ArraysFactory.eINSTANCE.createArrayDimension()));
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
      childFeature == ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_BEFORE ||
      childFeature == ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_AFTER;

    if (qualify)
    {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

		/**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator()
  {
    return PropertiesEditPlugin.INSTANCE;
  }

}
