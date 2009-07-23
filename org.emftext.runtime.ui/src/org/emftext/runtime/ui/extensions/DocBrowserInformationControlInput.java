package org.emftext.runtime.ui.extensions;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;

//TODO mseifert: align this class with the EMFText coding style
@SuppressWarnings("restriction")
public class DocBrowserInformationControlInput extends BrowserInformationControlInput {

	private final EObject fElement;
	private final String fHtml;
	private final int fLeadingImageWidth;
	private final Resource fResource;

	/**
	 * Creates a new browser information control input.
	 * 
	 * @param previous
	 *            previous input, or <code>null</code> if none available
	 * @param element
	 *            the element, or <code>null</code> if none available
	 * @param html
	 *            HTML contents, must not be null
	 * @param leadingImageWidth
	 *            the indent required for the element image
	 */
	public DocBrowserInformationControlInput(DocBrowserInformationControlInput previous, EObject element,
			Resource resource, String html, int leadingImageWidth) {
		super(previous);
		Assert.isNotNull(html);
		fElement = element;
		fHtml = html;
		fLeadingImageWidth = leadingImageWidth;
		fResource = resource;
	}

	/*
	 * @seeorg.eclipse.jface.internal.text.html.BrowserInformationControlInput#
	 * getLeadingImageWidth()
	 * 
	 * @since 3.4
	 */
	public int getLeadingImageWidth() {
		return fLeadingImageWidth;
	}

	/**
	 * Returns the element.
	 * 
	 * @return the element or <code>null</code> if none available
	 */
	public EObject getElement() {
		return fElement;
	}

	public Resource getResource() {
		return fResource;
	}

	/*
	 * @see org.eclipse.jface.internal.text.html.BrowserInput#getHtml()
	 */
	public String getHtml() {
		return fHtml;
	}

	/*
	 * @see org.eclipse.jdt.internal.ui.infoviews.BrowserInput#getInputElement()
	 */
	public Object getInputElement() {
		return fElement == null ? (Object) fHtml : fElement;
	}

	/*
	 * @see org.eclipse.jdt.internal.ui.infoviews.BrowserInput#getInputName()
	 */
	public String getInputName() {
		return fElement == null ? "" : fElement.toString(); //$NON-NLS-1$
	}

}
