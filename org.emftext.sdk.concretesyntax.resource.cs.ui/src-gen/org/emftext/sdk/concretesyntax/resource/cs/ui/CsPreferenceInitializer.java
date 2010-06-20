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
 * A class used to initialize default preference values.
 */
public class CsPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	private final static org.emftext.sdk.concretesyntax.resource.cs.ui.CsAntlrTokenHelper tokenHelper = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsAntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
		// Set default value for occurrences
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX, true);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_DEFINITION_COLOR, "240,216,168");
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_PROXY_COLOR, "212,212,212");
		
		// store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_OVERVIEW_
		// RULER, true);
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.sdk.concretesyntax.resource.cs.ICsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet bracketSet = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet(null, null);
		final java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.sdk.concretesyntax.resource.cs.ICsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {
				continue;
			}
			
			String tokenName = tokenHelper.getTokenName(tokenNames, i);
			if (tokenName == null) {
				continue;
			}
			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
