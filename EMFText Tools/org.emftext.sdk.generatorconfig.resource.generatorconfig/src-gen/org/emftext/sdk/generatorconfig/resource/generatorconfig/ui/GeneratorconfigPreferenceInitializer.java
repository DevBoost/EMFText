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

// Class used to initialize default preference values.
public class GeneratorconfigPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {

	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigAntlrTokenHelper tokenHelper = new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigAntlrTokenHelper();

	public void initializeDefaultPreferences() {

		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();

		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.getDefault().getPreferenceStore();
		//Set default value for matching brackets
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);

		//Set default value for occurrences
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigPreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX, true);
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigPreferenceConstants.EDITOR_DEFINITION_COLOR, "240,216,168");
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigPreferenceConstants.EDITOR_PROXY_COLOR, "212,212,212");

		//store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_OVERVIEW_RULER, true);
	}

	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation());
	}

	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation());
	}

	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigBracketSet bracketSet = new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigBracketSet(null, languageId);
		final java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}

	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigMetaInformation metaInformation) {
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
			org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}

	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
