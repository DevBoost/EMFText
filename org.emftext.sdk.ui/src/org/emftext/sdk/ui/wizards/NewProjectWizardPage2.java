package org.emftext.sdk.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;

public class NewProjectWizardPage2 extends WizardPage {

	private Button generateModelCodeButton;
	private Button generateEditCodeButton;
	private Button generateEditorCodeButton;
	private Button generateTestCodeButton;
	private Button generateResourceCodeButton;

	protected NewProjectWizardPage2() {
		super("wizardPage2");
		setTitle("Create EMFText project");
		setDescription("Select the code to be generated.");
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		
		generateModelCodeButton = new Button(container, SWT.CHECK);
		generateModelCodeButton.setText("Generate EMF model code");
		generateEditCodeButton = new Button(container, SWT.CHECK);
		generateEditCodeButton.setText("Generate EMF edit code");
		generateEditorCodeButton = new Button(container, SWT.CHECK);
		generateEditorCodeButton.setText("Generate EMF editor code");
		generateTestCodeButton = new Button(container, SWT.CHECK);
		generateTestCodeButton.setText("Generate EMF test code");
		generateResourceCodeButton = new Button(container, SWT.CHECK);
		generateResourceCodeButton.setText("Generate EMFText resource plug-ins");
		
		generateModelCodeButton.setSelection(true);
		generateEditCodeButton.setSelection(false);
		generateEditorCodeButton.setSelection(false);
		generateTestCodeButton.setSelection(false);
		generateResourceCodeButton.setSelection(true);
		
		setControl(container);
	}

	public void updateParameters(NewProjectParameters parameters) {
		parameters.setGenerateModelCode(generateModelCodeButton.getSelection());
		parameters.setGenerateEditCode(generateEditCodeButton.getSelection());
		parameters.setGenerateEditorCode(generateEditorCodeButton.getSelection());
		parameters.setGenerateTestCode(generateTestCodeButton.getSelection());
		parameters.setGenerateResourceCode(generateResourceCodeButton.getSelection());
	}
}
