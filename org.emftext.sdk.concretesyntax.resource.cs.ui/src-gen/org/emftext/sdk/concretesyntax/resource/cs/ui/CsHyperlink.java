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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * A hyperlink for the proxy elements in source code.
 */
public class CsHyperlink implements org.eclipse.jface.text.hyperlink.IHyperlink {
	
	private String text;
	private org.eclipse.emf.ecore.EObject linkTarget;
	private org.eclipse.jface.text.IRegion region;
	
	/**
	 * Creates the hyperlink.
	 * 
	 * @param region the region of the hyperlink to highlight
	 * @param linkTarget the link target where this hyperlink should go to
	 * @param targetText the text to specify the target position in the
	 * <code>linkTarget</code>
	 */
	public CsHyperlink(org.eclipse.jface.text.IRegion region, org.eclipse.emf.ecore.EObject linkTarget, String targetText) {
		this.region = region;
		this.linkTarget = linkTarget;
		this.text = targetText;
	}
	
	public String getHyperlinkText() {
		return text;
	}
	
	/**
	 * 
	 * @return the length of the hyperlink text
	 */
	public int length() {
		return text.length();
	}
	
	public String getTypeLabel() {
		return null;
	}
	
	/**
	 * Opens the resource in <code>linkTarget</code> with the generated editor, if it
	 * supports the file extension of this resource, and tries to jump to the
	 * definition. Otherwise it tries to open the target with the default editor.
	 */
	public void open() {
		if (linkTarget == null) {
			return;
		}
		org.eclipse.core.resources.IFile file = getIFileFromResource();
		if (file != null) {
			org.eclipse.ui.IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
			org.eclipse.ui.IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			try {
				org.eclipse.ui.IEditorDescriptor desc = workbench.getEditorRegistry().getDefaultEditor(file.getName());
				org.eclipse.ui.IEditorPart editorPart = page.openEditor(new org.eclipse.ui.part.FileEditorInput(file), desc.getId());
				if (editorPart instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) {
					org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor emftEditor = (org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) editorPart;
					emftEditor.setCaret(linkTarget, text);
				}
			} catch (org.eclipse.ui.PartInitException e) {
				e.printStackTrace();
			}
		}
	}
	
	private org.eclipse.core.resources.IFile getIFileFromResource() {
		org.eclipse.emf.ecore.resource.Resource linkTargetResource = linkTarget.eResource();
		org.eclipse.emf.common.util.URI resourceURI = linkTargetResource.getURI();
		if (linkTargetResource.getResourceSet() != null && linkTargetResource.getResourceSet().getURIConverter() != null) {
			resourceURI = linkTargetResource.getResourceSet().getURIConverter().normalize(resourceURI);
		}
		if (resourceURI.isPlatformResource()) {
			String platformString = resourceURI.toPlatformString(true);
			if (platformString != null) {
				org.eclipse.core.resources.IWorkspace workspace = org.eclipse.core.resources.ResourcesPlugin.getWorkspace();
				org.eclipse.core.resources.IWorkspaceRoot root = workspace.getRoot();
				return root.getFile(new org.eclipse.core.runtime.Path(platformString));
			}
		}
		return null;
	}
	
	public org.eclipse.jface.text.IRegion getHyperlinkRegion() {
		return region;
	}
	
}
