/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;

/**
 * The CsAutoEditStrategy extends the default auto edit strategy such that an
 * additional tab is added if a line break is entered after opening brackets which
 * are configured as <code>closeAfterEnter</code>. Also, closing brackets are
 * automatically inserted right away when opening brackets are added where
 * <code>closeAfterEnter</code> is set to <code>false</code>.
 */
public class CsAutoEditStrategy extends DefaultIndentLineAutoEditStrategy {
	
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet bracketSet;
	
	public CsAutoEditStrategy() {
		super();
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin plugin = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault();
		if (plugin != null) {
			IPreferenceStore preferenceStore = plugin.getPreferenceStore();
			bracketSet = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet();
			bracketSet.resetBrackets(preferenceStore);
		}
	}
	
	/**
	 * This method is only used for injecting a bracket set during tests.
	 */
	@Deprecated
	public void setBracketSet(org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet bracketSet) {
		this.bracketSet = bracketSet;
	}
	
	@Override
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		String text = command.text;
		String textBefore = command.text;
		super.customizeDocumentCommand(document, command);
		String textAfter = command.text;
		if (textAfter.length() < textBefore.length()) {
			return;
		}
		addClosingBracketAfterEnterIfRequired(document, command, text,
		textBefore, textAfter);
		addClosingBracket(command);
	}
	
	protected void addClosingBracket(DocumentCommand command) {
		String insertedText = command.text;
		boolean closeInstantly = bracketSet.isCloseInstantly(insertedText);
		if (!closeInstantly) {
			return;
		}
		String closingBracket = bracketSet.getCounterpart(insertedText);
		command.text = command.text + closingBracket;
		command.shiftsCaret = false;
		command.caretOffset = command.offset + 1;
	}
	
	protected void addClosingBracketAfterEnterIfRequired(IDocument document, DocumentCommand command, String text, String textBefore, String textAfter) {
		boolean isLineBreak = isLineBreak(text);
		if (!isLineBreak) {
			return;
		}
		String openingBracketBefore = getCloseAfterBracketBefore(document.get(), command.offset);
		if (openingBracketBefore == null) {
			return;
		}
		String indentation = textAfter.substring(0, textBefore.length());
		// add additional indentation (because a line break was entered after an opening
		// bracket)
		command.text = command.text + "\t";
		command.text = command.text + indentation;
		// add closing bracket
		String closingBracket = bracketSet.getCounterpart(openingBracketBefore);
		command.text = command.text + closingBracket;
		command.shiftsCaret = false;
		command.caretOffset = command.offset + indentation.length() + 1;
	}
	
	/**
	 * Searches for a bracket the must be closed when line breaks are entered and
	 * which is located right before the cursor (ignoring whitespace).
	 */
	protected String getCloseAfterBracketBefore(String text, int offset) {
		for (int i = offset - 1; i >= 0; i--) {
			char charAtI = text.charAt(i);
			String stringAtI = Character.toString(charAtI);
			if (bracketSet.isCloseAfterEnter(stringAtI)) {
				return stringAtI;
			}
			if (charAtI == ' ' || charAtI == '	') {
				continue;
			}
			break;
		}
		return null;
	}
	
	protected boolean isLineBreak(String text) {
		return "\n".equals(text) || "\r".equals(text) || "\r\n".equals(text);
	}
	
}
