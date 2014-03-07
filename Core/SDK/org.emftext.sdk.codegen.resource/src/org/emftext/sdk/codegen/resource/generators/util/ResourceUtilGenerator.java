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
package org.emftext.sdk.codegen.resource.generators.util;

import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static de.devboost.codecomposers.java.ClassNameConstants.SET;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.BYTE_ARRAY_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.FILE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.FILE_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.URI;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

import de.devboost.codecomposers.java.JavaComposite;

@SyntaxDependent
public class ResourceUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Class ResourceUtil can be used to perform common tasks on resources, " +
			"such as resolving proxy object, saving resources, as well as, checking " +
			"them for errors."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addFindUnresolvedProxiesMethod2(sc);
		addFindUnresolvedProxiesMethod1(sc);
		addResolveAllMethod(sc);
		addGetProxyIdentifierMethod(sc);
		addGetResourceMethod1(sc);
		addGetResourceMethod2(sc);
		addGetResourceMethod3(sc);
		addGetResourceMethod4(sc);
		addGetResourceMethod5(sc);
		addGetResourceMethod6(sc);
		addGetResourceContentMethod1(sc);
		addGetResourceContentMethod2(sc);
		addGetResourceContentMethod3(sc);
		addSaveResourceMethod(sc);
		addGetTextMethod(sc);
		addContainsErrorsMethod(sc);
		addContainsWarningsMethod(sc);
		addContainsProblemsMethod(sc);
	}

	private void addGetProxyIdentifierMethod(JavaComposite sc) {
		sc.add("public static String getProxyIdentifier(" + E_OBJECT(sc) + " eObject) {");
		new GeneratorUtil().addCodeToDeresolveProxyObject(sc, iContextDependentUriFragmentClassName, "eObject");
		sc.add("return deresolvedReference;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTextMethod(JavaComposite sc) {
		sc.add("public static String getText(" + E_OBJECT(sc) + " eObject) {");
		sc.add(metaInformationClassName + " metaInformation = new " + metaInformationClassName + "();");
		sc.add("metaInformation.registerResourceFactory();");
			
		sc.add(RESOURCE_SET(sc) + " rs = null;");
		sc.add(textResourceClassName + " resource = (" + textResourceClassName + ") eObject.eResource();");
		sc.add("if (resource != null) {");
		sc.add("rs = resource.getResourceSet();");
		sc.add("}");
		sc.add("if (rs == null) {");
		sc.add("rs = new " + RESOURCE_SET_IMPL(sc) + "();");
		sc.add("}");
		sc.add("if (resource == null) {");
		sc.add(URI(sc) + " uri = " + URI(sc) + ".createURI(\"temp.\" + metaInformation.getSyntaxName());");
		sc.add("resource = (" + textResourceClassName + ") rs.createResource(uri);");
		sc.add("}");
		sc.addComment("Convert layout information to EAdapters because the printer retrieves layout information from these adapters.");
		sc.add(layoutUtilClassName + " layoutUtil = new " + layoutUtilClassName + "();");
		sc.add("if (resource.isLayoutInformationRecordingEnabled()) {");
		sc.add("layoutUtil.transferAllLayoutInformationFromModel(eObject);");
		sc.add("}");
		sc.add(BYTE_ARRAY_OUTPUT_STREAM(sc) + " outputStream = new " + BYTE_ARRAY_OUTPUT_STREAM(sc) + "();");
		sc.add(iTextPrinterClassName + " printer = metaInformation.createPrinter(outputStream, resource);");
		sc.add("try {");
		sc.add("printer.print(eObject);");
		sc.add("} catch (" + IO_EXCEPTION(sc) + " e) {");
		sc.add("return null;");
		sc.add("}");
		sc.addComment("Move layout information from EAdapters back to the model.");
		sc.add("if (resource.isLayoutInformationRecordingEnabled()) {");
		sc.add("layoutUtil.transferAllLayoutInformationToModel(eObject);");
		sc.add("}");
		sc.add("return outputStream.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod1(JavaComposite sc) {
		sc.add("public static " + textResourceClassName + " getResource(" + FILE(sc) + " file) {");
		sc.add("return getResource(file, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindUnresolvedProxiesMethod2(JavaComposite sc) {
		sc.addJavadoc(
			"Searches for all unresolved proxy objects in the given resource set.",
			"@param resourceSet",
			"@return all proxy objects that are not resolvable"
		);
		sc.add("public static " + SET(sc) + "<" + E_OBJECT(sc) + "> findUnresolvedProxies(" + RESOURCE_SET(sc) + " resourceSet) {");
		sc.add("return new " + interruptibleEcoreResolverClassName + "().findUnresolvedProxies(resourceSet);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindUnresolvedProxiesMethod1(JavaComposite sc) {
		sc.addJavadoc(
			"Searches for all unresolved proxy objects in the given resource.",
			"@param resource",
			"@return all proxy objects that are not resolvable"
		);
		sc.add("public static " + SET(sc) + "<" + E_OBJECT(sc) + "> findUnresolvedProxies(" + RESOURCE(sc) + " resource) {");
		sc.add("return new " + interruptibleEcoreResolverClassName + "().findUnresolvedProxies(resource);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveAllMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Tries to resolve all unresolved proxy objects in the " +
			"given resource. If all proxies were resolved true is " +
			"returned. If some could not be resolved, false is " +
			"returned.",
			"@param resource the resource containing the proxy object",
			"@return true on success"
		);
		sc.add("public static boolean resolveAll(" + RESOURCE(sc) + " resource) {");
		sc.add(ECORE_UTIL(sc) + ".resolveAll(resource);");
		sc.add("if (findUnresolvedProxies(resource).size() > 0) {");
		sc.add("return false;");
		sc.add("} else {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSaveResourceMethod(JavaComposite sc) {
		sc.add("public static void saveResource(" + FILE(sc) + " file, " + RESOURCE(sc) + " resource) throws " + IO_EXCEPTION(sc) + " {");
		sc.add(MAP(sc) + "<?, ?> options = " + COLLECTIONS(sc) + ".EMPTY_MAP;");
		sc.add(OUTPUT_STREAM(sc) + " outputStream = new " + FILE_OUTPUT_STREAM(sc) + "(file);");
		sc.add("resource.save(outputStream, options);");
		sc.add("outputStream.close();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainsErrorsMethod(JavaComposite sc) {
		sc.add("public static boolean containsErrors(" + RESOURCE(sc) + " resource) {");
		sc.add("return !resource.getErrors().isEmpty();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainsWarningsMethod(JavaComposite sc) {
		sc.add("public static boolean containsWarnings(" + RESOURCE(sc) + " resource) {");
		sc.add("return !resource.getWarnings().isEmpty();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainsProblemsMethod(JavaComposite sc) {
		sc.add("public static boolean containsProblems(" + RESOURCE(sc) + " resource) {");
		sc.add("return containsErrors(resource) || containsWarnings(resource);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod2(JavaComposite sc) {
		sc.add("public static " + textResourceClassName + " getResource(" + FILE(sc) + " file, " + MAP(sc) + "<?,?> options) {");
		sc.add("return getResource(" + URI(sc) + ".createFileURI(file.getAbsolutePath()), options);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod3(JavaComposite sc) {
		sc.add("public static " + textResourceClassName + " getResource(" + URI(sc) + " uri) {");
		sc.add("return getResource(uri, null);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetResourceMethod4(JavaComposite sc) {
		sc.add("public static " + textResourceClassName + " getResource(" + URI(sc) + " uri, " + MAP(sc) + "<?,?> options) {");
		sc.add("new " + metaInformationClassName + "().registerResourceFactory();");
		sc.add(RESOURCE_SET(sc) + " rs = new " + RESOURCE_SET_IMPL(sc) + "();");
		sc.add("if (options != null) {");
		sc.add("rs.getLoadOptions().putAll(options);");
		sc.add("}");
		sc.add(RESOURCE(sc) + " resource = rs.getResource(uri, true);");
		sc.add("return (" + textResourceClassName + ") resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceContentMethod1(JavaComposite sc) {
		String returnType = getRootElementType(sc);
		sc.addJavadoc("Returns the root element of the resource with the given URI.");
		sc.add("public static " + returnType + " getResourceContent(" + URI(sc) + " uri) {");
		sc.add("return getResourceContent(uri, null);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetResourceContentMethod2(JavaComposite sc) {
		String returnType = getRootElementType(sc);
		sc.addJavadoc("Returns the root element of the resource with the given URI.");
		sc.add("public static " + returnType + " getResourceContent(" + URI(sc) + " uri, " + MAP(sc) + "<?,?> options) {");
		sc.add(RESOURCE(sc) + " resource = getResource(uri, options);");
		sc.add("if (resource == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> contents = resource.getContents();");
		sc.add("if (contents == null || contents.isEmpty()) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_OBJECT(sc) + " root = contents.get(0);");
		sc.add("return (" + returnType + ") root;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceContentMethod3(JavaComposite sc) {
		String returnType = getRootElementType(sc);
		sc.addJavadoc("Returns the root element after parsing the given text.");
		sc.add("public static " + returnType + " getResourceContent(String text) {");
		sc.add(RESOURCE(sc) + " resource = getResource(text);");
		sc.add("if (resource == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> contents = resource.getContents();");
		sc.add("if (contents == null || contents.isEmpty()) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_OBJECT(sc) + " root = contents.get(0);");
		sc.add("return (" + returnType + ") root;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod5(JavaComposite sc) {
		sc.addJavadoc("Returns the resource after parsing the given text.");
		sc.add("public static " + RESOURCE(sc) + " getResource(String text) {");
		sc.add(RESOURCE_SET(sc) + " resourceSet = new " + RESOURCE_SET_IMPL(sc) + "();");
		sc.add("return getResource(text, resourceSet);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetResourceMethod6(JavaComposite sc) {
		sc.addJavadoc("Returns the resource after parsing the given text.");
		sc.add("public static " + RESOURCE(sc) + " getResource(String text, " + RESOURCE_SET(sc) + " resourceSet) {");
		sc.add(metaInformationClassName + " metaInformation = new " + metaInformationClassName + "();");
		sc.add("metaInformation.registerResourceFactory();");
		sc.add(URI(sc) + " uri = " + URI(sc) + ".createURI(\"temp.\" + metaInformation.getSyntaxName());");
		sc.add(RESOURCE(sc) + " resource = resourceSet.createResource(uri);");
		sc.add("if (resource == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(BYTE_ARRAY_INPUT_STREAM(sc) + " inputStream = new " + BYTE_ARRAY_INPUT_STREAM(sc) + "(text.getBytes());");
		sc.add("try {");
		sc.add("resource.load(inputStream, null);");
		sc.add("} catch (" + IO_EXCEPTION(sc) + " ioe) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getRootElementType(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		List<GenClass> startSymbols = syntax.getActiveStartSymbols();
		String returnType;
		if (startSymbols.size() == 1) {
			returnType = startSymbols.get(0).getQualifiedInterfaceName();
		} else {
			returnType = E_OBJECT(sc);
		}
		return returnType;
	}
}
