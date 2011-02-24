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
 * Provides input for the <code>TextHover</code>. The most is copied from
 * <code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocBrowserInformationContr
 * olInput</code>.
 */
public class CsDocBrowserInformationControlInput {
	
	private final CsDocBrowserInformationControlInput fPrevious;
	private CsDocBrowserInformationControlInput fNext;
	private final org.eclipse.emf.ecore.EObject element;
	private final String htmlContent;
	private final String tokenText;
	private final org.eclipse.emf.ecore.resource.Resource resource;
	
	/**
	 * Creates a new browser information control input.
	 * 
	 * @param previous previous input, or <code>null</code> if none available
	 * @param element the element, or <code>null</code> if none available
	 * @param htmlContent HTML contents, must not be null
	 */
	public CsDocBrowserInformationControlInput(CsDocBrowserInformationControlInput previous, org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.resource.Resource resource, String htmlContent, String tokenText) {
		fPrevious= previous;
		if (previous != null) {
			previous.fNext= this;
		}
		assert htmlContent != null;
		this.element = element;
		this.htmlContent = htmlContent;
		this.tokenText = tokenText;
		this.resource = resource;
	}
	
	/**
	 * Returns the previous input or <code>null</code> if this is the first.
	 * 
	 * @return the previous input or <code>null</code>
	 */
	public CsDocBrowserInformationControlInput getPrevious() {
		return fPrevious;
	}
	
	/**
	 * Returns the next input or <code>null</code> if this is the last.
	 * 
	 * @return the next input or <code>null</code>
	 */
	public CsDocBrowserInformationControlInput getNext() {
		return fNext;
	}
	
	/**
	 * 
	 * @return the resource
	 */
	public org.eclipse.emf.ecore.resource.Resource getResource() {
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
	 * @return the token text, it is needed for a hyperlink where the caret has to
	 * jump to
	 */
	public String getTokenText() {
		return tokenText;
	}
	
	public Object getInputElement() {
		return element == null ? (Object) htmlContent : element;
	}
	
	public String getInputName() {
		return element == null ? "" : element.toString();
	}
	
	public int getLeadingImageWidth() {
		return 0;
	}
}
