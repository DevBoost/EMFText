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
package org.emftext.sdk.codegen.resource.generators.launch;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH_CONFIGURATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH_MANAGER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SERVER_SOCKET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STATUS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class LaunchConfigurationHelperGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		String classComment = "A class that provides common methods that are required by launch configuration delegates.";
		if (!getContext().isLaunchSupportEnabled()) {
			generateEmptyClass(sc, classComment, OptionTypes.DISABLE_LAUNCH_SUPPORT);
			return;
		}
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(classComment);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addSystemOutInterpreterClass(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addLaunchMethod(sc);
		addLaunchInterpreterMethod(sc);
		addGetURIMethod(sc);
		addGetModelRootMethod(sc);
		addFindFreePortMethod(sc);
		addAbortMethod(sc);
	}

	private void addAbortMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Throws an exception with a new status containing the given " +
			"message and optional exception.",
			"@param message error message",
			"@param e underlying exception",
			"@throws CoreException"
		);
		sc.add("protected void abort(String message, Throwable e) throws " + CORE_EXCEPTION + " {");
		sc.add("throw new " + CORE_EXCEPTION + "(new " + STATUS + "(" + I_STATUS + ".ERROR, " + pluginActivatorClassName + ".DEBUG_MODEL_ID, 0, message, e));");
		sc.add("}");
	}

	private void addFindFreePortMethod(JavaComposite sc) {
		sc.addJavadoc("Returns a free port number on localhost, or -1 if unable to find a free port.");
		sc.add("protected int findFreePort() {");
		sc.add(SERVER_SOCKET + " socket = null;");
		sc.add("try {");
		sc.add("socket = new " + SERVER_SOCKET + "(0);");
		sc.add("return socket.getLocalPort();");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("} finally {");
		sc.add("if (socket != null) {");
		sc.add("try {");
		sc.add("socket.close();");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return -1;");		
		sc.add("}");
	}

	private void addLaunchMethod(JavaComposite sc) {
		sc.addJavadoc("Launch an example interpreter that prints object to System.out.");
		sc.add("public void launch(" + I_LAUNCH_CONFIGURATION + " configuration, String mode, " + I_LAUNCH + " launch, " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
		sc.add(E_OBJECT + " root = getModelRoot(configuration);");
		sc.addComment("replace this delegate with your actual interpreter");
		sc.add("SystemOutInterpreter delegate = new SystemOutInterpreter();");
		sc.add("delegate.addObjectTreeToInterpreteTopDown(root);");
		sc.add("launchInterpreter(configuration, mode, launch, monitor, delegate, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLaunchInterpreterMethod(JavaComposite sc) {
		sc.add("public <ResultType, ContextType> void launchInterpreter(" + I_LAUNCH_CONFIGURATION + " configuration, String mode, " + I_LAUNCH + " launch, " + I_PROGRESS_MONITOR + " monitor, " + abstractInterpreterClassName + "<ResultType, ContextType> delegate, final ContextType context) throws " + CORE_EXCEPTION + " {");
		sc.add("final boolean enableDebugger = mode.equals(" + I_LAUNCH_MANAGER + ".DEBUG_MODE);");
		sc.addComment("step 1: find two free ports we can use to communicate between the Eclipse and the interpreter");
		sc.add("int requestPort = findFreePort();");
		sc.add("int eventPort = findFreePort();");
		sc.add("if (requestPort < 0 || eventPort < 0) {");
		sc.add("abort(\"Unable to find free port\", null);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("final " + debuggableInterpreterClassName + "<ResultType, ContextType> interpreter = new " + debuggableInterpreterClassName + "<ResultType, ContextType>(delegate, eventPort);");
		sc.addLineBreak();
		sc.addComment("step 2: prepare and start interpreter in separate thread");
		sc.add("Thread interpreterThread = new Thread(new Runnable() {");
		sc.addLineBreak();
		sc.add("public void run() {");
		sc.addComment("if we are in debug mode, the interpreter must wait for the debugger to attach");
		sc.add("interpreter.interprete(context, enableDebugger);");
		sc.add("}");
		sc.add("});");
		sc.add("interpreterThread.start();");
		sc.addLineBreak();
		sc.addComment("step 3: start debugger listener (sends commands from Eclipse debug framework to running process");
		sc.add(debuggerListenerClassName + "<ResultType, ContextType> debugListener = new " + debuggerListenerClassName + "<ResultType, ContextType>(requestPort);");
		sc.add("debugListener.setDebuggable(interpreter);");
		sc.add("new Thread(debugListener).start();");
		sc.addLineBreak();
		sc.addComment("step 4: start debugger");
		sc.add(debugProcessClassName + " process = new " + debugProcessClassName + "(launch);");
		sc.add("launch.addDebugTarget(new " + debugTargetClassName + "(process, launch, requestPort, eventPort));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSystemOutInterpreterClass(JavaComposite sc) {
		sc.add("public static class SystemOutInterpreter extends " + abstractInterpreterClassName + "<Void,Void> {");
		sc.addLineBreak();
		sc.add("@Override").addLineBreak();
		sc.add("public Void interprete(" + E_OBJECT + " object, Void context) {");
		sc.add("System.out.println(\"Found \" + object + \", but don't know what to do with it.\");");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetModelRootMethod(JavaComposite sc) {
		sc.add("public " + E_OBJECT + " getModelRoot(" + I_LAUNCH_CONFIGURATION + " configuration) throws " + CORE_EXCEPTION + " {");
		sc.add("return " + resourceUtilClassName + ".getResourceContent(getURI(configuration));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetURIMethod(JavaComposite sc) {
		sc.add("public " + URI + " getURI(" + I_LAUNCH_CONFIGURATION + " configuration) throws " + CORE_EXCEPTION + " {");
		sc.add("return " + URI + ".createURI(configuration.getAttribute(" + launchConfigurationDelegateClassName + ".ATTR_RESOURCE_URI, (String) null));");
		sc.add("}");
		sc.addLineBreak();
	}
}
