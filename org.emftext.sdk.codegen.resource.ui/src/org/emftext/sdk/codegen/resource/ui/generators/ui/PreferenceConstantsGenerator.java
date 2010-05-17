/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class PreferenceConstantsGenerator extends UIJavaBaseGenerator {

	public static final GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new PreferenceConstantsGenerator());

	private PreferenceConstantsGenerator() {
		super();
	}

	private PreferenceConstantsGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceUIArtifacts.PREFERENCE_CONSTANTS);
	}

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

		sc.addComment("Constants for occurrence highlighting");
		sc.add("public static final String EDITOR_OCCURRENCE_CHECKBOX = \"_occurrenceHighlightingCheckbox\";");
		sc.add("public static final String EDITOR_DEFINITION_COLOR = \"_definition_color\";");
		sc.add("public static final String EDITOR_PROXY_COLOR = \"_proxy_color\";");
		sc.addLineBreak();
		sc.add("}");
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new PreferenceConstantsGenerator(parent, context);
	}
}
