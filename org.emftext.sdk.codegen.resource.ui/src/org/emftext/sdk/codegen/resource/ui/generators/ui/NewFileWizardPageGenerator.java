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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BUTTON;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CONTAINER_SELECTION_DIALOG;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.GRID_DATA;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.GRID_LAYOUT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ADAPTABLE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTAINER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PATH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LABEL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MODIFY_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MODIFY_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PATH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_ADAPTER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TEXT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.WIZARD_PAGE;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class NewFileWizardPageGenerator extends UIJavaBaseGenerator {

	public static final GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new NewFileWizardPageGenerator());

	private NewFileWizardPageGenerator() {
		super();
	}

	private NewFileWizardPageGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceUIArtifacts.NEW_FILE_WIZARD_PAGE);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new NewFileWizardPageGenerator(parent, context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The NewWizardPage allows setting the container for the new file, as well " +
			"as the file name. The page will only accept file names without extension " +
			"OR with an extension that matches the expected one."
		);
		sc.add("public class " + getResourceClassName() + " extends " + WIZARD_PAGE + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		return true;
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

	private void addHandleBrowseMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Uses the standard container selection dialog to choose the new value for " +
			"the container field."
		);
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

	private void addInitializeMethod(JavaComposite sc) {
		sc.addJavadoc("Tests if the current workbench selection is a suitable container to use.");
		sc.add("private void initialize() {");
		sc.add("String name = \"new_file\";");
		sc.add("if (selection != null && selection.isEmpty() == false");
		sc.add("&& selection instanceof " + I_STRUCTURED_SELECTION + ") {");
		sc.add(I_STRUCTURED_SELECTION + " ssel = (" + I_STRUCTURED_SELECTION + ") selection;");
		sc.add("if (ssel.size() > 1)");
		sc.add("return;");
		sc.add("Object obj = ssel.getFirstElement();");
		sc.addComment("test for IAdaptable");
		sc.add("if ((! (obj instanceof " + I_RESOURCE + ")) && (obj instanceof " + I_ADAPTABLE + ")) {");
		sc.add("obj = (" + I_RESOURCE + ") ((" + I_ADAPTABLE + ") obj).getAdapter(" + I_RESOURCE + ".class);");
		sc.add("}");
		sc.add("if (obj instanceof " + I_RESOURCE + ") {");
		sc.add(I_CONTAINER + " container;");
		sc.add("if (obj instanceof " + I_CONTAINER + ") {");
		sc.add("container = (" + I_CONTAINER + ") obj;");
		sc.add("} else {");
		sc.add(I_RESOURCE + " resource = (" + I_RESOURCE + ") obj;");
		sc.add("container = resource.getParent();");
		sc.addComment("we use the name of the currently selected file instead of 'new_file'.");
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

	private void addCreateControlMethod(JavaComposite sc) {
		sc.addJavadoc("@see IDialogPage#createControl(" + COMPOSITE + ")");
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

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc("Constructor for NewWizardPage.");
		sc.add("public " + getResourceClassName() + "(" + I_SELECTION + " selection, String fileExtension) {");
		sc.add("super(\"wizardPage\");");
		sc.add("setTitle(\"Create new " + getContext().getConcreteSyntax().getName() + " file\");");
		sc.add("setDescription(\"This wizard creates a new file with *.\" + fileExtension + \" extension that can be opened with the EMFText editor.\");");
		sc.add("this.selection = selection;");
		sc.add("this.fileExtension = fileExtension;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private final String fileExtension;");
		sc.add("private " + TEXT + " containerText;");
		sc.add("private " + TEXT + " fileText;");
		sc.add("private " + I_SELECTION + " selection;");
		sc.addLineBreak();
	}
}
