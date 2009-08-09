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
package org.emftext.runtime.ui.extensions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.emftext.runtime.ui.editor.EMFTextEditor;

/**
 * Provides the hyperlink for the proxy elements in source code.
 * @author Tan-Ky Hoang-Kim
 *
 */
public class Hyperlink implements IHyperlink {

	private String text = "";
	private EObject linkTarget;
	private String fileExtension;
	private IRegion region;

	/**
	 * Creates the hyperlink.
	 * @param fileExtension the file extension in order to open with its default editor.
	 * Sets EMFTextEditor as default editor if you want to open this file extension with EMFTextEditor
	 * @param region the region of the hyperlink to highlight
	 */
	public Hyperlink(String fileExtension, IRegion region) {
		this.fileExtension=fileExtension;
		this.region = region;
	}
	
	/**
	 * Sets the token text to locate the position to jump.
	 * @param hyperlinkText the hyperlink text where the mouse cursor hovers
	 */
	public void setHyperlinkText(String hyperlinkText) {
		this.text = hyperlinkText;
	}

	/**
	 * Sets the resolved <code>EObject</code>.
	 * @param linkTarget the link target where it will jump to
	 */
	public void setLinkTarget(EObject linkTarget) {
		this.linkTarget = linkTarget;
	}

	public String getHyperlinkText() {
		return text;
	}

	/**
	 * @return the length of the hyperlink text 
	 */
	public int length() {
		return text.length();
	}

	public String getTypeLabel() {
		return null;
	}

	/**
	 * Opens the resource in <code>linkTarget</code> with an default editor. 
	 * If the editor is an EMFTextEditor it tries to jump to the definition.
	 * 
	 * @see org.eclipse.jface.text.hyperlink.IHyperlink#open()
	 */
	public void open() {
		if (linkTarget == null) {
			return;
		}
		IFile file = getIFileFromResource();
		if (file != null) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				//page.openEditor(new FileEditorInput(file), page.getActiveEditor().getSite().getId());
				IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(file.getName());
				page.openEditor(new FileEditorInput(file), desc.getId());
				
				IEditorPart editorPart = page.getActiveEditor();
				if (editorPart instanceof EMFTextEditor) {
					EMFTextEditor emftEditor = (EMFTextEditor) editorPart;
					emftEditor.setCaret(linkTarget, text);
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}

	private IFile getIFileFromResource() {
		URI resourceURI = linkTarget.eResource().getURI();
		if (resourceURI.toString().startsWith("pathmap")) {
			resourceURI = URIConverter.URI_MAP.get(resourceURI);
			if (!resourceURI.fileExtension().equals(fileExtension))
				return null;
		}
		if (resourceURI.isPlatformResource()) {
			String platformString = resourceURI.toPlatformString(true);
			if (platformString != null) {
				return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
			}
		}
		return null;
	}

	public IRegion getHyperlinkRegion() {
		return region;
	}
}
