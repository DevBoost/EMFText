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
package org.emftext.language.secprop.diagram.navigator;

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
import org.emftext.language.secprop.diagram.edit.parts.AccessEditPart;
import org.emftext.language.secprop.diagram.edit.parts.AccessValueEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ChannelEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataChannelEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataNameEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ElementEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ElementNameEditPart;
import org.emftext.language.secprop.diagram.edit.parts.EncryptionEditPart;
import org.emftext.language.secprop.diagram.edit.parts.EncryptionValueEditPart;
import org.emftext.language.secprop.diagram.edit.parts.SecPropModelEditPart;
import org.emftext.language.secprop.diagram.part.SecpropDiagramEditorPlugin;
import org.emftext.language.secprop.diagram.part.SecpropVisualIDRegistry;
import org.emftext.language.secprop.diagram.providers.SecpropElementTypes;
import org.emftext.language.secprop.diagram.providers.SecpropParserProvider;

/**
 * @generated
 */
public class SecpropNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		SecpropDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		SecpropDiagramEditorPlugin
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
		if (element instanceof SecpropNavigatorItem
				&& !isOwnView(((SecpropNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof SecpropNavigatorGroup) {
			SecpropNavigatorGroup group = (SecpropNavigatorGroup) element;
			return SecpropDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof SecpropNavigatorItem) {
			SecpropNavigatorItem navigatorItem = (SecpropNavigatorItem) element;
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
		switch (SecpropVisualIDRegistry.getVisualID(view)) {
		case SecPropModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.emftext.org/language/SecProp?SecPropModel", SecpropElementTypes.SecPropModel_1000); //$NON-NLS-1$
		case ElementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.emftext.org/language/SecProp?Element", SecpropElementTypes.Element_2001); //$NON-NLS-1$
		case DataEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.emftext.org/language/SecProp?Data", SecpropElementTypes.Data_2002); //$NON-NLS-1$
		case AccessEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/language/SecProp?Access", SecpropElementTypes.Access_3001); //$NON-NLS-1$
		case EncryptionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/language/SecProp?Encryption", SecpropElementTypes.Encryption_3002); //$NON-NLS-1$
		case ChannelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/language/SecProp?Channel", SecpropElementTypes.Channel_4001); //$NON-NLS-1$
		case DataChannelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/language/SecProp?Data?channel", SecpropElementTypes.DataChannel_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = SecpropDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& SecpropElementTypes.isKnownElementType(elementType)) {
			image = SecpropElementTypes.getImage(elementType);
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
		if (element instanceof SecpropNavigatorGroup) {
			SecpropNavigatorGroup group = (SecpropNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof SecpropNavigatorItem) {
			SecpropNavigatorItem navigatorItem = (SecpropNavigatorItem) element;
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
		switch (SecpropVisualIDRegistry.getVisualID(view)) {
		case SecPropModelEditPart.VISUAL_ID:
			return getSecPropModel_1000Text(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_2001Text(view);
		case DataEditPart.VISUAL_ID:
			return getData_2002Text(view);
		case AccessEditPart.VISUAL_ID:
			return getAccess_3001Text(view);
		case EncryptionEditPart.VISUAL_ID:
			return getEncryption_3002Text(view);
		case ChannelEditPart.VISUAL_ID:
			return getChannel_4001Text(view);
		case DataChannelEditPart.VISUAL_ID:
			return getDataChannel_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getSecPropModel_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getElement_2001Text(View view) {
		IParser parser = SecpropParserProvider.getParser(
				SecpropElementTypes.Element_2001,
				view.getElement() != null ? view.getElement() : view,
				SecpropVisualIDRegistry.getType(ElementNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			SecpropDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getData_2002Text(View view) {
		IParser parser = SecpropParserProvider.getParser(
				SecpropElementTypes.Data_2002, view.getElement() != null ? view
						.getElement() : view, SecpropVisualIDRegistry
						.getType(DataNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			SecpropDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAccess_3001Text(View view) {
		IParser parser = SecpropParserProvider.getParser(
				SecpropElementTypes.Access_3001,
				view.getElement() != null ? view.getElement() : view,
				SecpropVisualIDRegistry.getType(AccessValueEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			SecpropDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEncryption_3002Text(View view) {
		IParser parser = SecpropParserProvider.getParser(
				SecpropElementTypes.Encryption_3002,
				view.getElement() != null ? view.getElement() : view,
				SecpropVisualIDRegistry
						.getType(EncryptionValueEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			SecpropDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getChannel_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDataChannel_4002Text(View view) {
		IParser parser = SecpropParserProvider.getParser(
				SecpropElementTypes.DataChannel_4002,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			SecpropDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
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
		return SecPropModelEditPart.MODEL_ID.equals(SecpropVisualIDRegistry
				.getModelID(view));
	}

}
