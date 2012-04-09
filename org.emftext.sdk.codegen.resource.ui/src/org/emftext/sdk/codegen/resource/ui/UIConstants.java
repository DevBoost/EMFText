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
package org.emftext.sdk.codegen.resource.ui;

public class UIConstants {

	// icons
	public static final String DEFAULT_ICON_DIR = "icons";
	
	public enum Icon {
		// this should actually be 'new_icon.gif', but for compatibility reasons
		// we keep the old name.
		DEFAULT_NEW_ICON("default_new_icon.gif"),
		
		DEFAULT_EDITOR_ICON("editor_icon.gif"),
		DEFAULT_OCCURRENCE_ICON("occurrence_icon.gif"),
		DEFAULT_LAUNCH_SHORTCUT_ICON("launch_shortcut_icon.gif"),
		DEFAULT_LAUNCH_TAB_MAIN_ICON("launch_tab_main_icon.gif"),
		DEFAULT_LAUNCH_CONFIGURATION_TYPE_ICON("launch_type_icon.gif"),
		DEFAULT_BREAKPOINT_ICON("breakpoint_icon.gif"),
		DEFAULT_NEW_PROJECT_WIZBAN("new_project_wizban.gif"),
		DEFAULT_COLLAPSE_ALL_ICON("collapse_all_icon.gif"),
		DEFAULT_SORT_LEXICALLY_ICON("sort_lexically_icon.gif"),
		DEFAULT_GROUP_TYPES_ICON("group_types_icon.gif"), 
		DEFAULT_EXPAND_ALL_ICON("expand_all_icon.gif"), 
		DEFAULT_LINK_WITH_EDITOR_ICON("link_with_editor_icon.gif"), 
		DEFAULT_AUTO_EXPAND_ICON("auto_expand_icon.gif");
		
		private String filename;

		private Icon(String filename) {
			this.filename = filename;
		}

		public String getFilename() {
			return filename;
		}
	}
	
	// CSS
	public static final String DEFAULT_CSS_DIR = "css";
	public static final String HOVER_STYLE_FILENAME = "hover_style.css";
	
	// New Project
	public static final String NEW_PROJECT_FILENAME = "newProject.zip";
}
