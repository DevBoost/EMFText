/*******************************************************************************
 * Copyright (c) 2006-2015
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Dresden, Amtsgericht Dresden, HRB 34001
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import java.util.Collection;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class can be used to initialize default preference values.
 */
public class CsPreferenceInitializer extends AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		initializeDefaultsContentAssist();
		
		IPreferenceStore store = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		IPreferenceStore store = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation());
	}
	
	protected void initializeDefaultBrackets(IPreferenceStore store, org.emftext.sdk.concretesyntax.resource.cs.ICsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet bracketSet = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet();
		final Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		IPreferenceStore store = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(IPreferenceStore store, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void initializeDefaultsContentAssist() {
		IPreferenceStore store = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore();
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY_DEFAULT);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT);
	}
	
	protected void setProperties(IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.concretesyntax.resource.cs.ui.CsSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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

