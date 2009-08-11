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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.ui.editor.EMFTextEditor;

/**
 * Provides the hyperlink for the proxy elements in source code.
 * 
 * @author Tan-Ky Hoang-Kim
 * 
 */
public class Hyperlink implements IHyperlink {

	private String text;
	private EObject linkTarget;
	private IRegion region;
	private static final Collection<String> fileExtensions;
	static {
		fileExtensions = new ArrayList<String>();
		List<ITextResourcePluginMetaInformation> extensions = EMFTextRuntimePlugin
				.getConcreteSyntaxRegistry();
		for (ITextResourcePluginMetaInformation extension : extensions) {
			fileExtensions.add(extension.getSyntaxName());
		}
	}

	/**
	 * Creates the hyperlink.
	 * 
	 * @param region
	 *            the region of the hyperlink to highlight
	 * @param linkTarget the link target where this hyperlink should go to
	 * @param text the text to specify the target position in the <code>linkTarget</code>
	 */
	public Hyperlink(IRegion region, EObject linkTarget, String text) {
		this.region = region;
		this.linkTarget = linkTarget;
		this.text = text;
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
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			try {
				//FIXME the EditorID has to be of EMFTextEditor
				if (fileExtensions.contains(file.getFileExtension()))
					page.openEditor(new FileEditorInput(file), page
							.getActiveEditor().getSite().getId());
				else {
					IEditorDescriptor desc = PlatformUI.getWorkbench()
							.getEditorRegistry().getDefaultEditor(
									file.getName());
					page.openEditor(new FileEditorInput(file), desc.getId());
				}
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
		}
		if (resourceURI.isPlatformResource()) {
			String platformString = resourceURI.toPlatformString(true);
			if (platformString != null) {
				return ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(platformString));
			}
		}
		return null;
	}

	public IRegion getHyperlinkRegion() {
		return region;
	}
}
