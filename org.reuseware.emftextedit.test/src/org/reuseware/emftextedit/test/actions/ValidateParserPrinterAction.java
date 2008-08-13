package org.reuseware.emftextedit.test.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.reuseware.emftextedit.resource.TextResource;


public class ValidateParserPrinterAction implements IObjectActionDelegate {
	
	private ResourceSet resourceSet;
	private IFile currentSelection;
	
	/**
	 * Constructor for Action1.
	 */
	public ValidateParserPrinterAction() {
		super();
		 resourceSet = new ResourceSetImpl();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		String path = currentSelection.getFullPath().toString();
		String inName = currentSelection.getName();
		String outName = "test"+inName;
		TextResource currentTextResource = (TextResource) resourceSet.getResource(URI.createPlatformResourceURI(path, true), true);
			try {
				currentTextResource.load(currentSelection.getContents(),null);
				ByteArrayOutputStream s = new ByteArrayOutputStream();
				currentTextResource.save(s,null);
				s.flush();
				s.close();
				IFolder parent = (IFolder)currentSelection.getParent();
				IFile outFile = parent.getFile(outName);
				if(outFile.exists())
					outFile.setContents(new ByteArrayInputStream(s.toByteArray()),false,true,null);
				else
					outFile.create(new ByteArrayInputStream(s.toByteArray()),false,null);
			} catch (Exception e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell,e.getClass().getName(),e.getMessage());
				e.printStackTrace();
				return;
			}


		Shell shell = new Shell();
		MessageDialog.openInformation(
			shell,
			"EMFTextEdit Tests",
			"Successfully loaded and resolved model from " + inName +".\nSuccessfully deresolved and printed model to "+outName+".");
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection){
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			if(structuredSelection.getFirstElement() instanceof IFile){
				currentSelection = (IFile)structuredSelection.getFirstElement();
				

			}

		}
	
	}

}
