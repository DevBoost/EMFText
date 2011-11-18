/*******************************************************************************
 * Copyright (c) 2006-2011
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
	private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken> nextTokens;
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
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin plugin = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken>();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		boolean isOriginalToken = true;
		if (!nextTokens.isEmpty()) {
			currentToken = nextTokens.remove(0);
			isOriginalToken = false;
		} else {
			currentToken = lexer.getNextToken();
		}
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		
		if (isOriginalToken) {
			splitCurrentToken();
		}
		
		org.eclipse.jface.text.TextAttribute textAttribute = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
			if (dynamicStyle != null) {
				textAttribute = getTextAttribute(dynamicStyle);
			}
		}
		
		return new org.eclipse.jface.text.rules.Token(textAttribute);
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
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle getStaticTokenStyle() {
		org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle staticStyle = null;
		String tokenName = currentToken.getName();
		String enableKey = org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ENABLE);
		boolean enabled = store.getBoolean(enableKey);
		if (enabled) {
			String colorKey = org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.COLOR);
			org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
			org.eclipse.swt.graphics.RGB backgroundRGB = null;
			boolean bold = store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.BOLD));
			boolean italic = store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ITALIC));
			boolean strikethrough = store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
			boolean underline = store.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.UNDERLINE));
			staticStyle = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
		}
		return staticStyle;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle getDynamicTokenStyle(org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle staticStyle) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDynamicTokenStyler dynamicTokenStyler = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDynamicTokenStyler();
		org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public org.eclipse.jface.text.TextAttribute getTextAttribute(org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle tokeStyle) {
		int[] foregroundColorArray = tokeStyle.getColorAsRGB();
		org.eclipse.swt.graphics.Color foregroundColor = null;
		if (colorManager != null) {
			foregroundColor = colorManager.getColor(new org.eclipse.swt.graphics.RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
		}
		int[] backgroundColorArray = tokeStyle.getBackgroundColorAsRGB();
		org.eclipse.swt.graphics.Color backgroundColor = null;
		if (backgroundColorArray != null) {
			org.eclipse.swt.graphics.RGB backgroundRGB = new org.eclipse.swt.graphics.RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
			if (colorManager != null) {
				backgroundColor = colorManager.getColor(backgroundRGB);
			}
		}
		int style = org.eclipse.swt.SWT.NORMAL;
		if (tokeStyle.isBold()) {
			style = style | org.eclipse.swt.SWT.BOLD;
		}
		if (tokeStyle.isItalic()) {
			style = style | org.eclipse.swt.SWT.ITALIC;
		}
		if (tokeStyle.isStrikethrough()) {
			style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
		}
		if (tokeStyle.isUnderline()) {
			style = style | org.eclipse.jface.text.TextAttribute.UNDERLINE;
		}
		return new org.eclipse.jface.text.TextAttribute(foregroundColor, backgroundColor, style);
	}
	
	/**
	 * Tries to split the current token if it contains task items.
	 */
	public void splitCurrentToken() {
		final String text = currentToken.getText();
		final String name = currentToken.getName();
		final int line = currentToken.getLine();
		final int charStart = currentToken.getOffset();
		final int column = currentToken.getColumn();
		
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItem> taskItems = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken> newItems = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken>();
		for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item (TODO if required)
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTextToken(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item (TODO if required)
			String textAfter = text.substring(offset - charStart);
			newItems.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
