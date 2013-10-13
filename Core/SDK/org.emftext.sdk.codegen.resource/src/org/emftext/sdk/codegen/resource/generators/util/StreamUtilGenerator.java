/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource.generators.util;

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.OUTPUT_STREAM;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class StreamUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addCopyMethod(sc);
		addGetContentMethod1(sc);
		addGetContentMethod2(sc);
		addGetContentMethod3(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final static int IO_BUFFER_SIZE = 4 * 1024;");
		sc.addLineBreak();
	}

	private void addCopyMethod(JavaComposite sc) {
		sc.add("public static void copy(" + INPUT_STREAM(sc) + " in, " + OUTPUT_STREAM(sc) + " out) throws " + IO_EXCEPTION(sc) + " {");
		sc.add("byte[] b = new byte[IO_BUFFER_SIZE];");
		sc.add("int read;");
		sc.add("while ((read = in.read(b)) != -1) {");
		sc.add("out.write(b, 0, read);");
		sc.add("}");
		sc.add("out.flush();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContentMethod1(JavaComposite sc) {
		sc.add("public static String getContent(" + INPUT_STREAM(sc) + " inputStream) throws " + IO_EXCEPTION(sc) + " {");
		sc.add(INPUT_STREAM_READER(sc) + " reader = new " + INPUT_STREAM_READER(sc) + "(inputStream);");
		sc.add("return getContent(reader);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContentMethod2(JavaComposite sc) {
		sc.add("public static String getContent(" + INPUT_STREAM(sc) + " inputStream, String charset) throws " + IO_EXCEPTION(sc) + " {");
		sc.add(INPUT_STREAM_READER(sc) + " reader = new " + INPUT_STREAM_READER(sc) + "(inputStream, charset);");
		sc.add("return getContent(reader);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContentMethod3(JavaComposite sc) {
		sc.add("public static String getContent(" + INPUT_STREAM_READER(sc) + " reader) throws " + IO_EXCEPTION(sc) + " {");
		sc.add("StringBuffer content = new StringBuffer();");
		sc.add("int next = -1;");
		sc.add("while ((next = reader.read()) >= 0) {");
		sc.add("content.append((char) next);");
		sc.add("}");
		sc.add("return content.toString();");
		sc.add("}");
		sc.addLineBreak();
	}
}
