package org.emftext.runtime.ui.preferences;

//TODO mseifert: align this class with the EMFText coding style
public interface PreferenceConstants {
     
	//Constant for Syntax highlighting
 
     /**
      * Preference key suffix for bold text style preference keys.
      */
     public static final String EDITOR_ENABLE_SUFFIX = "_enable";
 
     public static final String EDITOR_COLOR_SUFFIX = "_color";
    
    //Constants for Brackets
	public static final String EDITOR_MATCHING_BRACKETS_COLOR = "matchingBracketsColor"; //$NON-NLS-1$
	
	public static final String EDITOR_MATCHING_BRACKETS_CHECKBOX="matchingBracketsCheckbox";
	
	public static final String EDITOR_BRACKETS_SUFFIX = "_brackets";
	
	//Constants for Occurrence
	
	public static final String EDITOR_DEFINITION_COLOR = "definition_color";
	
	public static final String EDITOR_PROXY_COLOR = "proxy_color";
	
	//Constants for Hyperlink
	
	public static final String EDITOR_HYPERLINK_COLOR = "hyperlink_color";
}
