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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.emftext.runtime.ui.editor.EMFTextEditor;

//TODO hoang-kim add documentation
public class Hyperlink implements IHyperlink {

	private String text = "";
	// TODO hoang-kim is this the source or the target of the link?
	private EObject eObject;

	public void setHyperlinkText(String hyperlinkText) {
		this.text = hyperlinkText;
	}

	public void setEObject(EObject eo) {
		this.eObject = eo;
	}

	public boolean containsEObject() {
		return eObject != null;
	}

	public String getHyperlinkText() {
		return text;
	}

	public int length() {
		return text.length();
	}

	public String getTypeLabel() {
		return null;
	}

	/**
	 * Opens the given Resource with an EMFTextEditor. Assumes the
	 * resource can be opened with EMFTextEditor.
	 * 
	 * @see org.eclipse.jface.text.hyperlink.IHyperlink#open()
	 */
	public void open() {
		if (eObject == null) {
			return;
		}
		IFile file = getIFileFromResource();
		if (file != null) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				page.openEditor(new FileEditorInput(file), page.getActiveEditor().getSite().getId());

				IEditorPart editorPart = page.getActiveEditor();
				if (editorPart instanceof EMFTextEditor) {
					EMFTextEditor emftEditor = (EMFTextEditor) editorPart;
					emftEditor.setCaret(eObject);
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}

	private IFile getIFileFromResource() {
		URI resourceURI = eObject.eResource().getURI();
		if (resourceURI.toString().startsWith("pathmap")) {
			resourceURI = URIConverter.URI_MAP.get(resourceURI);
		}
		// TODO what is a PlatformResource
		if (resourceURI.isPlatformResource()) {
			String platformString = resourceURI.toPlatformString(true);
			if (platformString != null) {
				return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
			}
		}
		return null;
	}

	public void resetValues() {
		if (text.equals("")) {
			return;
		}
		text = "";
		eObject = null;
	}

	public IRegion getHyperlinkRegion() {
		return null;
	}
}
