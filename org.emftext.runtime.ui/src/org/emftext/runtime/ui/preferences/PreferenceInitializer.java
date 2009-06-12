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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.preference.IPreferenceStore;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenStyle;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.TokenHelper;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	private final static TokenHelper tokenHelper = new TokenHelper();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = EMFTextRuntimeUIPlugin.getDefault()
				.getPreferenceStore();
		
		List<String> extensions = EMFTextRuntimePlugin.getConcreteSyntaxNamesList();

        for (String extension : extensions) {
        	Resource tempResource = null;
	        ResourceSet rs = new ResourceSetImpl();
	        tempResource = rs.createResource(URI.createURI("temp." + extension));

        	
        	if (tempResource instanceof ITextResource) {
        		ITextResource textResource = (ITextResource) tempResource;
        		
        		String languageId = extension;
	            String[] tokenNames = textResource.getTokenNames();
	            
				for (int i = 0; i < tokenNames.length; i++) {
					if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {
						continue;
					}
					
					String tokenName = tokenHelper.getTokenName(tokenNames, i);
					// TODO this information should be gathered from the meta information class
					// to avoid creating the temporary resource
	        		ITokenStyle style = textResource.getDefaultTokenStyle(tokenName);
	        		
	        		if (style != null) {
	        			String color = getColorString(style.getColorAsRGB());
	                    setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
	        		} else {
	                    setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
	                }
	            }
            }
        }   
	}

	private void setProperties(IPreferenceStore store, String languageID,
			String tokenName, String color,
			boolean bold,
			boolean enable,
			boolean italic,
			boolean strikethrough,
			boolean underline) {
		store.setDefault(languageID + "_" + tokenName + PreferenceConstants.EDITOR_BOLD_SUFFIX, bold);
		store.setDefault(languageID + "_" + tokenName + PreferenceConstants.EDITOR_COLOR_SUFFIX, color);
		store.setDefault(languageID + "_" + tokenName + PreferenceConstants.EDITOR_ENABLE_SUFFIX, enable);
		store.setDefault(languageID + "_" + tokenName + PreferenceConstants.EDITOR_ITALIC_SUFFIX, italic);
		store.setDefault(languageID + "_" + tokenName + PreferenceConstants.EDITOR_STRIKETHROUGH_SUFFIX, strikethrough);
		store.setDefault(languageID + "_" + tokenName + PreferenceConstants.EDITOR_UNDERLINE_SUFFIX, underline);
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
