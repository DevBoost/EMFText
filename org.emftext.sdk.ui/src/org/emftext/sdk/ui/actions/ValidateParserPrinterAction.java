/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.ui.actions;

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
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;

/**
 * A simple Action class for loading model instances from EMFText resources
 * and print them back to an adjacent text file. This is essentially useful 
 * for EMFText SDK users to test, if generated printers do formatting the text
 * as it was intended.
 */
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
		String outName = "test" + inName;
		ICsTextResource currentTextResource = (ICsTextResource) resourceSet
				.getResource(URI.createPlatformResourceURI(path, true), true);
		try {
			currentTextResource.load(currentSelection.getContents(), null);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			currentTextResource.save(outputStream, null);
			outputStream.flush();
			outputStream.close();
			IFolder parent = (IFolder) currentSelection.getParent();
			IFile outFile = parent.getFile(outName);
			if (outFile.exists()) {
				outFile.setContents(new ByteArrayInputStream(outputStream.toByteArray()),
						false, true, null);
			} else {
				outFile.create(new ByteArrayInputStream(outputStream.toByteArray()),
						false, null);
			}
		} catch (Exception e) {
			Shell shell = new Shell();
			MessageDialog.openInformation(shell, e.getClass().getName(), e
					.getMessage());
        	EMFTextSDKPlugin.logError("Exception while running validate parser action.", e);
			return;
		}

		Shell shell = new Shell();
		MessageDialog.openInformation(shell, "EMFText Tests",
				"Successfully loaded and resolved model from " + inName
						+ ".\nSuccessfully deresolved and printed model to "
						+ outName + ".");
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof IFile) {
				currentSelection = (IFile) structuredSelection
						.getFirstElement();
			}
		}
	}
}
