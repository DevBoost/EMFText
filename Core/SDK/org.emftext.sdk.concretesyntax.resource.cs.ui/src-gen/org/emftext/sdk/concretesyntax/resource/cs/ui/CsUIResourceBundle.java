/*******************************************************************************
 * Copyright (c) 2006-2014
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * A class to hold all resources (e.g., text constants) for the resource UI
 * plug-in.
 */
public class CsUIResourceBundle {
	
	/**
	 * The title of the NewProjectWizard window.
	 */
	public static String NEW_PROJECT_WIZARD_WINDOW_TITLE = "New cs Project";
	
	/**
	 * The name of the main page for the NewProjectWizard.
	 */
	public static String NEW_PROJECT_WIZARD_PAGE_NAME = "Create new cs Project";
	
	/**
	 * The name of the ZIP file that is used as content for the new project (relative
	 * to the root of the resource UI plug-in).
	 */
	public static String NEW_PROJECT_ZIP_FILE_NAME = "newProject.zip";
	
	/**
	 * The description of the project creation page
	 */
	public static String NEW_PROJECT_WIZARD_PAGE_DESCRIPTION = "Enter a name and select a location where the new project shall be created.";
	
	/**
	 * The name of the project in the project creation page
	 */
	public static String NEW_PROJECT_WIZARD_PROJECT_NAME = "";
	
	/**
	 * The path of the icon to be used for the pages of the NewProjectWizard.
	 */
	public static String NEW_PROJECT_WIZARD_PAGE_ICON = "icons/new_project_wizban.gif";
	
	/**
	 * The default file name for the new file wizard.
	 */
	public static String NEW_FILE_WIZARD_FILE_NAME = "new_file.cs";
	
	/**
	 * The static initializer tries to load resources from properties files or
	 * resource bundle classes. If no properties files or resource bundle classes are
	 * available, the default values are kept.
	 */
	static {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(CsUIResourceBundle.class.getName(), Locale.getDefault());
			if (bundle != null) {
				Set<String> keys = bundle.keySet();
				for (String key : keys) {
					String value = bundle.getString(key);
					try {
						Field field = CsUIResourceBundle.class.getDeclaredField(key.toUpperCase());
						field.set(null, value);
					} catch (SecurityException e) {
						// Ignore
					} catch (NoSuchFieldException e) {
						// Ignore?
					} catch (IllegalArgumentException e) {
						// Ignore
					} catch (IllegalAccessException e) {
						// Ignore
					}
				}
			}
		} catch (MissingResourceException mre) {
			// Ignore
		}
	}
	
}
