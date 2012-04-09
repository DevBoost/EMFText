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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BUFFERED_READER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PRINT_STREAM;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DebugCommunicationHelperGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addSendEventMethod(sc);
		addSendAndReceiveMethod(sc);
		addReceiveMethod(sc);
	}

	private void addSendEventMethod(JavaComposite sc) {
		sc.add("public void sendEvent(" + debugMessageClassName + " message, " + PRINT_STREAM + " stream) {");
		sc.add("synchronized (stream) {");
		//sc.add("System.out.println(\"send: \" + message);");
		sc.add("stream.println(message.serialize());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSendAndReceiveMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Sends a message using the given stream and waits for an answer.",
			"@param messageType the type of message to send",
			"@param stream the stream to send the message to",
			"@param reader the reader to obtain the answer from",
			"@param parameters additional parameter to send",
			"@return the answer that is received"
		);
		sc.add("public " + debugMessageClassName + " sendAndReceive(" + debugMessageClassName + " message, " + PRINT_STREAM + " stream, " + BUFFERED_READER + " reader) {");
		sc.add("synchronized (stream) {");
		sc.add("sendEvent(message, stream);");
		sc.add(debugMessageClassName + " response = receive(reader);");
		sc.add("return response;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReceiveMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Receives a message from the given reader. This method block until a message has arrived.",
			"@param reader the read to obtain the message from",
			"@return the received message"
		);
		sc.add("public " + debugMessageClassName + " receive(" + BUFFERED_READER + " reader) {");
		sc.add("try {");
		sc.add("String response = reader.readLine();");
		sc.add("if (response == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(debugMessageClassName + " receivedMessage = " + debugMessageClassName + ".deserialize(response);");
		//sc.add("System.out.println(\"receive: \" + receivedMessage);");
		sc.add("return receivedMessage;");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
