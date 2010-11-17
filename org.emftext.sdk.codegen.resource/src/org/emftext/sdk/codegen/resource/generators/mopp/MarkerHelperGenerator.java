/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_VALIDATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.JOB;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_DIAGNOSTIC;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STATUS;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class MarkerHelperGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"Helper class to add markers to text files based on EMF's <code>" + RESOURCE_DIAGNOSTIC + "</code>. " +
			"If a resource contains <code>" + iTextDiagnosticClassName + "</code>s it uses the more precise information of " +
			"this extended diagnostic type."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();

		addFields(sc);
		addInnerClassMarkerCommandQueue(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addInnerClassMarkerCommandQueue(JavaComposite sc) {
		sc.add("private static class MarkerCommandQueue {");
		sc.addLineBreak();
		sc.add("private " + LIST + "<" + iCommandClassName + "<Object>> commands = new " + ARRAY_LIST + "<" + iCommandClassName + "<Object>>();");
		sc.addLineBreak();
		sc.add("public void addCommand(" + iCommandClassName + "<Object> command) {");
		sc.add("synchronized(commands) {");
		sc.add("commands.add(command);");
		sc.addComment("we only need to schedule a job, if the queue was empty");
		sc.add("if (commands.size() == 1) {");
		sc.add("scheduleRunCommandsJob();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private void scheduleRunCommandsJob() {");
		sc.add("new " + JOB + "(\"updating markers\") {");
		sc.add("@Override").addLineBreak();	
		sc.add("protected " + I_STATUS + " run(" + I_PROGRESS_MONITOR + " monitor) {");	
		sc.add(LIST + "<" + iCommandClassName + "<Object>> commandsToProcess = new " + ARRAY_LIST + "<" + iCommandClassName + "<Object>>();");
		sc.add("synchronized(commands) {");
		sc.add("commandsToProcess.addAll(commands);");
		sc.add("commands.clear();");
		sc.add("}");
		sc.add("for (" + iCommandClassName +"<Object> command : commandsToProcess) {");	
		sc.add("command.execute(null);");
		sc.add("}");
		sc.add("return " + STATUS + ".OK_STATUS;");
		sc.add("}");
		sc.add("}.schedule();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addMarkMethod(sc);
		addCreateMarkersFromDiagnosticsMethod(sc);
		addUnmarkMethod1(sc);
		addUnmarkMethod2(sc);
		addGetMarkerIDMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc(
				"The extension id of the custom marker type that is used by this text resource."
		);

		sc.add("public static final String MARKER_TYPE = " + pluginActivatorClassName + ".PLUGIN_ID + \".problem\";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The total number of markers per file is restricted with this constant. " +
			"Restriction is needed because the performance of Eclipse decreases drastically " +
			"if large amounts of markers are added to files."
		);
		sc.add("public static int MAXIMUM_MARKERS = 500;");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"We use a queue to aggregate commands that create or remove markers. " +
			"This is basically for performance reasons. Without the queue we would " +
			"need to create a job for each marker creation/removal, which creates tons of threads and takes very long time."
		);
		sc.add("private final static MarkerCommandQueue COMMAND_QUEUE = new MarkerCommandQueue();");
		sc.addLineBreak();
	}

	private void addUnmarkMethod2(JavaComposite sc) {
		sc.addJavadoc(
			"Removes all markers of the given type from the given resource.",
			"@param resource The resource where to delete markers from",
			"@param problemType The type of problem to remove"
		);
		sc.add("public static void unmark(" + RESOURCE + " resource, " + eProblemTypeClassName + " problemType) {");
		sc.add("if (resource == null || !" + PLATFORM + ".isRunning()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("String platformString = resource.getURI().toPlatformString(true);");
		sc.add("if (platformString == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + I_FILE + " file = (" + I_FILE + ") " + RESOURCES_PLUGIN + ".getWorkspace().getRoot().findMember(platformString);");
		sc.add("if (file == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final String markerType = getMarkerID(problemType);");
		sc.add("COMMAND_QUEUE.addCommand(new " + iCommandClassName + "<Object>() {");
		sc.add("public boolean execute(Object context) {");
		sc.add("try {");
		sc.add("file.deleteMarkers(markerType, false, " + I_RESOURCE + ".DEPTH_ZERO);");
		sc.add("} catch (" + CORE_EXCEPTION + " ce) {");
		sc.add("if (ce.getMessage().matches(\"Marker.*not found.\")) {");
		sc.addComment("ignore");
		sc.add("} else {");
		sc.add(pluginActivatorClassName + ".logError(\"Error while removing markers from resource:\", ce);");
		sc.add("}");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addUnmarkMethod1(JavaComposite sc) {
		sc.addJavadoc(
			"Removes all markers from the given resource regardless of their type.",
			"@param resource The resource where to delete markers from"
		);
		sc.add("public static void unmark(" + RESOURCE + " resource) {");
		sc.add("for (" + eProblemTypeClassName + " nextType : " + eProblemTypeClassName + ".values()) {");
		sc.add("unmark(resource, nextType);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateMarkersFromDiagnosticsMethod(JavaComposite sc) {
		sc.add("private static void createMarkerFromDiagnostic(final " + I_FILE + " file, final " + iTextDiagnosticClassName + " diagnostic) {");
		sc.add("final " + iProblemClassName + " problem = diagnostic.getProblem();");
		sc.add(eProblemTypeClassName + " problemType = problem.getType();");
		sc.add("final String markerID = getMarkerID(problemType);");
		sc.add("COMMAND_QUEUE.addCommand(new " + iCommandClassName + "<Object>() {");
		sc.add("public boolean execute(Object context) {");
		sc.add("try {");
		sc.addComment("if there are too many markers, we do not add new ones");
		sc.add("if (file.findMarkers(markerID, false, " + I_RESOURCE + ".DEPTH_ZERO).length >= MAXIMUM_MARKERS) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(I_MARKER + " marker = file.createMarker(markerID);");
		sc.add("if (problem.getSeverity() == " + eProblemSeverityClassName + ".ERROR) {");
		sc.add("marker.setAttribute(" + I_MARKER + ".SEVERITY, " + I_MARKER + ".SEVERITY_ERROR);");
		sc.add("} else {");
		sc.add("marker.setAttribute(" + I_MARKER + ".SEVERITY, " + I_MARKER + ".SEVERITY_WARNING);");
		sc.add("}");
		sc.add("marker.setAttribute(" + I_MARKER + ".MESSAGE, diagnostic.getMessage());");
		sc.add(iTextDiagnosticClassName + " textDiagnostic = (" + iTextDiagnosticClassName + ") diagnostic;");
		sc.add("marker.setAttribute(" + I_MARKER + ".LINE_NUMBER, textDiagnostic.getLine());");
		sc.add("marker.setAttribute(" + I_MARKER + ".CHAR_START, textDiagnostic.getCharStart());");
		sc.add("marker.setAttribute(" + I_MARKER + ".CHAR_END, textDiagnostic.getCharEnd() + 1);");
		sc.add("if (diagnostic instanceof " + textResourceClassName + ".ElementBasedTextDiagnostic) {");
		sc.add(E_OBJECT + " element = ((" + textResourceClassName + ".ElementBasedTextDiagnostic) diagnostic).getElement();");
		sc.add("if (element != null) {");
		sc.add(RESOURCE + " eResource = element.eResource();");
		sc.add("if (eResource != null) {");
		sc.add("marker.setAttribute(" + ECORE_VALIDATOR + ".URI_ATTRIBUTE, eResource.getURI().toString() + \"#\" + eResource.getURIFragment(element));");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add(COLLECTION + "<" + iQuickFixClassName + "> quickFixes = textDiagnostic.getProblem().getQuickFixes();");
		sc.add(COLLECTION + "<Object> sourceIDs = new " + ARRAY_LIST + "<Object>();");
		sc.add("if (quickFixes != null) {");
		sc.add("for (" + iQuickFixClassName + " quickFix : quickFixes) {");
		sc.add("if (quickFix != null) {");
		sc.add("sourceIDs.add(quickFix.getContextAsString());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("if (!sourceIDs.isEmpty()) {");
		sc.add("marker.setAttribute(" + I_MARKER + ".SOURCE_ID, " + stringUtilClassName + ".explode(sourceIDs, \"|\"));");
		sc.add("}");
		sc.add("} catch (" + CORE_EXCEPTION + " ce) {");
		sc.add("if (ce.getMessage().matches(\"Marker.*not found.\")) {");
		sc.addComment("ignore");
		sc.add("} else {");
		sc.add(pluginActivatorClassName + ".logError(\"Error while creating marks for resource:\", ce);");
		sc.add("}");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMarkerIDMethod(JavaComposite sc) {
		sc.add("private static String getMarkerID(" + eProblemTypeClassName + " problemType) {");
		sc.add("String markerID = MARKER_TYPE;");
		sc.add("String typeID = problemType.getID();");
		sc.add("if (!\"\".equals(typeID)) {");
		sc.add("markerID += \".\" + typeID;");
		sc.add("}");
		sc.add("return markerID;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMarkMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Marks a file with markers.",
			"@param resource The resource that is the file to mark.",
			"@param diagnostic The diagnostic with information for the marker."
		);
		sc.add("public static void mark(" + RESOURCE + " resource, final " + iTextDiagnosticClassName +" diagnostic) {");
		sc.add("if (resource == null || !" + PLATFORM + ".isRunning()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("String platformString = resource.getURI().toPlatformString(true);");
		sc.add("if (platformString == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + I_FILE + " file = (" + I_FILE + ") " + RESOURCES_PLUGIN + ".getWorkspace().getRoot().findMember(platformString);");
		sc.addComment("URI might not point at a platform file");
		sc.add("if (file == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("createMarkerFromDiagnostic(file, diagnostic);");
		sc.add("}");
		sc.addLineBreak();
	}
}
