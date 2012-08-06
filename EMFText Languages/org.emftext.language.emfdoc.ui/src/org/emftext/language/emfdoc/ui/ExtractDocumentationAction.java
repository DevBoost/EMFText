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
package org.emftext.language.emfdoc.ui;

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
import org.emftext.language.emfdoc.resource.emfdoc.mopp.EmfdocMetaInformation;
import org.emftext.language.emfdoc.resource.emfdoc.mopp.EmfdocPlugin;

public class ExtractDocumentationAction implements IObjectActionDelegate {
    
	private ISelection selection;

    /**
     * Calls {@link #process(IFile)} for all selected <i>ecore</i> files .
     */
	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
            for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
                Object o = i.next();
                if (o instanceof IFile) {
                    IFile file = (IFile) o;                   
                    if (file.getFileExtension().startsWith("ecore")) process(file);
                }
            }
		}
	}
    
	/**
	 * Extracts the documentation from the given .ecore file.
	 * 
	 * @param file The file that contains the metamodel.
	 */
    public void process(final IFile file) {
        try {                 
        	
    		URI ecoreURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
    		URI ecoreDocURI = ecoreURI.trimFileExtension().appendFileExtension(new EmfdocMetaInformation().getSyntaxName());
			
			if (ecoreDocURI != null && ecoreDocURI.isPlatform()) {
				IResource workspaceMember = ResourcesPlugin.getWorkspace().getRoot().findMember(ecoreDocURI.toPlatformString(true));
				if (workspaceMember != null) {
					Shell shell = new Shell();
					boolean confirmed = MessageDialog.openConfirm(shell, "Extract documentation", 
						"A .ecoredoc file for the selected metamodel already exists. This will only add missing documentation."
					);
					if (!confirmed) {
						return;
					}
				}
			}
        	IRunnableWithProgress runnable = new ExtractDocumentationProcess(ecoreURI, ecoreDocURI);
        	PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
        }
        catch (InvocationTargetException e) {
        	e.printStackTrace();
        	Shell shell = new Shell();
			MessageDialog.openInformation(shell, e.getClass().getName(), e.getMessage());
        	EmfdocPlugin.logError("Exception while extracting documentation.", e);
        }
        catch (InterruptedException e) {
        	e.printStackTrace();
        	Shell shell = new Shell();
			MessageDialog.openInformation(shell, e.getClass().getName(), e.getMessage());
			EmfdocPlugin.logError("Exception while extracting documentation.", e);
        }
    }
    
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        // do nothing
	}
}
