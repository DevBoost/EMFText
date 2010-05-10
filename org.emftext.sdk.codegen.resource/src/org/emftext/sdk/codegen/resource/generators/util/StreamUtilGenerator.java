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
package org.emftext.sdk.codegen.resource.generators.util;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class StreamUtilGenerator extends JavaBaseGenerator<Object> {

	public StreamUtilGenerator() {
		super();
	}

	private StreamUtilGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.STREAM_UTIL);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new StreamUtilGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("private final static int IO_BUFFER_SIZE = 4 * 1024;");
		sc.addLineBreak();
		sc.add("public static void copy(" + INPUT_STREAM + " in, " + OUTPUT_STREAM + " out) throws " + IO_EXCEPTION + " {");
		sc.add("byte[] b = new byte[IO_BUFFER_SIZE];");
		sc.add("int read;");
		sc.add("while ((read = in.read(b)) != -1) {");
		sc.add("out.write(b, 0, read);");
		sc.add("}");
		sc.add("out.flush();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static String getContent(" + INPUT_STREAM + " inputStream) throws " + IO_EXCEPTION + " {");
		sc.add("StringBuffer content = new StringBuffer();");
		sc.add(INPUT_STREAM_READER + " reader = new " + INPUT_STREAM_READER + "(inputStream);");
		sc.add("int next = -1;");
		sc.add("while ((next = reader.read()) >= 0) {");
		sc.add("content.append((char) next);");
		sc.add("}");
		sc.add("return content.toString();");
		sc.add("}");
		sc.add("}");
		return true;
	}
}
