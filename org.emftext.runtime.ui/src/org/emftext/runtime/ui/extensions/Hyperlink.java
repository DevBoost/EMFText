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

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
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
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.ui.editor.EMFTextEditor;

/**
 * A hyperlink for the proxy elements in source code.
 * 
 * @author Tan-Ky Hoang-Kim
 * 
 */
@Deprecated
public class Hyperlink implements IHyperlink {

	private String text;
	private EObject linkTarget;
	private IRegion region;
	
	/**
	 * Creates the hyperlink.
	 * 
	 * @param region
	 *            the region of the hyperlink to highlight
	 * @param linkTarget the link target where this hyperlink should go to
	 * @param targetText the text to specify the target position in the <code>linkTarget</code>
	 */
	public Hyperlink(IRegion region, EObject linkTarget, String targetText) {
		this.region = region;
		this.linkTarget = linkTarget;
		this.text = targetText;
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
	 * Opens the resource in <code>linkTarget</code> with
	 * <code>EMFTextEditor</code>, if it supports the file extension of this
	 * resource, and tries to jump to the definition. Else it tries to open with
	 * a default editor.
	 * 
	 * @see org.eclipse.jface.text.hyperlink.IHyperlink#open()
	 */
	public void open() {
		if (linkTarget == null) {
			return;
		}
		IFile file = getIFileFromResource();
		if (file != null) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			try {
				//FIXME the EditorID has to be of EMFTextEditor
				IEditorPart activeEditor = page.getActiveEditor();
				if (isSupported(file.getFileExtension())) {
					page.openEditor(new FileEditorInput(file), activeEditor.getSite().getId());
				} else {
					IEditorDescriptor desc = workbench.getEditorRegistry().getDefaultEditor(file.getName());
					page.openEditor(new FileEditorInput(file), desc.getId());
				}
				IEditorPart editorPart = activeEditor;
				if (editorPart instanceof EMFTextEditor) {
					EMFTextEditor emftEditor = (EMFTextEditor) editorPart;
					emftEditor.setCaret(linkTarget, text);
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean isSupported(String fileExtension) {
		List<ITextResourcePluginMetaInformation> extensions = EMFTextRuntimePlugin.getConcreteSyntaxRegistry();
		for (ITextResourcePluginMetaInformation extension : extensions) {
			if (extension.getSyntaxName().equals(fileExtension)) {
				return true;
			}
		}
		return false;
	}

	private IFile getIFileFromResource() {
		URI resourceURI = linkTarget.eResource().getURI();
		if (resourceURI.toString().startsWith("pathmap")) {
			resourceURI = URIConverter.URI_MAP.get(resourceURI);
		}
		if (resourceURI.isPlatformResource()) {
			String platformString = resourceURI.toPlatformString(true);
			if (platformString != null) {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot root = workspace.getRoot();
				return root.getFile(new Path(platformString));
			}
		}
		return null;
	}

	public IRegion getHyperlinkRegion() {
		return region;
	}
}
