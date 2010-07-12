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
import org.emftext.sdk.EMFTextSDKPlugin;

public abstract class AbstractGenerateSyntaxAction implements IObjectActionDelegate {
    
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
	 * Generates a concrete syntax for the given genmodel.
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
					boolean confirmed = MessageDialog.openConfirm(shell, "Generate " + getSyntaxName(), 
							"A syntax specification for the selected metamodel already exists. This will only generate a syntax rule for " +
							"meta-classes that have no syntax defined yet.\n\nIf you want to generate a " + getSyntaxName() + " for the whole metamodel, please " +
							"delete the syntax specification first.");
					if (!confirmed) {
						return;
					}
				}					
			}
        	IRunnableWithProgress runnable = createGenerationProcess(file);
        	
        	PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
         } 
        catch (InvocationTargetException e) {
        	Shell shell = new Shell();
			MessageDialog.openInformation(shell, e.getClass().getName(), e
					.getMessage());
        	EMFTextSDKPlugin.logError("Exception while generating " + getSyntaxName() + ".", e);
        }
        catch (InterruptedException e) {
        	Shell shell = new Shell();
			MessageDialog.openInformation(shell, e.getClass().getName(), e
					.getMessage());
        	EMFTextSDKPlugin.logError("Exception while generating " + getSyntaxName() + ".", e);
        }
    }
    
	public abstract IRunnableWithProgress createGenerationProcess(IFile file);

	public abstract String getSyntaxName();

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        // do nothing
	}
}
