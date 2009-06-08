/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
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
			addActiveStartSymbolsPropertyDescriptor(object);
			addActiveTokensPropertyDescriptor(object);
			addAllStartSymbolsPropertyDescriptor(object);
			addOptionsPropertyDescriptor(object);
			addAllTokenStylesPropertyDescriptor(object);
			addAllTokenDirectivesPropertyDescriptor(object);
			addAllRulesPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Active Start Symbols feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActiveStartSymbolsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax_activeStartSymbols_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_activeStartSymbols_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ACTIVE_START_SYMBOLS,
				 false,
				 false,
				 false,
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
	 * This adds a property descriptor for the All Start Symbols feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllStartSymbolsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax_allStartSymbols_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_allStartSymbols_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_START_SYMBOLS,
				 false,
				 false,
				 false,
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
	 * This adds a property descriptor for the All Rules feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllRulesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConcreteSyntax_allRules_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConcreteSyntax_allRules_feature", "_UI_ConcreteSyntax_type"),
				 ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__ALL_RULES,
				 false,
				 false,
				 false,
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
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__MODIFIER);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__IMPORTS);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__OPTIONS);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__SYNTHETIC_TOKENS);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKEN_STYLES);
			childrenFeatures.add(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__RULES);
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
		ConcreteSyntax concreteSyntax = (ConcreteSyntax)object;
		String label = concreteSyntax.getName() + " : ";
		if (!concreteSyntax.eIsProxy()) {
			GenPackage genPackage = concreteSyntax.getPackage();
			if(genPackage != null && !genPackage.eIsProxy()) {
				label = label + genPackage.getNSURI();
			}
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
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__SYNTHETIC_TOKENS:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES:
			case ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES:
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
				 ConcretesyntaxFactory.eINSTANCE.createNormalToken()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createQuotedToken()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__SYNTHETIC_TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createNormalToken()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__SYNTHETIC_TOKENS,
				 ConcretesyntaxFactory.eINSTANCE.createQuotedToken()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__TOKEN_STYLES,
				 ConcretesyntaxFactory.eINSTANCE.createTokenStyle()));

		newChildDescriptors.add
			(createChildParameter
				(ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__RULES,
				 ConcretesyntaxFactory.eINSTANCE.createRule()));
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
			childFeature == ConcretesyntaxPackage.Literals.CONCRETE_SYNTAX__SYNTHETIC_TOKENS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
