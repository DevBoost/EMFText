package org.emftext.runtime.ui.preferences;

/**
 * An interface that defines some constants used to create
 * the keys for preferences. 
 */
public interface PreferenceConstants {
     
	//Constants for syntax highlighting
	/**
      * Preference key suffix to enable syntax highlighting for
      * a token type.
      */
	public static final String EDITOR_ENABLE_SUFFIX = "_enable";
    public static final String EDITOR_COLOR_SUFFIX = "_color";
    
    //Constants for brackets
	public static final String EDITOR_MATCHING_BRACKETS_COLOR = "_matchingBracketsColor";
	public static final String EDITOR_MATCHING_BRACKETS_CHECKBOX = "_matchingBracketsCheckbox";
	public static final String EDITOR_BRACKETS_SUFFIX = "_brackets";
	
	//Constants for occurrence highlighting
	public static final String EDITOR_DEFINITION_COLOR = "_definition_color";
	public static final String EDITOR_PROXY_COLOR = "_proxy_color";
	
	//Constants for hyper links
	public static final String EDITOR_HYPERLINK_COLOR = "_hyperlink_color";
}
