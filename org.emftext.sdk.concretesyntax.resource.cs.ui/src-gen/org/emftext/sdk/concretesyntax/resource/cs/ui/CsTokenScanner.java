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
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public CsTokenScanner(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource, org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().createLexer();
		this.languageId = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().getSyntaxName();
		this.store = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDynamicTokenStyler dynamicTokenStyler = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDynamicTokenStyler();
		currentToken = lexer.getNextToken();
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		org.eclipse.jface.text.TextAttribute ta = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			String enableKey = org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ENABLE);
			boolean enabled = store.getBoolean(enableKey);
			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle staticStyle = null;
			if (enabled) {
				String colorKey = org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
				org.eclipse.swt.graphics.RGB backgroundRGB = null;
				boolean bold = store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.BOLD));
				boolean italic = store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ITALIC));
				boolean strikethrough = store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
				boolean underline = store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.UNDERLINE));
				// now call dynamic token styler to allow to apply modifications to the static
				// style
				staticStyle = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
			}
			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, tokenName, currentToken.getText(), staticStyle);
			if (dynamicStyle != null) {
				int[] foregroundColorArray = dynamicStyle.getColorAsRGB();
				org.eclipse.swt.graphics.Color foregroundColor = colorManager.getColor(new org.eclipse.swt.graphics.RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
				int[] backgroundColorArray = dynamicStyle.getBackgroundColorAsRGB();
				org.eclipse.swt.graphics.Color backgroundColor = null;
				if (backgroundColorArray != null) {
					org.eclipse.swt.graphics.RGB backgroundRGB = new org.eclipse.swt.graphics.RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
					backgroundColor = colorManager.getColor(backgroundRGB);
				}
				int style = org.eclipse.swt.SWT.NORMAL;
				if (dynamicStyle.isBold()) {
					style = style | org.eclipse.swt.SWT.BOLD;
				}
				if (dynamicStyle.isItalic()) {
					style = style | org.eclipse.swt.SWT.ITALIC;
				}
				if (dynamicStyle.isStrikethrough()) {
					style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
				}
				if (dynamicStyle.isUnderline()) {
					style = style | org.eclipse.jface.text.TextAttribute.UNDERLINE;
				}
				ta = new org.eclipse.jface.text.TextAttribute(foregroundColor, backgroundColor, style);
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
	
	public int[] convertToIntArray(org.eclipse.swt.graphics.RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
}
