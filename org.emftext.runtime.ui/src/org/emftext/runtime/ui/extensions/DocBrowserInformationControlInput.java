package org.emftext.runtime.ui.extensions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;

//TODO hoang-kim can we remove the warning by copying the code from BrowserInformationControlInput?
//I can't some how. The warning is from BrowserInformationControlInput and it is needed by BrowserInformationControl in 
//TextHover, inner class OpenDeclarationAction
@SuppressWarnings("restriction")
public class DocBrowserInformationControlInput extends BrowserInformationControlInput {

	private final EObject element;
	private final String htmlContent;
	private final String tokenText;
	private final int leadingImageWidth;
	private final Resource resource;

	/**
	 * Creates a new browser information control input.
	 * 
	 * @param previous
	 *            previous input, or <code>null</code> if none available
	 * @param element
	 *            the element, or <code>null</code> if none available
	 * @param htmlContent
	 *            HTML contents, must not be null
	 * @param leadingImageWidth
	 *            the indent required for the element image
	 */
	public DocBrowserInformationControlInput(DocBrowserInformationControlInput previous, EObject element,
			Resource resource, String htmlContent, String tokenText, int leadingImageWidth) {
		super(previous);
		assert htmlContent != null;
		this.element = element;
		this.htmlContent = htmlContent;
		this.tokenText = tokenText;
		this.leadingImageWidth = leadingImageWidth;
		this.resource = resource;
	}

	/*
	 * @seeorg.eclipse.jface.internal.text.html.BrowserInformationControlInput#
	 * getLeadingImageWidth()
	 * 
	 * @since 3.4
	 */
	public int getLeadingImageWidth() {
		return leadingImageWidth;
	}

	/**
	 * Returns the element.
	 * 
	 * @return the element or <code>null</code> if none available
	 */
	public EObject getElement() {
		return element;
	}

	public Resource getResource() {
		return resource;
	}

	public String getHtml() {
		return htmlContent;
	}
	
	public String getTokenText() {
		return tokenText;
	}

	public Object getInputElement() {
		return element == null ? (Object) htmlContent : element;
	}

	public String getInputName() {
		return element == null ? "" : element.toString(); //$NON-NLS-1$
	}
}
