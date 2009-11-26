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

// A proposal for completing an incomplete document.
public class CsCompletionProposal implements java.lang.Comparable<CsCompletionProposal> {
	private java.lang.String insertString;
	private boolean startsWithPrefix;
	
	public CsCompletionProposal(java.lang.String insertString, boolean startsWithPrefix) {
		super();
		this.insertString = insertString;
		this.startsWithPrefix = startsWithPrefix;
	}
	
	public java.lang.String getInsertString() {
		return insertString;
	}
	
	public boolean getStartsWithPrefix() {
		return startsWithPrefix;
	}
	
	public boolean equals(Object object) {
		if (object instanceof CsCompletionProposal) {
			CsCompletionProposal other = (CsCompletionProposal) object;
			return other.getInsertString().equals(getInsertString());
		}
		return false;
	}
	
	public int hashCode() {
		return getInsertString().hashCode();
	}
	
	public int compareTo(CsCompletionProposal object) {
		if (object instanceof CsCompletionProposal) {
			CsCompletionProposal other = (CsCompletionProposal) object;
			// proposals that start with the prefix are preferred over the ones that do not
			int startCompare = (startsWithPrefix ? 1 : 0) - (other.getStartsWithPrefix() ? 1 : 0);
			// if both proposals start with the prefix of both do not the insert string is compared
			return startCompare == 0 ? getInsertString().compareTo(other.getInsertString()) : -startCompare;
		}
		return -1;
	}
	
}
