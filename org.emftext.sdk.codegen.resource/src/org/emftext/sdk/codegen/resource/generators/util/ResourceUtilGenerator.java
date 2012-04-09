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

import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BYTE_ARRAY_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FILE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FILE_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

@SyntaxDependent
public class ResourceUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
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
		addGetResourceMethod1(sc);
		addGetResourceMethod2(sc);
		addGetResourceMethod3(sc);
		addGetResourceMethod4(sc);
		addGetResourceMethod5(sc);
		addGetResourceContentMethod1(sc);
		addGetResourceContentMethod2(sc);
		addGetResourceContentMethod3(sc);
		addSaveResourceMethod(sc);
		addGetTextMethod(sc);
		addContainsErrorsMethod(sc);
		addContainsWarningsMethod(sc);
		addContainsProblemsMethod(sc);
	}

	private void addGetTextMethod(JavaComposite sc) {
		sc.add("public static String getText(" + E_OBJECT + " eObject) {");
		sc.add(metaInformationClassName + " metaInformation = new " + metaInformationClassName + "();");
		sc.add("metaInformation.registerResourceFactory();");
			
		sc.add(RESOURCE_SET + " rs = null;");
		sc.add(iTextResourceClassName + " resource = (" + iTextResourceClassName + ") eObject.eResource();");
		sc.add("if (resource != null) {");
		sc.add("rs = resource.getResourceSet();");
		sc.add("}");
		sc.add("if (rs == null) {");
		sc.add("rs = new " + RESOURCE_SET_IMPL + "();");
		sc.add("}");
		sc.add("if (resource == null) {");
		sc.add(URI + " uri = " + URI + ".createURI(\"temp.\" + metaInformation.getSyntaxName());");
		sc.add("resource = (" + iTextResourceClassName + ") rs.createResource(uri);");
		sc.add("}");
		sc.add(BYTE_ARRAY_OUTPUT_STREAM + " outputStream = new " + BYTE_ARRAY_OUTPUT_STREAM + "();");
		sc.add(iTextPrinterClassName + " printer = metaInformation.createPrinter(outputStream, resource);");
		sc.add("try {");
		sc.add("printer.print(eObject);");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return outputStream.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod1(JavaComposite sc) {
		sc.add("public static " + textResourceClassName + " getResource(" + FILE + " file) {");
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
		sc.add("public static " + SET + "<" + E_OBJECT + "> findUnresolvedProxies(" + RESOURCE_SET + " resourceSet) {");
		sc.add(SET + "<" + E_OBJECT + "> unresolvedProxies = new " + LINKED_HASH_SET + "<" + E_OBJECT + ">();");
		sc.addLineBreak();
		sc.add("for (" + RESOURCE + " resource : resourceSet.getResources()) {");
		sc.add("unresolvedProxies.addAll(findUnresolvedProxies(resource));");
		sc.add("}");
		sc.add("return unresolvedProxies;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindUnresolvedProxiesMethod1(JavaComposite sc) {
		sc.addJavadoc(
			"Searches for all unresolved proxy objects in the given resource.",
			"@param resource",
			"@return all proxy objects that are not resolvable"
		);
		sc.add("public static " + SET + "<" + E_OBJECT + "> findUnresolvedProxies(" + RESOURCE + " resource) {");
		sc.add(SET + "<" + E_OBJECT + "> unresolvedProxies = new " + LINKED_HASH_SET + "<" + E_OBJECT + ">();");
		sc.addLineBreak();
		sc.add("for (" + ITERATOR + "<" + E_OBJECT + "> elementIt = " + ECORE_UTIL + ".getAllContents(resource, true); elementIt.hasNext(); ) {");
		sc.add(INTERNAL_E_OBJECT + " nextElement = (" + INTERNAL_E_OBJECT + ") elementIt.next();");
		sc.add("if (nextElement.eIsProxy()) {");
		sc.add("unresolvedProxies.add(nextElement);");
		sc.add("}");
		sc.add("for (" + E_OBJECT + " crElement : nextElement.eCrossReferences()) {");
		sc.add("crElement = " + ECORE_UTIL + ".resolve(crElement, resource);");
		sc.add("if (crElement.eIsProxy()) {");
		sc.add("unresolvedProxies.add(crElement);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return unresolvedProxies;");
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
		sc.add("public static boolean resolveAll(" + RESOURCE + " resource) {");
		sc.add(ECORE_UTIL + ".resolveAll(resource);");
		sc.add("if (findUnresolvedProxies(resource).size() > 0) {");
		sc.add("return false;");
		sc.add("} else {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSaveResourceMethod(JavaComposite sc) {
		sc.add("public static void saveResource(" + FILE + " file, " + RESOURCE + " resource) throws " + IO_EXCEPTION + " {");
		sc.add(MAP + "<?, ?> options = " + COLLECTIONS + ".EMPTY_MAP;");
		sc.add(OUTPUT_STREAM + " outputStream = new " + FILE_OUTPUT_STREAM + "(file);");
		sc.add("resource.save(outputStream, options);");
		sc.add("outputStream.close();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainsErrorsMethod(JavaComposite sc) {
		sc.add("public static boolean containsErrors(" + RESOURCE + " resource) {");
		sc.add("return !resource.getErrors().isEmpty();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainsWarningsMethod(JavaComposite sc) {
		sc.add("public static boolean containsWarnings(" + RESOURCE + " resource) {");
		sc.add("return !resource.getWarnings().isEmpty();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainsProblemsMethod(JavaComposite sc) {
		sc.add("public static boolean containsProblems(" + RESOURCE + " resource) {");
		sc.add("return containsErrors(resource) || containsWarnings(resource);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod2(JavaComposite sc) {
		sc.add("public static " + textResourceClassName + " getResource(" + FILE + " file, " + MAP + "<?,?> options) {");
		sc.add("return getResource(" + URI + ".createFileURI(file.getAbsolutePath()), options);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod3(JavaComposite sc) {
		sc.add("public static " + textResourceClassName + " getResource(" + URI + " uri) {");
		sc.add("return getResource(uri, null);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetResourceMethod4(JavaComposite sc) {
		sc.add("public static " + textResourceClassName + " getResource(" + URI + " uri, " + MAP + "<?,?> options) {");
		sc.add("new " + metaInformationClassName + "().registerResourceFactory();");
		sc.add(RESOURCE_SET + " rs = new " + RESOURCE_SET_IMPL + "();");
		sc.add("if (options != null) {");
		sc.add("rs.getLoadOptions().putAll(options);");
		sc.add("}");
		sc.add(RESOURCE + " resource = rs.getResource(uri, true);");
		sc.add("return (" + textResourceClassName + ") resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceContentMethod1(JavaComposite sc) {
		String returnType = getRootElementType();
		sc.addJavadoc("Returns the root element of the resource with the given URI.");
		sc.add("public static " + returnType + " getResourceContent(" + URI + " uri) {");
		sc.add("return getResourceContent(uri, null);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetResourceContentMethod2(JavaComposite sc) {
		String returnType = getRootElementType();
		sc.addJavadoc("Returns the root element of the resource with the given URI.");
		sc.add("public static " + returnType + " getResourceContent(" + URI + " uri, " + MAP + "<?,?> options) {");
		sc.add(RESOURCE + " resource = getResource(uri, options);");
		sc.add("if (resource == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(LIST + "<" + E_OBJECT + "> contents = resource.getContents();");
		sc.add("if (contents == null || contents.isEmpty()) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_OBJECT + " root = contents.get(0);");
		sc.add("return (" + returnType + ") root;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceContentMethod3(JavaComposite sc) {
		String returnType = getRootElementType();
		sc.addJavadoc("Returns the root element after parsing the given text.");
		sc.add("public static " + returnType + " getResourceContent(String text) {");
		sc.add(RESOURCE + " resource = getResource(text);");
		sc.add("if (resource == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(LIST + "<" + E_OBJECT + "> contents = resource.getContents();");
		sc.add("if (contents == null || contents.isEmpty()) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_OBJECT + " root = contents.get(0);");
		sc.add("return (" + returnType + ") root;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod5(JavaComposite sc) {
		sc.addJavadoc("Returns the resource after parsing the given text.");
		sc.add("public static " + RESOURCE + " getResource(String text) {");
		sc.add(metaInformationClassName + " metaInformation = new " + metaInformationClassName + "();");
		sc.add("metaInformation.registerResourceFactory();");
		sc.add(URI + " uri = " + URI + ".createURI(\"temp.\" + metaInformation.getSyntaxName());");
		sc.add(RESOURCE_SET + " resourceSet = new " + RESOURCE_SET_IMPL + "();");
		sc.add(RESOURCE + " resource = resourceSet.createResource(uri);");
		sc.add("if (resource == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(BYTE_ARRAY_INPUT_STREAM + " inputStream = new " + BYTE_ARRAY_INPUT_STREAM + "(text.getBytes());");
		sc.add("try {");
		sc.add("resource.load(inputStream, null);");
		sc.add("} catch (" + IO_EXCEPTION + " ioe) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getRootElementType() {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		List<GenClass> startSymbols = syntax.getActiveStartSymbols();
		String returnType;
		if (startSymbols.size() == 1) {
			returnType = startSymbols.get(0).getQualifiedInterfaceName();
		} else {
			returnType = E_OBJECT;
		}
		return returnType;
	}
}
