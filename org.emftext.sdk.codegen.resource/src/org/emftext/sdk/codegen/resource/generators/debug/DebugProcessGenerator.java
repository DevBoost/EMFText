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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.DEBUG_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROCESS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_STREAMS_PROXY;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DebugProcessGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + debugElementClassName + " implements " + I_PROCESS + ", " + iDebugEventListenerClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addCanTerminateMethod(sc);
		addIsTerminatedMethod(sc);
		addTerminateMethod(sc);
		addGetLabelMethod(sc);
		addGetLaunchMethod(sc);
		addGetStreamsProxyMethod(sc);
		addSetAttributeMethod(sc);
		addGetAttributeMethod(sc);
		addGetExitValueMethod(sc);
		addHandleMessageMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + I_LAUNCH + " launch;");
		sc.addLineBreak();
		sc.add("private boolean terminated = false;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + I_LAUNCH + " launch) {");
		sc.add("super(launch.getDebugTarget());");
		sc.add("this.launch = launch;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanTerminateMethod(JavaComposite sc) {
		sc.add("public boolean canTerminate() {");
		sc.add("return !terminated;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsTerminatedMethod(JavaComposite sc) {
		sc.add("public boolean isTerminated() {");
		sc.add("return terminated;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTerminateMethod(JavaComposite sc) {
		sc.add("public void terminate() throws " + DEBUG_EXCEPTION + " {");
		sc.add("terminated = true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLabelMethod(JavaComposite sc) {
		sc.add("public String getLabel() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLaunchMethod(JavaComposite sc) {
		sc.add("public " + I_LAUNCH + " getLaunch() {");
		sc.add("return launch;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStreamsProxyMethod(JavaComposite sc) {
		sc.add("public " + I_STREAMS_PROXY + " getStreamsProxy() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetAttributeMethod(JavaComposite sc) {
		sc.add("public void setAttribute(String key, String value) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAttributeMethod(JavaComposite sc) {
		sc.add("public String getAttribute(String key) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetExitValueMethod(JavaComposite sc) {
		sc.add("public int getExitValue() throws " + DEBUG_EXCEPTION + " {");
		sc.add("return 0;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleMessageMethod(JavaComposite sc) {
		sc.add("public void handleMessage(" + debugMessageClassName + " message) {");
		sc.add("if (message.hasType(" + eDebugMessageTypesClassName + ".TERMINATED)) {");
		sc.add("terminated = true;");
		// TODO fire event?
		sc.add("} else {");
		sc.addComment("ignore other events");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
