/*******************************************************************************
 * Copyright (c) 2006-2013
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

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_CONTAINER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE_SET;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

@SyntaxDependent
public class TaskItemBuilderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		boolean removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(syntax, OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);

		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		if (removeEclipseDependentCode) {
			sc.addComment("This class is empty because option '" + OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE.getLiteral() + "' is set to true.");
		} else {
			sc.addJavadoc(
				"The " + getResourceClassName() + " is used to find task items in " +
				"text documents. The current implementation uses the generated lexer " +
				"and the TaskItemDetector to detect task items. This class is called by " +
				"the BuilderAdapter, which runs both this builder and the default builder " +
				"that is intended to be customized."
			);
		}
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		if (!removeEclipseDependentCode) {
	addMethods(sc);
		}
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addBuildMethod(sc);
		addGetBuilderMarkerIdMethod(sc);
		addIsInBinFolderMethod(sc);
	}

	private void addBuildMethod(JavaComposite sc) {
		sc.add("public void build(" + I_FILE(sc) + " resource, " + RESOURCE_SET(sc) + " resourceSet, " + I_PROGRESS_MONITOR(sc) + " monitor) {");
		sc.add("monitor.setTaskName(\"Searching for task items\");");
		sc.add("new " + markerHelperClassName + "().removeAllMarkers(resource, " + I_MARKER(sc) + ".TASK);");
		sc.add("if (isInBinFolder(resource)) {");
		sc.add("return;");
		sc.add("}");
		sc.add(sc.declareArrayList("taskItems", taskItemClassName));
		sc.add(taskItemDetectorClassName + " taskItemDetector = new " + taskItemDetectorClassName + "();");
		sc.add(INPUT_STREAM(sc) + " inputStream = null;");
		sc.add("try {");
		sc.add("inputStream = resource.getContents();");
		sc.add("String charset = resource.getCharset();");
		sc.add("String content = " + streamUtilClassName + ".getContent(inputStream, charset);");
		sc.add(iTextScannerClassName + " lexer = new " + metaInformationClassName + "().createLexer();");
		sc.add("lexer.setText(content);");
		sc.addLineBreak();
		sc.add(iTextTokenClassName + " nextToken = lexer.getNextToken();");
		sc.add("while (nextToken != null) {");
		sc.add("String text = nextToken.getText();");
		sc.add("taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));");
		sc.add("nextToken = lexer.getNextToken();");
		sc.add("}");
		sc.add("} catch (" + IO_EXCEPTION(sc) + " e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Exception while searching for task items\", e);");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Exception while searching for task items\", e);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("try {");
		sc.add("if (inputStream != null) {");
		sc.add("inputStream.close();");
		sc.add("}");
		sc.add("} catch (" + IO_EXCEPTION(sc) + " e) {");
		sc.addComment("Ignore this");
		sc.add("}");
		sc.addLineBreak();
		sc.add("for (" + taskItemClassName + " taskItem : taskItems) {");
		sc.add(sc.declareLinkedHashMap("markerAttributes", "String", "Object"));
		sc.add("markerAttributes.put(" + I_MARKER(sc) + ".USER_EDITABLE, false);");
		sc.add("markerAttributes.put(" + I_MARKER(sc) + ".DONE, false);");
		sc.add("markerAttributes.put(" + I_MARKER(sc) + ".LINE_NUMBER, taskItem.getLine());");
		sc.add("markerAttributes.put(" + I_MARKER(sc) + ".CHAR_START, taskItem.getCharStart());");
		sc.add("markerAttributes.put(" + I_MARKER(sc) + ".CHAR_END, taskItem.getCharEnd());");
		sc.add("markerAttributes.put(" + I_MARKER(sc) + ".MESSAGE, taskItem.getMessage());");
		sc.add("new " + markerHelperClassName + "().createMarker(resource, " + I_MARKER(sc) + ".TASK, markerAttributes);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBuilderMarkerIdMethod(JavaComposite sc) {
		sc.add("public String getBuilderMarkerId() {");
		sc.add("return " + I_MARKER(sc) + ".TASK;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addIsInBinFolderMethod(JavaComposite sc) {
		sc.add("public boolean isInBinFolder(" + I_FILE(sc) + " resource) {");
		sc.add(I_CONTAINER(sc) + " parent = resource.getParent();");
		sc.add("while (parent != null) {");
		sc.add("if (\"bin\".equals(parent.getName())) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("parent = parent.getParent();");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
}
