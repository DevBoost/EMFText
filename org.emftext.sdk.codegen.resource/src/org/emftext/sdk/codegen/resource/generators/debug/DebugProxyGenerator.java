package org.emftext.sdk.codegen.resource.generators.debug;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BUFFERED_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BUFFERED_READER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_VALUE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_VARIABLE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PRINT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SOCKET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.UNKNOWN_HOST_EXCEPTION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DebugProxyGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		String classComment = 
			"The DebugProxy allows to communicate between the interpreter, which runs in " +
			"a separate thread or process and the Eclipse Debug framework (i.e., the " +
			"DebugTarget class).";
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, classComment, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(classComment);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addConstants(sc);
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addConstants(JavaComposite sc) {
		sc.add("public static final int STARTUP_DELAY = 1000;");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addStartSocketMethod(sc);
		addResumeMethod(sc);
		addStepOverMethod(sc);
		addStepIntoMethod(sc);
		addStepReturnMethod(sc);
		addTerminateMethod(sc);
		addGetStackMethod(sc);
		addAddLineBreakpointMethod(sc);
		addRemoveLineBreakpointMethod(sc);
		addGetStackVariablesMethod(sc);
		addGetVariableMethod(sc);
		addSendCommandMessage(sc);
		addSendCommandAndReadMessage(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + PRINT_STREAM + " output;");
		sc.add("private " + BUFFERED_READER + " reader;");
		sc.addLineBreak();
		sc.add("private " + debugTargetClassName + " debugTarget;");
		sc.addLineBreak();
		sc.add("private " + debugCommunicationHelperClassName + " communicationHelper = new " + debugCommunicationHelperClassName + "();");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + debugTargetClassName + " debugTarget, int requestPort) throws " + UNKNOWN_HOST_EXCEPTION + ", " + IO_EXCEPTION + " {");
		sc.add("this.debugTarget = debugTarget;");
		sc.add("// give interpreter a chance to start");
		sc.add("try {");
		sc.add("Thread.sleep(STARTUP_DELAY);");
		sc.add("} catch (InterruptedException e) {");
		sc.add("}");
		sc.add("startSocket(requestPort);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStartSocketMethod(JavaComposite sc) {
		sc.add("private void startSocket(int requestPort) throws " + UNKNOWN_HOST_EXCEPTION + ", " + IO_EXCEPTION + " {");
		sc.addComment("creating client proxy socket (trying to connect)...");
		sc.add(SOCKET + " client = new " + SOCKET + "(\"localhost\", requestPort);");
		sc.addComment("creating client proxy socket - done. (connected)");
		sc.add("try {");
		sc.add(BUFFERED_INPUT_STREAM + " input = new " + BUFFERED_INPUT_STREAM + "(client.getInputStream());");
		sc.add("reader = new " + BUFFERED_READER + "(new " + INPUT_STREAM_READER + "(input));");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		// TODO
		sc.add("System.out.println(e);");
		sc.add("}");
		sc.add("try {");
		sc.add("output = new " + PRINT_STREAM + "(client.getOutputStream());");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		// TODO
		sc.add("System.out.println(e);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResumeMethod(JavaComposite sc) {
		sc.add("public void resume() {");
		sc.add("sendCommand(" + eDebugMessageTypesClassName + ".RESUME);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepOverMethod(JavaComposite sc) {
		sc.add("public void stepOver() {");
		sc.add("sendCommand(" + eDebugMessageTypesClassName + ".STEP_OVER);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepIntoMethod(JavaComposite sc) {
		sc.add("public void stepInto() {");
		sc.add("sendCommand(" + eDebugMessageTypesClassName + ".STEP_INTO);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStepReturnMethod(JavaComposite sc) {
		sc.add("public void stepReturn() {");
		sc.add("sendCommand(" + eDebugMessageTypesClassName + ".STEP_RETURN);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTerminateMethod(JavaComposite sc) {
		sc.add("public void terminate() {");
		sc.add("sendCommand(" + eDebugMessageTypesClassName + ".EXIT);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStackMethod(JavaComposite sc) {
		sc.add("public " + debugMessageClassName + " getStack() {");
		sc.add("return sendCommandAndRead(" + eDebugMessageTypesClassName + ".GET_STACK);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddLineBreakpointMethod(JavaComposite sc) {
		sc.add("public void addLineBreakpoint(int line) {");
		sc.add(debugMessageClassName + " message = new " + debugMessageClassName + "(" + eDebugMessageTypesClassName + ".ADD_LINE_BREAKPOINT, new String[] {Integer.toString(line)});");
		sc.add("communicationHelper.sendEvent(message, output);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveLineBreakpointMethod(JavaComposite sc) {
		sc.add("public void removeLineBreakpoint(int line) {");
		sc.add(debugMessageClassName + " message = new " + debugMessageClassName + "(" + eDebugMessageTypesClassName + ".REMOVE_LINE_BREAKPOINT, new String[] {Integer.toString(line)});");
		sc.add("communicationHelper.sendEvent(message, output);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStackVariablesMethod(JavaComposite sc) {
		sc.add("public " + I_VARIABLE + "[] getStackVariables() {");
		// TODO send stack frame ID
		sc.add(debugMessageClassName + " response = sendCommandAndRead(" + eDebugMessageTypesClassName + ".GET_FRAME_VARIABLES);");
		sc.add("String[] ids = response.getArguments();");
		sc.add(I_VARIABLE + "[] variables = new " + I_VARIABLE + "[ids.length];");
		sc.addComment("fetch all variables");
		sc.add("for (int i = 0; i < variables.length; i++) {");
		sc.add("variables[i] = getVariable(Long.parseLong(ids[i]));");
		sc.add("}");
		sc.add("return variables;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetVariableMethod(JavaComposite sc) {
		sc.add("public " + I_VARIABLE + " getVariable(long requestedID) {");
		sc.add(debugMessageClassName + " response = sendCommandAndRead(" + eDebugMessageTypesClassName + ".GET_VARIABLE, Long.toString(requestedID));");
		sc.add("String varString = response.getArgument(0);");
		sc.add(MAP + "<String, String> properties = " + stringUtilClassName + ".convertFromString(varString);");
		sc.addLineBreak();
		sc.addComment("convert varString to variables and values");
		sc.add("String valueString = properties.get(\"!valueString\");");
		sc.add("String valueRefType = \"valueRefType\";");
		sc.add(MAP + "<String, Long> childVariables = new " + LINKED_HASH_MAP + "<String, Long>();");
		sc.add("for (String property : properties.keySet()) {");
		sc.addComment("ignore special properties - they are not children");
		sc.add("if (property.startsWith(\"!\")) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("childVariables.put(property, Long.parseLong(properties.get(property)));");
		sc.add("}");
		sc.add("String id = properties.get(\"!id\");");
		sc.add(I_VALUE + " value = new " + debugValueClassName + "(debugTarget, id, valueString, valueRefType, childVariables);");
		sc.addLineBreak();
		sc.add("String variableName = properties.get(\"!name\");");
		sc.add("String variableRefType = properties.get(\"!type\");");
		sc.addLineBreak();
		sc.add(debugVariableClassName + " variable = new " + debugVariableClassName + "(debugTarget, variableName, value, variableRefType);");
		sc.add("return variable;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSendCommandMessage(JavaComposite sc) {
		sc.add("private void sendCommand(" + eDebugMessageTypesClassName + " command, String... parameters) {");
		sc.add(debugMessageClassName + " message = new " + debugMessageClassName + "(command, parameters);");
		sc.add("communicationHelper.sendEvent(message, output);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSendCommandAndReadMessage(JavaComposite sc) {
		sc.add("private " + debugMessageClassName + " sendCommandAndRead(" + eDebugMessageTypesClassName + " command, String... parameters) {");
		sc.add(debugMessageClassName + " message = new " + debugMessageClassName + "(command, parameters);");
		sc.add("return communicationHelper.sendAndReceive(message, output, reader);");
		sc.add("}");
		sc.addLineBreak();
	}
}
