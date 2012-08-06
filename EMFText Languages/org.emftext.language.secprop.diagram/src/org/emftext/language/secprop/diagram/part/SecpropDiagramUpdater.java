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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.secprop.Channel;
import org.emftext.language.secprop.Data;
import org.emftext.language.secprop.Element;
import org.emftext.language.secprop.SecPropModel;
import org.emftext.language.secprop.SecpropPackage;
import org.emftext.language.secprop.SecurityInformation;
import org.emftext.language.secprop.diagram.edit.parts.AccessEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ChannelEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataChannelEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataDataSecurityInformationCompartmentEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ElementEditPart;
import org.emftext.language.secprop.diagram.edit.parts.EncryptionEditPart;
import org.emftext.language.secprop.diagram.edit.parts.SecPropModelEditPart;
import org.emftext.language.secprop.diagram.providers.SecpropElementTypes;

/**
 * @generated
 */
public class SecpropDiagramUpdater {

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
		switch (SecpropVisualIDRegistry.getVisualID(view)) {
		case DataDataSecurityInformationCompartmentEditPart.VISUAL_ID:
			return getDataDataSecurityInformationCompartment_7001SemanticChildren(view);
		case SecPropModelEditPart.VISUAL_ID:
			return getSecPropModel_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDataDataSecurityInformationCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Data modelElement = (Data) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSecurityInformation().iterator(); it
				.hasNext();) {
			SecurityInformation childElement = (SecurityInformation) it.next();
			int visualID = SecpropVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AccessEditPart.VISUAL_ID) {
				result.add(new SecpropNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EncryptionEditPart.VISUAL_ID) {
				result.add(new SecpropNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSecPropModel_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		SecPropModel modelElement = (SecPropModel) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getElements().iterator(); it.hasNext();) {
			Element childElement = (Element) it.next();
			int visualID = SecpropVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ElementEditPart.VISUAL_ID) {
				result.add(new SecpropNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getData().iterator(); it.hasNext();) {
			Data childElement = (Data) it.next();
			int visualID = SecpropVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == DataEditPart.VISUAL_ID) {
				result.add(new SecpropNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (SecpropVisualIDRegistry.getVisualID(view)) {
		case SecPropModelEditPart.VISUAL_ID:
			return getSecPropModel_1000ContainedLinks(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_2001ContainedLinks(view);
		case DataEditPart.VISUAL_ID:
			return getData_2002ContainedLinks(view);
		case AccessEditPart.VISUAL_ID:
			return getAccess_3001ContainedLinks(view);
		case EncryptionEditPart.VISUAL_ID:
			return getEncryption_3002ContainedLinks(view);
		case ChannelEditPart.VISUAL_ID:
			return getChannel_4001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (SecpropVisualIDRegistry.getVisualID(view)) {
		case ElementEditPart.VISUAL_ID:
			return getElement_2001IncomingLinks(view);
		case DataEditPart.VISUAL_ID:
			return getData_2002IncomingLinks(view);
		case AccessEditPart.VISUAL_ID:
			return getAccess_3001IncomingLinks(view);
		case EncryptionEditPart.VISUAL_ID:
			return getEncryption_3002IncomingLinks(view);
		case ChannelEditPart.VISUAL_ID:
			return getChannel_4001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (SecpropVisualIDRegistry.getVisualID(view)) {
		case ElementEditPart.VISUAL_ID:
			return getElement_2001OutgoingLinks(view);
		case DataEditPart.VISUAL_ID:
			return getData_2002OutgoingLinks(view);
		case AccessEditPart.VISUAL_ID:
			return getAccess_3001OutgoingLinks(view);
		case EncryptionEditPart.VISUAL_ID:
			return getEncryption_3002OutgoingLinks(view);
		case ChannelEditPart.VISUAL_ID:
			return getChannel_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSecPropModel_1000ContainedLinks(View view) {
		SecPropModel modelElement = (SecPropModel) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Channel_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElement_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getData_2002ContainedLinks(View view) {
		Data modelElement = (Data) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Data_Channel_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAccess_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEncryption_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getChannel_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getElement_2001IncomingLinks(View view) {
		Element modelElement = (Element) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Channel_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getData_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAccess_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEncryption_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getChannel_4001IncomingLinks(View view) {
		Channel modelElement = (Channel) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Data_Channel_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElement_2001OutgoingLinks(View view) {
		Element modelElement = (Element) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Channel_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getData_2002OutgoingLinks(View view) {
		Data modelElement = (Data) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Data_Channel_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAccess_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEncryption_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getChannel_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Channel_4001(
			SecPropModel container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getChannels().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Channel) {
				continue;
			}
			Channel link = (Channel) linkObject;
			if (ChannelEditPart.VISUAL_ID != SecpropVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element dst = link.getTarget();
			Element src = link.getSource();
			result
					.add(new SecpropLinkDescriptor(src, dst, link,
							SecpropElementTypes.Channel_4001,
							ChannelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Channel_4001(
			Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != SecpropPackage.eINSTANCE
					.getChannel_Target()
					|| false == setting.getEObject() instanceof Channel) {
				continue;
			}
			Channel link = (Channel) setting.getEObject();
			if (ChannelEditPart.VISUAL_ID != SecpropVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element src = link.getSource();
			result
					.add(new SecpropLinkDescriptor(src, target, link,
							SecpropElementTypes.Channel_4001,
							ChannelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Data_Channel_4002(
			Channel target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == SecpropPackage.eINSTANCE
					.getData_Channel()) {
				result.add(new SecpropLinkDescriptor(setting.getEObject(),
						target, SecpropElementTypes.DataChannel_4002,
						DataChannelEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Channel_4001(
			Element source) {
		SecPropModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof SecPropModel) {
				container = (SecPropModel) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getChannels().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Channel) {
				continue;
			}
			Channel link = (Channel) linkObject;
			if (ChannelEditPart.VISUAL_ID != SecpropVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element dst = link.getTarget();
			Element src = link.getSource();
			if (src != source) {
				continue;
			}
			result
					.add(new SecpropLinkDescriptor(src, dst, link,
							SecpropElementTypes.Channel_4001,
							ChannelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Data_Channel_4002(
			Data source) {
		Collection result = new LinkedList();
		Channel destination = source.getChannel();
		if (destination == null) {
			return result;
		}
		result.add(new SecpropLinkDescriptor(source, destination,
				SecpropElementTypes.DataChannel_4002,
				DataChannelEditPart.VISUAL_ID));
		return result;
	}

}
