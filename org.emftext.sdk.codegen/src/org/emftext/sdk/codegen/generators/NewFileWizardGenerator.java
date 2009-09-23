/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_NEW_WIZARD;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IDE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INVOCATION_TARGET_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_CONTAINER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.NEW_WIZARD;
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

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * The NewFileContentGenerator can be used to create a NewFileWizard that 
 * creates a minimal sample file from a concrete syntax when it is invoked.
 */
public class NewFileWizardGenerator extends BaseGenerator {
	
	private final static GenClassUtil genClassUtil = new GenClassUtil();
	private String newFileWizardPageClassName;
	private String mimimalModelHelperClassName;
	private String metaInformationClassName;

	public NewFileWizardGenerator() {
		super();
	}

	private NewFileWizardGenerator(GenerationContext context) {
		super(context, EArtifact.NEW_FILE_WIZARD);
		newFileWizardPageClassName = getContext().getQualifiedClassName(EArtifact.NEW_FILE_WIZARD_PAGE);
		mimimalModelHelperClassName = getContext().getQualifiedClassName(EArtifact.MINIMAL_MODEL_HELPER);
		metaInformationClassName = getContext().getQualifiedClassName(EArtifact.META_INFORMATION);
	}

	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + NEW_WIZARD + " implements " + I_NEW_WIZARD + " {");
		sc.addLineBreak();
		
		sc.add("private " + newFileWizardPageClassName + " page;");
		sc.add("private " + I_SELECTION + " selection;");
		sc.add("private String newName = null;");
		sc.addLineBreak();
		
		addConstructor(sc);
		
		sc.add("// Adds the page to the wizard.");
		sc.add("public void addPages() {");
		sc.add("page = new " + newFileWizardPageClassName + "(selection, getFileExtension());");
		sc.add("addPage(page);");
		sc.add("}");
		sc.addLineBreak();
		
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
		sc.add(getClassNameHelper().getEMFTEXT_RUNTIME_PLUGIN() + ".logError(\"" + EXCEPTION + " while initializing new file\", e1);");
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
		sc.add(getClassNameHelper().getEMFTEXT_RUNTIME_PLUGIN() + ".logError(\"" + EXCEPTION + " while initializing new file\", e);");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		
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
		sc.add(I_WORKBENCH_PAGE + " page =");
		sc.add(PLATFORM_UI + ".getWorkbench().getActiveWorkbenchWindow().getActivePage();");
		sc.add("try {");
		sc.add(IDE + ".openEditor(page, file, true);");
		sc.add("} catch (" + PART_INIT_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("monitor.worked(1);");
		sc.add("}");
		sc.addLineBreak();
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
		
		sc.add("// We will initialize file contents with a sample text.");
		sc.add("private " + INPUT_STREAM + " openContentStream() {");
		sc.add("return new " + BYTE_ARRAY_INPUT_STREAM + "(getExampleContent().getBytes());");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private void throwCoreException(String message) throws " + CORE_EXCEPTION + " {");
		sc.add(I_STATUS + " status = new " + STATUS + "(" + I_STATUS + ".ERROR, \"NewFileContentPrinter\", " + I_STATUS + ".OK, message, null);");
		sc.add("throw new " + CORE_EXCEPTION + "(status);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// We will accept the selection in the workbench to see if");
		sc.add("// we can initialize from it.");
		sc.add("// @see IWorkbenchWizard#init(" + I_WORKBENCH + ", " + I_STRUCTURED_SELECTION + ")");
		sc.add("public void init(" + I_WORKBENCH + " workbench, " + I_STRUCTURED_SELECTION + " selection) {");
		sc.add("this.selection = selection;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("protected String getExampleContent(" + E_CLASS + "[] startClasses, " + E_CLASS + "[] allClassesWithSyntax) {");
		sc.add("String content = \"\";");
		sc.add("for (" + E_CLASS + " next : startClasses) {");
		sc.add("content = getExampleContent(next, allClassesWithSyntax);");
		sc.add("if (content.trim().length() > 0) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("return content;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private String getExampleContent(" + E_CLASS + " eClass, " + E_CLASS + "[] allClassesWithSyntax) {");
		sc.add("// create a minimal model");
		sc.add("" + E_OBJECT + " root = new " + mimimalModelHelperClassName + "().getMinimalModel(eClass, allClassesWithSyntax, newName);");
		sc.add("// use printer to get text for model");
		sc.add(BYTE_ARRAY_OUTPUT_STREAM + " buffer = new " + BYTE_ARRAY_OUTPUT_STREAM + "();");
		sc.add(getClassNameHelper().getI_TEXT_PRINTER() + " printer = getPrinter(buffer);");
		sc.add("try {");
		sc.add("printer.print(root);");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add(getClassNameHelper().getEMFTEXT_RUNTIME_PLUGIN() + ".logError(\"" + EXCEPTION + " while generating example content.\", e);");
		sc.add("}");
		sc.add("return buffer.toString();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + STRING + " getFileExtension() {");
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		sc.add("return \"" + syntax.getName() + "\";");
		sc.add("}");
		sc.addLineBreak();

		List<GenClass> startSymbols = syntax.getActiveStartSymbols();

		sc.add("public " + getClassNameHelper().getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() + " getMetaInformation() {");
		sc.add("return new " + metaInformationClassName + "();");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public " + STRING + " getExampleContent() {");
		sc.add("return getExampleContent(new " + E_CLASS + "[] {");
		for (GenClass startSymbol : startSymbols) {
			sc.add(genClassUtil.getAccessor(startSymbol) + ",");
		}
		sc.add("}, getMetaInformation().getClassesWithSyntax());");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + getClassNameHelper().getI_TEXT_PRINTER() + " getPrinter(" + OutputStream.class.getName() + " outputStream) {");
		sc.add("return new " + getContext().getQualifiedClassName(EArtifact.PRINTER) + "(outputStream, new " + getContext().getQualifiedClassName(EArtifact.RESOURCE) + "());");
		sc.add("}");

		sc.add("}");
		
		out.write(sc.toString());
		out.flush();
		return true;
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
