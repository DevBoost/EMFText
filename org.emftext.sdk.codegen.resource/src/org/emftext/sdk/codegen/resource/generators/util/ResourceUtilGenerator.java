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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FILE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FILE_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

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
		addFindUnresolvedProxiesMethod(sc);
		addResolveAllMethod(sc);
		addSaveResourceMethod(sc);
		addContainsErrorsMethod(sc);
		addContainsWarningsMethod(sc);
		addContainsProblemsMethod(sc);
	}

	private void addFindUnresolvedProxiesMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Searches for all unresolved proxy object in the given resource.",
			"@param resource",
			"@return all proxy object that are not resolvable"
		);
		sc.add("public static " + LIST + "<" + E_OBJECT + "> findUnresolvedProxies(" + RESOURCE + " resource) {");
		sc.add(LIST + "<" + E_OBJECT + "> unresolvedProxies = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
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
}
