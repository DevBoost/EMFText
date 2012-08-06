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
package org.emftext.language.hedl.codegen;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.actions.OrganizeImportsAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class ImportsOrganizer {

	public void organize(final IFolder rootPackage) {
		
		Job job = new Job("Organizing imports") {

			@Override				
			protected IStatus run(IProgressMonitor monitor) {
				doOrganize(rootPackage);
				return Status.OK_STATUS;
			}
		};
		job.schedule();

	}

	private void doOrganize(final IFolder rootPackage) {
		Display.getDefault().syncExec(new Runnable() {
			
			public void run() {
				IWorkbench workbench = PlatformUI.getWorkbench();
				IWorkbenchWindow someWorkbenchWindow = workbench.getWorkbenchWindows()[0];
				IWorkbenchPage activePage = someWorkbenchWindow.getActivePage();
				IWorkbenchPart activePart = activePage.getActivePart();
				IWorkbenchPartSite site = activePart.getSite();
				OrganizeImportsAction action = new OrganizeImportsAction(site);
				List<IFile> files = getFiles(rootPackage);
				List<ICompilationUnit> compilationUnits = new ArrayList<ICompilationUnit>();
				for (IFile file : files) {
					ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);
					compilationUnits.add(compilationUnit);
				}
				IStructuredSelection selection = new StructuredSelection(compilationUnits);
				action.run(selection);
			}
		});
	}

	private List<IFile> getFiles(final IFolder rootPackage) {
		List<IFile> files = new ArrayList<IFile>();
		IResource[] members = new IResource[0];
		try {
			members = rootPackage.members();
			for (IResource member : members) {
				if (member instanceof IFile) {
					IFile file = (IFile) member;
					String[] javaLikeExtensions = JavaCore.getJavaLikeExtensions();
					for (String javaLikeExtension : javaLikeExtensions) {
						if (file.getName().endsWith("." + javaLikeExtension)) {
							files.add(file);
							break;
						}
					}
				}
				if (member instanceof IFolder) {
					files.addAll(getFiles((IFolder) member));
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return files;
	}
}
