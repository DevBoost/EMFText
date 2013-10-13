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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BUTTON;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CONTAINER_SELECTION_DIALOG;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.GRID_DATA;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.GRID_LAYOUT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ADAPTABLE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONTAINER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PATH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.LABEL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MODIFY_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MODIFY_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PATH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_ADAPTER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.TEXT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.WIZARD_PAGE;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class NewFileWizardPageGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The NewFileWizardPage allows setting the container for the new file, as well " +
			"as the file name. The page will only accept file names without extension " +
			"OR with an extension that matches the expected one."
		);
		sc.add("public class " + getResourceClassName() + " extends " + WIZARD_PAGE(sc) + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
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

	private void addDialogChangedMethod(JavaComposite sc) {
		sc.addJavadoc("Ensures that both text fields are set.");
		sc.add("private void dialogChanged() {");
		sc.add(I_RESOURCE(sc) + " container = " + RESOURCES_PLUGIN(sc) + ".getWorkspace().getRoot().findMember(new " + PATH(sc) + "(getContainerName()));");
		sc.add("String fileName = getFileName();");
		sc.addLineBreak();
		sc.add("if (getContainerName().length() == 0) {");
		sc.add("updateStatus(\"File container must be specified\");");
		sc.add("return;");
		sc.add("}");
		sc.add("if (container == null || (container.getType() & (" + I_RESOURCE(sc) + ".PROJECT | " + I_RESOURCE(sc) + ".FOLDER)) == 0) {");
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

	private void addHandleBrowseMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Uses the standard container selection dialog to choose the new value for " +
			"the container field."
		);
		sc.add("private void handleBrowse() {");
		sc.add(CONTAINER_SELECTION_DIALOG(sc) + " dialog = new " + CONTAINER_SELECTION_DIALOG(sc) + "(getShell(), " + RESOURCES_PLUGIN(sc) + ".getWorkspace().getRoot(), false, \"Select new file container\");");
		sc.add("if (dialog.open() == " + CONTAINER_SELECTION_DIALOG(sc) + ".OK) {");
		sc.add("Object[] result = dialog.getResult();");
		sc.add("if (result.length == 1) {");
		sc.add("containerText.setText(((" + PATH(sc) + ") result[0]).toString());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeMethod(JavaComposite sc) {
		sc.addJavadoc("Tests if the current workbench selection is a suitable container to use.");
		sc.add("private void initialize() {");
		sc.add("String name = \"new_file\";");
		sc.add("if (selection != null && selection.isEmpty() == false && selection instanceof " + I_STRUCTURED_SELECTION(sc) + ") {");
		sc.add(I_STRUCTURED_SELECTION(sc) + " ssel = (" + I_STRUCTURED_SELECTION(sc) + ") selection;");
		sc.add("if (ssel.size() > 1) {");
		sc.add("return;");
		sc.add("}");
		sc.add("Object obj = ssel.getFirstElement();");
		sc.addComment("test for IAdaptable");
		sc.add("if ((! (obj instanceof " + I_RESOURCE(sc) + ")) && (obj instanceof " + I_ADAPTABLE(sc) + ")) {");
		sc.add("obj = (" + I_RESOURCE(sc) + ") ((" + I_ADAPTABLE(sc) + ") obj).getAdapter(" + I_RESOURCE(sc) + ".class);");
		sc.add("}");
		sc.add("if (obj instanceof " + I_RESOURCE(sc) + ") {");
		sc.add(I_CONTAINER(sc) + " container;");
		sc.add("if (obj instanceof " + I_CONTAINER(sc) + ") {");
		sc.add("container = (" + I_CONTAINER(sc) + ") obj;");
		sc.add("} else {");
		sc.add(I_RESOURCE(sc) + " resource = (" + I_RESOURCE(sc) + ") obj;");
		sc.add("container = resource.getParent();");
		sc.addComment("we use the name of the currently selected file instead of 'new_file'.");
		sc.add("name = resource.getFullPath().removeFileExtension().lastSegment();");
		sc.add("}");
		sc.add(I_PATH(sc) + " fullPath = container.getFullPath();");
		sc.add("containerText.setText(fullPath.toString());");
		sc.add("}");
		sc.add("}");
		sc.add("fileText.setText(name + \".\" + fileExtension);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateControlMethod(JavaComposite sc) {
		sc.addJavadoc("@see IDialogPage#createControl(" + COMPOSITE(sc) + ")");
		sc.add("public void createControl(" + COMPOSITE(sc) + " parent) {");
		sc.add(COMPOSITE(sc) + " container = new " + COMPOSITE(sc) + "(parent, " + SWT(sc) + ".NULL);");
		sc.add(GRID_LAYOUT(sc) + " layout = new " + GRID_LAYOUT(sc) + "();");
		sc.add("container.setLayout(layout);");
		sc.add("layout.numColumns = 3;");
		sc.add("layout.verticalSpacing = 9;");
		sc.add(LABEL(sc) + " label = new " + LABEL(sc) + "(container, " + SWT(sc) + ".NULL);");
		sc.add("label.setText(\"&Container:\");");
		sc.addLineBreak();
		sc.add("containerText = new " + TEXT(sc) + "(container, " + SWT(sc) + ".BORDER | " + SWT(sc) + ".SINGLE);");
		sc.add(GRID_DATA(sc) + " gd = new " + GRID_DATA(sc) + "(" + GRID_DATA(sc) + ".FILL_HORIZONTAL);");
		sc.add("containerText.setLayoutData(gd);");
		sc.add("containerText.addModifyListener(new " + MODIFY_LISTENER(sc) + "() {");
		sc.add("public void modifyText(" + MODIFY_EVENT(sc) + " e) {");
		sc.add("dialogChanged();");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.add(BUTTON(sc) + " button = new " + BUTTON(sc) + "(container, " + SWT(sc) + ".PUSH);");
		sc.add("button.setText(\"Browse...\");");
		sc.add("button.addSelectionListener(new " + SELECTION_ADAPTER(sc) + "() {");
		sc.add("public void widgetSelected(" + SELECTION_EVENT(sc) + " e) {");
		sc.add("handleBrowse();");
		sc.add("}");
		sc.add("});");
		sc.add("label = new " + LABEL(sc) + "(container, " + SWT(sc) + ".NULL);");
		sc.add("label.setText(\"&File name:\");");
		sc.addLineBreak();
		sc.add("fileText = new " + TEXT(sc) + "(container, " + SWT(sc) + ".BORDER | " + SWT(sc) + ".SINGLE);");
		sc.add("gd = new " + GRID_DATA(sc) + "(" + GRID_DATA(sc) + ".FILL_HORIZONTAL);");
		sc.add("fileText.setLayoutData(gd);");
		sc.add("fileText.addModifyListener(new " + MODIFY_LISTENER(sc) + "() {");
		sc.add("public void modifyText(" + MODIFY_EVENT(sc) + " e) {");
		sc.add("dialogChanged();");
		sc.add("}");
		sc.add("});");
		sc.add("initialize();");
		sc.add("dialogChanged();");
		sc.add("setControl(container);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		String syntaxName = getContext().getConcreteSyntax().getName();

		sc.addJavadoc("Constructor for the NewFileWizardPage.");
		sc.add("public " + getResourceClassName() + "(" + I_SELECTION(sc) + " selection, String fileExtension) {");
		sc.add("super(\"wizardPage\");");
		sc.add("setTitle(\"Create new " + syntaxName + " file\");");
		sc.add("setDescription(\"This wizard creates a new file with *.\" + fileExtension + \" extension that can be opened with the EMFText editor.\");");
		sc.add("this.selection = selection;");
		sc.add("this.fileExtension = fileExtension;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final String fileExtension;");
		sc.add("private " + TEXT(sc) + " containerText;");
		sc.add("private " + TEXT(sc) + " fileText;");
		sc.add("private " + I_SELECTION(sc) + " selection;");
		sc.addLineBreak();
	}
}
