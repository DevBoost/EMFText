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
package org.emftext.language.secprop.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.secprop.SecPropModel;
import org.emftext.language.secprop.SecpropPackage;
import org.emftext.language.secprop.diagram.edit.parts.AccessEditPart;
import org.emftext.language.secprop.diagram.edit.parts.AccessValueEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ChannelEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataChannelEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataDataSecurityInformationCompartmentEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataNameEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ElementEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ElementNameEditPart;
import org.emftext.language.secprop.diagram.edit.parts.EncryptionEditPart;
import org.emftext.language.secprop.diagram.edit.parts.EncryptionValueEditPart;
import org.emftext.language.secprop.diagram.edit.parts.SecPropModelEditPart;
import org.emftext.language.secprop.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class SecpropVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.emftext.language.secprop.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (SecPropModelEditPart.MODEL_ID.equals(view.getType())) {
				return SecPropModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.emftext.language.secprop.diagram.part.SecpropVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				SecpropDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (SecpropPackage.eINSTANCE.getSecPropModel().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((SecPropModel) domainElement)) {
			return SecPropModelEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.emftext.language.secprop.diagram.part.SecpropVisualIDRegistry
				.getModelID(containerView);
		if (!SecPropModelEditPart.MODEL_ID.equals(containerModelID)
				&& !"secprop".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (SecPropModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.emftext.language.secprop.diagram.part.SecpropVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SecPropModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case DataDataSecurityInformationCompartmentEditPart.VISUAL_ID:
			if (SecpropPackage.eINSTANCE.getAccess().isSuperTypeOf(
					domainElement.eClass())) {
				return AccessEditPart.VISUAL_ID;
			}
			if (SecpropPackage.eINSTANCE.getEncryption().isSuperTypeOf(
					domainElement.eClass())) {
				return EncryptionEditPart.VISUAL_ID;
			}
			break;
		case SecPropModelEditPart.VISUAL_ID:
			if (SecpropPackage.eINSTANCE.getElement().isSuperTypeOf(
					domainElement.eClass())) {
				return ElementEditPart.VISUAL_ID;
			}
			if (SecpropPackage.eINSTANCE.getData().isSuperTypeOf(
					domainElement.eClass())) {
				return DataEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.emftext.language.secprop.diagram.part.SecpropVisualIDRegistry
				.getModelID(containerView);
		if (!SecPropModelEditPart.MODEL_ID.equals(containerModelID)
				&& !"secprop".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (SecPropModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.emftext.language.secprop.diagram.part.SecpropVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SecPropModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ElementEditPart.VISUAL_ID:
			if (ElementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataEditPart.VISUAL_ID:
			if (DataNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataDataSecurityInformationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AccessEditPart.VISUAL_ID:
			if (AccessValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EncryptionEditPart.VISUAL_ID:
			if (EncryptionValueEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataDataSecurityInformationCompartmentEditPart.VISUAL_ID:
			if (AccessEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EncryptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SecPropModelEditPart.VISUAL_ID:
			if (ElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataChannelEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (SecpropPackage.eINSTANCE.getChannel().isSuperTypeOf(
				domainElement.eClass())) {
			return ChannelEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(SecPropModel element) {
		return true;
	}

}
