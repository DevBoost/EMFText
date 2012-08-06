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
package org.emftext.language.valueflow.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.emftext.language.valueflow.Model;
import org.emftext.language.valueflow.diagram.edit.parts.AgentEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.AgentNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateGiveToEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.ModelEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.StateNextStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateNameEditPart;
import org.emftext.language.valueflow.diagram.part.ValueflowDiagramEditorPlugin;
import org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry;
import org.emftext.language.valueflow.diagram.providers.ValueflowElementTypes;
import org.emftext.language.valueflow.diagram.providers.ValueflowParserProvider;

/**
 * @generated
 */
public class ValueflowNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		ValueflowDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		ValueflowDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof ValueflowNavigatorItem
				&& !isOwnView(((ValueflowNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof ValueflowNavigatorGroup) {
			ValueflowNavigatorGroup group = (ValueflowNavigatorGroup) element;
			return ValueflowDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof ValueflowNavigatorItem) {
			ValueflowNavigatorItem navigatorItem = (ValueflowNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.emftext.org/language/valueflow?Model", ValueflowElementTypes.Model_1000); //$NON-NLS-1$
		case AgentEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.emftext.org/language/valueflow?Agent", ValueflowElementTypes.Agent_2001); //$NON-NLS-1$
		case GiveStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/language/valueflow?GiveState", ValueflowElementTypes.GiveState_3001); //$NON-NLS-1$
		case TakeStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/language/valueflow?TakeState", ValueflowElementTypes.TakeState_3002); //$NON-NLS-1$
		case StateNextStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/language/valueflow?State?nextState", ValueflowElementTypes.StateNextState_4001); //$NON-NLS-1$
		case GiveStateGiveToEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/language/valueflow?GiveState?giveTo", ValueflowElementTypes.GiveStateGiveTo_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = ValueflowDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& ValueflowElementTypes.isKnownElementType(elementType)) {
			image = ValueflowElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof ValueflowNavigatorGroup) {
			ValueflowNavigatorGroup group = (ValueflowNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof ValueflowNavigatorItem) {
			ValueflowNavigatorItem navigatorItem = (ValueflowNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (ValueflowVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_1000Text(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2001Text(view);
		case GiveStateEditPart.VISUAL_ID:
			return getGiveState_3001Text(view);
		case TakeStateEditPart.VISUAL_ID:
			return getTakeState_3002Text(view);
		case StateNextStateEditPart.VISUAL_ID:
			return getStateNextState_4001Text(view);
		case GiveStateGiveToEditPart.VISUAL_ID:
			return getGiveStateGiveTo_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getModel_1000Text(View view) {
		Model domainModelElement = (Model) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ValueflowDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAgent_2001Text(View view) {
		IParser parser = ValueflowParserProvider.getParser(
				ValueflowElementTypes.Agent_2001,
				view.getElement() != null ? view.getElement() : view,
				ValueflowVisualIDRegistry.getType(AgentNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ValueflowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGiveState_3001Text(View view) {
		IParser parser = ValueflowParserProvider.getParser(
				ValueflowElementTypes.GiveState_3001,
				view.getElement() != null ? view.getElement() : view,
				ValueflowVisualIDRegistry
						.getType(GiveStateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ValueflowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTakeState_3002Text(View view) {
		IParser parser = ValueflowParserProvider.getParser(
				ValueflowElementTypes.TakeState_3002,
				view.getElement() != null ? view.getElement() : view,
				ValueflowVisualIDRegistry
						.getType(TakeStateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ValueflowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStateNextState_4001Text(View view) {
		IParser parser = ValueflowParserProvider.getParser(
				ValueflowElementTypes.StateNextState_4001,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ValueflowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGiveStateGiveTo_4002Text(View view) {
		IParser parser = ValueflowParserProvider.getParser(
				ValueflowElementTypes.GiveStateGiveTo_4002,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ValueflowDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ModelEditPart.MODEL_ID.equals(ValueflowVisualIDRegistry
				.getModelID(view));
	}

}
