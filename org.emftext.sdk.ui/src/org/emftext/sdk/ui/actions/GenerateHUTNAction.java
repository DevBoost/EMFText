package org.emftext.sdk.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
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
        	
        	IRunnableWithProgress runnable = new HUTNGenerationProcess(file);
        	
        	PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
         } 
        catch (InvocationTargetException e){
        	EMFTextRuntimePlugin.logError("Exception while generating HUTN syntax.", e);
        }
        catch (InterruptedException e){
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
