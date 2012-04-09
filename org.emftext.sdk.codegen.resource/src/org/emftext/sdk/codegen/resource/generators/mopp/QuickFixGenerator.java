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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BYTE_ARRAY_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class QuickFixGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public abstract class " + getResourceClassName() + " implements " + iQuickFixClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructors(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addApplyMethod(sc);
		addApplyChangesMethod(sc);
		addGetResourceMethod(sc);
		addGetDisplayStringMethod(sc);
		addGetImageKeyMethod(sc);
		addGetContextObjectsMethod(sc);
		addGetContextAsStringMethod(sc);
		addGetTypeMethod(sc);
	}

	private void addConstructors(JavaComposite sc) {
		addConstructor1(sc);
		addConstructor2(sc);
		addConstructor3(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private String displayString;");
		sc.add("private String imageKey;");
		sc.add("private " + RESOURCE + " resource;");
		sc.add("private " + COLLECTION + "<" + E_OBJECT + "> contextObjects;");
		sc.addLineBreak();
	}

	private void addConstructor1(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String displayString, String imageKey, " + E_OBJECT + " contextObject) {");
		sc.add("this(displayString, imageKey, " + COLLECTIONS + ".singleton(contextObject), contextObject.eResource());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String displayString, String imageKey, " + COLLECTION + "<" + E_OBJECT + "> contextObjects) {");
		sc.add("this(displayString, imageKey, contextObjects, contextObjects.iterator().next().eResource());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor3(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String displayString, String imageKey, " + COLLECTION + "<" + E_OBJECT + "> contextObjects, " + RESOURCE + " resource) {");
		sc.add("super();");
		sc.add("if (displayString == null) {");
		sc.add("throw new IllegalArgumentException(\"displayString must not be null.\");");
		sc.add("}");
		sc.add("if (contextObjects == null) {");
		sc.add("throw new IllegalArgumentException(\"contextObjects must not be null.\");");
		sc.add("}");
		sc.add("if (contextObjects.isEmpty()) {");
		sc.add("throw new IllegalArgumentException(\"contextObjects must not be empty.\");");
		sc.add("}");
		sc.add("this.displayString = displayString;");
		sc.add("this.imageKey = imageKey;");
		sc.add("this.contextObjects = contextObjects;");
		sc.add("this.resource = resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addApplyMethod(JavaComposite sc) {
		sc.add("public String apply(String currentText) {");
		sc.add("applyChanges();");
		sc.add("try {");
		sc.add(BYTE_ARRAY_OUTPUT_STREAM + " output = new " + BYTE_ARRAY_OUTPUT_STREAM + "();");
		sc.add("getResource().save(output, null);");
		sc.add("return output.toString();");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Exception while applying quick fix\", e);");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addApplyChangesMethod(JavaComposite sc) {
		sc.add("public abstract void applyChanges();");
		sc.addLineBreak();
	}

	private void addGetResourceMethod(JavaComposite sc) {
		sc.add("public " + RESOURCE + " getResource() {");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDisplayStringMethod(JavaComposite sc) {
		sc.add("public String getDisplayString() {");
		sc.add("return displayString;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetImageKeyMethod(JavaComposite sc) {
		sc.add("public String getImageKey() {");
		sc.add("return imageKey;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContextObjectsMethod(JavaComposite sc) {
		sc.add("public " + COLLECTION + "<" + E_OBJECT + "> getContextObjects() {");
		sc.add("return contextObjects;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContextAsStringMethod(JavaComposite sc) {
		sc.add("public String getContextAsString() {");
		sc.add("StringBuilder result = new StringBuilder();");
		sc.add("result.append(getType());");
		sc.add("result.append(\",\");");
		sc.add("for (" + E_OBJECT + " contextObject : contextObjects) {");
		sc.add("result.append(" + ECORE_UTIL + ".getURI(contextObject));");
		sc.add("result.append(\",\");");
		sc.add("}");
		sc.add("return result.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTypeMethod(JavaComposite sc) {
		sc.add("private String getType() {");
		sc.add("return this.getClass().getName();");
		sc.add("}");
		sc.addLineBreak();
	}
}
