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
package org.emftext.sdk.codegen.resource.generators.debug;

import static org.emftext.sdk.codegen.resource.ClassNameConstants.DEBUG_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_DEBUG_TARGET;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_VALUE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_VARIABLE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.STATUS;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

public class DebugVariableGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + debugElementClassName + " implements " + I_VARIABLE(sc) + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addSupportsValueModificationMethod(sc);
		addSetValueMethod1(sc);
		addSetValueMethod2(sc);
		addVerifyValueMethod1(sc);
		addVerifyValueMethod2(sc);
		addGetValueMethod(sc);
		addGetNameMethod(sc);
		addGetReferenceTypeNameMethod(sc);
		addHasValueChangedMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private String name;");
		sc.add("private " + I_VALUE(sc) + " value;");
		sc.add("private String referenceTypeName;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + I_DEBUG_TARGET(sc) + " debugTarget, String name, " + I_VALUE(sc) + " value, String referenceTypeName) {");
		sc.add("super(debugTarget);");
		sc.add("this.name = name;");
		sc.add("this.value = value;");
		sc.add("this.referenceTypeName = referenceTypeName;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSupportsValueModificationMethod(JavaComposite sc) {
		sc.add("public boolean supportsValueModification() {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetValueMethod2(JavaComposite sc) {
		sc.add("public void setValue(String expression) throws " + DEBUG_EXCEPTION(sc) + " {");
		sc.add("throw new " + DEBUG_EXCEPTION(sc) + "(new " + STATUS(sc) + "(" + I_STATUS(sc) + ".ERROR, " + pluginActivatorClassName + ".PLUGIN_ID, \"Can't set variable.\"));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetValueMethod1(JavaComposite sc) {
		sc.add("public void setValue(" + I_VALUE(sc) + " value) throws " + DEBUG_EXCEPTION(sc) + " {");
		sc.add("throw new " + DEBUG_EXCEPTION(sc) + "(new " + STATUS(sc) + "(" + I_STATUS(sc) + ".ERROR, " + pluginActivatorClassName + ".PLUGIN_ID, \"Can't set variable.\"));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addVerifyValueMethod2(JavaComposite sc) {
		sc.add("public boolean verifyValue(String expression) throws " + DEBUG_EXCEPTION(sc) + " {");
		sc.add("throw new " + DEBUG_EXCEPTION(sc) + "(new " + STATUS(sc) + "(" + I_STATUS(sc) + ".ERROR, " + pluginActivatorClassName + ".PLUGIN_ID, \"Can't set variable.\"));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addVerifyValueMethod1(JavaComposite sc) {
		sc.add("public boolean verifyValue(" + I_VALUE(sc) + " value) throws " + DEBUG_EXCEPTION(sc) + " {");
		sc.add("throw new " + DEBUG_EXCEPTION(sc) + "(new " + STATUS(sc) + "(" + I_STATUS(sc) + ".ERROR, " + pluginActivatorClassName + ".PLUGIN_ID, \"Can't set variable.\"));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetValueMethod(JavaComposite sc) {
		sc.add("public " + I_VALUE(sc) + " getValue() throws " + DEBUG_EXCEPTION(sc) + " {");
		sc.add("return value;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNameMethod(JavaComposite sc) {
		sc.add("public String getName() throws " + DEBUG_EXCEPTION(sc) + " {");
		sc.add("return name;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetReferenceTypeNameMethod(JavaComposite sc) {
		sc.add("public String getReferenceTypeName() throws " + DEBUG_EXCEPTION(sc) + " {");
		sc.add("return referenceTypeName;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasValueChangedMethod(JavaComposite sc) {
		sc.add("public boolean hasValueChanged() throws " + DEBUG_EXCEPTION(sc) + " {");
		// it may be more efficient to signal changes only if there were actually changes,
		// but for the time being, we assume all variables have changed since the last
		// request
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}
}
