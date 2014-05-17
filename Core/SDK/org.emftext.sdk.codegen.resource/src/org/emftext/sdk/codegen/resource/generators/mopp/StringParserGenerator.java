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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.TREE_MAP;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.URI;

import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

@SyntaxDependent
public class StringParserGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.addJavadoc("Utility class to allow parsing of textual language fragments in string format.");
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addMethods(sc);

		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addParseString1Method(sc);
		addParseString2Method(sc);
	}

	private void addParseString1Method(JavaComposite sc) {
		sc.addJavadoc("Parses the textual representation of a model.");
		sc.add("public static " + E_OBJECT(sc) + " parseString(String textualModel) {");
		sc.add("return parseString(textualModel, null);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addParseString2Method(JavaComposite sc) {
		GenerationContext context = getContext();

		String fileExtension = context.getConcreteSyntax().getName();
		
		String optionsClass = context.getQualifiedClassName(TextResourceArtifacts.I_OPTIONS);
		String metaInformationClass = context.getQualifiedClassName(TextResourceArtifacts.META_INFORMATION);
		
		sc.addJavadoc("Parses the textual representation of a model using an arbitrary start class as override for the ones specified in the syntax. The start class must have a corresponding rule (i.e., it must be a non-abstract non-interface class with declared concrete syntax that does not represent an operator rule).");
		sc.add("public static " + E_OBJECT(sc) + " parseString(String textualModel, " + E_CLASS(sc) + " startEClass) {");
		sc.add(BYTE_ARRAY_INPUT_STREAM(sc) + " input = null;");
		sc.addLineBreak();
		sc.add("new " + metaInformationClass + "().registerResourceFactory();");
		sc.add("try {");
		sc.add(RESOURCE_SET(sc) + " rs = new " + RESOURCE_SET_IMPL(sc) + "();");
		sc.add(RESOURCE(sc) + " resource = rs.createResource(" + URI(sc) + ".createFileURI(\"Dummy." + fileExtension +"\"));");
		sc.addLineBreak();	
		sc.add("input = new " + BYTE_ARRAY_INPUT_STREAM(sc) + "(textualModel.getBytes());");
		sc.addLineBreak();
		sc.add(MAP(sc) + "<Object, Object> options = new " + TREE_MAP(sc) + "<Object, Object>();");
		sc.addLineBreak();
		sc.add("if (startEClass != null) {");
		sc.add("options.put(" + optionsClass + ".RESOURCE_CONTENT_TYPE, startEClass);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("resource.load(input, options);");
		sc.addLineBreak();	
		sc.add(E_LIST(sc) + "<" + E_OBJECT(sc) + "> contents = resource.getContents();");
		sc.addLineBreak();	
		sc.add("if (!contents.isEmpty()) {");
		sc.add("return contents.get(0);");
		sc.add("}");
		sc.add("} catch(Exception e) {");
		sc.add("} finally {");
		sc.add("if (input != null) {");
		sc.add("try {");
		sc.add("input.close();");
		sc.add("} catch(Exception e) {");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
}
