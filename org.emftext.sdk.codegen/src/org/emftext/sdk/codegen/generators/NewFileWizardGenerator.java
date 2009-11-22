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
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IDE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INVOCATION_TARGET_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_CONTAINER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_NEW_WIZARD;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_RUNNABLE_WITH_PROGRESS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKBENCH_PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKSPACE_ROOT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MESSAGE_BOX;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MESSAGE_DIALOG;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PART_INIT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PATH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PLATFORM_UI;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STATUS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.WIZARD;

import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

/**
 * The NewFileContentGenerator can be used to create a NewFileWizard that 
 * creates a minimal sample file from a concrete syntax when it is invoked.
 */
public class NewFileWizardGenerator extends JavaBaseGenerator {
	
	private String newFileWizardPageClassName;
	private String metaInformationClassName;

	public NewFileWizardGenerator() {
		super();
	}

	private NewFileWizardGenerator(GenerationContext context) {
		super(context, EArtifact.NEW_FILE_WIZARD);
		newFileWizardPageClassName = getContext().getQualifiedClassName(EArtifact.NEW_FILE_WIZARD_PAGE);
		metaInformationClassName = getContext().getQualifiedClassName(EArtifact.META_INFORMATION);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + WIZARD + " implements " + I_NEW_WIZARD + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
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
		sc.add("public " + getClassNameHelper().getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() + " getMetaInformation() {");
		sc.add("return new " + metaInformationClassName + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFileExtensionMethod(StringComposite sc) {
		sc.add("public " + STRING + " getFileExtension() {");
		String metaInformationName = getContext().getQualifiedClassName(EArtifact.META_INFORMATION);
		sc.add("return new " + metaInformationName + "().getSyntaxName();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitMethod(StringComposite sc) {
		sc.add("// We will accept the selection in the workbench to see if");
		sc.add("// we can initialize from it.");
		sc.add("// @see IWorkbenchWizard#init(" + I_WORKBENCH + ", " + I_STRUCTURED_SELECTION + ")");
		sc.add("public void init(" + I_WORKBENCH + " workbench, " + I_STRUCTURED_SELECTION + " selection) {");
		sc.add("this.selection = selection;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addThrowCoreExceptionMethod(StringComposite sc) {
		sc.add("private void throwCoreException(String message) throws " + CORE_EXCEPTION + " {");
		sc.add(I_STATUS + " status = new " + STATUS + "(" + I_STATUS + ".ERROR, \"NewFileContentPrinter\", " + I_STATUS + ".OK, message, null);");
		sc.add("throw new " + CORE_EXCEPTION + "(status);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addOpenContentStreamMethod(StringComposite sc) {
		sc.add("// We will initialize file contents with a sample text.");
		sc.add("private " + INPUT_STREAM + " openContentStream() {");
		sc.add("return new " + BYTE_ARRAY_INPUT_STREAM + "(new " + metaInformationClassName + "().getNewFileContentProvider().getNewFileContent(newName).getBytes());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFileMethod(StringComposite sc) {
		sc.add("private " + I_FILE + " getFile(String fileName, String containerName) throws " + CORE_EXCEPTION + " {");
		sc.add(I_WORKSPACE_ROOT + " root = " + RESOURCES_PLUGIN + ".getWorkspace().getRoot();");
		sc.add(I_RESOURCE + " resource = root.findMember(new " + PATH + "(containerName));");
		sc.add("if (!resource.exists() || !(resource instanceof " + I_CONTAINER + ")) {");
		sc.add("throwCoreException(\"Container \\\"\" + containerName + \"\\\" does not exist.\");");
		sc.add("}");
		sc.add(I_CONTAINER + " container = (" + I_CONTAINER + ") resource;");
		sc.add("final " + I_FILE + " file = container.getFile(new " + PATH + "(fileName));");
		sc.add("return file;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoFinishMethod(StringComposite sc) {
		sc.add("// The worker method. It will find the container, create the");
		sc.add("// file if missing or just replace its contents, and open");
		sc.add("// the editor on the newly created file.");
		sc.add("private void doFinish(String containerName, String fileName, " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
		sc.add("// create a sample file");
		sc.add("monitor.beginTask(\"Creating \" + fileName, 2);");
		sc.add("final " + I_FILE + " file = getFile(fileName, containerName);");
		sc.add("try {");
		sc.add(INPUT_STREAM + " stream = openContentStream();");
		sc.add("if (file.exists()) {");
		sc.add("file.setContents(stream, true, true, monitor);");
		sc.add("} else {");
		sc.add("file.create(stream, true, monitor);");
		sc.add("}");
		sc.add("stream.close();");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("monitor.worked(1);");
		sc.add("monitor.setTaskName(\"Opening file for editing...\");");
		sc.add("getShell().getDisplay().asyncExec(new Runnable() {");
		sc.add("public void run() {");
		sc.add(I_WORKBENCH_PAGE + " page = " + PLATFORM_UI + ".getWorkbench().getActiveWorkbenchWindow().getActivePage();");
		sc.add("try {");
		sc.add(IDE + ".openEditor(page, file, true);");
		sc.add("} catch (" + PART_INIT_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("monitor.worked(1);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformFinishMethod(StringComposite sc) {
		sc.add("// This method is called when 'Finish' button is pressed in");
		sc.add("// the wizard. We will create an operation and run it");
		sc.add("// using wizard as execution context.");
		sc.add("public boolean performFinish() {");
		sc.add("final String containerName = page.getContainerName();");
		sc.add("final String fileName = page.getFileName();");
		sc.add("this.newName = fileName;");
		sc.add("int seperatorIdx = newName.indexOf('.');");
		sc.add("if(seperatorIdx != -1) {");
		sc.add("newName = newName.substring(0, seperatorIdx);");
		sc.add("}");
		sc.add("final " + I_FILE + " file;");
		sc.add("try {");
		sc.add("file = getFile(fileName, containerName);");
		sc.add("} catch (" + CORE_EXCEPTION + " e1) {");
		sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"" + EXCEPTION + " while initializing new file\", e1);");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (file.exists()) {");
		sc.add("// ask for confirmation");
		sc.add(MESSAGE_BOX + " messageBox = new " + MESSAGE_BOX + "(getShell(), " + SWT + ".ICON_QUESTION");
		sc.add("| " + SWT + ".YES | " + SWT + ".NO);");
		sc.add("messageBox.setMessage(\"File \\\"\" + fileName + \"\\\" already exists. Do you want to override it?\");");
		sc.add("messageBox.setText(\"File exists\");");
		sc.add("int response = messageBox.open();");
		sc.add("if (response == " + SWT + ".NO) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add(I_RUNNABLE_WITH_PROGRESS + " op = new " + I_RUNNABLE_WITH_PROGRESS + "() {");
		sc.add("public void run(" + I_PROGRESS_MONITOR + " monitor) throws " + INVOCATION_TARGET_EXCEPTION + " {");
		sc.add("try {");
		sc.add("doFinish(containerName, fileName, monitor);");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add("throw new " + INVOCATION_TARGET_EXCEPTION + "(e);");
		sc.add("} finally {");
		sc.add("monitor.done();");
		sc.add("}");
		sc.add("}");
		sc.add("};");
		sc.add("try {");
		sc.add("getContainer().run(true, false, op);");
		sc.add("} catch (InterruptedException e) {");
		sc.add("return false;");
		sc.add("} catch (" + INVOCATION_TARGET_EXCEPTION + " e) {");
		sc.add("Throwable realException = e.getTargetException();");
		sc.add(MESSAGE_DIALOG + ".openError(getShell(), \"Error\", realException.getMessage());");
		sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"" + EXCEPTION + " while initializing new file\", e);");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddPagesMethod(StringComposite sc) {
		sc.add("// Adds the page to the wizard.");
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

	private void addFields(StringComposite sc) {
		sc.add("private String categoryId = null;");
		sc.add("private " + newFileWizardPageClassName + " page;");
		sc.add("private " + I_SELECTION + " selection;");
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

	public Collection<GenerationProblem> getCollectedErrors() {
		return new ArrayList<GenerationProblem>();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return new ArrayList<GenerationProblem>();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new NewFileWizardGenerator(context);
	}
}
