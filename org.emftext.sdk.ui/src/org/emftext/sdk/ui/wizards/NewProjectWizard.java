/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin;
import org.emftext.sdk.ui.jobs.CreateNewEMFTextProjectJob;
import org.emftext.sdk.ui.jobs.WorkspaceMarker;
import org.osgi.framework.Bundle;

public class NewProjectWizard extends Wizard implements INewWizard {

	private NewProjectWizardPage1 page1;
	private NewProjectWizardPage2 page2;

	public NewProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean performFinish() {
		final NewProjectParameters parameters = page1.getParameters();
		page2.updateParameters(parameters);
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(parameters, monitor);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}

	private void doFinish(NewProjectParameters parameters, IProgressMonitor monitor) {
		try {
			new CreateNewEMFTextProjectJob(parameters, new WorkspaceMarker()).run(monitor);
		} catch (Exception e) {
			EMFTextSDKPlugin.logError("Error while creating new EMFText project.", e);
		}
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// set default image for all wizard pages
		org.eclipse.core.runtime.IPath path = new org.eclipse.core.runtime.Path("icons/new_project_wizban.gif");
		Bundle bundle = CsUIPlugin.getDefault().getBundle();
		URL url = org.eclipse.core.runtime.FileLocator.find(bundle, path, null);
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.eclipse.jface.resource.ImageDescriptor.createFromURL(url);
	    setDefaultPageImageDescriptor(descriptor);
	}

	public void addPages() {
		page1 = new NewProjectWizardPage1();
		page2 = new NewProjectWizardPage2();
		addPage(page1);
		addPage(page2);
	}
}
