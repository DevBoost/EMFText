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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.dbschema.resource.dbschema.ui;

public class DbschemaNewFileWizard extends org.eclipse.jface.wizard.Wizard implements org.eclipse.ui.INewWizard {
	
	private String categoryId = null;
	private DbschemaConnectionParameterPage connectionParameterPage;
	private DbschemaNewFileWizardPage containerAndName;
	private org.eclipse.jface.viewers.ISelection selection;
	private String newName = null;
	
	public DbschemaNewFileWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String id) {
		categoryId = id;
	}
	
	/**
	 * Adds the pages to the wizard.
	 */
	public void addPages() {
		connectionParameterPage = new DbschemaConnectionParameterPage(getFileExtension());
		addPage(connectionParameterPage);
		containerAndName = new org.emftext.language.dbschema.resource.dbschema.ui.DbschemaNewFileWizardPage(selection, getFileExtension());
		addPage(containerAndName);
	}
	
	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We will
	 * create an operation and run it using the wizard as execution context.
	 */
	public boolean performFinish() {
		final String containerName = containerAndName.getContainerName();
		final String fileName = containerAndName.getFileName();
		this.newName = fileName;
		int seperatorIdx = newName.indexOf('.');
		if (seperatorIdx != -1) {
			newName = newName.substring(0, seperatorIdx);
		}
		final org.eclipse.core.resources.IFile file;
		try {
			file = getFile(fileName, containerName);
		} catch (org.eclipse.core.runtime.CoreException e1) {
			org.emftext.language.dbschema.resource.dbschema.ui.DbschemaUIPlugin.logError("Exception while initializing new file", e1);
			return false;
		}
		
		if (file.exists()) {
			// ask for confirmation
			org.eclipse.swt.widgets.MessageBox messageBox = new org.eclipse.swt.widgets.MessageBox(getShell(), org.eclipse.swt.SWT.ICON_QUESTION			| org.eclipse.swt.SWT.YES | org.eclipse.swt.SWT.NO);
			messageBox.setMessage("File \"" + fileName + "\" already exists. Do you want to override it?");
			messageBox.setText("File exists");
			int response = messageBox.open();
			if (response == org.eclipse.swt.SWT.NO) {
				return true;
			}
		}
		
		org.eclipse.jface.operation.IRunnableWithProgress op = new org.eclipse.jface.operation.IRunnableWithProgress() {
			public void run(org.eclipse.core.runtime.IProgressMonitor monitor) throws java.lang.reflect.InvocationTargetException {
				try {
					doFinish(containerName, fileName, monitor);
				} catch (org.eclipse.core.runtime.CoreException e) {
					throw new java.lang.reflect.InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (java.lang.reflect.InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			org.eclipse.jface.dialogs.MessageDialog.openError(getShell(), "Error", realException.getMessage());
			org.emftext.language.dbschema.resource.dbschema.ui.DbschemaUIPlugin.logError("Exception while initializing new file", e);
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the file if missing or
	 * just replace its contents, and open the editor on the newly created file.
	 */
	private void doFinish(String containerName, String fileName, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		final org.eclipse.core.resources.IFile file = getFile(fileName, containerName);
		try {
			java.io.InputStream stream = openContentStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (java.io.IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				org.eclipse.ui.IWorkbenchPage page = org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					org.eclipse.ui.ide.IDE.openEditor(page, file, true);
				} catch (org.eclipse.ui.PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}
	
	private org.eclipse.core.resources.IFile getFile(String fileName, String containerName) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IWorkspaceRoot root = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot();
		org.eclipse.core.resources.IResource resource = root.findMember(new org.eclipse.core.runtime.Path(containerName));
		if (!resource.exists() || !(resource instanceof org.eclipse.core.resources.IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		org.eclipse.core.resources.IContainer container = (org.eclipse.core.resources.IContainer) resource;
		final org.eclipse.core.resources.IFile file = container.getFile(new org.eclipse.core.runtime.Path(fileName));
		return file;
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 */
	private java.io.InputStream openContentStream() {
		String content = connectionParameterPage.getResourceContent(newName);
		byte[] defaultContent = content.getBytes();
		return new java.io.ByteArrayInputStream(defaultContent);
	}

	private void throwCoreException(String message) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.runtime.IStatus status = new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, "NewFileContentPrinter", org.eclipse.core.runtime.IStatus.OK, message, null);
		throw new org.eclipse.core.runtime.CoreException(status);
	}
	
	/**
	 * We will accept the selection in the workbench to see if we can initialize from
	 * it.
	 * 
	 * @see IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(org.eclipse.ui.IWorkbench workbench, org.eclipse.jface.viewers.IStructuredSelection selection) {
		this.selection = selection;
	}
	
	public String getFileExtension() {
		return new org.emftext.language.dbschema.resource.dbschema.mopp.DbschemaMetaInformation().getSyntaxName();
	}
	
	public org.emftext.language.dbschema.resource.dbschema.IDbschemaMetaInformation getMetaInformation() {
		return new org.emftext.language.dbschema.resource.dbschema.mopp.DbschemaMetaInformation();
	}
	
}
