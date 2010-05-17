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

public class SyntaxColoringHelperGenerator extends UIJavaBaseGenerator {

	public static final GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new SyntaxColoringHelperGenerator());

	private SyntaxColoringHelperGenerator() {
		super();
	}

	private SyntaxColoringHelperGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceUIArtifacts.SYNTAX_COLORING_HELPER);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new SyntaxColoringHelperGenerator(parent, context);
	}

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public static enum StyleProperty {");
		sc.addLineBreak();
		sc.add("BOLD(\"bold\"),");
		sc.add("ITALIC(\"italic\"),");
		sc.add("ENABLE(\"enable\"),");
		sc.add("UNDERLINE(\"underline\"),");
		sc.add("STRIKETHROUGH(\"strikethrough\"),");
		sc.add("COLOR(\"color\");");
		sc.addLineBreak();
		sc.add("private String suffix;");
		sc.addLineBreak();
		sc.add("private StyleProperty(String suffix) {");
		sc.add("this.suffix = suffix;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getSuffix() {");
		sc.add("return suffix;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static String getPreferenceKey(String languageID, String tokenName, StyleProperty styleProperty) {");
		sc.add("return languageID + \"$\" + tokenName + \"$\" + styleProperty.getSuffix();");
		sc.add("}");
		sc.add("}");
	}
}
