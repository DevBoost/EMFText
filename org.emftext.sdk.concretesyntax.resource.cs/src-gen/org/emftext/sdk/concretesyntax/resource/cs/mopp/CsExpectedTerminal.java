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

// A representation for a range in a document where a keyword (i.e.,
// a static string) is expected.
public class CsExpectedTerminal {
	private int followSetID;
	private org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement terminal;
	
	public CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement terminal, int followSetID) {
		super();
		this.terminal = terminal;
		this.followSetID = followSetID;
	}
	
	public int getFollowSetID() {
		return followSetID;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement getTerminal() {
		return terminal;
	}
	
	public String toString() {
		return " Expected Terminal \"" + terminal + "\"" + toString(startIncludingHiddenTokens) + "(" + toString(startExcludingHiddenTokens) + ")";
	}
	
	private String toString(int index) {
		if (index == -1) {
			return "MIN";
		} else if (index == Integer.MAX_VALUE) {
			return "*";
		} else {
			return "" + index;
		}
	}
	
	public boolean equals(Object o) {
		return this.terminal.equals(((CsExpectedTerminal) o).terminal);
	}
	private int startIncludingHiddenTokens;
	private int startExcludingHiddenTokens;
	private String prefix;
	private boolean discardFollowingExpectations;
	
	public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens) {
		assert startExcludingHiddenTokens <= startExcludingHiddenTokens;
		assert startIncludingHiddenTokens <= startExcludingHiddenTokens;
		
		this.startIncludingHiddenTokens = startIncludingHiddenTokens;
		this.startExcludingHiddenTokens = startExcludingHiddenTokens;
	}
	
	public int getStartIncludingHiddenTokens() {
		return startIncludingHiddenTokens;
	}
	
	public int getStartExcludingHiddenTokens() {
		return startExcludingHiddenTokens;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	// Checks whether the cursor index is inside the range of
	// relevant characters, not considering hidden tokens
	// (e.g., whitespace).
	public boolean isAt(int cursorIndex) {
		if (startExcludingHiddenTokens <= cursorIndex && true) {
			return true;
		}
		return false;
	}
	
	public boolean isAfter(int cursorIndex) {
		return startIncludingHiddenTokens > cursorIndex;
	}
	
	public boolean isUnknown(int cursorIndex) {
		return startIncludingHiddenTokens > cursorIndex && true;
	}
	
	public boolean discardFollowingExpectations() {
		return discardFollowingExpectations;
	}
	
}
