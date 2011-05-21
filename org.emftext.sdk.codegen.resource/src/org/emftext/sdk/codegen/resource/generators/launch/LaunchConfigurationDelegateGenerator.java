/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators.launch;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH_CONFIGURATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH_MANAGER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LAUNCH_CONFIGURATION_DELEGATE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class LaunchConfigurationDelegateGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		String classComment = "A class that handles launch configurations.";
		if (!getContext().isLaunchSupportEnabled()) {
			generateEmptyClass(sc, classComment, OptionTypes.DISABLE_LAUNCH_SUPPORT);
			return;
		}
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(classComment);
		sc.add("public class " + getResourceClassName() + " extends " + LAUNCH_CONFIGURATION_DELEGATE + " {");
		sc.addLineBreak();
		addConstants(sc);
		addSystemOutInterpreterClass(sc);
		// TODO mseifert: move these methods to a LaunchHelper class to keep this delegate
		// more clean and to ease customizations
		addMethods(sc);
		sc.add("}");
	}

	private void addConstants(JavaComposite sc) {
		sc.addJavadoc("The URI of the resource that shall be launched.");
		sc.add("public final static String ATTR_RESOURCE_URI = \"uri\";");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addLaunchMethod(sc);
		addGetURIMethod(sc);
		addGetModelRootMethod(sc);
	}

	private void addLaunchMethod(JavaComposite sc) {
		sc.add("public void launch(" + I_LAUNCH_CONFIGURATION + " configuration, String mode, " + I_LAUNCH + " launch, " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
		sc.addComment(
				"Set the " + OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE.getLiteral() + " option to <code>false</code> to implement this method or " +
				"disable launching support by setting " + OptionTypes.DISABLE_LAUNCH_SUPPORT.getLiteral() + " to <code>true</code>.");
		sc.addLineBreak();
		sc.add("final boolean enableDebugger = mode.equals(" + I_LAUNCH_MANAGER + ".DEBUG_MODE);");
		sc.addLineBreak();
		
		sc.add(E_OBJECT + " root = getModelRoot(configuration);");
		sc.addComment("replace this delegate with your actual interpreter");
		sc.add("SystemOutInterpreter delegate = new SystemOutInterpreter();");
		sc.add("delegate.addObjectTreeToInterpreteTopDown(root);");
		sc.add("final " + debuggableInterpreterClassName + "<Void, Void> interpreter = new " + debuggableInterpreterClassName + "<Void, Void>(delegate);");
		sc.addLineBreak();
		sc.addComment("step 1: prepare and start interpreter in separate thread");
		sc.add("Thread interpreterThread = new Thread(new Runnable() {");
		sc.addLineBreak();
		sc.add("public void run() {");
		sc.addComment("if we are in debug mode, the interpreter must wait for the debugger to attach");
		sc.add("interpreter.interprete(null, enableDebugger);");
		sc.add("}");
		sc.add("});");
		sc.add("interpreterThread.start();");
		sc.addLineBreak();
		sc.add("if (enableDebugger) {");
		sc.addComment("step 2: start debugger listener (sends commands from Eclipse debug framework to running process");
		sc.add(debuggerListenerClassName + "<Void, Void> debugListener = new " + debuggerListenerClassName + "<Void, Void>();");
		sc.add("debugListener.setDebuggable(interpreter);");
		sc.add("new Thread(debugListener).start();");
		sc.addComment("step 3: start debugger");
		sc.add(debugProcessClassName + " process = new " + debugProcessClassName + "(launch);");
		sc.add("launch.addDebugTarget(new " + debugTargetClassName + "(process, launch));");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSystemOutInterpreterClass(JavaComposite sc) {
		sc.add("private static class SystemOutInterpreter extends " + abstractInterpreterClassName + "<Void,Void> {");
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
		sc.add("private " + E_OBJECT + " getModelRoot(" + I_LAUNCH_CONFIGURATION + " configuration) throws " + CORE_EXCEPTION + " {");
		sc.add("return " + resourceUtilClassName + ".getResourceContent(getURI(configuration));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetURIMethod(JavaComposite sc) {
		sc.add("private " + URI + " getURI(" + I_LAUNCH_CONFIGURATION + " configuration) throws " + CORE_EXCEPTION + " {");
		sc.add("return " + URI + ".createURI(configuration.getAttribute(ATTR_RESOURCE_URI, (String) null));");
		sc.add("}");
		sc.addLineBreak();
	}
}
