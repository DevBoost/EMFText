/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.ui.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.emftext.sdk.ui.jobs.GenerateResourcePluginsJob;

/**
 * An action that generates a complete resource plug-in from a CS specification
 * and a meta model.
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
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Iterator<?> it = structuredSelection.iterator();
			while (it.hasNext()) {
				Object next = it.next();
				if (next instanceof IFile) {
					IFile file = (IFile) next;
                    String fileExtension = file.getFileExtension();
					if (fileExtension != null && fileExtension.startsWith("cs")) {
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
	public void process(IFile file) {
		String jobName = "Generating resource project for " + file.getName();
		GenerateResourcePluginsJob job = new GenerateResourcePluginsJob(jobName, file);
		job.setUser(true);
		job.schedule();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// do nothing as we do not need information about the action or part
	}
}
