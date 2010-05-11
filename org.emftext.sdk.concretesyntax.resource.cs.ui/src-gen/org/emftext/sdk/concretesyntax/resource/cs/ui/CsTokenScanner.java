/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class CsTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTextScanner lexer;
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken currentToken;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager colorManager;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public CsTokenScanner(org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager colorManager) {
		this.lexer = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().createLexer();
		this.languageId = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().getSyntaxName();
		this.store = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore();
		this.colorManager = colorManager;
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		currentToken = lexer.getNextToken();
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		org.eclipse.jface.text.TextAttribute ta = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			String enableKey = org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ENABLE);
			if (store.getBoolean(enableKey)) {
				String colorKey = org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.Color color = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey));
				int style = org.eclipse.swt.SWT.NORMAL;
				if (store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.BOLD))) {
					style = style | org.eclipse.swt.SWT.BOLD;
				}
				if (store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ITALIC))) {
					style = style | org.eclipse.swt.SWT.ITALIC;
				}
				if (store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH))) {
					style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
				}
				if (store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.UNDERLINE))) {
					style = style | org.eclipse.jface.text.TextAttribute.UNDERLINE;
				}
				ta = new org.eclipse.jface.text.TextAttribute(color, null, style);
			}
		}
		return new org.eclipse.jface.text.rules.Token(ta);
	}
	
	public void setRange(org.eclipse.jface.text.IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (org.eclipse.jface.text.BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
}
