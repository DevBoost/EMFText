/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.GenerationContext;
import java.io.PrintWriter;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.IGenerator;

public class TextResourceUtilGenerator extends BaseGenerator {

	private String textResourceClassName;

	public TextResourceUtilGenerator() {
		super();
	}

	private TextResourceUtilGenerator(GenerationContext context) {
		super(context, EArtifact.TEXT_RESOURCE_UTIL);
		textResourceClassName = getContext().getQualifiedClassName(EArtifact.RESOURCE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new TextResourceUtilGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Class TextResourceUtil can be used to perform common tasks on text resources,");
		sc.add("// such as loading and saving resources, as well as, checking them for errors.");
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
		out.print(sc.toString());
		return true;
	}
}
