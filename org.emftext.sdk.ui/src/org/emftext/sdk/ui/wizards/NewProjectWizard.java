package org.emftext.sdk.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.ui.jobs.CreateNewProjectJob;
import org.emftext.sdk.ui.jobs.WorkspaceMarker;

public class NewProjectWizard extends Wizard implements INewWizard {

	private IStructuredSelection selection;
	private NewProjectWizardPage page;

	public NewProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean performFinish() {
		final NewProjectParameters parameters = page.getParameters();
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
			new CreateNewProjectJob(parameters, new WorkspaceMarker()).run(monitor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	public void addPages() {
		page = new NewProjectWizardPage(selection);
		addPage(page);
	}
}
