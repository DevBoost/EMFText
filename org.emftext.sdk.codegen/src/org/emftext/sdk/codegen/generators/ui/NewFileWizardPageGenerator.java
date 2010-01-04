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
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BUTTON;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.CONTAINER_SELECTION_DIALOG;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.GRID_DATA;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.GRID_LAYOUT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_CONTAINER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PATH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LABEL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MODIFY_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MODIFY_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PATH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_ADAPTER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TEXT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.WIZARD_PAGE;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class NewFileWizardPageGenerator extends JavaBaseGenerator {

	public NewFileWizardPageGenerator() {
		super();
	}

	private NewFileWizardPageGenerator(GenerationContext context) {
		super(context, EArtifact.NEW_FILE_WIZARD_PAGE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new NewFileWizardPageGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// The NewWizardPage allows setting the container for the new file, as well");
		sc.add("// as the file name. The page will only accept file name without the extension");
		sc.add("// OR with the extension that matches the expected one.");
		sc.add("public class " + getResourceClassName() + " extends " + WIZARD_PAGE + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
		addCreateControlMethod(sc);
		addInitializeMethod(sc);
		addHandleBrowseMethod(sc);
		addDialogChangedMethod(sc);
		addUpdateStatusMethod(sc);
		addGetContainerNameMethod(sc);
		addGetFileNameMethod(sc);
	}

	private void addGetFileNameMethod(StringComposite sc) {
		sc.add("public String getFileName() {");
		sc.add("return fileText.getText();");
		sc.add("}");
	}

	private void addGetContainerNameMethod(StringComposite sc) {
		sc.add("public String getContainerName() {");
		sc.add("return containerText.getText();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addUpdateStatusMethod(StringComposite sc) {
		sc.add("private void updateStatus(String message) {");
		sc.add("setErrorMessage(message);");
		sc.add("setPageComplete(message == null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDialogChangedMethod(StringComposite sc) {
		sc.add("// Ensures that both text fields are set.");
		sc.add("private void dialogChanged() {");
		sc.add(I_RESOURCE + " container = " + RESOURCES_PLUGIN + ".getWorkspace().getRoot().findMember(new " + PATH + "(getContainerName()));");
		sc.add("String fileName = getFileName();");
		sc.addLineBreak();
		sc.add("if (getContainerName().length() == 0) {");
		sc.add("updateStatus(\"File container must be specified\");");
		sc.add("return;");
		sc.add("}");
		sc.add("if (container == null || (container.getType() & (" + I_RESOURCE + ".PROJECT | " + I_RESOURCE + ".FOLDER)) == 0) {");
		sc.add("updateStatus(\"File container must exist\");");
		sc.add("return;");
		sc.add("}");
		sc.add("if (!container.isAccessible()) {");
		sc.add("updateStatus(\"Project must be writable\");");
		sc.add("return;");
		sc.add("}");
		sc.add("if (fileName.length() == 0) {");
		sc.add("updateStatus(\"File name must be specified\");");
		sc.add("return;");
		sc.add("}");
		sc.add("if (fileName.replace('\\\\', '/').indexOf('/', 1) > 0) {");
		sc.add("updateStatus(\"File name must be valid\");");
		sc.add("return;");
		sc.add("}");
		sc.add("if (!fileName.endsWith(\".\" + fileExtension)) {");
		sc.add("updateStatus(\"File extension must be \\\"\" + fileExtension + \"\\\"\");");
		sc.add("return;");
		sc.add("}");
		sc.add("updateStatus(null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleBrowseMethod(StringComposite sc) {
		sc.add("// Uses the standard container selection dialog to choose the new value for");
		sc.add("// the container field.");
		sc.add("private void handleBrowse() {");
		sc.add(CONTAINER_SELECTION_DIALOG + " dialog = new " + CONTAINER_SELECTION_DIALOG + "(");
		sc.add("getShell(), " + RESOURCES_PLUGIN + ".getWorkspace().getRoot(), false,");
		sc.add("\"Select new file container\");");
		sc.add("if (dialog.open() == " + CONTAINER_SELECTION_DIALOG + ".OK) {");
		sc.add("Object[] result = dialog.getResult();");
		sc.add("if (result.length == 1) {");
		sc.add("containerText.setText(((" + PATH + ") result[0]).toString());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeMethod(StringComposite sc) {
		sc.add("// Tests if the current workbench selection is a suitable container to use.");
		sc.add("private void initialize() {");
		sc.add("String name = \"new_file\";");
		sc.add("if (selection != null && selection.isEmpty() == false");
		sc.add("&& selection instanceof " + I_STRUCTURED_SELECTION + ") {");
		sc.add(I_STRUCTURED_SELECTION + " ssel = (" + I_STRUCTURED_SELECTION + ") selection;");
		sc.add("if (ssel.size() > 1)");
		sc.add("return;");
		sc.add("Object obj = ssel.getFirstElement();");
		sc.add("if (obj instanceof " + I_RESOURCE + ") {");
		sc.add(I_CONTAINER + " container;");
		sc.add("if (obj instanceof " + I_CONTAINER + ") {");
		sc.add("container = (" + I_CONTAINER + ") obj;");
		sc.add("} else {");
		sc.add(I_RESOURCE + " resource = (" + I_RESOURCE + ") obj;");
		sc.add("container = resource.getParent();");
		sc.add("// we use the name of the currently selected file");
		sc.add("// instead of 'new_file'.");
		sc.add("name = resource.getFullPath().removeFileExtension().lastSegment();");
		sc.add("}");
		sc.add(I_PATH + " fullPath = container.getFullPath();");
		sc.add("containerText.setText(fullPath.toString());");
		sc.add("}");
		sc.add("}");
		sc.add("fileText.setText(name + \".\" + fileExtension);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateControlMethod(StringComposite sc) {
		sc.add("// @see IDialogPage#createControl(" + COMPOSITE + ")");
		sc.add("public void createControl(" + COMPOSITE + " parent) {");
		sc.add(COMPOSITE + " container = new " + COMPOSITE + "(parent, " + SWT + ".NULL);");
		sc.add(GRID_LAYOUT + " layout = new " + GRID_LAYOUT + "();");
		sc.add("container.setLayout(layout);");
		sc.add("layout.numColumns = 3;");
		sc.add("layout.verticalSpacing = 9;");
		sc.add(LABEL + " label = new " + LABEL + "(container, " + SWT + ".NULL);");
		sc.add("label.setText(\"&Container:\");");
		sc.addLineBreak();
		sc.add("containerText = new " + TEXT + "(container, " + SWT + ".BORDER | " + SWT + ".SINGLE);");
		sc.add(GRID_DATA + " gd = new " + GRID_DATA + "(" + GRID_DATA + ".FILL_HORIZONTAL);");
		sc.add("containerText.setLayoutData(gd);");
		sc.add("containerText.addModifyListener(new " + MODIFY_LISTENER + "() {");
		sc.add("public void modifyText(" + MODIFY_EVENT + " e) {");
		sc.add("dialogChanged();");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.add(BUTTON + " button = new " + BUTTON + "(container, " + SWT + ".PUSH);");
		sc.add("button.setText(\"Browse...\");");
		sc.add("button.addSelectionListener(new " + SELECTION_ADAPTER + "() {");
		sc.add("public void widgetSelected(" + SELECTION_EVENT + " e) {");
		sc.add("handleBrowse();");
		sc.add("}");
		sc.add("});");
		sc.add("label = new " + LABEL + "(container, " + SWT + ".NULL);");
		sc.add("label.setText(\"&File name:\");");
		sc.addLineBreak();
		sc.add("fileText = new " + TEXT + "(container, " + SWT + ".BORDER | " + SWT + ".SINGLE);");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".FILL_HORIZONTAL);");
		sc.add("fileText.setLayoutData(gd);");
		sc.add("fileText.addModifyListener(new " + MODIFY_LISTENER + "() {");
		sc.add("public void modifyText(" + MODIFY_EVENT + " e) {");
		sc.add("dialogChanged();");
		sc.add("}");
		sc.add("});");
		sc.add("initialize();");
		sc.add("dialogChanged();");
		sc.add("setControl(container);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("// Constructor for NewWizardPage.");
		sc.add("//");
		sc.add("// @param pageName");
		sc.add("public " + getResourceClassName() + "(" + I_SELECTION + " selection, String fileExtension) {");
		sc.add("super(\"wizardPage\");");
		sc.add("setTitle(\"Create new " + getContext().getConcreteSyntax().getName() + " file\");");
		sc.add("setDescription(\"This wizard creates a new file with *.\" + fileExtension + \" extension that can be opened with the EMFText editor.\");");
		sc.add("this.selection = selection;");
		sc.add("this.fileExtension = fileExtension;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private final String fileExtension;");
		sc.add("private " + TEXT + " containerText;");
		sc.add("private " + TEXT + " fileText;");
		sc.add("private " + I_SELECTION + " selection;");
		sc.addLineBreak();
	}
}
