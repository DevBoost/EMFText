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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

// The "New" wizard page allows setting the container for the new file as well
// as the file name. The page will only accept file name without the extension
// OR with the extension that matches the expected one.
public class CsNewFileWizardPage extends org.eclipse.jface.wizard.WizardPage {
	
	private final String fileExtension;
	private org.eclipse.swt.widgets.Text containerText;
	private org.eclipse.swt.widgets.Text fileText;
	private org.eclipse.jface.viewers.ISelection selection;
	
	// Constructor for SampleNewWizardPage.
	//
	// @param pageName
	public CsNewFileWizardPage(org.eclipse.jface.viewers.ISelection selection, String fileExtension) {
		super("wizardPage");
		setTitle("EMFText File");
		setDescription("This wizard creates a new file with *." + fileExtension + " extension that can be opened with the EMFText editor.");
		this.selection = selection;
		this.fileExtension = fileExtension;
	}
	
	// @see IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	public void createControl(org.eclipse.swt.widgets.Composite parent) {
		org.eclipse.swt.widgets.Composite container = new org.eclipse.swt.widgets.Composite(parent, org.eclipse.swt.SWT.NULL);
		org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		org.eclipse.swt.widgets.Label label = new org.eclipse.swt.widgets.Label(container, org.eclipse.swt.SWT.NULL);
		label.setText("&Container:");
		
		containerText = new org.eclipse.swt.widgets.Text(container, org.eclipse.swt.SWT.BORDER | org.eclipse.swt.SWT.SINGLE);
		org.eclipse.swt.layout.GridData gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL);
		containerText.setLayoutData(gd);
		containerText.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				dialogChanged();
			}
		});
		
		org.eclipse.swt.widgets.Button button = new org.eclipse.swt.widgets.Button(container, org.eclipse.swt.SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				handleBrowse();
			}
		});
		label = new org.eclipse.swt.widgets.Label(container, org.eclipse.swt.SWT.NULL);
		label.setText("&File name:");
		
		fileText = new org.eclipse.swt.widgets.Text(container, org.eclipse.swt.SWT.BORDER | org.eclipse.swt.SWT.SINGLE);
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL);
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				dialogChanged();
			}
		});
		initialize();
		dialogChanged();
		setControl(container);
	}
	
	// Tests if the current workbench selection is a suitable container to use.
	
	private void initialize() {
		String name = "new_file";
		if (selection != null && selection.isEmpty() == false		&& selection instanceof org.eclipse.jface.viewers.IStructuredSelection) {
			org.eclipse.jface.viewers.IStructuredSelection ssel = (org.eclipse.jface.viewers.IStructuredSelection) selection;
			if (ssel.size() > 1)			return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof org.eclipse.core.resources.IResource) {
				org.eclipse.core.resources.IContainer container;
				if (obj instanceof org.eclipse.core.resources.IContainer) {
					container = (org.eclipse.core.resources.IContainer) obj;
				} else {
					org.eclipse.core.resources.IResource resource = (org.eclipse.core.resources.IResource) obj;
					container = resource.getParent();
					// we use the name of the currently selected file
					// instead of 'new_file'.
					name = resource.getFullPath().removeFileExtension().lastSegment();
				}
				org.eclipse.core.runtime.IPath fullPath = container.getFullPath();
				containerText.setText(fullPath.toString());
			}
		}
		fileText.setText(name + "." + fileExtension);
	}
	
	// Uses the standard container selection dialog to choose the new value for
	// the container field.
	
	private void handleBrowse() {
		org.eclipse.ui.dialogs.ContainerSelectionDialog dialog = new org.eclipse.ui.dialogs.ContainerSelectionDialog(		getShell(), org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot(), false,
		"Select new file container");
		if (dialog.open() == org.eclipse.ui.dialogs.ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				containerText.setText(((org.eclipse.core.runtime.Path) result[0]).toString());
			}
		}
	}
	
	// Ensures that both text fields are set.
	
	private void dialogChanged() {
		org.eclipse.core.resources.IResource container = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(new org.eclipse.core.runtime.Path(getContainerName()));
		String fileName = getFileName();
		
		if (getContainerName().length() == 0) {
			updateStatus("File container must be specified");
			return;
		}
		if (container == null		|| (container.getType() & (org.eclipse.core.resources.IResource.PROJECT | org.eclipse.core.resources.IResource.FOLDER)) == 0) {
			updateStatus("File container must exist");
			return;
		}
		if (!container.isAccessible()) {
			updateStatus("Project must be writable");
			return;
		}
		if (fileName.length() == 0) {
			updateStatus("File name must be specified");
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus("File name must be valid");
			return;
		}
		if (!fileName.endsWith("." + fileExtension)) {
			updateStatus("File extension must be \"" + fileExtension + "\"");
			return;
		}
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
	public String getContainerName() {
		return containerText.getText();
	}
	
	public String getFileName() {
		return fileText.getText();
	}
}
