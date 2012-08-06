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
package org.emftext.language.valueflow.diagram.providers;

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
import org.emftext.language.valueflow.ValueflowPackage;
import org.emftext.language.valueflow.diagram.edit.parts.AgentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateGiveToEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.ModelEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.StateNextStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateEditPart;
import org.emftext.language.valueflow.diagram.part.ValueflowDiagramEditorPlugin;

/**
 * @generated
 */
public class ValueflowElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private ValueflowElementTypes() {
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
	public static final IElementType Model_1000 = getElementType("org.emftext.language.valueflow.diagram.Model_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Agent_2001 = getElementType("org.emftext.language.valueflow.diagram.Agent_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GiveState_3001 = getElementType("org.emftext.language.valueflow.diagram.GiveState_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TakeState_3002 = getElementType("org.emftext.language.valueflow.diagram.TakeState_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StateNextState_4001 = getElementType("org.emftext.language.valueflow.diagram.StateNextState_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GiveStateGiveTo_4002 = getElementType("org.emftext.language.valueflow.diagram.GiveStateGiveTo_4002"); //$NON-NLS-1$

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
				return ValueflowDiagramEditorPlugin.getInstance()
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

			elements.put(Model_1000, ValueflowPackage.eINSTANCE.getModel());

			elements.put(Agent_2001, ValueflowPackage.eINSTANCE.getAgent());

			elements.put(GiveState_3001, ValueflowPackage.eINSTANCE
					.getGiveState());

			elements.put(TakeState_3002, ValueflowPackage.eINSTANCE
					.getTakeState());

			elements.put(StateNextState_4001, ValueflowPackage.eINSTANCE
					.getState_NextState());

			elements.put(GiveStateGiveTo_4002, ValueflowPackage.eINSTANCE
					.getGiveState_GiveTo());
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
			KNOWN_ELEMENT_TYPES.add(Model_1000);
			KNOWN_ELEMENT_TYPES.add(Agent_2001);
			KNOWN_ELEMENT_TYPES.add(GiveState_3001);
			KNOWN_ELEMENT_TYPES.add(TakeState_3002);
			KNOWN_ELEMENT_TYPES.add(StateNextState_4001);
			KNOWN_ELEMENT_TYPES.add(GiveStateGiveTo_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ModelEditPart.VISUAL_ID:
			return Model_1000;
		case AgentEditPart.VISUAL_ID:
			return Agent_2001;
		case GiveStateEditPart.VISUAL_ID:
			return GiveState_3001;
		case TakeStateEditPart.VISUAL_ID:
			return TakeState_3002;
		case StateNextStateEditPart.VISUAL_ID:
			return StateNextState_4001;
		case GiveStateGiveToEditPart.VISUAL_ID:
			return GiveStateGiveTo_4002;
		}
		return null;
	}

}
