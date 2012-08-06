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
/*
 * 
 */
package org.emftext.language.secprop.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.emftext.language.secprop.SecpropPackage;
import org.emftext.language.secprop.diagram.edit.parts.AccessEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ChannelEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataChannelEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ElementEditPart;
import org.emftext.language.secprop.diagram.edit.parts.EncryptionEditPart;
import org.emftext.language.secprop.diagram.edit.parts.SecPropModelEditPart;
import org.emftext.language.secprop.diagram.part.SecpropDiagramEditorPlugin;

/**
 * @generated
 */
public class SecpropElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private SecpropElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType SecPropModel_1000 = getElementType("org.emftext.language.secprop.diagram.SecPropModel_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Element_2001 = getElementType("org.emftext.language.secprop.diagram.Element_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Data_2002 = getElementType("org.emftext.language.secprop.diagram.Data_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Access_3001 = getElementType("org.emftext.language.secprop.diagram.Access_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Encryption_3002 = getElementType("org.emftext.language.secprop.diagram.Encryption_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Channel_4001 = getElementType("org.emftext.language.secprop.diagram.Channel_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataChannel_4002 = getElementType("org.emftext.language.secprop.diagram.DataChannel_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return SecpropDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(SecPropModel_1000, SecpropPackage.eINSTANCE
					.getSecPropModel());

			elements.put(Element_2001, SecpropPackage.eINSTANCE.getElement());

			elements.put(Data_2002, SecpropPackage.eINSTANCE.getData());

			elements.put(Access_3001, SecpropPackage.eINSTANCE.getAccess());

			elements.put(Encryption_3002, SecpropPackage.eINSTANCE
					.getEncryption());

			elements.put(Channel_4001, SecpropPackage.eINSTANCE.getChannel());

			elements.put(DataChannel_4002, SecpropPackage.eINSTANCE
					.getData_Channel());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(SecPropModel_1000);
			KNOWN_ELEMENT_TYPES.add(Element_2001);
			KNOWN_ELEMENT_TYPES.add(Data_2002);
			KNOWN_ELEMENT_TYPES.add(Access_3001);
			KNOWN_ELEMENT_TYPES.add(Encryption_3002);
			KNOWN_ELEMENT_TYPES.add(Channel_4001);
			KNOWN_ELEMENT_TYPES.add(DataChannel_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case SecPropModelEditPart.VISUAL_ID:
			return SecPropModel_1000;
		case ElementEditPart.VISUAL_ID:
			return Element_2001;
		case DataEditPart.VISUAL_ID:
			return Data_2002;
		case AccessEditPart.VISUAL_ID:
			return Access_3001;
		case EncryptionEditPart.VISUAL_ID:
			return Encryption_3002;
		case ChannelEditPart.VISUAL_ID:
			return Channel_4001;
		case DataChannelEditPart.VISUAL_ID:
			return DataChannel_4002;
		}
		return null;
	}

}
