package org.emftext.sdk.ui.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.emftext.sdk.ui.jobs.GenerateResourceJob;

/**
 * An action that calls the generator and in addition generates a
 * <code><plugin.xml</code> and <code>MANIFEST.MF</code> file.
 * 
 * @author jj2
 * 
 */
public class GenerateResourceAction implements IObjectActionDelegate {

	private ISelection selection;

	/**
	 * Calls {@link #process(IFile)} for all selected <i>cs</i> files .
	 */
	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> i = ((IStructuredSelection) selection).iterator(); i
					.hasNext();) {
				Object o = i.next();
				if (o instanceof IFile) {
					IFile file = (IFile) o;
					if (file.getFileExtension().startsWith("cs")) {
						process(file);
					}
				}
			}
		}
	}

	/**
	 * Creates a new Java project in the Workspace and calls the generators,
	 * 
	 * @param file
	 *            The file that contains the concrete syntax definition.
	 */
	public void process(final IFile file) {
		GenerateResourceJob job = new GenerateResourceJob("Generating resource project for " + file.getName(), file);
		job.setUser(true);
		job.schedule();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action
	 * .IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.
	 * action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// this.part = targetPart;
	}
}
