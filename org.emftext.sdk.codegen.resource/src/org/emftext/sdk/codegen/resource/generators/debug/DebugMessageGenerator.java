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

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DebugMessageGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		String classComment = 
			"DebugMessages are exchanged between the debug server (the Eclipse debug " +
			"framework) and the debug client (a running process or interpreter). To " +
			"exchange messages they are serialized and sent over sockets.";

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
		addConstructors(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetMessageTypeMethod(sc);
		addGetArgumentsMethod(sc);
		addSerializeMethod(sc);
		addDeserializeMethod(sc);
		addHasTypeMethod(sc);
		addGetArgumentMethod(sc);
		addToStringMethod(sc);
	}

	private void addConstructors(JavaComposite sc) {
		addConstructor1(sc);
		addConstructor2(sc);
	}

	private void addConstants(JavaComposite sc) {
		sc.add("private static final char DELIMITER = ':';");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + eDebugMessageTypesClassName + " messageType;");
		sc.add("private String[] arguments;");
		sc.addLineBreak();
	}

	private void addConstructor1(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + eDebugMessageTypesClassName + " messageType, String[] arguments) {");
		sc.add("super();");
		sc.add("this.messageType = messageType;");
		sc.add("this.arguments = arguments;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + eDebugMessageTypesClassName + " messageType, " + LIST + "<String> arguments) {");
		sc.add("super();");
		sc.add("this.messageType = messageType;");
		sc.add("this.arguments = new String[arguments.size()];");
		sc.add("for (int i = 0; i < arguments.size(); i++) {");
		sc.add("this.arguments[i] = arguments.get(i);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMessageTypeMethod(JavaComposite sc) {
		sc.add("public " + eDebugMessageTypesClassName + " getMessageType() {");
		sc.add("return messageType;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetArgumentsMethod(JavaComposite sc) {
		sc.add("public String[] getArguments() {");
		sc.add("return arguments;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSerializeMethod(JavaComposite sc) {
		sc.add("public String serialize() {");
		sc.add("" + LIST + "<String> parts = new " + ARRAY_LIST + "<String>();");
		sc.add("parts.add(messageType.name());");
		sc.add("for (String argument : arguments) {");
		sc.add("parts.add(argument);");
		sc.add("}");
		sc.add("return " + stringUtilClassName + ".encode(DELIMITER, parts);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeserializeMethod(JavaComposite sc) {
		sc.add("public static " + getResourceClassName() + " deserialize(String response) {");
		sc.add("" + LIST + "<String> parts = " + stringUtilClassName + ".decode(response, DELIMITER);");
		sc.add("String messageType = parts.get(0);");
		sc.add("String[] arguments = new String[parts.size() - 1];");
		sc.add("for (int i = 1; i < parts.size(); i++) {");
		sc.add("arguments[i - 1] = parts.get(i);");
		sc.add("}");
		sc.add(eDebugMessageTypesClassName + " type = " + eDebugMessageTypesClassName + ".valueOf(messageType);");
		sc.add(getResourceClassName() + " message = new " + getResourceClassName() + "(type, arguments);");
		sc.add("return message;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasTypeMethod(JavaComposite sc) {
		sc.add("public boolean hasType(" + eDebugMessageTypesClassName + " type) {");
		sc.add("return this.messageType == type;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetArgumentMethod(JavaComposite sc) {
		sc.add("public String getArgument(int index) {");
		sc.add("return getArguments()[index];");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {");
		sc.add("return this.getClass().getSimpleName() + \"[\" + messageType.name() + \": \" + " + stringUtilClassName + ".explode(arguments, \", \") + \"]\";");
		sc.add("}");
		sc.addLineBreak();
	}
}
