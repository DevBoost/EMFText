/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.ui.preferences;

import java.util.List;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.ITokenStyle;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.AntlrTokenHelper;
import org.emftext.runtime.ui.preferences.SyntaxColoringHelper.StyleProperty;

/**
 * Class used to initialize default preference values.
 */
//TODO mseifert: align this class with the EMFText coding style
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	private final static AntlrTokenHelper tokenHelper = new AntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		IPreferenceStore store = EMFTextRuntimeUIPlugin.getDefault()
				.getPreferenceStore();
		
		List<ITextResourcePluginMetaInformation> extensions = EMFTextRuntimePlugin.getConcreteSyntaxRegistry();

        for (ITextResourcePluginMetaInformation extension : extensions) {
    		String languageId = extension.getSyntaxName();
            String[] tokenNames = extension.getTokenNames();
            if (tokenNames == null) {
            	continue;
            }
			for (int i = 0; i < tokenNames.length; i++) {
				if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {
					continue;
				}
				
				String tokenName = tokenHelper.getTokenName(tokenNames, i);
				if (tokenName == null) {
					continue;
				}
        		ITokenStyle style = extension.getDefaultTokenStyle(tokenName);
        		if (style != null) {
        			String color = getColorString(style.getColorAsRGB());
                    setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
        		} else {
                    setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
                }
            }
			//Set default brackets for ITextResource bracket set
			store.setDefault(languageId+PreferenceConstants.EDITOR_BRACKETS_SUFFIX, "\"\"\'\'");
        }   
			        
        //Set default value for MatchingBrackets
        store.setDefault(PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "60,255,60");
        store.setDefault(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
        
        //Set default value for Occurrence
        store.setDefault(PreferenceConstants.EDITOR_DEFINITION_COLOR, "240,216,168");
        store.setDefault(PreferenceConstants.EDITOR_PROXY_COLOR, "212,212,212");
        
        //Set default value for Hyperlink 
        store.setDefault(PreferenceConstants.EDITOR_HYPERLINK_COLOR, "42,0,255");
        
        //store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_OVERVIEW_RULER, true);
	}

	private void setProperties(IPreferenceStore store, String languageID,
			String tokenName, String color,
			boolean bold,
			boolean enable,
			boolean italic,
			boolean strikethrough,
			boolean underline) {
		store.setDefault(SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.BOLD), bold);
		store.setDefault(SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.COLOR), color);
		store.setDefault(SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.ENABLE), enable);
		store.setDefault(SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.ITALIC), italic);
		store.setDefault(SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.UNDERLINE), underline);
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
