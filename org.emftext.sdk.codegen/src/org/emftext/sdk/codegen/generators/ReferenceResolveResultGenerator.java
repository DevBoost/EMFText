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
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

public class ReferenceResolveResultGenerator extends JavaBaseGenerator {

	private String qualifiedElementMappingClassName;
	private String qualifiedURIMappingClassName;

	public ReferenceResolveResultGenerator() {
		super();
	}

	private ReferenceResolveResultGenerator(GenerationContext context) {
		super(context, EArtifact.REFERENCE_RESOLVE_RESULT);
		qualifiedElementMappingClassName = context.getQualifiedClassName(EArtifact.ELEMENT_MAPPING);
		qualifiedURIMappingClassName = context.getQualifiedClassName(EArtifact.URI_MAPPING);
	}

	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A basic implementation of IResolveResult interface");
		sc.add("// that collects mappings in a list.");
		sc.add("//");
		sc.add("// @param <ReferenceType> the type of the references that can be contained in this result");
		sc.add("//");
		sc.add("public class " + getResourceClassName() + "<ReferenceType> implements " + getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<ReferenceType> {");
		sc.addLineBreak();
		sc.add("private " + COLLECTION + "<" + getClassNameHelper().getI_REFERENCE_MAPPING() + "<ReferenceType>> mappings;");
		sc.add("private String errorMessage;");
		sc.add("private boolean resolveFuzzy;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(boolean resolveFuzzy) {");
		sc.add("super();");
		sc.add("this.resolveFuzzy = resolveFuzzy;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getErrorMessage() {");
		sc.add("return errorMessage;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + COLLECTION + "<" + getClassNameHelper().getI_REFERENCE_MAPPING() + "<ReferenceType>> getMappings() {");
		sc.add("return mappings;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean wasResolved() {");
		sc.add("return mappings != null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean wasResolvedMultiple() {");
		sc.add("return mappings != null && mappings.size() > 1;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean wasResolvedUniquely() {");
		sc.add("return mappings != null && mappings.size() == 1;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setErrorMessage(String message) {");
		sc.add("errorMessage = message;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, ReferenceType target) {");
		sc.add("if (resolveFuzzy && target == null) {");
		sc.add("throw new IllegalArgumentException(\"Mapping references to null is only allowed for fuzzy resolution.\");");
		sc.add("}");
		sc.add("addMapping(identifier, target, null);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, ReferenceType target, String warning) {");
		sc.add("if (mappings == null) {");
		sc.add("mappings = new " + ARRAY_LIST + "<" + getClassNameHelper().getI_REFERENCE_MAPPING() + "<ReferenceType>>();");
		sc.add("}");
		sc.add("mappings.add(new " + qualifiedElementMappingClassName + "<ReferenceType>(identifier, target, warning));");
		sc.add("errorMessage = null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, " + URI + " uri) {");
		sc.add("addMapping(identifier, uri, null);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, " + URI + " uri, String warning) {");
		sc.add("if (mappings == null) {");
		sc.add("mappings = new " + ARRAY_LIST + "<" + getClassNameHelper().getI_REFERENCE_MAPPING() + "<ReferenceType>>();");
		sc.add("}");
		sc.add("mappings.add(new " + qualifiedURIMappingClassName + "<ReferenceType>(identifier, uri, warning));");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ReferenceResolveResultGenerator(context);
	}
}
