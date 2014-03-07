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

import static org.emftext.sdk.codegen.resource.ClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.DEBUG_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_BREAKPOINT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_WORKSPACE_RUNNABLE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.LINE_BREAKPOINT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

public class LineBreakpointGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + LINE_BREAKPOINT(sc) + " {");
		sc.addLineBreak();
		addConstants(sc);
		addConstructors(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetModelIdentifierMethod(sc);
		addInstallMethod(sc);
		addRemoveMethod(sc);
	}

	private void addConstructors(JavaComposite sc) {
		addConstructor1(sc);
		addConstructor2(sc);
		addConstructor3(sc);
	}

	private void addConstants(JavaComposite sc) {
		sc.add("private static final String LINE_BREAKPOINT_MARKER_ID = \"" + getContext().getLineBreakpointMarkerID() + "\";");
		sc.addLineBreak();
	}

	private void addConstructor1(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(final " + I_RESOURCE(sc) + " resource, final int lineNumber) throws " + DEBUG_EXCEPTION(sc) + " {");
		sc.add("this(resource, lineNumber, -1, -1);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addConstructor3(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(final " + I_RESOURCE(sc) + " resource, final int lineNumber, final int charStart, final int charEnd) throws " + DEBUG_EXCEPTION(sc) + " {");
		sc.add(I_WORKSPACE_RUNNABLE(sc) + " runnable = new " + I_WORKSPACE_RUNNABLE(sc) + "() {");
		sc.add("public void run(" + I_PROGRESS_MONITOR(sc) + " monitor) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add(I_MARKER(sc) + " marker = resource.createMarker(LINE_BREAKPOINT_MARKER_ID);");
		sc.add("setMarker(marker);");
		sc.add("marker.setAttribute(" + I_BREAKPOINT(sc) + ".ENABLED, Boolean.TRUE);");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".LINE_NUMBER, lineNumber);");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".CHAR_START, charStart);");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".CHAR_END, charEnd);");
		sc.add("marker.setAttribute(" + I_BREAKPOINT(sc) + ".ID, getModelIdentifier());");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".MESSAGE, \"Line Breakpoint: \" + resource.getName() + \" [line: \" + lineNumber + \"]\");");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".LOCATION, resource.getRawLocation().toPortableString());");		
		sc.add("}");
		sc.add("};");
		sc.add("run(getMarkerRule(resource), runnable);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetModelIdentifierMethod(JavaComposite sc) {
		sc.add("public String getModelIdentifier() {");
		sc.add("return " + pluginActivatorClassName + ".DEBUG_MODEL_ID;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInstallMethod(JavaComposite sc) {
		sc.add("public void install(" + debugTargetClassName + " target) {");
		sc.add("try {");
		sc.add("String location = (String) getMarker().getAttribute(" + I_MARKER(sc) + ".LOCATION);");
		sc.add("target.getDebugProxy().addLineBreakpoint(location, getLineNumber());");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " e) {");
		// TODO handle exception
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveMethod(JavaComposite sc) {
		sc.add("public void remove(" + debugTargetClassName + " target) {");
		sc.add("try {");
		sc.add("String location = (String) getMarker().getAttribute(" + I_MARKER(sc) + ".LOCATION);");
		sc.add("target.getDebugProxy().removeLineBreakpoint(location, getLineNumber());");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
