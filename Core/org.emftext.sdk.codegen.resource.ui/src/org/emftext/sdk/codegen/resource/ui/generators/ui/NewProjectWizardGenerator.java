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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FILE_LOCATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FILE_NOT_FOUND_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_EXECUTABLE_EXTENSION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ZIP_ENTRY;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ZIP_FILE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BASIC_NEW_PROJECT_RESOURCE_WIZARD;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BUNDLE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ENUMERATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FILE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FILE_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_COMMAND;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONFIGURATION_ELEMENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_NEW_WIZARD;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PATH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PROJECT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PROJECT_DESCRIPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RUNNABLE_WITH_PROGRESS;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKSPACE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.OUTPUT_STREAM_WRITER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PATH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SUB_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.URL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.WIZARD;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.WIZARD_NEW_PROJECT_CREATION_PAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.WORKSPACE_MODIFY_OPERATION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class NewProjectWizardGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();

		sc.addJavadoc(
			"This class is based on: " +
			"<i>org.eclipse.gef.examples.ui.pde.internal.wizards.ProjectUnzipperNewWizard</i>.",
			"It is responsible for offering an example project via the new dialog of Eclipse."
		);
		sc.add("public class " + getResourceClassName() + " extends " + WIZARD + " implements " + I_NEW_WIZARD + ", " + I_EXECUTABLE_EXTENSION + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc(
			"The single page provided by this base implementation. It provides all the " + 
			"functionality required to capture the name and location of the target " +
			"project."
		);
		sc.add("private " + WIZARD_NEW_PROJECT_CREATION_PAGE + " wizardNewProjectCreationPage;");
		sc.addLineBreak();
		
		sc.addJavadoc("The name of the project creation page");
		sc.add("private String pageName = \"New \" + new " + metaInformationClassName + "().getSyntaxName() + \" Project\";");
		sc.addLineBreak();
		
		sc.addJavadoc("The title of the project creation page");
		sc.add("private String pageTitle = pageName;");
		sc.addLineBreak();
		
		sc.addJavadoc("The description of the project creation page");
		sc.add("private String pageDescription = \"Enter a name and select a location where the new project shall be created.\";");
		sc.addLineBreak();
		
		sc.addJavadoc(" The name of the project in the project creation page");
		sc.add("private String  pageProjectName= \"\";");
		sc.addLineBreak();
		
		sc.addJavadoc("The name of the new project zip file (relative to the UI plugin's root)");
		sc.add("private String  newProjectZip=\"newProject.zip\";");
		sc.addLineBreak();
		
		sc.addJavadoc("The configuration element associated with this new project wizard");		
		sc.add("private " + I_CONFIGURATION_ELEMENT + " config;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc("The constructor.");
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addPerformFinishMethod(sc);
		addExtractProjectMethod(sc);
		addUnzipMethod(sc);
		addRenameProjectMethod(sc);
		addInitMethod(sc);
		addSetInitializationDataMethod(sc);
	}

	private void addPerformFinishMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Performs the bulk of the wizard functionality: project creation, the " +
			"unzip operation and classpath update.",
			"@see " + WIZARD + "#performFinish"
		);
		sc.add("public boolean performFinish() {");
		sc.addLineBreak();
		sc.add("try {");
		sc.add(I_RUNNABLE_WITH_PROGRESS + " operation = new " + WORKSPACE_MODIFY_OPERATION + "() {");
		sc.addLineBreak();
		sc.add("public void execute(" + I_PROGRESS_MONITOR + " monitor) throws InterruptedException {");
		sc.add("try {");
		sc.add("monitor.beginTask(\"Creating Example Project\", 120);");
		sc.addLineBreak();
		sc.addComment("Create the project folder");
		
		sc.add(I_PATH + " projectPath = wizardNewProjectCreationPage.getLocationPath();");
		sc.addLineBreak();
		sc.add("String projectName = wizardNewProjectCreationPage.getProjectName();");
		sc.add("String projectFolder = projectPath.toOSString() + " + FILE + ".separator + projectName;");
		sc.add(FILE + " projectFolderFile = new " + FILE + "(projectFolder);");
		sc.addLineBreak();
		sc.add(I_WORKSPACE + " workspace = " + RESOURCES_PLUGIN + ".getWorkspace();");
		sc.add(I_PROJECT + " project = workspace.getRoot().getProject(projectName);");
		sc.addLineBreak();
		sc.addComment("If the project does not exist, we will create it and populate it.");
		sc.add("if (!project.exists()) {");
		sc.add("projectFolderFile.mkdirs();");
		sc.add("monitor.worked(10);");
		sc.addLineBreak();
		sc.add(BUNDLE + " bundle = " + PLATFORM + ".getBundle(\"" + getContext().getResourceUIPlugin().getName() + "\");");
		sc.add(URL + " newProjectZipURL = bundle.getEntry(newProjectZip);");
		sc.addLineBreak();
		sc.add("if (newProjectZipURL != null) {");
		sc.addComment("Copy plug-in project code");
		sc.add("extractProject(projectFolderFile, newProjectZipURL, new " + SUB_PROGRESS_MONITOR + "(monitor, 100));");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (monitor.isCanceled()) {");
		sc.add("throw new InterruptedException();");
		sc.add("}");
		sc.addLineBreak();
		sc.add(I_PROJECT_DESCRIPTION + " desc = workspace.newProjectDescription(project.getName());");
		sc.add("if (!projectPath.equals(workspace.getRoot().getLocation())) {");
		sc.add("desc.setLocation(new " + PATH + "(projectFolder));");
		sc.add("}");
		sc.addLineBreak();
		
		String natureClassName = getContext().getQualifiedClassName(TextResourceArtifacts.NATURE);
		
		sc.add("String natureID = " + natureClassName + ".NATURE_ID;");
		sc.add(LIST + "<" + I_COMMAND + "> buildCommands = new " + ARRAY_LIST +"<" + I_COMMAND + ">();");
		sc.add("for (String builderID : " + natureClassName + ".BUILDER_IDS) {");
		sc.add(I_COMMAND + " command = desc.newCommand();");
		sc.add("command.setBuilderName(builderID);");
		sc.add("buildCommands.add(command);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("desc.setNatureIds(new String[] {natureID});");
		sc.add("desc.setBuildSpec(buildCommands.toArray(new " + I_COMMAND + "[buildCommands.size()]));");
		sc.add("project.create(desc, monitor);");
		sc.addComment("Now, we ensure that the project is open.");
		sc.add("project.open(monitor);");
		sc.add("renameProject(project, projectName);");
		sc.addLineBreak();
		sc.add(I_FILE + " defaultNewFile = project.getFile(\"NEW_FILE_PLACEHOLDER\");");
		sc.add("if (newProjectZipURL == null) {");
		sc.add("defaultNewFile.create(new " + BYTE_ARRAY_INPUT_STREAM + "(new byte[0]), true, null);");
		sc.add("}");
		sc.add("if (defaultNewFile.exists()) {");
		sc.add(metaInformationClassName + " info = new " + metaInformationClassName + "();");
		sc.add("String fileName = \"new_file.\" + info.getSyntaxName();");
		sc.add("String content = info.getNewFileContentProvider().getNewFileContent(\"new_file.\" + info.getSyntaxName());");
		sc.add("defaultNewFile.setContents(new " + BYTE_ARRAY_INPUT_STREAM + "(content.getBytes()), " + I_FILE + ".FORCE, null);");
		sc.add("defaultNewFile.move(project.getProjectRelativePath().append(fileName), true, null);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("monitor.worked(10);");
		sc.add("if (monitor.isCanceled()) {");
		sc.add("throw new InterruptedException();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("throw new RuntimeException(e);");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add("throw new RuntimeException(e);");
		sc.add("} finally {");
		sc.add("monitor.done();");
		sc.add("}");
		sc.add("}");
		sc.add("};");
		sc.addLineBreak();
		sc.add("getContainer().run(false, true, operation);");
		sc.addLineBreak();
		sc.addComment("Set perspective");
		sc.add(BASIC_NEW_PROJECT_RESOURCE_WIZARD + ".updatePerspective(config);");
		sc.addLineBreak();
		sc.add("} catch (InterruptedException e) {");
		sc.add("return false;");
		sc.add("} catch (Exception e) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addExtractProjectMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Unzip the project archive to the specified folder",
			"@param projectFolderFile The folder where to unzip the project archive",
			"@param monitor Monitor to display progress and/or cancel operation",
			"@throws " + IO_EXCEPTION,
			"@throws InterruptedException",
			"@throws " + FILE_NOT_FOUND_EXCEPTION);
		
		sc.add("private void extractProject(" + FILE + " projectFolderFile, " + URL + " url, " + I_PROGRESS_MONITOR + " monitor) throws " + FILE_NOT_FOUND_EXCEPTION + ", " + IO_EXCEPTION + ", InterruptedException {");
		sc.addLineBreak();
		sc.addComment("Get project archive");
		sc.add(URL + " urlZipLocal = " + FILE_LOCATOR + ".toFileURL(url);");
		sc.addLineBreak();
		sc.addComment("Walk each element and unzip");
		
		sc.add(ZIP_FILE + " zipFile = new " + ZIP_FILE + "(urlZipLocal.getPath());");
		sc.addLineBreak();
		sc.add("try {");
		sc.addComment("Allow for a hundred work units");
		sc.add("monitor.beginTask(\"Extracting Project\", zipFile.size());");
		sc.addLineBreak();
		sc.add("unzip(zipFile, projectFolderFile, monitor);");
		sc.add("} finally {");
		sc.add("zipFile.close();");
		sc.add("monitor.done();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addUnzipMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Unzips the platform formatted zip file to specified folder",
			"@param zipFile The platform formatted zip file",
			"@param projectFolderFile The folder where to unzip the project archive",
			"@param monitor Monitor to display progress and/or cancel operation",
			"@throws " + IO_EXCEPTION,
			"@throws " + FILE_NOT_FOUND_EXCEPTION,
			"@throws InterruptedException"
		);
		sc.add("private void unzip(" + ZIP_FILE + " zipFile, " + FILE + " projectFolderFile, " + I_PROGRESS_MONITOR + " monitor) throws " + IO_EXCEPTION + ", " + FILE_NOT_FOUND_EXCEPTION + ", InterruptedException {");
		sc.addLineBreak();
		sc.add(ENUMERATION + "<? extends " + ZIP_ENTRY + "> e = zipFile.entries();");
		sc.addLineBreak();
		sc.add("while (e.hasMoreElements()) {");
		sc.add(ZIP_ENTRY + " zipEntry = (" + ZIP_ENTRY + ") e.nextElement();");
		sc.add(FILE + " file = new " + FILE + "(projectFolderFile, zipEntry.getName());");
		sc.addLineBreak();
		sc.add("if (false == zipEntry.isDirectory()) {");
		sc.addLineBreak();
		sc.addComment("Copy files (and make sure parent directory exist)");
		
		sc.add(FILE + " parentFile = file.getParentFile();");
		sc.add("if (null != parentFile && false == parentFile.exists()) {");
		sc.add("parentFile.mkdirs();");
		sc.add("}");
		sc.addLineBreak();
		sc.add(PATH + " path = new " + PATH + "(file.getPath());");
		sc.add("if (\"java\".equals(path.getFileExtension())) {");
		sc.add(INPUT_STREAM_READER + " is = null;");
		sc.add(OUTPUT_STREAM_WRITER + " os = null;");
		sc.addLineBreak();
		sc.add("try {");
		sc.add("is = new " + INPUT_STREAM_READER + "(zipFile.getInputStream(zipEntry), \"ISO-8859-1\");");
		sc.add("os = new " + OUTPUT_STREAM_WRITER + "(new " + FILE_OUTPUT_STREAM + "(file), " + RESOURCES_PLUGIN + ".getEncoding());");
		sc.add("char[] buffer = new char[102400];");
		sc.add("while (true) {");
		sc.add("int len = is.read(buffer);");
		sc.add("if (len < 0)");
		sc.add("break;");
		sc.add("os.write(buffer, 0, len);");
		sc.add("}");
		sc.add("} finally {");
		sc.add("if (null != is) {");
		sc.add("is.close();");
		sc.add("}");
		sc.add("if (null != os) {");
		sc.add("os.close();");
		sc.add("}");
		sc.add("}");
		sc.add("} else {");
		sc.add(INPUT_STREAM + " is = null;");
		sc.add(OUTPUT_STREAM + " os = null;");
		sc.addLineBreak();
		sc.add("try {");
		sc.add("is = zipFile.getInputStream(zipEntry);");
		sc.add("os = new " + FILE_OUTPUT_STREAM + "(file);");
		sc.addLineBreak();
		sc.add("byte[] buffer = new byte[102400];");
		sc.add("while (true) {");
		sc.add("int len = is.read(buffer);");
		sc.add("if (len < 0)");
		sc.add("break;");
		sc.add("os.write(buffer, 0, len);");
		sc.add("}");
		sc.add("} finally {");
		sc.add("if (null != is) {");
		sc.add("is.close();");
		sc.add("}");
		sc.add("if (null != os) {");
		sc.add("os.close();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("monitor.worked(1);");
		sc.addLineBreak();
		sc.add("if (monitor.isCanceled()) {");
		sc.add("throw new InterruptedException();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRenameProjectMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Renames the specified project to the specified name",
			"@param project Project to rename",
			"@param projectName New name for the project",
			"@throws " + CORE_EXCEPTION
		);
		sc.add("private void renameProject(" + I_PROJECT + " project, String projectName) throws " + CORE_EXCEPTION + " {");
		sc.add(I_PROJECT_DESCRIPTION + " description = project.getDescription();");
		sc.add("description.setName(projectName);");
		sc.add("project.move(description, " + I_RESOURCE + ".FORCE | " + I_RESOURCE + ".SHALLOW, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Creates the sole wizard page contributed by this base implementation; the " +
			"standard Eclipse WizardNewProjectCreationPage.",
			"@see " + WIZARD_NEW_PROJECT_CREATION_PAGE + "#" + WIZARD_NEW_PROJECT_CREATION_PAGE + "(String)"
		);
		sc.add("public void init(" + I_WORKBENCH + " workbench, " + I_STRUCTURED_SELECTION + " selection) {");
		sc.addComment("Set default image for all wizard pages");
		sc.add(I_PATH + " path = new " + PATH + "(\"icons/" + UIConstants.Icon.DEFAULT_NEW_PROJECT_WIZBAN.getFilename() + "\");");
		sc.add(BUNDLE + " bundle = " + uiPluginActivatorClassName + ".getDefault().getBundle();");
		sc.add(URL + " url = " + FILE_LOCATOR + ".find(bundle, path, null);");
		sc.add(IMAGE_DESCRIPTOR + " descriptor = " + IMAGE_DESCRIPTOR + ".createFromURL(url);");
		sc.add("setDefaultPageImageDescriptor(descriptor);");
		sc.addLineBreak();
		sc.add("wizardNewProjectCreationPage = new " + WIZARD_NEW_PROJECT_CREATION_PAGE + "(pageName);");
		sc.add("wizardNewProjectCreationPage.setTitle(pageTitle);");
		sc.add("wizardNewProjectCreationPage.setDescription(pageDescription);");
		sc.add("wizardNewProjectCreationPage.setInitialProjectName(pageProjectName);");
		sc.addLineBreak();
		sc.add("this.addPage(wizardNewProjectCreationPage);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetInitializationDataMethod(JavaComposite sc) {
		sc.add("public void setInitializationData(" + I_CONFIGURATION_ELEMENT + " configIn, String propertyName, Object data) throws " + CORE_EXCEPTION + " {");
		sc.add("config = configIn;");
		sc.add("}");
		sc.addLineBreak();
	}
}
