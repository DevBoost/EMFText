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
import org.emftext.language.valueflow.ValueflowPackage;
import org.emftext.language.valueflow.diagram.edit.parts.AgentNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateNameEditPart;
import org.emftext.language.valueflow.diagram.parsers.MessageFormatParser;
import org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry;

/**
 * @generated
 */
public class ValueflowParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser agentName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getAgentName_5003Parser() {
		if (agentName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { ValueflowPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			agentName_5003Parser = parser;
		}
		return agentName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser giveStateName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getGiveStateName_5001Parser() {
		if (giveStateName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { ValueflowPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			giveStateName_5001Parser = parser;
		}
		return giveStateName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser takeStateName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getTakeStateName_5002Parser() {
		if (takeStateName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { ValueflowPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			takeStateName_5002Parser = parser;
		}
		return takeStateName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case AgentNameEditPart.VISUAL_ID:
			return getAgentName_5003Parser();
		case GiveStateNameEditPart.VISUAL_ID:
			return getGiveStateName_5001Parser();
		case TakeStateNameEditPart.VISUAL_ID:
			return getTakeStateName_5002Parser();
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
			return getParser(ValueflowVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(ValueflowVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (ValueflowElementTypes.getElement(hint) == null) {
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
