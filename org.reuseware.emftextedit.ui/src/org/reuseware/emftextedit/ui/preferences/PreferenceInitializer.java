package org.reuseware.emftextedit.ui.preferences;

import java.util.Map;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.preference.IPreferenceStore;
import org.reuseware.emftextedit.codegen.TextParserGenerator;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.ui.EMFTextEditUIPlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = EMFTextEditUIPlugin.getDefault()
				.getPreferenceStore();

		Map<String, Object> extensionToFactoryMap = 
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		
        for(String extension : extensionToFactoryMap.keySet()) {
        	ResourceSet rs = new ResourceSetImpl();
        	Resource tempResource = rs.createResource(URI.createURI("temp." + extension));
        	
        	if (tempResource instanceof TextResource) {
        		TextResource tr = (TextResource) tempResource;
        		
        		String languageId = extension;
	            int z = 0;;
	            
	            for(int i=6; i<tr.getTokenNames().length; i++) {
	                String tokenName = tr.getTokenNames()[i];
	
	                if (tokenName.matches("[A-Z]+") && !tokenName.equals(TextParserGenerator.STD_TOKEN_NAME)) {
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
	                    
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_BOLD_SUFFIX, false);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_COLOR_SUFFIX, color);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_ENABLE_SUFFIX, true);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_ITALIC_SUFFIX, false);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_STRIKETHROUGH_SUFFIX, false);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_UNDERLINE_SUFFIX, false);
	                }
	                else if (tokenName.matches(".[a-zA-Z][a-zA-Z0-9]+.")) {
	                    tokenName = tokenName.substring(1,tokenName.length()-1).trim();
	                    //a keyword (most likely)
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_BOLD_SUFFIX, true);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_COLOR_SUFFIX, "127,0,85");
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_ENABLE_SUFFIX, true);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_ITALIC_SUFFIX, false);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_STRIKETHROUGH_SUFFIX, false);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_UNDERLINE_SUFFIX, false);                   
	                }
	                else {
	                    tokenName = tokenName.substring(1,tokenName.length()-1).trim();
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_BOLD_SUFFIX, false);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_COLOR_SUFFIX, "0,0,0");
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_ENABLE_SUFFIX, false);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_ITALIC_SUFFIX, false);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_STRIKETHROUGH_SUFFIX, false);
	                    store.setDefault(languageId + "_" + tokenName + PreferenceConstants.EDITOR_UNDERLINE_SUFFIX, false); 
	                }
	            }
            }
        }   
	}

}
