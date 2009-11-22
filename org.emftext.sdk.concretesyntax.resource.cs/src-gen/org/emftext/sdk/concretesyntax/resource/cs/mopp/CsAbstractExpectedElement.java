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
	
	private int startIncludingHiddenTokens;
	private int startExcludingHiddenTokens;
	private String prefix;
	private int followSetID;
	private boolean discardFollowingExpectations;
	
	public CsAbstractExpectedElement(int followSetID) {
		this.followSetID = followSetID;
	}
	
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
	
	public int getFollowSetID() {
		return followSetID;
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
	
	public String toString() {
		return		toString(startIncludingHiddenTokens) + "(" + toString(startExcludingHiddenTokens) + ")" +		" followSetID = " + followSetID;
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
}
