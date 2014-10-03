/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import java.util.Collection;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class can be used to initialize default preference values.
 */
public class Cct5PreferenceInitializer extends AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		initializeDefaultsContentAssist();
		
		IPreferenceStore store = org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		IPreferenceStore store = org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation());
	}
	
	protected void initializeDefaultBrackets(IPreferenceStore store, org.emftext.test.cct5.resource.cct5.ICct5MetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		org.emftext.test.cct5.resource.cct5.ui.Cct5BracketSet bracketSet = new org.emftext.test.cct5.resource.cct5.ui.Cct5BracketSet();
		final Collection<org.emftext.test.cct5.resource.cct5.ICct5BracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.test.cct5.resource.cct5.ICct5BracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + org.emftext.test.cct5.resource.cct5.ui.Cct5PreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		IPreferenceStore store = org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(IPreferenceStore store, org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			org.emftext.test.cct5.resource.cct5.ICct5TokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void initializeDefaultsContentAssist() {
		IPreferenceStore store = org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.getDefault().getPreferenceStore();
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5PreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED, org.emftext.test.cct5.resource.cct5.ui.Cct5PreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT);
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5PreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY, org.emftext.test.cct5.resource.cct5.ui.Cct5PreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY_DEFAULT);
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5PreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS, org.emftext.test.cct5.resource.cct5.ui.Cct5PreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT);
	}
	
	protected void setProperties(IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.test.cct5.resource.cct5.ui.Cct5SyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	protected String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
	
}

