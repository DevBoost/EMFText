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
package org.emftext.language.java.closures.provider;


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
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.emftext.language.java.annotations.AnnotationsFactory;

import org.emftext.language.java.arrays.ArraysFactory;
import org.emftext.language.java.arrays.ArraysPackage;

import org.emftext.language.java.classifiers.ClassifiersFactory;

import org.emftext.language.java.closures.AbstractClosure;
import org.emftext.language.java.closures.ClosuresFactory;
import org.emftext.language.java.closures.ClosuresPackage;

import org.emftext.language.java.expressions.ExpressionsFactory;

import org.emftext.language.java.generics.GenericsFactory;
import org.emftext.language.java.generics.GenericsPackage;

import org.emftext.language.java.instantiations.InstantiationsFactory;

import org.emftext.language.java.members.provider.MemberItemProvider;

import org.emftext.language.java.modifiers.ModifiersPackage;

import org.emftext.language.java.parameters.ParametersFactory;
import org.emftext.language.java.parameters.ParametersPackage;

import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.ReferencesPackage;

import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.statements.StatementsPackage;

import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.emftext.language.java.closures.AbstractClosure} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractClosureItemProvider
	extends MemberItemProvider
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
	public AbstractClosureItemProvider(AdapterFactory adapterFactory) {
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
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addAnnotationsAndModifiersPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

	/**
   * This adds a property descriptor for the Annotations And Modifiers feature.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void addAnnotationsAndModifiersPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AnnotableAndModifiable_annotationsAndModifiers_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AnnotableAndModifiable_annotationsAndModifiers_feature", "_UI_AnnotableAndModifiable_type"),
         ModifiersPackage.Literals.ANNOTABLE_AND_MODIFIABLE__ANNOTATIONS_AND_MODIFIERS,
         true,
         false,
         true,
         null,
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
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE);
      childrenFeatures.add(ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_BEFORE);
      childrenFeatures.add(ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_AFTER);
      childrenFeatures.add(GenericsPackage.Literals.TYPE_ARGUMENTABLE__TYPE_ARGUMENTS);
      childrenFeatures.add(StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS);
      childrenFeatures.add(ParametersPackage.Literals.PARAMETRIZABLE__PARAMETERS);
      childrenFeatures.add(ReferencesPackage.Literals.REFERENCE__NEXT);
      childrenFeatures.add(ReferencesPackage.Literals.REFERENCE__ARRAY_SELECTORS);
      childrenFeatures.add(ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES);
      childrenFeatures.add(ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE);
      childrenFeatures.add(ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE_ARRAY_DIMENSION);
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
    String label = ((AbstractClosure)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_AbstractClosure_type") :
      getString("_UI_AbstractClosure_type") + " " + label;
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

    switch (notification.getFeatureID(AbstractClosure.class))
    {
      case ClosuresPackage.ABSTRACT_CLOSURE__TYPE_REFERENCE:
      case ClosuresPackage.ABSTRACT_CLOSURE__ARRAY_DIMENSIONS_BEFORE:
      case ClosuresPackage.ABSTRACT_CLOSURE__ARRAY_DIMENSIONS_AFTER:
      case ClosuresPackage.ABSTRACT_CLOSURE__TYPE_ARGUMENTS:
      case ClosuresPackage.ABSTRACT_CLOSURE__STATEMENTS:
      case ClosuresPackage.ABSTRACT_CLOSURE__PARAMETERS:
      case ClosuresPackage.ABSTRACT_CLOSURE__NEXT:
      case ClosuresPackage.ABSTRACT_CLOSURE__ARRAY_SELECTORS:
      case ClosuresPackage.ABSTRACT_CLOSURE__PARAMETER_TYPES:
      case ClosuresPackage.ABSTRACT_CLOSURE__VALUE_TYPE:
      case ClosuresPackage.ABSTRACT_CLOSURE__VALUE_TYPE_ARRAY_DIMENSION:
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

    newChildDescriptors.add
      (createChildParameter
        (GenericsPackage.Literals.TYPE_ARGUMENTABLE__TYPE_ARGUMENTS,
         GenericsFactory.eINSTANCE.createExtendsTypeArgument()));

    newChildDescriptors.add
      (createChildParameter
        (GenericsPackage.Literals.TYPE_ARGUMENTABLE__TYPE_ARGUMENTS,
         GenericsFactory.eINSTANCE.createQualifiedTypeArgument()));

    newChildDescriptors.add
      (createChildParameter
        (GenericsPackage.Literals.TYPE_ARGUMENTABLE__TYPE_ARGUMENTS,
         GenericsFactory.eINSTANCE.createSuperTypeArgument()));

    newChildDescriptors.add
      (createChildParameter
        (GenericsPackage.Literals.TYPE_ARGUMENTABLE__TYPE_ARGUMENTS,
         GenericsFactory.eINSTANCE.createUnknownTypeArgument()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         ClosuresFactory.eINSTANCE.createClosure()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         ClassifiersFactory.eINSTANCE.createClass()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         ClassifiersFactory.eINSTANCE.createInterface()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         ClassifiersFactory.eINSTANCE.createEnumeration()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         ClassifiersFactory.eINSTANCE.createAnnotation()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createAssert()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createBreak()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createBlock()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createCondition()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createContinue()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createWhileLoop()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createDoWhileLoop()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createEmptyStatement()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createExpressionStatement()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createForLoop()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createForEachLoop()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createJumpLabel()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createLocalVariableStatement()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createReturn()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createSwitch()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createSynchronizedBlock()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createThrow()));

    newChildDescriptors.add
      (createChildParameter
        (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS,
         StatementsFactory.eINSTANCE.createTryBlock()));

    newChildDescriptors.add
      (createChildParameter
        (ParametersPackage.Literals.PARAMETRIZABLE__PARAMETERS,
         ClosuresFactory.eINSTANCE.createClosure()));

    newChildDescriptors.add
      (createChildParameter
        (ParametersPackage.Literals.PARAMETRIZABLE__PARAMETERS,
         ParametersFactory.eINSTANCE.createOrdinaryParameter()));

    newChildDescriptors.add
      (createChildParameter
        (ParametersPackage.Literals.PARAMETRIZABLE__PARAMETERS,
         ParametersFactory.eINSTANCE.createVariableLengthParameter()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ClosuresFactory.eINSTANCE.createClosure()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         AnnotationsFactory.eINSTANCE.createAnnotationInstance()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ArraysFactory.eINSTANCE.createArrayInstantiationBySize()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ArraysFactory.eINSTANCE.createArrayInstantiationByValues()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ExpressionsFactory.eINSTANCE.createNestedExpression()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         InstantiationsFactory.eINSTANCE.createNewConstructorCall()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         InstantiationsFactory.eINSTANCE.createExplicitConstructorCall()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ReferencesFactory.eINSTANCE.createIdentifierReference()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ReferencesFactory.eINSTANCE.createMethodCall()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ReferencesFactory.eINSTANCE.createReflectiveClassReference()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ReferencesFactory.eINSTANCE.createPrimitiveTypeReference()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ReferencesFactory.eINSTANCE.createStringReference()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__NEXT,
         ReferencesFactory.eINSTANCE.createSelfReference()));

    newChildDescriptors.add
      (createChildParameter
        (ReferencesPackage.Literals.REFERENCE__ARRAY_SELECTORS,
         ArraysFactory.eINSTANCE.createArraySelector()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createClassifierReference()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createNamespaceClassifierReference()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createBoolean()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createByte()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createChar()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createDouble()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createFloat()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createInt()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createLong()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createShort()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES,
         TypesFactory.eINSTANCE.createVoid()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createClassifierReference()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createNamespaceClassifierReference()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createBoolean()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createByte()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createChar()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createDouble()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createFloat()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createInt()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createLong()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createShort()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE,
         TypesFactory.eINSTANCE.createVoid()));

    newChildDescriptors.add
      (createChildParameter
        (ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE_ARRAY_DIMENSION,
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
      childFeature == TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE ||
      childFeature == ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES ||
      childFeature == ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE ||
      childFeature == ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_BEFORE ||
      childFeature == ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_AFTER ||
      childFeature == ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE_ARRAY_DIMENSION ||
      childFeature == StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS ||
      childFeature == ParametersPackage.Literals.PARAMETRIZABLE__PARAMETERS ||
      childFeature == ReferencesPackage.Literals.REFERENCE__NEXT;

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
	public ResourceLocator getResourceLocator() {
    return ClosuresEditPlugin.INSTANCE;
  }

}
