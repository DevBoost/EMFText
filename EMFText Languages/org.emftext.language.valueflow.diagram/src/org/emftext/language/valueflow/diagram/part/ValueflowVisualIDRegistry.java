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
package org.emftext.language.valueflow.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.valueflow.Model;
import org.emftext.language.valueflow.ValueflowPackage;
import org.emftext.language.valueflow.diagram.edit.parts.AgentAgentStatesCompartmentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.AgentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.AgentNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateGiveToEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.ModelEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.StateNextStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.WrappingLabel2EditPart;
import org.emftext.language.valueflow.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class ValueflowVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.emftext.language.valueflow.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ModelEditPart.MODEL_ID.equals(view.getType())) {
				return ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry
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
				ValueflowDiagramEditorPlugin.getInstance().logError(
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
		if (ValueflowPackage.eINSTANCE.getModel().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Model) domainElement)) {
			return ModelEditPart.VISUAL_ID;
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
		String containerModelID = org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry
				.getModelID(containerView);
		if (!ModelEditPart.MODEL_ID.equals(containerModelID)
				&& !"valueflow".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case AgentAgentStatesCompartmentEditPart.VISUAL_ID:
			if (ValueflowPackage.eINSTANCE.getGiveState().isSuperTypeOf(
					domainElement.eClass())) {
				return GiveStateEditPart.VISUAL_ID;
			}
			if (ValueflowPackage.eINSTANCE.getTakeState().isSuperTypeOf(
					domainElement.eClass())) {
				return TakeStateEditPart.VISUAL_ID;
			}
			break;
		case ModelEditPart.VISUAL_ID:
			if (ValueflowPackage.eINSTANCE.getAgent().isSuperTypeOf(
					domainElement.eClass())) {
				return AgentEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry
				.getModelID(containerView);
		if (!ModelEditPart.MODEL_ID.equals(containerModelID)
				&& !"valueflow".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case AgentEditPart.VISUAL_ID:
			if (AgentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AgentAgentStatesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GiveStateEditPart.VISUAL_ID:
			if (GiveStateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TakeStateEditPart.VISUAL_ID:
			if (TakeStateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AgentAgentStatesCompartmentEditPart.VISUAL_ID:
			if (GiveStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TakeStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEditPart.VISUAL_ID:
			if (AgentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateNextStateEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GiveStateGiveToEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
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
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Model element) {
		return true;
	}

}
