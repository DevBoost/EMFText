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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class ReferenceResolveResultGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A basic implementation of the " + iReferenceResolveResultClassName + " interface that collects mappings in a list.",
			"@param <ReferenceType> the type of the references that can be contained in this result"
		);
		sc.add("public class " + getResourceClassName() + "<ReferenceType> implements " + iReferenceResolveResultClassName + "<ReferenceType> {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetErrorMessageMethod(sc);
		addGetQuickFixesMethod(sc);
		addAddQuickFixMethod(sc);
		addGetMappingsMethod(sc);
		addWasResolvedMethod(sc);
		addWasResolvedMultipleMethod(sc);
		addWasResolvedUniquelyMethod(sc);
		addSetErrorMessageMethod(sc);
		addAddMappingMethod1(sc);
		addAddMappingMethod2(sc);
		addAddMappingMethod3(sc);
		addAddMappingMethod4(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + COLLECTION + "<" + iReferenceMappingClassName + "<ReferenceType>> mappings;");
		sc.add("private String errorMessage;");
		sc.add("private boolean resolveFuzzy;");
		sc.add("private " + SET + "<" + iQuickFixClassName + "> quickFixes;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(boolean resolveFuzzy) {");
		sc.add("super();");
		sc.add("this.resolveFuzzy = resolveFuzzy;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetErrorMessageMethod(JavaComposite sc) {
		sc.add("public String getErrorMessage() {");
		sc.add("return errorMessage;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetQuickFixesMethod(JavaComposite sc) {
		sc.add("public " + COLLECTION + "<" + iQuickFixClassName + "> getQuickFixes() {");
		sc.add("if (quickFixes == null) {");
		sc.add("quickFixes = new " + LINKED_HASH_SET + "<" + iQuickFixClassName + ">();");
		sc.add("}");
		sc.add("return " + COLLECTIONS + ".unmodifiableSet(quickFixes);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddQuickFixMethod(JavaComposite sc) {
		sc.add("public void addQuickFix(" + iQuickFixClassName + " quickFix) {");
		sc.add("if (quickFixes == null) {");
		sc.add("quickFixes = new " + LINKED_HASH_SET + "<" + iQuickFixClassName + ">();");
		sc.add("}");
		sc.add("quickFixes.add(quickFix);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMappingsMethod(JavaComposite sc) {
		sc.add("public " + COLLECTION + "<" + iReferenceMappingClassName + "<ReferenceType>> getMappings() {");
		sc.add("return mappings;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addWasResolvedMethod(JavaComposite sc) {
		sc.add("public boolean wasResolved() {");
		sc.add("return mappings != null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addWasResolvedMultipleMethod(JavaComposite sc) {
		sc.add("public boolean wasResolvedMultiple() {");
		sc.add("return mappings != null && mappings.size() > 1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addWasResolvedUniquelyMethod(JavaComposite sc) {
		sc.add("public boolean wasResolvedUniquely() {");
		sc.add("return mappings != null && mappings.size() == 1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetErrorMessageMethod(JavaComposite sc) {
		sc.add("public void setErrorMessage(String message) {");
		sc.add("errorMessage = message;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddMappingMethod1(JavaComposite sc) {
		sc.add("public void addMapping(String identifier, ReferenceType target) {");
		sc.add("if (!resolveFuzzy && target == null) {");
		sc.add("throw new IllegalArgumentException(\"Mapping references to null is only allowed for fuzzy resolution.\");");
		sc.add("}");
		sc.add("addMapping(identifier, target, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddMappingMethod2(JavaComposite sc) {
		sc.add("public void addMapping(String identifier, ReferenceType target, String warning) {");
		sc.add("if (mappings == null) {");
		sc.add("mappings = new " + ARRAY_LIST + "<" + iReferenceMappingClassName + "<ReferenceType>>(1);");
		sc.add("}");
		sc.add("mappings.add(new " + elementMappingClassName + "<ReferenceType>(identifier, target, warning));");
		sc.add("errorMessage = null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddMappingMethod3(JavaComposite sc) {
		sc.add("public void addMapping(String identifier, " + URI + " uri) {");
		sc.add("addMapping(identifier, uri, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddMappingMethod4(JavaComposite sc) {
		sc.add("public void addMapping(String identifier, " + URI + " uri, String warning) {");
		sc.add("if (mappings == null) {");
		sc.add("mappings = new " + ARRAY_LIST + "<" + iReferenceMappingClassName + "<ReferenceType>>(1);");
		sc.add("}");
		sc.add("mappings.add(new " + uriMappingClassName + "<ReferenceType>(identifier, uri, warning));");
		sc.add("}");
	}

	
}
