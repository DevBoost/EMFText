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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.secprop.SecpropPackage;
import org.emftext.language.secprop.diagram.edit.parts.AccessValueEditPart;
import org.emftext.language.secprop.diagram.edit.parts.DataNameEditPart;
import org.emftext.language.secprop.diagram.edit.parts.ElementNameEditPart;
import org.emftext.language.secprop.diagram.edit.parts.EncryptionValueEditPart;
import org.emftext.language.secprop.diagram.parsers.MessageFormatParser;
import org.emftext.language.secprop.diagram.part.SecpropVisualIDRegistry;

/**
 * @generated
 */
public class SecpropParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser elementName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getElementName_5001Parser() {
		if (elementName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { SecpropPackage.eINSTANCE
					.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			elementName_5001Parser = parser;
		}
		return elementName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser dataName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getDataName_5004Parser() {
		if (dataName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { SecpropPackage.eINSTANCE
					.getData_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dataName_5004Parser = parser;
		}
		return dataName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser accessValue_5002Parser;

	/**
	 * @generated
	 */
	private IParser getAccessValue_5002Parser() {
		if (accessValue_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { SecpropPackage.eINSTANCE
					.getAccess_Value() };
			MessageFormatParser parser = new MessageFormatParser(features);
			accessValue_5002Parser = parser;
		}
		return accessValue_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser encryptionValue_5003Parser;

	/**
	 * @generated
	 */
	private IParser getEncryptionValue_5003Parser() {
		if (encryptionValue_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { SecpropPackage.eINSTANCE
					.getEncryption_Value() };
			MessageFormatParser parser = new MessageFormatParser(features);
			encryptionValue_5003Parser = parser;
		}
		return encryptionValue_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ElementNameEditPart.VISUAL_ID:
			return getElementName_5001Parser();
		case DataNameEditPart.VISUAL_ID:
			return getDataName_5004Parser();
		case AccessValueEditPart.VISUAL_ID:
			return getAccessValue_5002Parser();
		case EncryptionValueEditPart.VISUAL_ID:
			return getEncryptionValue_5003Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(SecpropVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(SecpropVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (SecpropElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
