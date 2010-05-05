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
package org.emftext.sdk.codegen.generators.util;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.FILE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class TextResourceUtilGenerator extends JavaBaseGenerator {

	public TextResourceUtilGenerator() {
		super();
	}

	private TextResourceUtilGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.TEXT_RESOURCE_UTIL);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new TextResourceUtilGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Class TextResourceUtil can be used to perform common tasks on text resources, " +
			"such as loading and saving resources, as well as, checking them for errors."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public static " + textResourceClassName + " getResource(" + I_FILE + " file) {");
		sc.add(RESOURCE_SET + " rs = new " + RESOURCE_SET_IMPL + "();");
		sc.add(RESOURCE + " csResource = rs.getResource(" + URI + ".createPlatformResourceURI(file.getFullPath().toString(),true), true);");
		sc.add("return (" + textResourceClassName + ") csResource;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static " + textResourceClassName + " getResource(" + FILE + " file) {");
		sc.add("return getResource(file, null);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static " + textResourceClassName + " getResource(" + FILE + " file, " + MAP + "<?,?> options) {");
		sc.add(RESOURCE_SET + " rs = new " + RESOURCE_SET_IMPL + "();");
		sc.add("if (options != null) {");
		sc.add("rs.getLoadOptions().putAll(options);");
		sc.add("}");
		sc.add(RESOURCE + " csResource = rs.getResource(" + URI + ".createFileURI(file.getAbsolutePath()), true);");
		sc.add("return (" + textResourceClassName + ") csResource;");
		sc.add("}");
		sc.add("}");
		return true;
	}
}
