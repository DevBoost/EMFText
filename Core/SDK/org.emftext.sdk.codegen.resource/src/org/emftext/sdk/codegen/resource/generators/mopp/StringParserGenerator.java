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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static de.devboost.codecomposers.java.ClassNameConstants.LINKED_HASH_MAP;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.URI;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class StringParserGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private static final String DOCUMENTATION_1 = "Parses the textual representation of a model.";
	private static final String DOCUMENTATION_2 = "Parses the textual representation of a model using an arbitrary start class as override for the ones specified in the syntax. The start class must have a corresponding rule (i.e., it must be a non-abstract non-interface class with declared concrete syntax that does not represent an operator rule).";

	@Override
	public void generateJavaContents(JavaComposite jc) {
		jc.addJavadoc("Utility class to allow parsing of textual language fragments in string format.");
		jc.add("package " + getResourcePackageName() + ";");
		jc.addLineBreak();
		jc.addImportsPlaceholder();
		jc.addLineBreak();
		jc.add("public class " + getResourceClassName() + " {");
		jc.addLineBreak();
		
		addMethods(jc);

		jc.add("}");
	}

	private void addMethods(JavaComposite jc) {
		addParseStringMethod1(jc);
		addParseStringMethod2(jc);
		addParseStringMethod3(jc);
		addParseStringMethod4(jc);
	}

	private void addParseStringMethod1(JavaComposite jc) {
		jc.addJavadoc(
			DOCUMENTATION_1 +
			" This method is deprecated because it uses the default platform encoding. Use " +
			"{@link #parseString(String, String} instead."
		);
		jc.add("@" + jc.getClassName(Deprecated.class));
		jc.add("public static " + E_OBJECT(jc) + " parseString(String textualModel) {");
		jc.add("return parseString(textualModel, (" + E_CLASS(jc) + ") null);");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addParseStringMethod2(JavaComposite jc) {
		jc.addJavadoc(DOCUMENTATION_1);
		jc.add("public static " + E_OBJECT(jc) + " parseString(String textualModel, String encoding) {");
		jc.add("return parseString(textualModel, null, encoding);");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addParseStringMethod3(JavaComposite jc) {
		GenerationContext context = getContext();

		String fileExtension = context.getConcreteSyntax().getName();
		
		String optionsClass = context.getQualifiedClassName(TextResourceArtifacts.I_OPTIONS);
		String metaInformationClass = context.getQualifiedClassName(TextResourceArtifacts.META_INFORMATION);
		
		jc.addJavadoc(
			DOCUMENTATION_2 +
			" This method is deprecated because it uses the default platform encoding. Use " +
			"{@link #parseString(String, " + E_CLASS(jc) + ", String)} instead."
		);
		jc.add("@" + jc.getClassName(Deprecated.class));
		jc.add("public static " + E_OBJECT(jc) + " parseString(String textualModel, " + E_CLASS(jc) + " startEClass) {");
		jc.add(BYTE_ARRAY_INPUT_STREAM(jc) + " input = null;");
		jc.addLineBreak();
		jc.add("new " + metaInformationClass + "().registerResourceFactory();");
		jc.add("try {");
		jc.add(RESOURCE_SET(jc) + " rs = new " + RESOURCE_SET_IMPL(jc) + "();");
		jc.add(RESOURCE(jc) + " resource = rs.createResource(" + URI(jc) + ".createFileURI(\"in_memory_temp." + fileExtension +"\"));");
		jc.addLineBreak();	
		jc.add("input = new " + BYTE_ARRAY_INPUT_STREAM(jc) + "(textualModel.getBytes());");
		jc.addLineBreak();
		jc.add(MAP(jc) + "<Object, Object> options = new " + LINKED_HASH_MAP(jc) + "<Object, Object>();");
		jc.addLineBreak();
		jc.add("if (startEClass != null) {");
		jc.add("options.put(" + optionsClass + ".RESOURCE_CONTENT_TYPE, startEClass);");
		jc.add("}");
		jc.addLineBreak();
		jc.add("resource.load(input, options);");
		jc.addLineBreak();	
		jc.add(LIST(jc) + "<" + E_OBJECT(jc) + "> contents = resource.getContents();");
		jc.addLineBreak();	
		jc.add("if (!contents.isEmpty()) {");
		jc.add("return contents.get(0);");
		jc.add("}");
		jc.add("} catch(Exception e) {");
		jc.add("} finally {");
		jc.add("if (input != null) {");
		jc.add("try {");
		jc.add("input.close();");
		jc.add("} catch(Exception e) {");
		jc.add("}");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addParseStringMethod4(JavaComposite jc) {
		GenerationContext context = getContext();

		String fileExtension = context.getConcreteSyntax().getName();
		
		String optionsClass = context.getQualifiedClassName(TextResourceArtifacts.I_OPTIONS);
		String metaInformationClass = context.getQualifiedClassName(TextResourceArtifacts.META_INFORMATION);
		
		jc.addJavadoc(
			DOCUMENTATION_2
		);
		jc.add("public static " + E_OBJECT(jc) + " parseString(String textualModel, " + E_CLASS(jc) + " startEClass, String encoding) {");
		jc.add(BYTE_ARRAY_INPUT_STREAM(jc) + " input = null;");
		jc.addLineBreak();
		jc.add("new " + metaInformationClass + "().registerResourceFactory();");
		jc.add("try {");
		jc.add(RESOURCE_SET(jc) + " rs = new " + RESOURCE_SET_IMPL(jc) + "();");
		jc.add(RESOURCE(jc) + " resource = rs.createResource(" + URI(jc) + ".createFileURI(\"in_memory_temp." + fileExtension +"\"));");
		jc.addLineBreak();	
		jc.add("if (encoding == null) {");
		jc.add("input = new " + BYTE_ARRAY_INPUT_STREAM(jc) + "(textualModel.getBytes());");
		jc.add("} else {");
		jc.add("input = new " + BYTE_ARRAY_INPUT_STREAM(jc) + "(textualModel.getBytes(encoding));");
		jc.add("}");
		jc.addLineBreak();
		jc.add(MAP(jc) + "<Object, Object> options = new " + LINKED_HASH_MAP(jc) + "<Object, Object>();");
		jc.addLineBreak();
		jc.add("if (startEClass != null) {");
		jc.add("options.put(" + optionsClass + ".RESOURCE_CONTENT_TYPE, startEClass);");
		jc.add("}");
		jc.addLineBreak();
		jc.add("resource.load(input, options);");
		jc.addLineBreak();	
		jc.add(LIST(jc) + "<" + E_OBJECT(jc) + "> contents = resource.getContents();");
		jc.addLineBreak();	
		jc.add("if (!contents.isEmpty()) {");
		jc.add("return contents.get(0);");
		jc.add("}");
		jc.add("} catch(Exception e) {");
		jc.add("} finally {");
		jc.add("if (input != null) {");
		jc.add("try {");
		jc.add("input.close();");
		jc.add("} catch(" + IO_EXCEPTION(jc) + " e) {");
		jc.add("}");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
	}
}
