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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.ui;

// An interface that defines some constants used to create
// the keys for preferences.
public interface GeneratorconfigPreferenceConstants {

	//Constants for syntax highlighting
	//
	// Preference key suffix to enable syntax highlighting for
	// a token type.
	public static final String EDITOR_ENABLE_SUFFIX = "_enable";
	public static final String EDITOR_COLOR_SUFFIX = "_color";

	//Constants for brackets
	public static final String EDITOR_MATCHING_BRACKETS_COLOR = "_matchingBracketsColor";
	public static final String EDITOR_MATCHING_BRACKETS_CHECKBOX = "_matchingBracketsCheckbox";
	public static final String EDITOR_BRACKETS_SUFFIX = "_brackets";

	//Constants for occurrence highlighting
	public static final String EDITOR_OCCURRENCE_CHECKBOX = "_occurrenceHighlightingCheckbox";
	public static final String EDITOR_DEFINITION_COLOR = "_definition_color";
	public static final String EDITOR_PROXY_COLOR = "_proxy_color";

}
