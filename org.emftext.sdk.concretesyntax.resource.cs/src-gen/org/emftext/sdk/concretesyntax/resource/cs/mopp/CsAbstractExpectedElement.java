/*******************************************************************************
 * Copyright (c) 2006-2009 
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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

// Abstract super class for all expected elements. Provides methods to
// set and retrieve the document range, where the element is expected.
// This range is expressed using four integers - two denoting the range
// including hidden tokens (e.g., whitespace) and two denoting the range
// excluding those token (i.e., the part of the document containing the
// relevant characters).
public abstract class CsAbstractExpectedElement implements org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement {
	
	public CsAbstractExpectedElement() {
		super();
	}
	
}
