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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.valueflow.Agent;
import org.emftext.language.valueflow.GiveState;
import org.emftext.language.valueflow.Model;
import org.emftext.language.valueflow.State;
import org.emftext.language.valueflow.TakeState;
import org.emftext.language.valueflow.ValueflowPackage;
import org.emftext.language.valueflow.diagram.edit.parts.AgentAgentStatesCompartmentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.AgentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateGiveToEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.ModelEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.StateNextStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateEditPart;
import org.emftext.language.valueflow.diagram.providers.ValueflowElementTypes;

/**
 * @generated
 */
public class ValueflowDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case AgentAgentStatesCompartmentEditPart.VISUAL_ID:
			return getAgentAgentStatesCompartment_7001SemanticChildren(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAgentAgentStatesCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Agent modelElement = (Agent) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getStates().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = ValueflowVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == GiveStateEditPart.VISUAL_ID) {
				result.add(new ValueflowNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TakeStateEditPart.VISUAL_ID) {
				result.add(new ValueflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getAgents().iterator(); it.hasNext();) {
			Agent childElement = (Agent) it.next();
			int visualID = ValueflowVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AgentEditPart.VISUAL_ID) {
				result.add(new ValueflowNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_1000ContainedLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2001ContainedLinks(view);
		case GiveStateEditPart.VISUAL_ID:
			return getGiveState_3001ContainedLinks(view);
		case TakeStateEditPart.VISUAL_ID:
			return getTakeState_3002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case AgentEditPart.VISUAL_ID:
			return getAgent_2001IncomingLinks(view);
		case GiveStateEditPart.VISUAL_ID:
			return getGiveState_3001IncomingLinks(view);
		case TakeStateEditPart.VISUAL_ID:
			return getTakeState_3002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case AgentEditPart.VISUAL_ID:
			return getAgent_2001OutgoingLinks(view);
		case GiveStateEditPart.VISUAL_ID:
			return getGiveState_3001OutgoingLinks(view);
		case TakeStateEditPart.VISUAL_ID:
			return getTakeState_3002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getModel_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAgent_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGiveState_3001ContainedLinks(View view) {
		GiveState modelElement = (GiveState) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_4001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_GiveState_GiveTo_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTakeState_3002ContainedLinks(View view) {
		TakeState modelElement = (TakeState) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAgent_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGiveState_3001IncomingLinks(View view) {
		GiveState modelElement = (GiveState) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_State_NextState_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTakeState_3002IncomingLinks(View view) {
		TakeState modelElement = (TakeState) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_State_NextState_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_GiveState_GiveTo_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAgent_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGiveState_3001OutgoingLinks(View view) {
		GiveState modelElement = (GiveState) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_4001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_GiveState_GiveTo_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTakeState_3002OutgoingLinks(View view) {
		TakeState modelElement = (TakeState) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_State_NextState_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_State_NextState_4001(
			State target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ValueflowPackage.eINSTANCE
					.getState_NextState()) {
				result.add(new ValueflowLinkDescriptor(setting.getEObject(),
						target, ValueflowElementTypes.StateNextState_4001,
						StateNextStateEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_GiveState_GiveTo_4002(
			TakeState target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ValueflowPackage.eINSTANCE
					.getGiveState_GiveTo()) {
				result.add(new ValueflowLinkDescriptor(setting.getEObject(),
						target, ValueflowElementTypes.GiveStateGiveTo_4002,
						GiveStateGiveToEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_State_NextState_4001(
			State source) {
		Collection result = new LinkedList();
		State destination = source.getNextState();
		if (destination == null) {
			return result;
		}
		result.add(new ValueflowLinkDescriptor(source, destination,
				ValueflowElementTypes.StateNextState_4001,
				StateNextStateEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_GiveState_GiveTo_4002(
			GiveState source) {
		Collection result = new LinkedList();
		TakeState destination = source.getGiveTo();
		if (destination == null) {
			return result;
		}
		result.add(new ValueflowLinkDescriptor(source, destination,
				ValueflowElementTypes.GiveStateGiveTo_4002,
				GiveStateGiveToEditPart.VISUAL_ID));
		return result;
	}

}
