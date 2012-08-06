/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.runtime.ui.preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.preference.IPreferenceStore;
import org.emftext.runtime.EPredefinedTokens;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenStyle;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.TokenHelper;

/**
 * Class used to initialize default preference values.
 */
@Deprecated public class PreferenceInitializer extends AbstractPreferenceInitializer {

	private final static TokenHelper tokenHelper = new TokenHelper();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = EMFTextRuntimeUIPlugin.getDefault()
				.getPreferenceStore();

		Map<String, Object> extensionToFactoryMap = 
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		
		List<String> extensions = new ArrayList<String>(extensionToFactoryMap.keySet());
		//TODO remove special handling of ecore here
		extensions.add("ecore");

        for (String extension : extensions) {
        	Resource tempResource = null;
        	
        	if (extension.equals("ecore")) {
        		Resource.Factory rf =  Resource.Factory.Registry.INSTANCE.getFactory(
        				URI.createURI("temp.ecore"), "org.eclipse.emf.ecore.textual");
        		if (rf != null) {
        			tempResource = rf.createResource(URI.createURI("temp.ecore"));
        		}
        	}
        	else {
	        	ResourceSet rs = new ResourceSetImpl();
	        	try {
	        		tempResource = rs.createResource(URI.createURI("temp." + extension));
	        	} catch (WrappedException ce) {
	        		// this exception is thrown by the Teneo plug-in in Eclipse Galileo
	        		continue;
	        	}
        	}
        	
        	if (tempResource instanceof ITextResource) {
        		ITextResource tr = (ITextResource) tempResource;
        		
        		String languageId = extension;
	            int z = 0;
	            
	            String[] tokenNames = tr.getTokenNames();
	            
				for (int i = 0; i < tokenNames.length; i++) {
					if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {
						continue;
					}
					
	                String originalTokenName = tokenNames[i];
					String tokenName = tokenHelper.getTokenName(tokenNames, i);
	        		ITokenStyle style = tr.getDefaultTokenStyle(tokenName);
	        		
	        		if (style != null) {
	        			String color = getColorString(style.getColorAsRGB());
	                    setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
	        		} else if (originalTokenName.matches("[A-Z]+") && !originalTokenName.equals(EPredefinedTokens.STANDARD.getTokenName())) {
	                    //a string like thing (most likely)
	                    String color = "0,0,0";
	                    if (z == 0) {
	                        color = "42,0,255";
	                        z++;
	                    }
	                    else if (z == 1) {
	                        color = "63,127,95";
	                        z++;
	                    }
	                    
	                    setProperties(store, languageId, tokenName, color, false, true, false, false, false);
	                }
	                else if (originalTokenName.matches(".[a-zA-Z][a-zA-Z0-9:]+.")) { 
	                    //a keyword (most likely)
	                    setProperties(store, languageId, tokenName, "127,0,85", true, true, false, false, false);
	                }
	                else {
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
