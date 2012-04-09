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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BUFFERED_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BUFFERED_READER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COMPARATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_VALUE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_VARIABLE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PRINT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SOCKET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.TREE_MAP;
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
		sc.addLineBreak();
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
		// TODO handle exception
		sc.add("System.out.println(e);");
		sc.add("}");
		sc.add("try {");
		sc.add("output = new " + PRINT_STREAM + "(client.getOutputStream());");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		// TODO handle exception
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
		sc.add("public void addLineBreakpoint(String location, int line) {");
		sc.add(debugMessageClassName + " message = new " + debugMessageClassName + "(" + eDebugMessageTypesClassName + ".ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});");
		sc.add("communicationHelper.sendEvent(message, output);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveLineBreakpointMethod(JavaComposite sc) {
		sc.add("public void removeLineBreakpoint(String location, int line) {");
		sc.add(debugMessageClassName + " message = new " + debugMessageClassName + "(" + eDebugMessageTypesClassName + ".REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});");
		sc.add("communicationHelper.sendEvent(message, output);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStackVariablesMethod(JavaComposite sc) {
		sc.add("public " + I_VARIABLE + "[] getStackVariables(String stackFrame) {");
		sc.add(debugMessageClassName + " response = sendCommandAndRead(" + eDebugMessageTypesClassName + ".GET_FRAME_VARIABLES, new String[] {stackFrame});");
		sc.add("String[] ids = response.getArguments();");
		sc.addComment("fetch all variables");
		sc.add(I_VARIABLE + "[] variables = getVariables(ids);");
		sc.add("return variables;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetVariableMethod(JavaComposite sc) {
		sc.add("public " + I_VARIABLE + "[] getVariables(String... requestedIDs) {");
		sc.add(debugMessageClassName + " response = sendCommandAndRead(" + eDebugMessageTypesClassName + ".GET_VARIABLES, requestedIDs);");
		sc.add("String[] varStrings = response.getArguments();");
		sc.add(debugVariableClassName + "[] variables  = new " + debugVariableClassName + "[varStrings.length];");
		sc.add("int i = 0;");
		sc.add("for (String varString : varStrings) {");
		sc.add(MAP + "<String, String> properties = " + stringUtilClassName + ".convertFromString(varString);");
		sc.addLineBreak();
		sc.addComment("convert varString to variables and values");
		sc.add("String valueString = properties.get(\"!valueString\");");
		sc.add("String valueRefType = \"valueRefType\";");
		sc.add(MAP + "<String, Long> childVariables = new " + TREE_MAP + "<String, Long>(new " + COMPARATOR + "<String>() {");
		sc.add("public int compare(String s1, String s2) {");
		sc.add("return s1.compareToIgnoreCase(s2);");
		sc.add("}");
		sc.add("});");
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
		sc.add("variables[i++] = variable;");
		sc.add("}");
		sc.add("return variables;");
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
