/*******************************************************************************
 * Copyright (c) 2006-2015
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Dresden, Amtsgericht Dresden, HRB 34001
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <p>
 * CsLayoutInformation objects are used to store layout information that is found
 * while parsing text files. Layout information does include all unused tokens.
 * Usually, these are whitespace characters, line breaks and comments, but
 * depending on the concrete syntax definition it can also include other tokens.
 * </p>
 * <p>
 * CsLayoutInformations are aggregated in LayoutInformationAdapters. One
 * CsLayoutInformation contains the layout that was found before a keyword,
 * attribute or reference.
 * </p>
 */
public class CsLayoutInformation {
	
	/**
	 * The element in the grammar that is associated with this layout information.
	 * This can be either an attribute, a non-containment reference (placeholder) or a
	 * terminal (boolean or enumeration).
	 */
	private final org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement syntaxElement;
	
	/**
	 * The offset in the document where this piece of layout was found.
	 */
	private final int startOffset;
	
	/**
	 * Contains a concatenated version of all hidden tokens that were found before
	 * this object.
	 */
	private final String hiddenTokenText;
	
	/**
	 * Contains the visible token that represented this object in its text form.
	 */
	private final String visibleTokenText;
	
	/**
	 * The object the layout information refers to. This can be either the value of an
	 * attribute or a referenced EObject.
	 */
	private Object object;
	
	/**
	 * A flag that is used to remember whether the proxy to which this layout refers
	 * was resolved.
	 */
	private boolean wasResolved;
	
	public CsLayoutInformation(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement syntaxElement, Object object, int startOffset, String hiddenTokenText, String visibleTokenText) {
		super();
		this.syntaxElement = syntaxElement;
		this.object = object;
		this.startOffset = startOffset;
		this.hiddenTokenText = hiddenTokenText;
		this.visibleTokenText = visibleTokenText;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement getSyntaxElement() {
		return syntaxElement;
	}
	
	public int getStartOffset() {
		return startOffset;
	}
	
	/**
	 * Returns the objects that this layout information adapter refers to. This can be
	 * either the value of an attribute or a referenced object. If the parameter
	 * 'resolve' is set to true and the referenced object is a proxy, this method
	 * tries to resolve the proxy.
	 */
	public Object getObject(EObject container, boolean resolve) {
		if (wasResolved || !resolve) {
			return object;
		}
		// we need to try to resolve proxy objects again, because the proxy might have
		// been resolved before this adapter existed, which means we missed the
		// replaceProxy() notification
		if (object instanceof InternalEObject) {
			InternalEObject internalObject = (InternalEObject) object;
			if (internalObject.eIsProxy()) {
				if (container instanceof InternalEObject) {
					InternalEObject internalContainer = (InternalEObject) container;
					EObject resolvedObject = internalContainer.eResolveProxy(internalObject);
					if (resolvedObject != internalObject) {
						object = resolvedObject;
						wasResolved = true;
					}
				}
			}
		} else {
			wasResolved = true;
		}
		return object;
	}
	
	public String getHiddenTokenText() {
		return hiddenTokenText;
	}
	
	public String getVisibleTokenText() {
		return visibleTokenText;
	}
	
	public void replaceProxy(EObject proxy, EObject target) {
		if (this.object == proxy) {
			this.object = target;
		}
	}
	
	public String toString() {
		return "visible='" + visibleTokenText + "', hidden='" + hiddenTokenText + "', object='" + object + "', syntaxElement='" + syntaxElement + "'";
	}
	
}
