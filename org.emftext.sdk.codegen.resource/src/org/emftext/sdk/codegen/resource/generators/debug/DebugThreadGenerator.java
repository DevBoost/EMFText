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
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.DEBUG_EVENT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.DEBUG_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_BREAKPOINT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_STACK_FRAME;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_THREAD;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DebugThreadGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + debugElementClassName + " implements " + I_THREAD + ", " + iDebugEventListenerClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetBreakpointsMethod(sc);
		addGetNameMethod(sc);
		addGetPriorityMethod(sc);
		addGetStackFramesMethod(sc);
		addTopStackFrameMethod(sc);
		addHasStackFramesMethod(sc);
		addCanResumeMethod(sc);
		addCanSuspendMethod(sc);
		addIsSuspendedMethod(sc);
		addResumeMethod(sc);
		addSuspendMethod(sc);
		addCanStepIntoMethod(sc);
		addCanStepOverMethod(sc);
		addCanStepReturnMethod(sc);
		addIsSteppingMethod(sc);
		addStepIntoMethod(sc);
		addStepOverMethod(sc);
		addStepReturnMethod(sc);
		addCanTerminateMethod(sc);
		addIsTerminatedMethod(sc);
		addTerminateMethod(sc);
		addHandleMessageMethod(sc);
		addGetTargetMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private boolean suspended = false;");
		sc.add("private " + debugTargetClassName + " debugTarget;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + debugTargetClassName + " target) {");
		sc.add("super(target);");
		sc.add("this.debugTarget = target;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBreakpointsMethod(JavaComposite sc) {
		sc.add("public " + I_BREAKPOINT + "[] getBreakpoints() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNameMethod(JavaComposite sc) {
		sc.add("public String getName() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return \"Thread [main]\";");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPriorityMethod(JavaComposite sc) {
		sc.add("public int getPriority() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return 0;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStackFramesMethod(JavaComposite sc) {
		sc.add("public " + I_STACK_FRAME + "[] getStackFrames() throws " + DEBUG_EXCEPTION + " {");
		sc.add("if (isSuspended()) {");
		sc.add(debugMessageClassName + " stack = this.debugTarget.getDebugProxy().getStack();");
		sc.add("String framesData = stack.getArgument(0);");
		sc.add("if (framesData != null && !\"\".equals(framesData)) {");
		sc.add(LIST + "<String> frames = " + stringUtilClassName + ".decode(framesData, '#');");
		sc.add(I_STACK_FRAME + "[] theFrames = new " + I_STACK_FRAME + "[frames.size()];");
		sc.add("for (int i = 0; i < frames.size(); i++) {");
		sc.add("String data = frames.get(i);");
		sc.add("theFrames[frames.size() - i - 1] = new " + stackFrameClassName + "(getTarget(), data);");
		sc.add("}");
		sc.add("return theFrames;");
		sc.add("}");
		sc.add("}");
		sc.add("return new " + I_STACK_FRAME + "[0];");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTopStackFrameMethod(JavaComposite sc) {
		sc.add("public " + I_STACK_FRAME + " getTopStackFrame() throws " + DEBUG_EXCEPTION + " {");
		sc.add(I_STACK_FRAME + "[] frames = getStackFrames();");
		sc.add("if (frames.length > 0) {");
		sc.add("return frames[0];");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasStackFramesMethod(JavaComposite sc) {
		sc.add("public boolean hasStackFrames() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return isSuspended();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanResumeMethod(JavaComposite sc) {
		sc.add("public boolean canResume() {");
		sc.add("return isSuspended();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanSuspendMethod(JavaComposite sc) {
		sc.add("public boolean canSuspend() {");
		sc.add("return !isSuspended();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsSuspendedMethod(JavaComposite sc) {
		sc.add("public boolean isSuspended() {");
		sc.add("return suspended && !isTerminated();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResumeMethod(JavaComposite sc) {
		sc.add("public void resume() throws " + DEBUG_EXCEPTION + " {");
		sc.add("debugTarget.getDebugProxy().resume();");
		sc.add("suspended = false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSuspendMethod(JavaComposite sc) {
		sc.add("public void suspend() throws " + DEBUG_EXCEPTION + " {");
		sc.add("suspended = true;");
		sc.add("fireSuspendEvent(" + DEBUG_EVENT + ".BREAKPOINT);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanStepIntoMethod(JavaComposite sc) {
		sc.add("public boolean canStepInto() {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanStepOverMethod(JavaComposite sc) {
		sc.add("public boolean canStepOver() {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanStepReturnMethod(JavaComposite sc) {
		sc.add("public boolean canStepReturn() {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsSteppingMethod(JavaComposite sc) {
		sc.add("public boolean isStepping() {");
		// TODO figure out what this method is used for and whether there is cases
		// where we should not return false
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepIntoMethod(JavaComposite sc) {
		sc.add("public void stepInto() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getTarget().getDebugProxy().stepInto();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepOverMethod(JavaComposite sc) {
		sc.add("public void stepOver() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getTarget().getDebugProxy().stepOver();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepReturnMethod(JavaComposite sc) {
		sc.add("public void stepReturn() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getTarget().getDebugProxy().stepReturn();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanTerminateMethod(JavaComposite sc) {
		sc.add("public boolean canTerminate() {");
		sc.add("return !isTerminated();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsTerminatedMethod(JavaComposite sc) {
		sc.add("public boolean isTerminated() {");
		sc.add("return getDebugTarget().isTerminated();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTerminateMethod(JavaComposite sc) {
		sc.add("public void terminate() throws " + DEBUG_EXCEPTION + " {");
		sc.add("getTarget().getDebugProxy().terminate();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleMessageMethod(JavaComposite sc) {
		sc.add("public void handleMessage(" + debugMessageClassName + " message) {");
		sc.add("if (message.hasType(" + eDebugMessageTypesClassName + ".STARTED)) {");
		sc.add("fireCreationEvent();");
		sc.add("} else if (message.hasType(" + eDebugMessageTypesClassName + ".RESUMED)) {");
		sc.add("suspended = false;");
		sc.add("fireResumeEvent(0);");
		sc.add("} else if (message.hasType(" + eDebugMessageTypesClassName + ".SUSPENDED)) {");
		sc.add("suspended = true;");
		sc.add("fireSuspendEvent(" + DEBUG_EVENT + ".BREAKPOINT);");
		sc.add("} else if (message.hasType(" + eDebugMessageTypesClassName + ".TERMINATED)) {");
		sc.add("// ignore this event");
		sc.add("} else {");
		sc.add("System.out.println(\"ERROR \" + this.getClass().getName() + \".handleMessage(\" + message + \") unknown event\");");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTargetMethod(JavaComposite sc) {
		sc.add("public " + debugTargetClassName + " getTarget() {");
		sc.add("return debugTarget;");
		sc.add("}");
		sc.addLineBreak();
	}
}
