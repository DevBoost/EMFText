package org.emftext.sdk.codegen.resource.generators.debug;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STACK;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class DebuggableInterpreterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A DebuggableInterpreter is a facade for interpreters that adds debug support.",
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
		addGetElementByDepthMethod(sc);
		addGetDepthMethod(sc);
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
		sc.add("private " + E_OBJECT + " stopAt;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + abstractInterpreterClassName + "<ResultType, ContextType> interpreterDelegate) {");
		sc.add("this.interpreterDelegate = interpreterDelegate;");
		sc.add("this.interpreterDelegate.addListener(new " + iInterpreterListenerClassName + "() {");
		sc.addLineBreak();
		sc.add("public void handleInterpreteObject(" + E_OBJECT + " element) {");
		sc.addComment("check whether we have hit an element after a step over/into/return");
		sc.add("evaluateStep(element);");
		sc.addComment("check whether we have hit a line breakpoint");
		sc.add("int line = getLine(element);");
		sc.add("if (line >= 0) {");
		sc.add("evaluateLineBreakpoint(line);");
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
		sc.add("startEventSocket();");
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
		sc.add("stack[--i] = parent.eClass().getName() + \",\" + parent.eResource().getURI().toString() + \",\" + getLine(parent) + \",\" + getCharStart(parent) + \",\" + getCharEnd(parent);");
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

	private void addGetElementByDepthMethod(JavaComposite sc) {
		sc.add("private " + E_OBJECT + " getElementByDepth(" + STACK + "<" + E_OBJECT + "> stack, int depth) {");
		sc.add("for (int i = stack.size() - 1; i >= 0; i--) {");
		sc.add(E_OBJECT + " next = stack.get(i);");
		sc.add("if (getDepth(next) == depth) {");
		sc.add("return next;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDepthMethod(JavaComposite sc) {
		sc.add("private int getDepth(" + E_OBJECT + " current) {");
		sc.addComment("TODO move this to EObjectUtil class");
		sc.add(E_OBJECT + " parent = current.eContainer();");
		sc.add("if (parent == null) {");
		sc.add("return 0;");
		sc.add("} else {");
		sc.add("return getDepth(parent) + 1;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEvaluateStepMethod(JavaComposite sc) {
		sc.add("private void evaluateStep(" + E_OBJECT + " element) {");
		sc.add("if (stopAt == element) {");
		sc.add("stopAt = null;");
		sc.addComment("suspending after step...");
		sc.add("setSuspend(true);");
		sc.add("sendEvent(" + eDebugMessageTypesClassName + ".SUSPENDED);");
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
		sc.add(E_OBJECT + " current = interpreterDelegate.getNextObjectToInterprete();");
		sc.add("int depth = getDepth(current);");
		sc.add(STACK + "<" + E_OBJECT + "> stack = interpreterDelegate.getInterpretationStack();");
		sc.add(E_OBJECT + " nextElementAtSameDepth = getElementByDepth(stack, depth);");
		sc.add("if (nextElementAtSameDepth != null) {");
		//sc.add("System.out.println(\"WebtestDebuggableInterpreter.stepOver() must stop at: \" + nextElementAtSameDepth);");
		sc.add("stopAt = nextElementAtSameDepth;");
		sc.add("}");
		sc.add("resume();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepIntoMethod(JavaComposite sc) {
		sc.add("public void stepInto() {");
		sc.add(STACK + "<" + E_OBJECT + "> stack = interpreterDelegate.getInterpretationStack();");
		sc.add("if (!stack.isEmpty()) {");
		sc.add(E_OBJECT + " next = stack.peek();");
		//sc.add("System.out.println(\"DebuggableInterpreter.stepInto() must stop at: \" + next);");
		sc.add("stopAt = next;");
		sc.add("}");
		sc.add("resume();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepReturnMethod(JavaComposite sc) {
		sc.add("public void stepReturn() {");
		sc.add(E_OBJECT + " current = interpreterDelegate.getNextObjectToInterprete();");
		sc.add("int depth = getDepth(current) + 1;");
		sc.add(STACK + "<" + E_OBJECT + "> stack = interpreterDelegate.getInterpretationStack();");
		sc.add(E_OBJECT + " nextElementAtParentLevel = getElementByDepth(stack, depth);");
		sc.add("if (nextElementAtParentLevel != null) {");
		//sc.add("System.out.println(\"WebtestDebuggableInterpreter.stepReturn() must stop at: \" + nextElementAtParentLevel);");
		sc.add("stopAt = nextElementAtParentLevel;");
		sc.add("}");
		sc.add("resume();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFrameVariablesMethod(JavaComposite sc) {
		sc.add("public " + MAP + "<String, Object> getFrameVariables() {");
		sc.add(MAP + "<String, Object> frameVariables = new " + LINKED_HASH_MAP + "<String, Object>();");
		sc.add("frameVariables.put(\"this\", getInterpreterDelegate().getNextObjectToInterprete());");
		sc.add("frameVariables.put(\"context\", getInterpreterDelegate().getCurrentContext());");
		sc.add("return frameVariables;");
		sc.add("}");
		sc.addLineBreak();
	}
}
