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

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.sdk.ui.jobs.HUTNGenerationProcess;

/**
 * An action that generates a HUTN based concrete syntax for the given generator
 * model.
 */
public class GenerateHUTNAction implements IObjectActionDelegate {
    
	private ISelection selection;

    /**
     * Calls {@link #process(IFile)} for all selected <i>cs</i> files .
     */
	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
            for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
                Object o = i.next();
                if (o instanceof IFile) {
                    IFile file = (IFile) o;                   
                    if (file.getFileExtension().startsWith("genmodel")) process(file);
                }
            }
		}
	}
    
	/**
	 * Generates a HUTN based concrete syntax for the given genmodel.
	 * 
	 * @param file The file that contains the concrete syntax definition.
	 */
    public void process(final IFile file) {
        try {                 
        	
			URI uri = URI.createPlatformResourceURI(file.getFullPath().removeFileExtension().addFileExtension("cs").toString(), true);
			
			if (uri != null && uri.isPlatform()) {
				IResource workspaceMember = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true));
				if (workspaceMember != null) {
					Shell shell = new Shell();
					boolean confirmed = MessageDialog.openConfirm(shell, "Generate HUTN Syntax", 
							"A syntax specification for the selected metamodel already exists. This will only generate a syntax rule for " +
							"meta-classes that have no syntax defined yet.\n\nIf you want to generate a HUTN syntax for the whole metamodel, please " +
							"delete the syntax specification first.");
					if(!confirmed) return;
				}					
			}
        	IRunnableWithProgress runnable = new HUTNGenerationProcess(file);
        	
        	PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
         } 
        catch (InvocationTargetException e) {
        	Shell shell = new Shell();
			MessageDialog.openInformation(shell, e.getClass().getName(), e
					.getMessage());
        	EMFTextRuntimePlugin.logError("Exception while generating HUTN syntax.", e);
        }
        catch (InterruptedException e) {
        	Shell shell = new Shell();
			MessageDialog.openInformation(shell, e.getClass().getName(), e
					.getMessage());
        	EMFTextRuntimePlugin.logError("Exception while generating HUTN syntax.", e);
        }
     }
    
   
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        //this.part = targetPart;
	}
}
