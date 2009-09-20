package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.GenerationContext;
import java.io.PrintWriter;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.IGenerator;

public class NewFileWizardPageGenerator extends BaseGenerator {

	public NewFileWizardPageGenerator() {
		super();
	}

	private NewFileWizardPageGenerator(GenerationContext context) {
		super(context, EArtifact.NEW_FILE_WIZARD_PAGE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new NewFileWizardPageGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// The \"New\" wizard page allows setting the container for the new file as well");
		sc.add("// as the file name. The page will only accept file name without the extension");
		sc.add("// OR with the extension that matches the expected one.");
		sc.add("public class " + getResourceClassName() + " extends " + WIZARD_PAGE + " {");
		sc.addLineBreak();
		addFields(sc);
		
		sc.add("// Constructor for SampleNewWizardPage.");
		sc.add("//");
		sc.add("// @param pageName");
		sc.add("public " + getResourceClassName() + "(" + I_SELECTION + " selection, String fileExtension) {");
		sc.add("super(\"wizardPage\");");
		// TODO set other title
		sc.add("setTitle(\"EMFText File\");");
		sc.add("setDescription(\"This wizard creates a new file with *.\" + fileExtension + \" extension that can be opened with the EMFText editor.\");");
		sc.add("this.selection = selection;");
		sc.add("this.fileExtension = fileExtension;");
		sc.add("}");
		sc.addLineBreak();
		
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
		
		sc.add("// Tests if the current workbench selection is a suitable container to use.");
		
		sc.addLineBreak();
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
		
		sc.add("// Uses the standard container selection dialog to choose the new value for");
		sc.add("// the container field.");
		
		sc.addLineBreak();
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
		
		sc.add("// Ensures that both text fields are set.");
		
		sc.addLineBreak();
		sc.add("private void dialogChanged() {");
		sc.add(I_RESOURCE + " container = " + RESOURCES_PLUGIN + ".getWorkspace().getRoot().findMember(new " + PATH + "(getContainerName()));");
		sc.add("String fileName = getFileName();");
		sc.addLineBreak();
		sc.add("if (getContainerName().length() == 0) {");
		sc.add("updateStatus(\"File container must be specified\");");
		sc.add("return;");
		sc.add("}");
		sc.add("if (container == null");
		sc.add("|| (container.getType() & (" + I_RESOURCE + ".PROJECT | " + I_RESOURCE + ".FOLDER)) == 0) {");
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
		sc.add("private void updateStatus(String message) {");
		sc.add("setErrorMessage(message);");
		sc.add("setPageComplete(message == null);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getContainerName() {");
		sc.add("return containerText.getText();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getFileName() {");
		sc.add("return fileText.getText();");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private final String fileExtension;");
		sc.add("private " + TEXT + " containerText;");
		sc.add("private " + TEXT + " fileText;");
		sc.add("private " + I_SELECTION + " selection;");
		sc.addLineBreak();
	}
}
