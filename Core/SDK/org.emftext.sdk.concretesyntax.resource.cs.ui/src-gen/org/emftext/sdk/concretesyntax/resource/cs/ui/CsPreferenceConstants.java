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


/**
 * An interface that defines some constants used to create the keys for
 * preferences.
 */
public interface CsPreferenceConstants {
	
	// Constants for syntax highlighting
	/**
	 * Preference key suffix to enable syntax highlighting for a token type.
	 */
	public static final String EDITOR_ENABLE_SUFFIX = "_enable";
	public static final String EDITOR_COLOR_SUFFIX = "_color";
	
	// Constants for brackets
	public static final String EDITOR_MATCHING_BRACKETS_COLOR = "_matchingBracketsColor";
	public static final String EDITOR_MATCHING_BRACKETS_CHECKBOX = "_matchingBracketsCheckbox";
	public static final String EDITOR_BRACKETS_SUFFIX = "_brackets";
	
	// Constants for content assists
	public static final String EDITOR_CONTENT_ASSIST_ENABLED 	= "_activationEnabled";
	public static final String EDITOR_CONTENT_ASSIST_DELAY 		= "_activationDelay";
	public static final String EDITOR_CONTENT_ASSIST_TRIGGERS 	= "_activationTriggers";
	// and their defaults
	public static final boolean EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT	= true;
	public static final int EDITOR_CONTENT_ASSIST_DELAY_DEFAULT			= 200;
	public static final String EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT 	= ":=|+@";
	
}
