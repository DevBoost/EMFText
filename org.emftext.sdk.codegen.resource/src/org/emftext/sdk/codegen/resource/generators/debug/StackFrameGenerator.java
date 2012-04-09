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

import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.DEBUG_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_REGISTER_GROUP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_STACK_FRAME;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_THREAD;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_VARIABLE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class StackFrameGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + debugElementClassName + " implements " + I_STACK_FRAME + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetTargetMethod(sc);
		addGetLineNumberMethod(sc);
		addGetCharStartMethod(sc);
		addGetCharEndMethod(sc);
		addGetNameMethod(sc);
		addGetRegisterGroupsMethod(sc);
		addGetThreadMethod(sc);
		addGetVariablesMethod(sc);
		addHasRegisterGroupsMethod(sc);
		addHasVariablesMethod(sc);
		addCanStepIntoMethod(sc);
		addCanStepOverMethod(sc);
		addCanStepReturnMethod(sc);
		addIsSteppingMethod(sc);
		addStepIntoMethod(sc);
		addStepOverMethod(sc);
		addStepReturnMethod(sc);
		addCanResumeMethod(sc);
		addCanSuspendMethod(sc);
		addIsSuspendedMethod(sc);
		addResumeMethod(sc);
		addSuspendMethod(sc);
		addCanTerminateMethod(sc);
		addIsTerminatedMethod(sc);
		addTerminateMethod(sc);
		addGetSourceMethod(sc);
		addHashCodeMethod(sc);
		addEqualsMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + debugTargetClassName + " target;");
		sc.add("private String name;");
		sc.add("private int id;");
		sc.add("private String resourceURI;");
		sc.add("private int line;");
		sc.add("private int charStart;");
		sc.add("private int charEnd;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + debugTargetClassName + " target, String data) {");
		sc.add("super(target);");
		sc.add("this.target = target;");
		sc.addLineBreak();
		sc.add(LIST + "<String> dataParts = " + stringUtilClassName + ".decode(data, ',');");
		sc.add("this.name = dataParts.get(0);");
		sc.add("this.id = Integer.parseInt(dataParts.get(1));");
		sc.add("this.resourceURI = dataParts.get(2);");
		sc.add("this.line = Integer.parseInt(dataParts.get(3));");
		sc.add("this.charStart = Integer.parseInt(dataParts.get(4));");
		sc.add("this.charEnd = Integer.parseInt(dataParts.get(5));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTargetMethod(JavaComposite sc) {
		sc.add("private " + debugTargetClassName + " getTarget() {");
		sc.add("return target;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLineNumberMethod(JavaComposite sc) {
		sc.add("public int getLineNumber() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return this.line;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCharStartMethod(JavaComposite sc) {
		sc.add("public int getCharStart() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return charStart;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCharEndMethod(JavaComposite sc) {
		sc.add("public int getCharEnd() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return charEnd;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNameMethod(JavaComposite sc) {
		sc.add("public String getName() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return this.name;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetRegisterGroupsMethod(JavaComposite sc) {
		sc.add("public " + I_REGISTER_GROUP + "[] getRegisterGroups() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return new " + I_REGISTER_GROUP + "[0];");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetThreadMethod(JavaComposite sc) {
		sc.add("public " + I_THREAD + " getThread() {");
		sc.add("return target.getThread();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetVariablesMethod(JavaComposite sc) {
		sc.add("public " + I_VARIABLE + "[] getVariables() throws " + DEBUG_EXCEPTION + " {");
		sc.addComment("get root (top level) variables");
		sc.add(I_VARIABLE + "[] variables = getTarget().getDebugProxy().getStackVariables(Integer.toString(id));");
		sc.add("return variables;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasRegisterGroupsMethod(JavaComposite sc) {
		sc.add("public boolean hasRegisterGroups() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasVariablesMethod(JavaComposite sc) {
		sc.add("public boolean hasVariables() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanStepIntoMethod(JavaComposite sc) {
		sc.add("public boolean canStepInto() {");
		sc.add("return getThread().canStepInto();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanStepOverMethod(JavaComposite sc) {
		sc.add("public boolean canStepOver() {");
		sc.add("return getThread().canStepOver();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanStepReturnMethod(JavaComposite sc) {
		sc.add("public boolean canStepReturn() {");
		sc.add("return getThread().canStepReturn();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsSteppingMethod(JavaComposite sc) {
		sc.add("public boolean isStepping() {");
		sc.add("return getThread().isStepping();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepIntoMethod(JavaComposite sc) {
		sc.add("public void stepInto() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getThread().stepInto();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepOverMethod(JavaComposite sc) {
		sc.add("public void stepOver() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getThread().stepOver();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepReturnMethod(JavaComposite sc) {
		sc.add("public void stepReturn() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getThread().stepReturn();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanResumeMethod(JavaComposite sc) {
		sc.add("public boolean canResume() {");
		sc.add("return getThread().canResume();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanSuspendMethod(JavaComposite sc) {
		sc.add("public boolean canSuspend() {");
		sc.add("return getThread().canSuspend();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsSuspendedMethod(JavaComposite sc) {
		sc.add("public boolean isSuspended() {");
		sc.add("return getThread().isSuspended();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResumeMethod(JavaComposite sc) {
		sc.add("public void resume() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getThread().resume();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSuspendMethod(JavaComposite sc) {
		sc.add("public void suspend() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getThread().suspend();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanTerminateMethod(JavaComposite sc) {
		sc.add("public boolean canTerminate() {");
		sc.add("return getThread().canTerminate();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsTerminatedMethod(JavaComposite sc) {
		sc.add("public boolean isTerminated() {");
		sc.add("return getThread().isTerminated();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTerminateMethod(JavaComposite sc) {
		sc.add("public void terminate() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getThread().terminate();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSourceMethod(JavaComposite sc) {
		sc.add("public String getResourceURI() {");
		sc.add("return this.resourceURI;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHashCodeMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public int hashCode() {");
		sc.add("final int prime = 31;");
		sc.add("int result = 1;");
		sc.add("result = prime * result + ((name == null) ? 0 : name.hashCode());");
		sc.add("result = prime * result");
		sc.add("+ ((resourceURI == null) ? 0 : resourceURI.hashCode());");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEqualsMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public boolean equals(Object obj) {");
		sc.add("if (this == obj)");
		sc.add("return true;");
		sc.add("if (obj == null)");
		sc.add("return false;");
		sc.add("if (getClass() != obj.getClass())");
		sc.add("return false;");
		sc.add(stackFrameClassName + " other = (" + stackFrameClassName + ") obj;");
		sc.add("if (name == null) {");
		sc.add("if (other.name != null)");
		sc.add("return false;");
		sc.add("} else if (!name.equals(other.name))");
		sc.add("return false;");
		sc.add("if (resourceURI == null) {");
		sc.add("if (other.resourceURI != null)");
		sc.add("return false;");
		sc.add("} else if (!resourceURI.equals(other.resourceURI))");
		sc.add("return false;");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}
}
