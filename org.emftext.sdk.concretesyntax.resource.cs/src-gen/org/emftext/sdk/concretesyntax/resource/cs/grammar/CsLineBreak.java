/*******************************************************************************
 * Copyright (c) 2006-2010 
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

package org.emftext.sdk.concretesyntax.resource.cs.grammar;

public class CsLineBreak extends org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement {
	
	private final int tabs;
	
	public CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality cardinality, int tabs) {
		super(cardinality, null);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
}
