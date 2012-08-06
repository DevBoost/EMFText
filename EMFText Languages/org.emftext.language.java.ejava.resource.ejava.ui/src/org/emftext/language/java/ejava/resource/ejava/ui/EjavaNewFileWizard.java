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
package org.emftext.language.java.ejava.resource.ejava.ui;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public class EjavaNewFileWizard extends org.eclipse.jface.wizard.Wizard implements org.eclipse.ui.INewWizard {
	
	private String categoryId = null;
	private org.emftext.language.java.ejava.resource.ejava.ui.EjavaNewFileWizardPage page;
	private org.eclipse.jface.viewers.ISelection selection;
	
	public EjavaNewFileWizard() {
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
		page = new org.emftext.language.java.ejava.resource.ejava.ui.EjavaNewFileWizardPage(selection, getFileExtension());
		addPage(page);
	}
	
	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We will
	 * create an operation and run it using the wizard as execution context.
	 */
	public boolean performFinish() {
		final IFile file = page.getEJavaFile();
		final EPackage metamodel = page.getSelectedMetamodel();
		final EClass metaclass = page.getSelectedMetaclass();
		final GenModel genmodel = page.getGenmodel();
		if (file.exists()) {
			// ask for confirmation
			org.eclipse.swt.widgets.MessageBox messageBox = new org.eclipse.swt.widgets.MessageBox(getShell(), org.eclipse.swt.SWT.ICON_QUESTION			| org.eclipse.swt.SWT.YES | org.eclipse.swt.SWT.NO);
			messageBox.setMessage("A file for metaclass \"" + metaclass.getName() + "\" already exists. Do you want to override it?");
			messageBox.setText("File exists");
			int response = messageBox.open();
			if (response == org.eclipse.swt.SWT.NO) {
				return true;
			}
		}
		
		org.eclipse.jface.operation.IRunnableWithProgress op = new org.eclipse.jface.operation.IRunnableWithProgress() {
			public void run(org.eclipse.core.runtime.IProgressMonitor monitor) throws java.lang.reflect.InvocationTargetException {
				try {
					doFinish(file, metamodel, genmodel, metaclass, monitor);
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
			org.emftext.language.java.ejava.resource.ejava.ui.EjavaUIPlugin.logError("Exception while initializing new file", e);
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the file if missing or
	 * just replace its contents, and open the editor on the newly created file.
	 */
	private void doFinish(final IFile file, EPackage metamodel, GenModel genmodel, EClass metaclass, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		// create a sample file
		monitor.beginTask("Creating " + file.getName(), 2);
		try {
			java.io.InputStream stream = openContentStream(metaclass.getEPackage(), genmodel, metaclass);
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				IContainer parent = file.getParent();
				if(parent instanceof IFolder && !parent.exists()){
					((IFolder) parent).create(true, true, monitor);
				}
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
	
	/**
	 * We will initialize file contents with a sample text.
	 * @param metaclass 
	 * @param metamodel 
	 * @param genmodel 
	 */
	private java.io.InputStream openContentStream(EPackage metamodel, GenModel genmodel, EClass metaclass) {
		return new java.io.ByteArrayInputStream(new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation().getNewFileContentProvider().getNewFileContent(metamodel, genmodel, metaclass).getBytes());
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
		return new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation().getSyntaxName();
	}
	
	public org.emftext.language.java.ejava.resource.ejava.IEjavaMetaInformation getMetaInformation() {
		return new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation();
	}
	
}
