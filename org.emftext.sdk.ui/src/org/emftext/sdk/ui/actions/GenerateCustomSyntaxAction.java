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
                    if (file.getFileExtension().startsWith("genmodel")) {
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
