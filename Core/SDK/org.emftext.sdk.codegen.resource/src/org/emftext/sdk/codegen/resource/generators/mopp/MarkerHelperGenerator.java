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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.BASIC_E_OBJECT_IMPL;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.ECORE_VALIDATOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_SCHEDULING_RULE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.JOB;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.STATUS;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

@SyntaxDependent
public class MarkerHelperGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private static final String COMMENT_ON_EXECUTION_ORDER = 
		"Markers are created and removed asynchronously. Thus, they may not appear when calls to " +
		"this method return. But, the order of marker additions and removals is preserved.";

	public void generateJavaContents(JavaComposite sc) {

		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"Helper class to add markers to text files based on EMF's <code>ResourceDiagnostic</code>. " +
			"If a resource contains <code>" + iTextDiagnosticClassName + "</code>s it uses the more precise information of " +
			"this extended diagnostic type."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();

		boolean removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);
		if (!removeEclipseDependentCode) {
	addFields(sc);
	addInnerClassMutexRule(sc);
	addInnerClassMarkerCommandQueue(sc);
	addMethods(sc);
		} else {
			sc.addComment("This class is empty because option '" + OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE.getLiteral() + "' is set to true.");
		}
		
		sc.add("}");
	}

	private void addInnerClassMutexRule(JavaComposite sc) {
		sc.add("public static class MutexRule implements " + I_SCHEDULING_RULE(sc) + " {");
		sc.addLineBreak();
		sc.add("public boolean isConflicting(" + I_SCHEDULING_RULE(sc) + " rule) {");
		sc.add("return rule == this;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean contains(" + I_SCHEDULING_RULE(sc) + " rule) {");
		sc.add("return rule == this;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInnerClassMarkerCommandQueue(JavaComposite sc) {
		sc.add("private static class MarkerCommandQueue {");
		sc.addLineBreak();
		sc.add("private " + LIST(sc) + "<" + iCommandClassName + "<Object>> commands = new " + ARRAY_LIST(sc) + "<" + iCommandClassName + "<Object>>();");
		sc.addLineBreak();
		sc.add("private MutexRule schedulingRule = new MutexRule();");
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
		sc.add(JOB(sc) + " job = new " + JOB(sc) + "(\"updating markers\") {");
		sc.add("@Override");	
		sc.add("protected " + I_STATUS(sc) + " run(" + I_PROGRESS_MONITOR(sc) + " monitor) {");	
		sc.add("runCommands();");
		sc.add("return " + STATUS(sc) + ".OK_STATUS;");
		sc.add("}");
		sc.add("};");
		sc.add("job.setRule(schedulingRule);");
		sc.add("job.schedule();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void runCommands() {");
		sc.add(LIST(sc) + "<" + iCommandClassName + "<Object>> commandsToProcess = new " + ARRAY_LIST(sc) + "<" + iCommandClassName + "<Object>>();");
		sc.add("synchronized(commands) {");
		sc.add("commandsToProcess.addAll(commands);");
		sc.add("commands.clear();");
		sc.add("}");
		sc.add("for (" + iCommandClassName +"<Object> command : commandsToProcess) {");	
		sc.add("command.execute(null);");
		sc.add("}");
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
		addUnmarkMethod3(sc);
		addGetMarkerIDMethod(sc);
		addGetFileMethod(sc);
		addGetObjectURIMethod(sc);
		addHandleExceptionMethod(sc);
		addRemoveAllMarkersMethod1(sc);
		addCreateMarkerMethod(sc);
		addBeginDeferMarkerUpdatesMethod(sc);
		addEndDeferMarkerUpdatesMethod(sc);
		addRunCommandsMethod(sc);
	}

	private void addRunCommandsMethod(JavaComposite sc) {
		sc.add("public void runCommands() {");
		sc.add("COMMAND_QUEUE.runCommands();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addBeginDeferMarkerUpdatesMethod(JavaComposite sc) {
		sc.add("public void beginDeferMarkerUpdates() {");
		// TODO 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEndDeferMarkerUpdatesMethod(JavaComposite sc) {
		sc.add("public void endDeferMarkerUpdates() {");
		// TODO 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateMarkerMethod(JavaComposite sc) {
		sc.add("public void createMarker(final " + I_RESOURCE(sc) + " resource, final String markerId, final " + MAP(sc) + "<String, Object> markerAttributes) {");
		sc.add("if (resource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("COMMAND_QUEUE.addCommand(new " + iCommandClassName + "<Object>() {");
		sc.add("public boolean execute(Object context) {");
		sc.add("try {");
		sc.add(I_MARKER(sc) + " marker = resource.createMarker(markerId);");
		sc.add("for (String key : markerAttributes.keySet()) {");
		sc.add("marker.setAttribute(key, markerAttributes.get(key));");
		sc.add("}");
		sc.add("return true;");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Can't create marker.\", e);");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
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
			"Removes all markers of the given type from the given resource. " +
			COMMENT_ON_EXECUTION_ORDER,
			"@param resource The resource where to delete markers from",
			"@param problemType The type of problem to remove"
		);
		sc.add("public void unmark(" + RESOURCE(sc) + " resource, " + eProblemTypeClassName + " problemType) {");
		sc.add("final " + I_FILE(sc) + " file = getFile(resource);");
		sc.add("if (file == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final String markerType = getMarkerID(problemType);");
		sc.add("COMMAND_QUEUE.addCommand(new " + iCommandClassName + "<Object>() {");
		sc.add("public boolean execute(Object context) {");
		sc.add("try {");
		sc.add("file.deleteMarkers(markerType, false, " + I_RESOURCE(sc) + ".DEPTH_ZERO);");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " ce) {");
		sc.add("handleException(ce);");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addRemoveAllMarkersMethod1(JavaComposite sc) {
		sc.addJavadoc(
			"Removes all markers of the given type from the given resource. " +
			COMMENT_ON_EXECUTION_ORDER,
			"@param resource The resource where to delete markers from",
			"@param markerId The id of the marker type to remove"
		);
		sc.add("public void removeAllMarkers(final " + I_RESOURCE(sc) + " resource, final String markerId) {");
		sc.add("if (resource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("COMMAND_QUEUE.addCommand(new " + iCommandClassName + "<Object>() {");
		sc.add("public boolean execute(Object context) {");
		sc.add("try {");
		sc.add("resource.deleteMarkers(markerId, false, " + I_RESOURCE(sc) + ".DEPTH_ZERO);");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " ce) {");
		sc.add("handleException(ce);");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addUnmarkMethod3(JavaComposite sc) {
		sc.addJavadoc(
			"Removes all markers that were caused by the given object from the resource. " +
			COMMENT_ON_EXECUTION_ORDER,
			"@param resource The resource where to delete markers from",
			"@param causingObject The cause of the problems to remove"
		);
		sc.add("public void unmark(" + RESOURCE(sc) + " resource, final " + E_OBJECT(sc) + " causingObject) {");
		sc.add("final " + I_FILE(sc) + " file = getFile(resource);");
		sc.add("if (file == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final String markerID = getMarkerID(" + eProblemTypeClassName + ".UNKNOWN);");
		sc.add("final String causingObjectURI = getObjectURI(causingObject);");
		sc.add("if (causingObjectURI == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("COMMAND_QUEUE.addCommand(new " + iCommandClassName + "<Object>() {");
		sc.add("public boolean execute(Object context) {");
		sc.add("try {");
		sc.add(I_MARKER(sc) + "[] markers = file.findMarkers(markerID, true, " + I_RESOURCE(sc) + ".DEPTH_ZERO);");
		sc.add("for (" + I_MARKER(sc) + " marker : markers) {");
		sc.add("if (causingObjectURI.equals(marker.getAttribute(" + ECORE_VALIDATOR(sc) + ".URI_ATTRIBUTE))) {");
		sc.add("marker.delete();");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " ce) {");
		sc.add("handleException(ce);");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFileMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Tries to determine the file for the given resource. If the platform is not running, " +
			"the resource is not a platform resource, or the resource cannot be found in the " +
			"workspace, this method returns <code>null</code>."
		);
		sc.add("protected " + I_FILE(sc) + " getFile(" + RESOURCE(sc) + " resource) {");
		sc.add("if (resource == null || !" + PLATFORM(sc) + ".isRunning()) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("String platformString = resource.getURI().toPlatformString(true);");
		sc.add("if (platformString == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(I_FILE(sc) + " file = (" + I_FILE(sc) + ") " + RESOURCES_PLUGIN(sc) + ".getWorkspace().getRoot().findMember(platformString);");
		sc.add("return file;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addUnmarkMethod1(JavaComposite sc) {
		sc.addJavadoc(
			"Removes all markers from the given resource regardless of their type. " +
			COMMENT_ON_EXECUTION_ORDER,
			"@param resource The resource where to delete markers from"
		);
		sc.add("public void unmark(" + RESOURCE(sc) + " resource) {");
		sc.add("for (" + eProblemTypeClassName + " nextType : " + eProblemTypeClassName + ".values()) {");
		sc.add("unmark(resource, nextType);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateMarkersFromDiagnosticsMethod(JavaComposite sc) {
		sc.add("protected void createMarkerFromDiagnostic(final " + I_FILE(sc) + " file, final " + iTextDiagnosticClassName + " diagnostic) {");
		sc.add("final " + iProblemClassName + " problem = diagnostic.getProblem();");
		sc.add(eProblemTypeClassName + " problemType = problem.getType();");
		sc.add("final String markerID = getMarkerID(problemType);");
		sc.add("COMMAND_QUEUE.addCommand(new " + iCommandClassName + "<Object>() {");
		sc.add("public boolean execute(Object context) {");
		sc.add("try {");
		sc.addComment("if there are too many markers, we do not add new ones");
		sc.add("if (file.findMarkers(markerID, false, " + I_RESOURCE(sc) + ".DEPTH_ZERO).length >= MAXIMUM_MARKERS) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(I_MARKER(sc) + " marker = file.createMarker(markerID);");
		sc.add("if (problem.getSeverity() == " + eProblemSeverityClassName + ".ERROR) {");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".SEVERITY, " + I_MARKER(sc) + ".SEVERITY_ERROR);");
		sc.add("} else {");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".SEVERITY, " + I_MARKER(sc) + ".SEVERITY_WARNING);");
		sc.add("}");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".MESSAGE, diagnostic.getMessage());");
		sc.add(iTextDiagnosticClassName + " textDiagnostic = (" + iTextDiagnosticClassName + ") diagnostic;");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".LINE_NUMBER, textDiagnostic.getLine());");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".CHAR_START, textDiagnostic.getCharStart());");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".CHAR_END, textDiagnostic.getCharEnd() + 1);");
		sc.add("if (diagnostic instanceof " + textResourceClassName + ".ElementBasedTextDiagnostic) {");
		sc.add(E_OBJECT(sc) + " element = ((" + textResourceClassName + ".ElementBasedTextDiagnostic) diagnostic).getElement();");
		sc.add("String elementURI = getObjectURI(element);");
		sc.add("if (elementURI != null) {");
		sc.add("marker.setAttribute(" + ECORE_VALIDATOR(sc) + ".URI_ATTRIBUTE, elementURI);");
		sc.add("}");
		sc.add("}");
		sc.add(COLLECTION(sc) + "<" + iQuickFixClassName + "> quickFixes = textDiagnostic.getProblem().getQuickFixes();");
		sc.add(COLLECTION(sc) + "<Object> sourceIDs = new " + ARRAY_LIST(sc) + "<Object>();");
		sc.add("if (quickFixes != null) {");
		sc.add("for (" + iQuickFixClassName + " quickFix : quickFixes) {");
		sc.add("if (quickFix != null) {");
		sc.add("sourceIDs.add(quickFix.getContextAsString());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("if (!sourceIDs.isEmpty()) {");
		sc.add("marker.setAttribute(" + I_MARKER(sc) + ".SOURCE_ID, " + stringUtilClassName + ".explode(sourceIDs, \"|\"));");
		sc.add("}");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " ce) {");
		sc.add("handleException(ce);");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetObjectURIMethod(JavaComposite sc) {
		sc.addJavadoc("Returns an URI that identifies the given object.");
		sc.add("protected String getObjectURI(" + E_OBJECT(sc) + " object) {");
		sc.add("if (object == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("if (object.eIsProxy() && object instanceof " + BASIC_E_OBJECT_IMPL(sc) + ") {");
		sc.add("return ((" + BASIC_E_OBJECT_IMPL(sc) + ") object).eProxyURI().toString();");
		sc.add("}");
		sc.add(RESOURCE(sc) + " eResource = object.eResource();");
		sc.add("if (eResource == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return eResource.getURI().toString() + \"#\" + eResource.getURIFragment(object);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMarkerIDMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the ID of the marker type that is used to indicate problems of the given type.");
		sc.add("public String getMarkerID(" + eProblemTypeClassName + " problemType) {");
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
			"Creates a marker from the given diagnostics object and attaches the marker to the resource. " +
			COMMENT_ON_EXECUTION_ORDER,
			"@param resource The resource that is the file to mark.",
			"@param diagnostic The diagnostic with information for the marker."
		);
		sc.add("public void mark(" + RESOURCE(sc) + " resource, " + iTextDiagnosticClassName +" diagnostic) {");
		sc.add("final " + I_FILE(sc) + " file = getFile(resource);");
		sc.add("if (file == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("createMarkerFromDiagnostic(file, diagnostic);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addHandleExceptionMethod(JavaComposite sc) {
		sc.add("protected void handleException(" + CORE_EXCEPTION(sc) + " ce) {");
		sc.add("if (ce.getMessage().matches(\"Marker.*not found.\")) {");
		sc.addComment("ignore");
		sc.add("}else if (ce.getMessage().matches(\"Resource.*does not exist.\")) {");
		sc.addComment("ignore");
		sc.add("} else {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Error while removing markers from resource:\", ce);");
		sc.add("}");	
		sc.add("}");
		sc.addLineBreak();
	}
}
