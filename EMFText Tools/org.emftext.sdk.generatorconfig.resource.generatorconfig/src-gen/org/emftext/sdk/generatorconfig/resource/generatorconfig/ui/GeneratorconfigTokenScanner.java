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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.ui;

// An adapter from the Eclipse <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface
// to the generated lexer.
//
public class GeneratorconfigTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {

	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextScanner lexer;
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextToken currentToken;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigColorManager colorManager;

	// @param colorManager A manager to obtain color objects
	public GeneratorconfigTokenScanner(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigColorManager colorManager) {
		this.lexer = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation().createLexer();
		this.languageId = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation().getSyntaxName();
		this.store = org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.getDefault().getPreferenceStore();
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
			String enableKey = org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.ENABLE);
			if (store.getBoolean(enableKey)) {
				String colorKey = org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.Color color = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey));
				int style = org.eclipse.swt.SWT.NORMAL;
				if (store.getBoolean(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.BOLD))) {
					style = style | org.eclipse.swt.SWT.BOLD;
				}
				if (store.getBoolean(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.ITALIC))) {
					style = style | org.eclipse.swt.SWT.ITALIC;
				}
				if (store.getBoolean(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.STRIKETHROUGH))) {
					style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
				}
				if (store.getBoolean(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.UNDERLINE))) {
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
			//ignore this error. It might occur during editing when locations are outdated quickly.
		}
	}

	public String getTokenText() {
		return currentToken.getText();
	}
}
