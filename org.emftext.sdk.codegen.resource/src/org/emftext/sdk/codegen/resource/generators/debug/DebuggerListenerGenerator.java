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
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BUFFERED_READER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FIELD;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MODIFIER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PRINT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SERVER_SOCKET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SOCKET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DebuggerListenerGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		String classComment = 
			"The DebuggerListener receives commands from the Eclipse Debug framework and sends " +
			"these commands to a debuggable process (e.g., an interpreter or generated code).";
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, classComment, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(classComment);
		sc.add("public class " + getResourceClassName() + "<ResultType, ContextType> implements Runnable {");
		sc.addLineBreak();
		addConstants(sc);
		addArrayPartitionClass(sc);
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addArrayPartitionClass(JavaComposite sc) {
		sc.add("private final static class ArrayPartition {");
		sc.addLineBreak();

		sc.add("private final Object array;");
		sc.add("private final int startIndex;");
		sc.add("private final int endIndex;");
		sc.addLineBreak();

		sc.add("public ArrayPartition(Object array, int startIndex, int endIndex) {");
		sc.add("super();");
		sc.add("this.array = array;");
		sc.add("this.startIndex = startIndex;");
		sc.add("this.endIndex = endIndex;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public int getStartIndex() {");
		sc.add("return startIndex;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public int getEndIndex() {");
		sc.add("return endIndex;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public Object getArray() {");
		sc.add("return array;");
		sc.add("}");
		sc.addLineBreak();
			
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(int requestPort) {");
		sc.add("super();");
		sc.add("this.requestPort = requestPort;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addRunMethod(sc);
		addRunDebuggerMethod(sc);
		addConvertToStringMethod(sc);
		addGetPartitionCount(sc);
		addAddFieldsMethod(sc);
		addIsPrimitiveTypeClassMethod(sc);
		addGetObjectIDMethod(sc);
		addGetInterpreterMethod(sc);
		addSetInterpreterMethod(sc);
	}

	private void addAddFieldsMethod(JavaComposite sc) {
		sc.add("private void addFields(Object object, " + MAP + "<String, Object> properties, Class<?> javaClass) {");
		sc.add(FIELD + "[] fields = javaClass.getDeclaredFields();");
		sc.add("for (" + FIELD + " field : fields) {");
		sc.addComment("here we should check the settings of the debug view");
		sc.add("if (" + MODIFIER + ".isStatic(field.getModifiers())) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("try {");
		sc.add("field.setAccessible(true);");
		sc.add("Object value = field.get(object);");
		sc.add("String fieldName = field.getName();");
		sc.add("long valueID = getObjectID(fieldName, value);");
		sc.add("properties.put(fieldName, Long.toString(valueID));");
		sc.add("} catch (IllegalArgumentException e) {");
		sc.add("e.printStackTrace();");
		sc.add("} catch (IllegalAccessException e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("Class<?> superclass = javaClass.getSuperclass();");
		sc.add("if (superclass != null) {");
		sc.add("addFields(object, properties, superclass);");
		sc.add("}");
		sc.add("}");
	}

	private void addConstants(JavaComposite sc) {
		sc.add("private static final Class<?>[] PRIMITIVE_TYPES = new Class<?>[] {");
		sc.add("String.class,");
		sc.add("Integer.class, int.class,");
		sc.add("Long.class, long.class,");
		sc.add("Boolean.class, boolean.class,");
		sc.add("Float.class, float.class,");
		sc.add("Double.class, double.class,");
		sc.add("Byte.class, byte.class,");
		sc.add("Short.class, short.class,");
		sc.add("Character.class, char.class,");
		sc.add("};");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private boolean stop = false;");
		sc.add("private " + abstractDebuggableClassName + " debuggable;");
		sc.addJavadoc("The last object id that was used.");
		sc.add("private long id = 0;");
		sc.addJavadoc("This map maps object ids to pairs of object names and object values.");
		sc.add("private " + MAP + "<Long, " + pairClassName + "<String, Object>> objectMap = new " + LINKED_HASH_MAP + "<Long, " + pairClassName + "<String, Object>>();");
		sc.addLineBreak();
		sc.add("private " + debugCommunicationHelperClassName + " communicationHelper = new " + debugCommunicationHelperClassName + "();");
		sc.addLineBreak();
		sc.add("private int requestPort;");
		sc.addLineBreak();
	}

	private void addRunMethod(JavaComposite sc) {
		sc.add("public void run() {");
		sc.add("try {");
		sc.add("runDebugger();");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		// TODO handle exception
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRunDebuggerMethod(JavaComposite sc) {
		sc.add("private void runDebugger() throws " + IO_EXCEPTION + " {");
		sc.add(SERVER_SOCKET + " server = new " + SERVER_SOCKET + "(requestPort);");
		sc.add(SOCKET + " accept = server.accept();");
		sc.add(INPUT_STREAM + " inputStream = accept.getInputStream();");
		sc.add(BUFFERED_READER + " reader = new " + BUFFERED_READER + "(new " + INPUT_STREAM_READER + "(inputStream));");
		sc.add(PRINT_STREAM + " output = new " + PRINT_STREAM + "(accept.getOutputStream());");
		sc.addLineBreak();
		sc.add(debugMessageClassName + " command;");
		sc.add("while (!stop) {");
		sc.add("command = communicationHelper.receive(reader);");
		sc.add("if (command == null) {");
		sc.add("break;");
		sc.add("}");
		sc.add("if (command.hasType(" + eDebugMessageTypesClassName + ".EXIT)) {");
		sc.add("debuggable.terminate();");
		sc.add("stop = true;");
		sc.add("} else if (command.hasType(" + eDebugMessageTypesClassName + ".RESUME)) {");
		sc.add("debuggable.resume();");
		sc.add("} else if (command.hasType(" + eDebugMessageTypesClassName + ".STEP_OVER)) {");
		sc.add("debuggable.stepOver();");
		sc.add("} else if (command.hasType(" + eDebugMessageTypesClassName + ".STEP_INTO)) {");
		sc.add("debuggable.stepInto();");
		sc.add("} else if (command.hasType(" + eDebugMessageTypesClassName + ".STEP_RETURN)) {");
		sc.add("debuggable.stepReturn();");
		sc.add("} else if (command.hasType(" + eDebugMessageTypesClassName + ".ADD_LINE_BREAKPOINT)) {");
		sc.add("String location = command.getArgument(0);");
		sc.add("int line = Integer.parseInt(command.getArgument(1));");
		sc.add("debuggable.addLineBreakpoint(location, line);");
		sc.add("} else if (command.hasType(" + eDebugMessageTypesClassName + ".REMOVE_LINE_BREAKPOINT)) {");
		sc.add("String location = command.getArgument(0);");
		sc.add("int line = Integer.parseInt(command.getArgument(1));");
		sc.add("debuggable.removeLineBreakpoint(location, line);");
		sc.add("} else if (command.hasType(" + eDebugMessageTypesClassName + ".GET_STACK)) {");
		sc.add("final String[] stack = debuggable.getStack();");
		sc.add("String controlStack = " + stringUtilClassName + ".encode('#', stack);");
		sc.add(debugMessageClassName + " message = new " + debugMessageClassName + "(" + eDebugMessageTypesClassName + ".GET_STACK_RESPONSE, new String[] {controlStack});");
		sc.add("communicationHelper.sendEvent(message, output);");
		sc.add("} else if (command.hasType(" + eDebugMessageTypesClassName + ".GET_FRAME_VARIABLES)) {");
		sc.add("String stackFrame = command.getArgument(0);");
		sc.add(MAP + "<String, Object> frameVariables = debuggable.getFrameVariables(stackFrame);");
		sc.addLineBreak();
		sc.add(LIST + "<String> topVariableIDs = new " + ARRAY_LIST + "<String>();");
		sc.add("for (String name : frameVariables.keySet()) {");
		sc.add("Object value = frameVariables.get(name);");
		sc.add("long id = getObjectID(name, value);");
		sc.add("topVariableIDs.add(Long.toString(id));");
		sc.add("}");
		sc.add(debugMessageClassName + " message = new " + debugMessageClassName + "(" + eDebugMessageTypesClassName + ".GET_FRAME_VARIABLES_RESPONSE, topVariableIDs);");
		sc.add("communicationHelper.sendEvent(message, output);");
		sc.add("} else if (command.hasType(" + eDebugMessageTypesClassName + ".GET_VARIABLES)) {");
		sc.add("String[] arguments = command.getArguments();");
		sc.add("Long[] requestedIDs = new Long[arguments.length];");
		sc.add("int i = 0;");
		sc.add("for (String argument : arguments) {");
		sc.add("requestedIDs[i++] = Long.parseLong(argument);");
		sc.add("}");
		sc.addComment("create variable strings");
		sc.add("String[] varStrings = new String[arguments.length];");
		sc.add("i = 0;");
		sc.add("for (Long requestedID : requestedIDs) {");
		sc.add("Object next = objectMap.get(requestedID).getRight();");
		sc.add("String varString = convertToString(requestedID, next);");
		sc.add("varStrings[i++] = varString;");
		sc.add("}");
		sc.add(debugMessageClassName + " message = new " + debugMessageClassName + "(" + eDebugMessageTypesClassName + ".GET_VARIABLES_RESPONSE, varStrings);");
		sc.add("communicationHelper.sendEvent(message, output);");
		sc.add("} else {");
		sc.add("System.out.println(\"ERROR: Unrecognized command (\" + command + \")!\");");
		sc.add("output.append(\"Unrecognized command!\");");
		sc.add("}");
		sc.add("}");
		sc.addComment("closing server");
		sc.add("server.close();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConvertToStringMethod(JavaComposite sc) {
		sc.add("private String convertToString(long id, Object object) {");
		sc.add("String name = objectMap.get(id).getLeft();");
		sc.addLineBreak();
		sc.add(MAP + "<String, Object> properties = new " + LINKED_HASH_MAP + "<String, Object>();");
		sc.add("properties.put(\"!name\", name);");
		sc.add("properties.put(\"!id\", Long.toString(id));");
		sc.add("String valueString = object == null ? \"null\" : object.toString();");
		sc.add("if (object != null) {");
		sc.add("if (object instanceof " + E_OBJECT + ") {");
		sc.add(E_OBJECT + " eObject = (" + E_OBJECT + ") object;");
		sc.add(E_CLASS + " eClass = eObject.eClass();");
		sc.add("String eClassName = eClass.getName();");
		sc.add("valueString = eClassName + \" (id=\" + id + \")\";");
		sc.add("properties.put(\"!type\", eClassName);");
		sc.addLineBreak();
		sc.add(LIST + "<" + E_STRUCTURAL_FEATURE + "> features = eClass.getEAllStructuralFeatures();");
		sc.add("for (" + E_STRUCTURAL_FEATURE + " feature : features) {");
		sc.add("Object value = eObject.eGet(feature);");
		sc.add("String featureName = feature.getName();");
		sc.add("long valueID = getObjectID(featureName, value);");
		sc.add("properties.put(featureName, Long.toString(valueID));");
		sc.add("}");
		sc.add("} else if (object instanceof ArrayPartition) {");
		sc.add("ArrayPartition partition = (ArrayPartition) object;");
		sc.add("valueString = \"\";");
		sc.addComment(
			"if there is only a single partition, the elements of the array " +
			"are directly used a children"
		);
		sc.add("for (int i = partition.getStartIndex(); i < partition.getEndIndex(); i++) {");
		sc.add("Object array = partition.getArray();");
		sc.add("Object objectAtIndex = java.lang.reflect.Array.get(array, i);");
		sc.add("String fieldName = \"[\" + i + \"]\";");
		sc.add("long valueID = getObjectID(fieldName, objectAtIndex);");
		sc.add("properties.put(fieldName, Long.toString(valueID));");
		sc.add("}");
		sc.add("} else {");
		sc.add("Class<? extends Object> javaClass = object.getClass();");
		sc.add("valueString = javaClass.getSimpleName() + \" (id=\" + id + \")\";");
		sc.add("if (!isPrimitiveTypeClass(javaClass)) {");
		sc.add("addFields(object, properties, javaClass);");
		sc.add("} else {");
		sc.add("valueString = object.toString();");
		sc.add("}");
		sc.add("if (javaClass.isArray()) {");
		sc.add("int length = " + ARRAY + ".getLength(object);");
		sc.add("int partitions = getPartitionCount(length);");
		sc.add("Class<?> componentType = javaClass.getComponentType();");
		sc.add("valueString = componentType.getName() + \"[\" + length + \"] (id=\" + id + \")\";");
		sc.add("if (partitions == 1) {");
		sc.addComment(
			"if there is only a single partition, the elements of the array " +
			"are directly used a children");
		sc.add("for (int i = 0; i < length; i++) {");
		sc.add("Object objectAtIndex = " + ARRAY + ".get(object, i);");
		sc.add("String fieldName = \"[\" + i + \"]\";");
		sc.add("long valueID = getObjectID(fieldName, objectAtIndex);");
		sc.add("properties.put(fieldName, Long.toString(valueID));");
		sc.add("}");
		sc.add("} else {");
		sc.addComment(
			"if there are multiple partitions, we introduce artificial " +
			"objects that represent partitions of the array");
		sc.add("for (int i = 0; i < partitions; i++) {");
		sc.add("int startIndex = i * 100;");
		sc.add("int endIndex = Math.min((i + 1) * 100, length);");
		sc.add("String fieldName = \"[\" + startIndex + \"..\" + (endIndex - 1) + \"]\";");
		sc.add("ArrayPartition newPartition = new ArrayPartition(object, startIndex, endIndex);");
		sc.add("long valueID = getObjectID(fieldName, newPartition);");
		sc.add("properties.put(fieldName, Long.toString(valueID));");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("properties.put(\"!valueString\", valueString);");
		sc.addLineBreak();
		sc.add("return " + stringUtilClassName + ".convertToString(properties);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetPartitionCount(JavaComposite sc) {
		sc.add("private int getPartitionCount(int arraySize) {");
		sc.add("int partitionSize = 100;");
		sc.add("int numPartitions = arraySize / partitionSize;");
		sc.add("int remainder = arraySize % partitionSize;");
		sc.add("if (remainder > 0) {");
		sc.add("numPartitions++;");
		sc.add("}");
		sc.add("return numPartitions;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsPrimitiveTypeClassMethod(JavaComposite sc) {
		sc.add("private boolean isPrimitiveTypeClass(Class<?> javaClass) {");
		sc.add("for (Class<?> clazz : PRIMITIVE_TYPES) {");
		sc.add("if (clazz.getName().equals(javaClass.getName())) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetObjectIDMethod(JavaComposite sc) {
		sc.add("private long getObjectID(String name, Object value) {");
		sc.add(pairClassName + "<String, Object> pair = new " + pairClassName + "<String, Object>(name, value);");
		sc.add("if (objectMap.containsValue(pair)) {");
		sc.add("for (Long nextID : objectMap.keySet()) {");
		sc.add("Object next = objectMap.get(nextID);");
		sc.add("if (pair.equals(next)) {");
		sc.add("return nextID;");
		sc.add("}");
		sc.add("}");
		sc.addComment("This should not happen, because objectMap.containsValue() was true. Maybe there is a fault equals() method?");
		sc.add("assert false;");
		sc.add("return -1;");
		sc.add("} else {");
		sc.add("long usedID = id;");
		sc.add("objectMap.put(usedID, pair);");
		sc.add("id++;");
		sc.add("return usedID;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetInterpreterMethod(JavaComposite sc) {
		sc.add("public " + abstractDebuggableClassName + " getDebuggable() {");
		sc.add("return debuggable;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetInterpreterMethod(JavaComposite sc) {
		sc.add("public void setDebuggable(" + abstractDebuggableClassName + " debuggable) {");
		sc.add("this.debuggable = debuggable;");
		sc.add("}");
		sc.addLineBreak();
	}
}
