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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Provides input for the <code>TextHover</code>. The most is copied from
 * 
 * <code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocBrowserInformationControlInput</code>
 * 
 * @author Tan-Ky Hoang-Kim
 * 
 */
public class DocBrowserInformationControlInput {
	
	private final DocBrowserInformationControlInput fPrevious;
	private DocBrowserInformationControlInput fNext;

	private final EObject element;
	private final String htmlContent;
	private final String tokenText;
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
	public DocBrowserInformationControlInput(
			DocBrowserInformationControlInput previous, EObject element,
			Resource resource, String htmlContent, String tokenText) {
		fPrevious= previous;
		if (previous != null)
			previous.fNext= this;
		//super(previous);
		assert htmlContent != null;
		this.element = element;
		this.htmlContent = htmlContent;
		this.tokenText = tokenText;
		this.resource = resource;
	}
	
	/**
	 * The previous input or <code>null</code> if this
	 * is the first.
	 *
	 * @return the previous input or <code>null</code>
	 */
	public DocBrowserInformationControlInput getPrevious() {
		return fPrevious;
	}

	/**
	 * The next input or <code>null</code> if this
	 * is the last.
	 *
	 * @return the next input or <code>null</code>
	 */
	public DocBrowserInformationControlInput getNext() {
		return fNext;
	}

	/**
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}

	public String getHtml() {
		return htmlContent;
	}
	
	public String toString() {
		return getHtml();
	}

	/**
	 * 
	 * @return the token text, it is needed for a hyperlink where the caret has
	 *         to jump to
	 */
	public String getTokenText() {
		return tokenText;
	}

	public Object getInputElement() {
		return element == null ? (Object) htmlContent : element;
	}

	public String getInputName() {
		return element == null ? "" : element.toString(); //$NON-NLS-1$
	}

	public int getLeadingImageWidth() {
		return 0;
	}
}
