/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class Cct5TokenScanner implements org.emftext.test.cct5.resource.cct5.ui.ICct5TokenScanner {
	
	private org.emftext.test.cct5.resource.cct5.ICct5TextScanner lexer;
	private org.emftext.test.cct5.resource.cct5.ICct5TextToken currentToken;
	private List<org.emftext.test.cct5.resource.cct5.ICct5TextToken> nextTokens;
	private int offset;
	private String languageId;
	private IPreferenceStore store;
	private org.emftext.test.cct5.resource.cct5.ui.Cct5ColorManager colorManager;
	private org.emftext.test.cct5.resource.cct5.ICct5TextResource resource;
	
	/**
	 * <p>
	 * Creates a new Cct5TokenScanner.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 */
	public Cct5TokenScanner(org.emftext.test.cct5.resource.cct5.ICct5TextResource resource, org.emftext.test.cct5.resource.cct5.ui.Cct5ColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation().createLexer();
		this.languageId = new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation().getSyntaxName();
		org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin plugin = org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new ArrayList<org.emftext.test.cct5.resource.cct5.ICct5TextToken>();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public IToken nextToken() {
		boolean isOriginalToken = true;
		if (!nextTokens.isEmpty()) {
			currentToken = nextTokens.remove(0);
			isOriginalToken = false;
		} else {
			currentToken = lexer.getNextToken();
		}
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return Token.EOF;
		}
		
		if (isOriginalToken) {
			splitCurrentToken();
		}
		
		TextAttribute textAttribute = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			org.emftext.test.cct5.resource.cct5.ICct5TokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			org.emftext.test.cct5.resource.cct5.ICct5TokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
			if (dynamicStyle != null) {
				textAttribute = getTextAttribute(dynamicStyle);
			}
		}
		
		return new Token(textAttribute);
	}
	
	public void setRange(IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
	
	public int[] convertToIntArray(RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TokenStyle getStaticTokenStyle() {
		String tokenName = currentToken.getName();
		String enableKey = org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.ENABLE);
		if (store == null) {
			return null;
		}
		
		boolean enabled = store.getBoolean(enableKey);
		if (!enabled) {
			return null;
		}
		
		String colorKey = org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.COLOR);
		RGB foregroundRGB = PreferenceConverter.getColor(store, colorKey);
		RGB backgroundRGB = null;
		boolean bold = store.getBoolean(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.BOLD));
		boolean italic = store.getBoolean(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.ITALIC));
		boolean strikethrough = store.getBoolean(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
		boolean underline = store.getBoolean(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.UNDERLINE));
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TokenStyle getDynamicTokenStyle(org.emftext.test.cct5.resource.cct5.ICct5TokenStyle staticStyle) {
		org.emftext.test.cct5.resource.cct5.mopp.Cct5DynamicTokenStyler dynamicTokenStyler = new org.emftext.test.cct5.resource.cct5.mopp.Cct5DynamicTokenStyler();
		dynamicTokenStyler.setOffset(offset);
		org.emftext.test.cct5.resource.cct5.ICct5TokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public TextAttribute getTextAttribute(org.emftext.test.cct5.resource.cct5.ICct5TokenStyle tokeStyle) {
		int[] foregroundColorArray = tokeStyle.getColorAsRGB();
		Color foregroundColor = null;
		if (colorManager != null) {
			foregroundColor = colorManager.getColor(new RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
		}
		int[] backgroundColorArray = tokeStyle.getBackgroundColorAsRGB();
		Color backgroundColor = null;
		if (backgroundColorArray != null) {
			RGB backgroundRGB = new RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
			if (colorManager != null) {
				backgroundColor = colorManager.getColor(backgroundRGB);
			}
		}
		int style = SWT.NORMAL;
		if (tokeStyle.isBold()) {
			style = style | SWT.BOLD;
		}
		if (tokeStyle.isItalic()) {
			style = style | SWT.ITALIC;
		}
		if (tokeStyle.isStrikethrough()) {
			style = style | TextAttribute.STRIKETHROUGH;
		}
		if (tokeStyle.isUnderline()) {
			style = style | TextAttribute.UNDERLINE;
		}
		return new TextAttribute(foregroundColor, backgroundColor, style);
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
		
		List<org.emftext.test.cct5.resource.cct5.mopp.Cct5TaskItem> taskItems = new org.emftext.test.cct5.resource.cct5.mopp.Cct5TaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		List<org.emftext.test.cct5.resource.cct5.ICct5TextToken> newItems = new ArrayList<org.emftext.test.cct5.resource.cct5.ICct5TextToken>();
		for (org.emftext.test.cct5.resource.cct5.mopp.Cct5TaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new org.emftext.test.cct5.resource.cct5.mopp.Cct5TextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new org.emftext.test.cct5.resource.cct5.mopp.Cct5TextToken(org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item
			String textAfter = text.substring(offset - charStart);
			newItems.add(new org.emftext.test.cct5.resource.cct5.mopp.Cct5TextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
