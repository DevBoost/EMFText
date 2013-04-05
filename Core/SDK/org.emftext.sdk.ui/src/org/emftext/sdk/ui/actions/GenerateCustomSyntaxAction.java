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
package org.emftext.sdk.ui.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.emftext.sdk.ui.wizards.CustomizeSyntaxWizard;

public class GenerateCustomSyntaxAction implements IObjectActionDelegate {

	private ISelection selection;
	private IWorkbenchPart part;

	public void run(IAction action) {
		// TODO this code is copied from AbstractGenerateSyntaxAction
		if (selection instanceof IStructuredSelection) {
            for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
                Object o = i.next();
                if (o instanceof IFile) {
                    IFile file = (IFile) o;                   
                    String fileExtension = file.getFileExtension();
					if (fileExtension != null && fileExtension.startsWith("genmodel")) {
                    	process(file);
                    }
                }
            }
		}
	}

	private void process(IFile genModelFile) {
		CustomizeSyntaxWizard wizard = new CustomizeSyntaxWizard(genModelFile);
		if ((selection instanceof IStructuredSelection) || (selection == null)) {
			wizard.init(
				part.getSite().getWorkbenchWindow().getWorkbench(), 
				(IStructuredSelection) selection
			);
		}
			
		WizardDialog dialog = new WizardDialog(part.getSite().getShell(), wizard);
		dialog.create();
		dialog.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart part) {
		this.part = part;
	}
}
