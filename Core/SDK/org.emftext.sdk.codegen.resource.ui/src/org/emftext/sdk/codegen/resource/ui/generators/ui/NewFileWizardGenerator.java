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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.IDE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.INVOCATION_TARGET_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONTAINER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_NEW_WIZARD;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_RUNNABLE_WITH_PROGRESS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKSPACE_ROOT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MESSAGE_BOX;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MESSAGE_DIALOG;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PART_INIT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PATH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PLATFORM_UI;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.STATUS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.WIZARD;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

/**
 * The NewFileContentGenerator can be used to create a NewFileWizard that 
 * creates a minimal sample file from a concrete syntax when it is invoked.
 */
public class NewFileWizardGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + WIZARD(sc) + " implements " + I_NEW_WIZARD(sc) + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetCategoryIdMethod(sc);
		addSetCategoryIdMethod(sc);
		addAddPagesMethod(sc);
		addPerformFinishMethod(sc);
		addDoFinishMethod(sc);
		addGetFileMethod(sc);
		addOpenContentStreamMethod(sc);
		addThrowCoreExceptionMethod(sc);
		addInitMethod(sc);
		addGetFileExtensionMethod(sc);
		addGetMetaInformationMethod(sc);
	}

	private void addGetMetaInformationMethod(StringComposite sc) {
		sc.add("public " + iMetaInformationClassName + " getMetaInformation() {");
		sc.add("return new " + metaInformationClassName + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFileExtensionMethod(StringComposite sc) {
		sc.add("public String getFileExtension() {");
		sc.add("return new " + metaInformationClassName + "().getSyntaxName();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitMethod(JavaComposite sc) {
		sc.addJavadoc(
			"We will accept the selection in the workbench to see if " +
			"we can initialize from it.",
			"@see IWorkbenchWizard#init(" + I_WORKBENCH(sc) + ", " + I_STRUCTURED_SELECTION(sc) + ")"
		);
		sc.add("public void init(" + I_WORKBENCH(sc) + " workbench, " + I_STRUCTURED_SELECTION(sc) + " selection) {");
		sc.add("this.selection = selection;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addThrowCoreExceptionMethod(JavaComposite sc) {
		sc.add("private void throwCoreException(String message) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add(I_STATUS(sc) + " status = new " + STATUS(sc) + "(" + I_STATUS(sc) + ".ERROR, \"NewFileContentPrinter\", " + I_STATUS(sc) + ".OK, message, null);");
		sc.add("throw new " + CORE_EXCEPTION(sc) + "(status);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addOpenContentStreamMethod(JavaComposite sc) {
		sc.addJavadoc("We will initialize file contents with a sample text.");
		sc.add("private " + INPUT_STREAM(sc) + " openContentStream() {");
		sc.add("return new " + BYTE_ARRAY_INPUT_STREAM(sc) + "(new " + metaInformationClassName + "().getNewFileContentProvider().getNewFileContent(newName).getBytes());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFileMethod(JavaComposite sc) {
		sc.add("private " + I_FILE(sc) + " getFile(String fileName, String containerName) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add(I_WORKSPACE_ROOT(sc) + " root = " + RESOURCES_PLUGIN(sc) + ".getWorkspace().getRoot();");
		sc.add(I_RESOURCE(sc) + " resource = root.findMember(new " + PATH(sc) + "(containerName));");
		sc.add("if (!resource.exists() || !(resource instanceof " + I_CONTAINER(sc) + ")) {");
		sc.add("throwCoreException(\"Container \\\"\" + containerName + \"\\\" does not exist.\");");
		sc.add("}");
		sc.add(I_CONTAINER(sc) + " container = (" + I_CONTAINER(sc) + ") resource;");
		sc.add("final " + I_FILE(sc) + " file = container.getFile(new " + PATH(sc) + "(fileName));");
		sc.add("return file;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoFinishMethod(JavaComposite sc) {
		sc.addJavadoc(
			"The worker method. It will find the container, create the " +
			"file if missing or just replace its contents, and open " +
			"the editor on the newly created file."
		);
		sc.add("private void doFinish(String containerName, String fileName, " + I_PROGRESS_MONITOR(sc) + " monitor) throws " + CORE_EXCEPTION(sc) + " {");
		sc.addComment("create a sample file");
		sc.add("monitor.beginTask(\"Creating \" + fileName, 2);");
		sc.add("final " + I_FILE(sc) + " file = getFile(fileName, containerName);");
		sc.add("try {");
		sc.add(INPUT_STREAM(sc) + " stream = openContentStream();");
		sc.add("if (file.exists()) {");
		sc.add("file.setContents(stream, true, true, monitor);");
		sc.add("} else {");
		sc.add("file.create(stream, true, monitor);");
		sc.add("}");
		sc.add("stream.close();");
		sc.add("} catch (" + IO_EXCEPTION(sc) + " e) {");
		sc.add("}");
		sc.add("monitor.worked(1);");
		sc.add("monitor.setTaskName(\"Opening file for editing...\");");
		sc.add("getShell().getDisplay().asyncExec(new Runnable() {");
		sc.add("public void run() {");
		sc.add(I_WORKBENCH_PAGE(sc) + " page = " + PLATFORM_UI(sc) + ".getWorkbench().getActiveWorkbenchWindow().getActivePage();");
		sc.add("try {");
		sc.add(IDE(sc) + ".openEditor(page, file, true);");
		sc.add("} catch (" + PART_INIT_EXCEPTION(sc) + " e) {");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("monitor.worked(1);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformFinishMethod(JavaComposite sc) {
		sc.addJavadoc(
			"This method is called when 'Finish' button is pressed in " +
			"the wizard. We will create an operation and run it " +
			"using the wizard as execution context."
		);
		sc.add("public boolean performFinish() {");
		sc.add("final String containerName = page.getContainerName();");
		sc.add("final String fileName = page.getFileName();");
		sc.add("this.newName = fileName;");
		sc.add("int seperatorIdx = newName.indexOf('.');");
		sc.add("if (seperatorIdx != -1) {");
		sc.add("newName = newName.substring(0, seperatorIdx);");
		sc.add("}");
		sc.add("final " + I_FILE(sc) + " file;");
		sc.add("try {");
		sc.add("file = getFile(fileName, containerName);");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " e1) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while initializing new file\", e1);");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (file.exists()) {");
		sc.addComment("ask for confirmation");
		sc.add(MESSAGE_BOX(sc) + " messageBox = new " + MESSAGE_BOX(sc) + "(getShell(), " + SWT(sc) + ".ICON_QUESTION");
		sc.add("| " + SWT(sc) + ".YES | " + SWT(sc) + ".NO);");
		sc.add("messageBox.setMessage(\"File \\\"\" + fileName + \"\\\" already exists. Do you want to override it?\");");
		sc.add("messageBox.setText(\"File exists\");");
		sc.add("int response = messageBox.open();");
		sc.add("if (response == " + SWT(sc) + ".NO) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add(I_RUNNABLE_WITH_PROGRESS(sc) + " op = new " + I_RUNNABLE_WITH_PROGRESS(sc) + "() {");
		sc.add("public void run(" + I_PROGRESS_MONITOR(sc) + " monitor) throws " + INVOCATION_TARGET_EXCEPTION(sc) + " {");
		sc.add("try {");
		sc.add("doFinish(containerName, fileName, monitor);");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " e) {");
		sc.add("throw new " + INVOCATION_TARGET_EXCEPTION(sc) + "(e);");
		sc.add("} finally {");
		sc.add("monitor.done();");
		sc.add("}");
		sc.add("}");
		sc.add("};");
		sc.add("try {");
		sc.add("getContainer().run(true, false, op);");
		sc.add("} catch (InterruptedException e) {");
		sc.add("return false;");
		sc.add("} catch (" + INVOCATION_TARGET_EXCEPTION(sc) + " e) {");
		sc.add("Throwable realException = e.getTargetException();");
		sc.add(MESSAGE_DIALOG(sc) + ".openError(getShell(), \"Error\", realException.getMessage());");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while initializing new file\", e);");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddPagesMethod(JavaComposite sc) {
		sc.addJavadoc("Adds the pages to the wizard.");
		sc.add("public void addPages() {");
		sc.add("page = new " + newFileWizardPageClassName + "(selection, getFileExtension());");
		sc.add("addPage(page);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetCategoryIdMethod(StringComposite sc) {
		sc.add("public void setCategoryId(String id) {");
		sc.add("categoryId = id;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCategoryIdMethod(StringComposite sc) {
		sc.add("public String getCategoryId() {");
		sc.add("return categoryId;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private String categoryId = null;");
		sc.add("private " + newFileWizardPageClassName + " page;");
		sc.add("private " + I_SELECTION(sc) + " selection;");
		sc.add("private String newName = null;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("setNeedsProgressMonitor(true);");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
