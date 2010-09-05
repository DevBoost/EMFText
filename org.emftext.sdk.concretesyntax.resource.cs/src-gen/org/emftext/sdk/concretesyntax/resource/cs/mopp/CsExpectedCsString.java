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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class CsExpectedCsString extends org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAbstractExpectedElement {
	
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword keyword;
	
	public CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof CsExpectedCsString) {
			return getValue().equals(((CsExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
