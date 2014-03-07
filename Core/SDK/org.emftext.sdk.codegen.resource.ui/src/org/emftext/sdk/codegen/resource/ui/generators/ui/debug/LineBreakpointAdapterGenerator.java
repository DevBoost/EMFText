/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.ui.generators.ui.debug;

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.DEBUG_PLUGIN;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_BREAKPOINT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_LINE_BREAKPOINT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_EDITOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TOGGLE_BREAKPOINTS_TARGET;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_PART;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

public class LineBreakpointAdapterGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_TOGGLE_BREAKPOINTS_TARGET(sc) + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addToggleLineBreakpointsMethod(sc);
		addCanToggleLineBreakpointsMethod(sc);
		addGetEditorMethod(sc);
		addToggleMethodBreakpointsMethod(sc);
		addCanToggleMethodBreakpointsMethod(sc);
		addToggleWatchpointsMethod(sc);
		addCanToggleWatchpointsMethod(sc);
	}

	private void addToggleLineBreakpointsMethod(JavaComposite sc) {
		sc.add("public void toggleLineBreakpoints(" + I_WORKBENCH_PART(sc) + " part, " + I_SELECTION(sc) + " selection) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add(I_TEXT_EDITOR(sc) + " textEditor = getEditor(part);");
		sc.add("if (textEditor != null) {");
		sc.add(I_RESOURCE(sc) + " resource = (" + I_RESOURCE(sc) + ") textEditor.getEditorInput().getAdapter(" + I_RESOURCE(sc) + ".class);");
		sc.add(I_TEXT_SELECTION(sc) + " textSelection = (" + I_TEXT_SELECTION(sc) + ") selection;");
		sc.add("int lineNumber = textSelection.getStartLine();");
		sc.add(I_BREAKPOINT(sc) + "[] breakpoints = " + DEBUG_PLUGIN(sc) + ".getDefault().getBreakpointManager().getBreakpoints(" + pluginActivatorClassName + ".DEBUG_MODEL_ID);");
		sc.add("for (int i = 0; i < breakpoints.length; i++) {");
		sc.add(I_BREAKPOINT(sc) + " breakpoint = breakpoints[i];");
		sc.add("if (resource.equals(breakpoint.getMarker().getResource())) {");
		sc.add("if (((" + I_LINE_BREAKPOINT(sc) + ")breakpoint).getLineNumber() == (lineNumber + 1)) {");
		sc.addComment("remove");
		sc.add("breakpoint.delete();");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addComment("create line breakpoint (document line numbers start at 0)");
		sc.add(lineBreakpointClassName + " lineBreakpoint = new " + lineBreakpointClassName + "(resource, lineNumber + 1);");
		sc.add(DEBUG_PLUGIN(sc) + ".getDefault().getBreakpointManager().addBreakpoint(lineBreakpoint);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanToggleLineBreakpointsMethod(JavaComposite sc) {
		sc.add("public boolean canToggleLineBreakpoints(" + I_WORKBENCH_PART(sc) + " part, " + I_SELECTION(sc) + " selection) {");
		sc.add(I_TEXT_EDITOR(sc) + " editor = getEditor(part);");
		sc.add("return editor != null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEditorMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the editor being used, associated with the " +
			"given part, or <code>null</code> if none.",
			"@param part workbench part"
		);
		sc.add("private " + I_TEXT_EDITOR(sc) + " getEditor(" + I_WORKBENCH_PART(sc) + " part) {");
		sc.add("if (part instanceof " + I_TEXT_EDITOR(sc) + ") {");
		sc.add(I_TEXT_EDITOR(sc) + " editorPart = (" + I_TEXT_EDITOR(sc) + ") part;");
		sc.add(I_RESOURCE(sc) + " resource = (" + I_RESOURCE(sc) + ") editorPart.getEditorInput().getAdapter(" + I_RESOURCE(sc) + ".class);");
		sc.add("if (resource != null) {");
		sc.add("String extension = resource.getFileExtension();");
		sc.add("if (extension != null && extension.equals(new " + metaInformationClassName + "().getSyntaxName())) {");
		sc.add("return editorPart;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToggleMethodBreakpointsMethod(JavaComposite sc) {
		sc.add("public void toggleMethodBreakpoints(" + I_WORKBENCH_PART(sc) + " part, " + I_SELECTION(sc) + " selection) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanToggleMethodBreakpointsMethod(JavaComposite sc) {
		sc.add("public boolean canToggleMethodBreakpoints(" + I_WORKBENCH_PART(sc) + " part, " + I_SELECTION(sc) + " selection) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToggleWatchpointsMethod(JavaComposite sc) {
		sc.add("public void toggleWatchpoints(" + I_WORKBENCH_PART(sc) + " part, " + I_SELECTION(sc) + " selection) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanToggleWatchpointsMethod(JavaComposite sc) {
		sc.add("public boolean canToggleWatchpoints(" + I_WORKBENCH_PART(sc) + " part, " + I_SELECTION(sc) + " selection) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
}
