/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.codegen.resource.generators.debug;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.DEBUG_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_VALUE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_VARIABLE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DebugValueGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + debugElementClassName + " implements " + I_VALUE + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetReferenceTypeName(sc);
		addGetValueStringMethod(sc);
		addIsAllocatedMethod(sc);
		addGetVariablesMethod(sc);
		addHasVariablesMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + debugTargetClassName + " debugTarget;");
		sc.add("private " + I_VARIABLE + "[] variables;");
		sc.add("private String referenceTypeName;");
		sc.add("private String valueString;");
		sc.add("private " + MAP + "<String, Long> children;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + debugTargetClassName + " target, String id, String valueString, String referenceTypeName, " + MAP + "<String, Long> children) {");
		sc.add("super(target);");
		sc.add("this.debugTarget = target;");
		sc.add("this.valueString = valueString;");
		sc.add("this.referenceTypeName = referenceTypeName;");
		sc.add("this.children = children;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetReferenceTypeName(JavaComposite sc) {
		sc.add("public String getReferenceTypeName() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return referenceTypeName;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetValueStringMethod(JavaComposite sc) {
		sc.add("public String getValueString() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return valueString;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsAllocatedMethod(JavaComposite sc) {
		sc.add("public boolean isAllocated() throws " + DEBUG_EXCEPTION + " {");
		// TODO do we need to implement this method differently?
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetVariablesMethod(JavaComposite sc) {
		sc.add("public " + I_VARIABLE + "[] getVariables() throws " + DEBUG_EXCEPTION + " {");
		sc.add("if (variables == null) {");
		sc.addComment("request variables from debug client");
		sc.add("" + LIST + "<" + I_VARIABLE + "> variables = new " + ARRAY_LIST + "<" + I_VARIABLE + ">();");
		sc.add("for (String key : children.keySet()) {");
		sc.add("Long variableID = children.get(key);");
		sc.add("" + I_VARIABLE + " response = debugTarget.getDebugProxy().getVariable(variableID);");
		sc.add("variables.add(response);");
		sc.add("}");
		sc.add("this.variables = variables.toArray(new " + I_VARIABLE + "[variables.size()]);");
		sc.add("}");
		sc.add("return variables;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasVariablesMethod(JavaComposite sc) {
		sc.add("public boolean hasVariables() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return this.children.keySet().size() > 0;");
		sc.add("}");
		sc.addLineBreak();
	}
}
