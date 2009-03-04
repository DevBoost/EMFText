/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.ui.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.emftext.sdk.ui.jobs.GenerateResourcePluginJob;

/**
 * An action that generates a complete resource plug-in from
 * a CS specification and a meta model.
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public class GenerateResourcePluginAction implements IObjectActionDelegate {

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
		GenerateResourcePluginJob job = new GenerateResourcePluginJob("Generating resource project for " + file.getName(), file);
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
