package org.emftext.sdk.ui.wizards;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.emftext.sdk.codegen.newproject.creators.NewProjectParameters;

public class NewProjectWizardPage extends WizardPage {
	
	private Text namespaceUriText;
	private Text basePackageText;
	private Text namespacePrefixText;
	private Text metamodelNameText;
	private Text ecoreFileText;
	private Text syntaxFileText;
	private Text genmodelFileText;
	private Text metamodelFolderText;
	private Text syntaxNameText;
	private Text srcFolderText;
	private Text pluginNameText;

	private Button deriveModelFileNames;

	private boolean isChanging;

	public NewProjectWizardPage(IStructuredSelection selection) {
		super("wizardPage");
		setTitle("Create EMFText project");
		setDescription("This wizard creates a new EMFText project.");
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		
		createLabel(container, "&Metamodel Name:");
		metamodelNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, metamodelNameText);
		
		createLabel(container, "&Namespace Prefix:");
		namespacePrefixText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, namespacePrefixText);
		
		createLabel(container, "&Namespace URI:");
		namespaceUriText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, namespaceUriText);

		createLabel(container, "&Plugin Name:");
		pluginNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, pluginNameText);
		
		createLabel(container, "&Base Package:");
		basePackageText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, basePackageText);
		
		createLabel(container, "&Metamodel Folder:");
		metamodelFolderText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, metamodelFolderText);
		
		createLabel(container, "&Generated Code Folder:");
		srcFolderText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, srcFolderText);
		
		createLabel(container, "&Syntax Name (File Extension):");
		syntaxNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, syntaxNameText);
		
		createLabel(container, "&Ecore File Name:");
		ecoreFileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, ecoreFileText);
		
		createLabel(container, "&Syntax File Name:");
		syntaxFileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, syntaxFileText);
		
		createLabel(container, "&GenModel File Name:");
		genmodelFileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		createTextInput(container, genmodelFileText);
		
		deriveModelFileNames = new Button(container, SWT.CHECK);
		deriveModelFileNames.setText("derive file names from metamodel name");
		deriveModelFileNames.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				dialogChanged();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		initialize();
		dialogChanged();
		setControl(container);
	}

	private void createTextInput(Composite container, Text text) {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(gd);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
	}

	private void createLabel(Composite container, String labelText) {
		Label label = new Label(container, SWT.NULL);
		label.setText(labelText);
	}

	private void initialize() {
		metamodelNameText.setText("myDSL");
		deriveModelFileNames.setSelection(true);
		metamodelFolderText.setText("metamodel");
		srcFolderText.setText("src-gen");
	}

	private synchronized void dialogChanged() {
		if (isChanging) {
			return;
		}
		isChanging = true;
		boolean enabled = deriveModelFileNames.getSelection();
		if (enabled) {
			String metaModelName = metamodelNameText.getText();
			syntaxNameText.setText(metaModelName);
			namespacePrefixText.setText(metaModelName);
			namespaceUriText.setText("http://www.emftext.org/language/" + metaModelName);
			ecoreFileText.setText(metaModelName + ".ecore");
			genmodelFileText.setText(metaModelName + ".genmodel");
			syntaxFileText.setText(metaModelName + ".cs");
			pluginNameText.setText("org.emftext.language." + metaModelName);
			basePackageText.setText("org.emftext.language." + metaModelName);
		}
		setEnabled(
				!enabled,
				syntaxNameText,
				namespacePrefixText,
				namespaceUriText,
				ecoreFileText,
				genmodelFileText,
				syntaxFileText,
				basePackageText,
				pluginNameText
			);
		checkNotEmpty(syntaxNameText, "Syntax name must be specified");
		updateStatus(null);
		isChanging = false;
	}

	private void setEnabled(boolean enabled, Text... texts) {
		for (Text text : texts) {
			text.setEnabled(enabled);
		}
	}

	private void checkNotEmpty(Text textWidget, String errorMessage) {
		String text = textWidget.getText();
		if (text.length() == 0) {
			updateStatus(errorMessage);
		}
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public NewProjectParameters getParameters() {
		NewProjectParameters parameters = new NewProjectParameters(
				metamodelNameText.getText(),
				namespaceUriText.getText(),
				namespacePrefixText.getText(),
				pluginNameText.getText(),
				basePackageText.getText(),
				ecoreFileText.getText(),
				syntaxFileText.getText(),
				genmodelFileText.getText(),
				metamodelFolderText.getText(),
				syntaxNameText.getText(),
				srcFolderText.getText()
		);
		return parameters;
	}
}
