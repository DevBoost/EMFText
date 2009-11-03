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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.FILE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.FILE_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ResourceUtilGenerator extends BaseGenerator {

	public ResourceUtilGenerator() {
		super();
	}

	private ResourceUtilGenerator(GenerationContext context) {
		super(context, EArtifact.RESOURCE_UTIL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ResourceUtilGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Class ResourceUtil can be used to perform common tasks on resources,");
		sc.add("// such as resolving proxy object, saving resources, as well as, checking");
		sc.add("// them for errors.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Searches for all unresolved proxy object in the given resource.");
		sc.add("//");
		sc.add("// @param resource");
		sc.add("// @return all proxy object that are not resolvable");
		sc.add("public static " + LIST + "<" + E_OBJECT + "> findUnresolvedProxies(" + RESOURCE + " resource) {");
		sc.add(LIST + "<" + E_OBJECT + "> unresolveProxies = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
		sc.addLineBreak();
		sc.add("for(" + ITERATOR + "<" + E_OBJECT + "> elementIt = " + ECORE_UTIL + ".getAllContents(resource, true); elementIt.hasNext(); ) {");
		sc.add(INTERNAL_E_OBJECT + " nextElement = (" + INTERNAL_E_OBJECT + ") elementIt.next();");
		sc.add("if (nextElement.eIsProxy()) {");
		sc.add("unresolveProxies.add(nextElement);");
		sc.add("}");
		sc.add("for (" + E_OBJECT + " crElement : nextElement.eCrossReferences()) {");
		sc.add("crElement = " + ECORE_UTIL + ".resolve(crElement, resource);");
		sc.add("if (crElement.eIsProxy()) {");
		sc.add("unresolveProxies.add(nextElement);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return unresolveProxies;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// Tries to resolve all unresolved proxy objects in the");
		sc.add("// given resource. If all proxies were resolved true is");
		sc.add("// returned. If some could not be resolved, false is");
		sc.add("// returned.");
		sc.add("//");
		sc.add("// @param resource the resource containing the proxy object");
		sc.add("// @return true on success");
		
		sc.add("public static boolean resolveAll(" + RESOURCE + " resource) {");
		sc.add(ECORE_UTIL + ".resolveAll(resource);");
		sc.add("if (findUnresolvedProxies(resource).size() > 0) {");
		sc.add("return false;");
		sc.add("} else {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static void saveResource(" + FILE + " file, " + RESOURCE + " resource) throws " + IO_EXCEPTION + " {");
		sc.add(MAP + "<?, ?> options = " + COLLECTIONS + ".EMPTY_MAP;");
		sc.add(OUTPUT_STREAM + " outputStream = new " + FILE_OUTPUT_STREAM + "(file);");
		sc.add("resource.save(outputStream, options);");
		sc.add("outputStream.close();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static boolean containsErrors(" + RESOURCE + " resource) {");
		sc.add("return !resource.getErrors().isEmpty();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static boolean containsWarnings(" + RESOURCE + " resource) {");
		sc.add("return !resource.getWarnings().isEmpty();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static boolean containsProblems(" + RESOURCE + " resource) {");
		sc.add("return containsErrors(resource) || containsWarnings(resource);");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
