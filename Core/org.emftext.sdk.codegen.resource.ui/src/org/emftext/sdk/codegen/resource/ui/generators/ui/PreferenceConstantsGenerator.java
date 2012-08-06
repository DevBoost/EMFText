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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class PreferenceConstantsGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"An interface that defines some constants used to create " +
			"the keys for preferences."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addComment("Constants for syntax highlighting");
		sc.addJavadoc("Preference key suffix to enable syntax highlighting for a token type.");
		sc.add("public static final String EDITOR_ENABLE_SUFFIX = \"_enable\";");
		sc.add("public static final String EDITOR_COLOR_SUFFIX = \"_color\";");
		sc.addLineBreak();
		
		sc.addComment("Constants for brackets");
		sc.add("public static final String EDITOR_MATCHING_BRACKETS_COLOR = \"_matchingBracketsColor\";");
		sc.add("public static final String EDITOR_MATCHING_BRACKETS_CHECKBOX = \"_matchingBracketsCheckbox\";");
		sc.add("public static final String EDITOR_BRACKETS_SUFFIX = \"_brackets\";");
		sc.addLineBreak();
		sc.add("}");
	}
}
