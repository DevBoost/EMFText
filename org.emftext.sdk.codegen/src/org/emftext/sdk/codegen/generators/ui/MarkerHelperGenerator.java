/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DIAGNOSTIC;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCES_PLUGIN;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class MarkerHelperGenerator extends BaseGenerator {

	private String markeHelperClassName;

	public MarkerHelperGenerator() {
		super();
	}

	private MarkerHelperGenerator(GenerationContext context) {
		super(context, EArtifact.MARKER_HELPER);
		markeHelperClassName = getContext().getQualifiedClassName(EArtifact.MARKER_HELPER);
	}

	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// Helper class to add markers to test files based on EMF's <code>" + RESOURCE + "." + DIAGNOSTIC + "</code>.");
		sc.add("// If a resource contains <code>" + getClassNameHelper().getI_TEXT_DIAGNOSTIC() + "</code>s it uses the more precise information of");
		sc.add("// this extended diagnostic type.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();

		addFields(sc);
		addMethods(sc);
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addMethods(StringComposite sc) {
		addMarkMethod(sc);
		addCreateMarkersFromDiagnosticsMethod(sc);
		addUnmarkMethod(sc);
	}

	private void addFields(StringComposite sc) {
		sc.add("public static final String MARKER_TYPE = " + getContext().getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR) + ".PLUGIN_ID + \".problem\";");
		sc.addLineBreak();
	}

	private void addUnmarkMethod(StringComposite sc) {
		sc.add("// Removes all markers from a given resource.");
		sc.add("//");
		sc.add("// @param resource The resource where to delete markers from.");
		sc.add("//");
		sc.add("// @throws " + CORE_EXCEPTION + "");
		sc.add("public static void unmark(" + RESOURCE + " resource) throws " + CORE_EXCEPTION + " {");
		sc.add(I_FILE + " file = (" + I_FILE + ") " + RESOURCES_PLUGIN + ".getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true));");
		sc.add("if (file != null) {");
		sc.add("file.deleteMarkers(" + markeHelperClassName + ".MARKER_TYPE, false, " + I_RESOURCE + ".DEPTH_ZERO);");
		sc.add("}");
		sc.add("}");
	}

	private void addCreateMarkersFromDiagnosticsMethod(StringComposite sc) {
		sc.add("private static void createMarkersFromDiagnostics(" + RESOURCE + " resource, " + I_FILE + " file, " + LIST + "<" + DIAGNOSTIC + "> diagnostics, int markerSeverity) throws " + CORE_EXCEPTION + " {");
		sc.addLineBreak();
		sc.add("for (" + DIAGNOSTIC + " diagnostic : diagnostics) {");
		sc.add("try {");
		sc.add(I_MARKER + " marker = file.createMarker(MARKER_TYPE);");
		sc.add("marker.setAttribute(" + I_MARKER + ".SEVERITY, markerSeverity);");
		sc.add("marker.setAttribute(" + I_MARKER + ".MESSAGE, diagnostic.getMessage());");
		sc.add("if (diagnostic instanceof " + getClassNameHelper().getI_TEXT_DIAGNOSTIC() + ") {");
		sc.add(getClassNameHelper().getI_TEXT_DIAGNOSTIC() + " textDiagnostic = (" + getClassNameHelper().getI_TEXT_DIAGNOSTIC() + ") diagnostic;");
		sc.add("marker.setAttribute(" + I_MARKER + ".LINE_NUMBER, textDiagnostic.getLine());");
		sc.add("marker.setAttribute(" + I_MARKER + ".CHAR_START, textDiagnostic.getCharStart());");
		sc.add("marker.setAttribute(" + I_MARKER + ".CHAR_END, textDiagnostic.getCharEnd() + 1);");
		sc.add("}");
		sc.add("else {");
		sc.add("marker.setAttribute(" + I_MARKER + ".CHAR_START, 0);");
		sc.add("marker.setAttribute(" + I_MARKER + ".CHAR_END, 1);");
		sc.add("}");
		sc.add("} catch (" + CORE_EXCEPTION + " ce) {");
		sc.add("if (ce.getMessage().matches(\"Marker.*not found.\")) {");
		sc.add("// ignore");
		sc.add("} else {");
		sc.add("ce.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMarkMethod(StringComposite sc) {
		sc.add("// Marks a file with markers.");
		sc.add("//");
		sc.add("// @param resource The resource that is the file to mark.");
		sc.add("// @throws " + CORE_EXCEPTION + "");
		sc.add("public static void mark(" + RESOURCE + " resource) throws " + CORE_EXCEPTION + " {");
		sc.add("if (resource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(I_FILE + " file = (" + I_FILE + ") " + RESOURCES_PLUGIN + ".getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true));");
		sc.add("//URI might not point at a platform file");
		sc.add("if (file == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("createMarkersFromDiagnostics(resource, file, resource.getErrors(), " + I_MARKER + ".SEVERITY_ERROR);");
		sc.add("createMarkersFromDiagnostics(resource, file, resource.getWarnings(), " + I_MARKER + ".SEVERITY_WARNING);");
		sc.add("}");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new MarkerHelperGenerator(context);
	}
}
