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
package org.emftext.sdk.concretesyntax.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EPackage;
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
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;

/**
 * This is the item provider adapter for a {@link org.emftext.sdk.concretesyntax.ConcreteSyntax} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConcreteSyntaxItemProvider
	extends GenPackageDependentElementItemProvider
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
	public ConcreteSyntaxItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addStartSymbolsPropertyDescriptor(object);
			addActiveTokensPropertyDescriptor(object);
			addOptionsPropertyDescriptor(object);
			addAllTokenStylesPropertyDescriptor(object);
			addAllTokenDirectivesPropertyDescriptor(object);
			add_operatorRulesPropertyDescriptor(object);
			add_operatorRuleSubsetsPropertyDescriptor(object);
			add_operatorRulesInitializedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_name_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Start Symbols feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartSymbolsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax_startSymbols_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_startSymbols_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__START_SYMBOLS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Active Tokens feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActiveTokensPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax_activeTokens_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_activeTokens_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ACTIVE_TOKENS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Options feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOptionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax_options_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_options_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__OPTIONS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the All Token Styles feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllTokenStylesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax_allTokenStyles_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_allTokenStyles_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_TOKEN_STYLES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the All Token Directives feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllTokenDirectivesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax_allTokenDirectives_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_allTokenDirectives_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the operator Rules feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void add_operatorRulesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax__operatorRules_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax__operatorRules_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__OPERATOR_RULES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the operator Rule Subsets feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void add_operatorRuleSubsetsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax__operatorRuleSubsets_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax__operatorRuleSubsets_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the operator Rules Initialized feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void add_operatorRulesInitializedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax__operatorRulesInitialized_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax__operatorRulesInitialized_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED,
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
	 * @generated NOT
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.ANNOTABLE__ANNOTATIONS);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__MODIFIER);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__IMPORTS);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__OPTIONS);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__SYNTHETIC_TOKENS);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_TOKEN_STYLES);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__RULES);
			//childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__GEN_CLASS_CACHE);
			//childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ECLASS_UTIL);
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
	 * This returns ConcreteSyntax.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConcreteSyntax"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		ConcreteSyntax concreteSyntax = (ConcreteSyntax) object;
		String label = concreteSyntax.getName() + " : ";
		try {
			if (!concreteSyntax.eIsProxy()) {
				GenPackage genPackage = concreteSyntax.getPackage();
				if (genPackage != null && !genPackage.eIsProxy()) {
					EPackage ecorePackage = genPackage.getEcorePackage();
					if (ecorePackage != null) {
						label = label + ecorePackage.getNsURI();
					}
				}
			}
		} catch (NullPointerException e) {
			// do nothing
			// the NPE is sometimes triggered by the background parsing
		}
		return label;
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

		switch (notification.getFeatureID(ConcreteSyntax.class)) {
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__SYNTHETIC_TOKENS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_TOKEN_STYLES:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__GEN_CLASS_CACHE:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__ECLASS_UTIL:
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
				(ConcretesyntaxPackage.Literals.ANNOTABLE__ANNOTATIONS,
				 ConcretesyntaxFactory.eINSTANCE.createAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__MODIFIER,
				 ConcretesyntaxFactory.eINSTANCE.createAbstract()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__IMPORTS,
				 ConcretesyntaxFactory.eINSTANCE.createImport()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__OPTIONS,
				 ConcretesyntaxFactory.eINSTANCE.createOption()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createQuotedTokenDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__SYNTHETIC_TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__SYNTHETIC_TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createQuotedTokenDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKEN_STYLES,
				 ConcretesyntaxFactory.eINSTANCE.createTokenStyle()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_TOKEN_STYLES,
				 ConcretesyntaxFactory.eINSTANCE.createTokenStyle()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__RULES,
				 ConcretesyntaxFactory.eINSTANCE.createRule()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__GEN_CLASS_CACHE,
				 ConcretesyntaxFactory.eINSTANCE.createGenClassCache()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ECLASS_UTIL,
				 ConcretesyntaxFactory.eINSTANCE.createEClassUtil()));
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
			childFeature == ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS ||
			childFeature == ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__SYNTHETIC_TOKENS ||
			childFeature == ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKEN_STYLES ||
			childFeature == ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_TOKEN_STYLES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
