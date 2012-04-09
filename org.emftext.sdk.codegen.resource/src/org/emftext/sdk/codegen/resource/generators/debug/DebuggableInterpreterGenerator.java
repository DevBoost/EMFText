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

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

// TODO ease stack frame handling (startFrame(), stopFrame())
// TODO check what is "Drop to frame" (in debug view)

// TODO check how to support debugging of generated code
// TODO provide better example interpreter that has a GUI
public class DebuggableInterpreterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		String classComment = "A DebuggableInterpreter is a facade for interpreters that adds debug support.";
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, classComment, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			classComment,
			"@param <ResultType> the result type of the actual interpreter",
			"@param <ContextType> the context type of the actual interpreter"
		);
		sc.add("public class " + getResourceClassName() + "<ResultType, ContextType> extends " + abstractDebuggableClassName + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addInterpreteMethod1(sc);
		addInterpreteMethod2(sc);
		addGetStackMethod(sc);
		addGetInterpreterDelegateMethod(sc);
		addGetLineMethod(sc);
		addGetCharStartMethod(sc);
		addGetCharEndMethod(sc);
		addGetLocationMapMethod(sc);
		addEvaluateStepMethod(sc);
		addTerminateMethod(sc);
		addStepOverMethod(sc);
		addStepIntoMethod(sc);
		addStepReturnMethod(sc);
		addGetFrameVariablesMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc("The actual interpreter. Interpretation is delegated to this object.");
		sc.add("private " + abstractInterpreterClassName + "<ResultType, ContextType> interpreterDelegate;");
		sc.addLineBreak();
		sc.addJavadoc("To check whether we must stop the execution after step over/into/return, we use a closure");
		sc.add("private " + iCommandClassName + "<" + E_OBJECT + "> stopCondition;");
		sc.addLineBreak();
		sc.addJavadoc("The port of the socket that is used to send debug events to the Eclipse debugging framework");
		sc.add("private int eventPort;");
		sc.addLineBreak();
		sc.addJavadoc("This map is used to remember the IDs of stack frame elements");
		sc.add(MAP + "<Integer, " + E_OBJECT + "> stackFrameMap = new " + LINKED_HASH_MAP + "<Integer, " + E_OBJECT + ">();");
		sc.addLineBreak();
		sc.addJavadoc("The ID of the last stack frame element");
		sc.add("int stackFrameID = 0;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + abstractInterpreterClassName + "<ResultType, ContextType> interpreterDelegate, int eventPort) {");
		sc.add("this.eventPort = eventPort;");
		sc.add("this.interpreterDelegate = interpreterDelegate;");
		sc.add("this.interpreterDelegate.addListener(new " + iInterpreterListenerClassName + "() {");
		sc.addLineBreak();
		sc.add("public void handleInterpreteObject(" + E_OBJECT + " element) {");
		sc.addComment("check whether we have hit an element after a step over/into/return");
		sc.add("evaluateStep(element);");
		sc.addComment("if we are stepping we do ignore breakpoints");
		sc.add("if (stopCondition != null) {");
		sc.add("return;");
		sc.add("}");
		sc.addComment("check whether we have hit a line breakpoint");
		sc.add("int line = getLine(element);");
		sc.add(E_OBJECT + " parent = element.eContainer();");
		sc.add("if (parent != null) {");
		sc.add("int parentLine = getLine(parent);");
		sc.add("if (line == parentLine) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("if (line >= 0) {");
		sc.add("evaluateLineBreakpoint(element.eResource().getURI(), line);");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInterpreteMethod1(JavaComposite sc) {
		sc.add("private ResultType interprete(ContextType context) {");
		sc.add("startUpAndWait();");
		sc.addComment("start interpretation when the debugger has sent the resume signal");
		sc.add("ResultType result = interpreterDelegate.interprete(context);");
		sc.add("terminate();");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInterpreteMethod2(JavaComposite sc) {
		sc.add("public ResultType interprete(ContextType context, boolean debugMode) {");
		sc.add("setDebugMode(debugMode);");
		sc.add("startEventSocket(eventPort);");
		sc.addLineBreak();
		sc.add("ResultType result = interprete(context);");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStackMethod(JavaComposite sc) {
		sc.add("public String[] getStack() {");
		sc.add(E_OBJECT + " next = interpreterDelegate.getNextObjectToInterprete();");
		sc.add(LIST + "<" + E_OBJECT + "> parents = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
		sc.add(E_OBJECT + " current = next;");
		sc.add("while (current != null) {");
		sc.add("parents.add(current);");
		sc.add("current = current.eContainer();");
		sc.add("}");
		sc.add("String[] stack = new String[parents.size()];");
		sc.add("int i = parents.size();");
		sc.add("for (" + E_OBJECT + " parent : parents) {");
		sc.add("String serializedStackElement = " + stringUtilClassName + ".encode(',', new String[] {parent.eClass().getName(), Integer.toString(stackFrameID), parent.eResource().getURI().toString(), Integer.toString(getLine(parent)), Integer.toString(getCharStart(parent)), Integer.toString(getCharEnd(parent))});");
		sc.add("stack[--i] = serializedStackElement;");
		sc.add("stackFrameMap.put(stackFrameID++, parent);");
		sc.add("}");
		sc.add("return stack;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetInterpreterDelegateMethod(JavaComposite sc) {
		sc.add("public " + abstractInterpreterClassName + "<ResultType, ContextType> getInterpreterDelegate() {");
		sc.add("return interpreterDelegate;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLineMethod(JavaComposite sc) {
		sc.add("private int getLine(" + E_OBJECT + " element) {");
		sc.add("int line = -1;");
		sc.add(iLocationMapClassName + " locationMap = getLocationMap(element);");
		sc.add("if (locationMap != null) {");
		sc.add("line = locationMap.getLine(element);");
		sc.add("}");
		sc.add("return line;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCharStartMethod(JavaComposite sc) {
		sc.add("private int getCharStart(" + E_OBJECT + " element) {");
		sc.add(iLocationMapClassName + " locationMap = getLocationMap(element);");
		sc.add("if (locationMap != null) {");
		sc.add("return locationMap.getCharStart(element);");
		sc.add("}");
		sc.add("return -1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCharEndMethod(JavaComposite sc) {
		sc.add("private int getCharEnd(" + E_OBJECT + " element) {");
		sc.add(iLocationMapClassName + " locationMap = getLocationMap(element);");
		sc.add("if (locationMap != null) {");
		sc.add("return locationMap.getCharEnd(element) + 1;");
		sc.add("}");
		sc.add("return -1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLocationMapMethod(JavaComposite sc) {
		sc.add("private " + iLocationMapClassName + " getLocationMap(" + E_OBJECT + " element) {");
		sc.add(RESOURCE + " resource = element.eResource();");
		sc.add("if (resource instanceof " + iTextResourceClassName + ") {");
		sc.add(iTextResourceClassName + " textResource = (" + iTextResourceClassName + ") resource;");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add("return locationMap;");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEvaluateStepMethod(JavaComposite sc) {
		sc.add("private void evaluateStep(" + E_OBJECT + " element) {");
		sc.addComment("create local copy to avoid race conditions");
		sc.add(iCommandClassName + "<" + E_OBJECT + "> stopCheck = stopCondition;");
		sc.add("if (stopCheck != null && stopCheck.execute(element)) {");
		sc.add("stopCondition = null;");
		sc.addComment("suspending after step...");
		sc.add("setSuspend(true);");
		sc.add("sendEvent(" + eDebugMessageTypesClassName + ".SUSPENDED, true);");
		sc.add("return;");
		sc.add("}");
		sc.add("waitIfSuspended();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTerminateMethod(JavaComposite sc) {
		sc.add("public void terminate() {");
		sc.add("interpreterDelegate.terminate();");
		sc.add("super.terminate();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepOverMethod(JavaComposite sc) {
		sc.add("public void stepOver() {");
		sc.add("final " + E_OBJECT + " current = interpreterDelegate.getNextObjectToInterprete();");
		sc.add("final int currentLevel = " + eObjectUtilClassName + ".getDepth(current);");
		
		sc.add("stopCondition = new " + iCommandClassName + "<" + E_OBJECT + ">() {");
		sc.add("public boolean execute(" + E_OBJECT + " element) {");
		sc.addComment("For step over, we stop at the next object that is at the same level or higher");
		sc.add("int depth = " + eObjectUtilClassName + ".getDepth(element);");
		sc.add("boolean sameOrHigher = depth <= currentLevel;");
		sc.add("boolean differentElement = element != current;");
		sc.add("return sameOrHigher && differentElement;");
		sc.add("}");
		sc.add("};");
		sc.add("resume();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepIntoMethod(JavaComposite sc) {
		sc.add("public void stepInto() {");
		sc.add("stopCondition = new " + iCommandClassName + "<" + E_OBJECT + ">() {");
		sc.add("public boolean execute(" + E_OBJECT + " element) {");
		sc.addComment("For step into, we stop at the next object");
		sc.add("return true;");
		sc.add("}");
		sc.add("};");
		sc.add("resume();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepReturnMethod(JavaComposite sc) {
		sc.add("public void stepReturn() {");
		sc.add(E_OBJECT + " current = interpreterDelegate.getNextObjectToInterprete();");
		sc.add("final int parentLevel = " + eObjectUtilClassName + ".getDepth(current) - 1;");
		
		sc.add("stopCondition = new " + iCommandClassName + "<" + E_OBJECT + ">() {");
		sc.add("public boolean execute(" + E_OBJECT + " element) {");
		sc.addComment("For step return, we stop at the next object that is at least one level higher");
		sc.add("int depth = " + eObjectUtilClassName + ".getDepth(element);");
		sc.add("return depth <= parentLevel;");
		sc.add("}");
		sc.add("};");
		sc.add("resume();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFrameVariablesMethod(JavaComposite sc) {
		sc.add("public " + MAP + "<String, Object> getFrameVariables(String stackFrame) {");
		sc.add("int stackFrameID = Integer.parseInt(stackFrame);");
		sc.add(MAP + "<String, Object> frameVariables = new " + LINKED_HASH_MAP + "<String, Object>();");
		sc.add("frameVariables.put(\"this\", stackFrameMap.get(stackFrameID));");
		sc.add("frameVariables.put(\"context\", getInterpreterDelegate().getCurrentContext());");
		sc.add("return frameVariables;");
		sc.add("}");
		sc.addLineBreak();
	}
}
