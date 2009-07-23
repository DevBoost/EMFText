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

//TODO mseifert: align this class with the EMFText coding style
public class Hyperlink implements IHyperlink {

	private String text = "";
	private EObject eobject;

	public void setHyperlinkText(String hyperlinkText) {
		this.text = hyperlinkText;
	}

	public void setEObject(EObject eo) {
		this.eobject = eo;
	}

	public boolean containsEObject() {
		return eobject != null;
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

	/*
	 * (non-Javadoc) Open the given Resource with EMFTextEditor. Assume the
	 * resource is openable with EMFTextEditor.
	 * 
	 * @see org.eclipse.jface.text.hyperlink.IHyperlink#open()
	 */
	public void open() {
		if (eobject == null)
			return;
		IFile file = getIFileFromResource();
		if (file != null) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				page.openEditor(new FileEditorInput(file), page.getActiveEditor().getSite().getId());

				IEditorPart ep = page.getActiveEditor();
				if (ep instanceof EMFTextEditor) {
					EMFTextEditor emftEditor = (EMFTextEditor) ep;
					emftEditor.setCaret(eobject);
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}

	private IFile getIFileFromResource() {
		URI eUri = eobject.eResource().getURI();
		if (eUri.toString().startsWith("pathmap"))
			;
		eUri = URIConverter.URI_MAP.get(eUri);
		// TODO what is a PlatformResource
		if (eUri.isPlatformResource()) {
			String platformString = eUri.toPlatformString(true);
			if (platformString != null) {
				return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
			}
		}
		return null;
	}

	public void resetValues() {
		if (text.equals(""))
			return;
		text = "";
		eobject = null;
	}

	public IRegion getHyperlinkRegion() {
		return null;
	}

}
