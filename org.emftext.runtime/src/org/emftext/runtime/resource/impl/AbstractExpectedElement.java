package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.IExpectedElement;

/**
 * Abstract super class for all expected elements. Provides methods to
 * set and retrieve the document range, where the element is expected.
 * This range is expressed using four integers - two denoting the range
 * including hidden tokens (e.g., whitespace) and two denoting the range
 * excluding those token (i.e., the part of the document containing the
 * relevant characters).
 */
// TODO generate this class
public abstract class AbstractExpectedElement implements IExpectedElement {

	private int startIncludingHiddenTokens;
	private int startExcludingHiddenTokens;
	//private int endIncludingHiddenTokens;
	//private int endExcludingHiddenTokens;
	private String prefix;
	private String scopeID;
	private boolean discardFollowingExpectations;
	
	public AbstractExpectedElement(String scopeID, boolean discardFollowingExpectations) {
		this.scopeID = scopeID;
		this.discardFollowingExpectations = discardFollowingExpectations;
	}

	public void setPosition(
			int startIncludingHiddenTokens, 
			int startExcludingHiddenTokens 
			//int endIncludingHiddenTokens,
			//int endExcludingHiddenTokens
	) {
		//startIncludingHiddenTokens = Math.min(startIncludingHiddenTokens, startExcludingHiddenTokens);
		//startIncludingHiddenTokens = Math.min(startIncludingHiddenTokens, endIncludingHiddenTokens);
		//endIncludingHiddenTokens = Math.min(endIncludingHiddenTokens, endExcludingHiddenTokens);

		/*System.out.println("setPosition: " +
				toString(startIncludingHiddenTokens) + "(" +
				toString(startExcludingHiddenTokens) + ") in " + this);*/
/*		System.out.println("setPosition: " +
				toString(startIncludingHiddenTokens) + "-" +
				toString(endIncludingHiddenTokens) + " (" +
				toString(startExcludingHiddenTokens) + "-" +
				toString(endExcludingHiddenTokens) + 
				") in " + this);*/
		
		//assert startIncludingHiddenTokens <= endIncludingHiddenTokens;
		//assert endIncludingHiddenTokens <= endIncludingHiddenTokens;
		assert startExcludingHiddenTokens <= startExcludingHiddenTokens;
		//assert endExcludingHiddenTokens <= endExcludingHiddenTokens;
		
		assert startIncludingHiddenTokens <= startExcludingHiddenTokens;
		//assert endExcludingHiddenTokens <= endIncludingHiddenTokens;

		this.startIncludingHiddenTokens = startIncludingHiddenTokens;
		this.startExcludingHiddenTokens = startExcludingHiddenTokens;
		//this.endIncludingHiddenTokens = endIncludingHiddenTokens;
		//this.endExcludingHiddenTokens = endExcludingHiddenTokens;
	}

	public int getStartIncludingHiddenTokens() {
		return startIncludingHiddenTokens;
	}

	public int getStartExcludingHiddenTokens() {
		return startExcludingHiddenTokens;
	}
	
	public String getScopeID() {
		return scopeID;
	}

	/*
	public int getEndIncludingHiddenTokens() {
		return endIncludingHiddenTokens;
	}

	public int getEndExcludingHiddenTokens() {
		return endExcludingHiddenTokens;
	}
*/
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	/**
	 * Checks whether the cursor index is inside the range of
	 * relevant characters, not considering hidden tokens
	 * (e.g., whitespace).
	 */
	public boolean isAt(int cursorIndex) {
		if (startExcludingHiddenTokens <= cursorIndex &&
			true) {//endExcludingHiddenTokens >= cursorIndex) {
			return true;
		}
		return false;
	}
	
	public boolean isAfter(int cursorIndex) {
		return startIncludingHiddenTokens > cursorIndex;
	}

	public boolean isUnknown(int cursorIndex) {
		return 
			startIncludingHiddenTokens > cursorIndex &&
			true; //endIncludingHiddenTokens == Integer.MAX_VALUE;
	}
	
	public boolean discardFollowingExpectations() {
		return discardFollowingExpectations;
	}

	public String toString() {
		return 
		toString(startIncludingHiddenTokens) + "(" + toString(startExcludingHiddenTokens) + ")" +
		/*" (" + toString(startExcludingHiddenTokens) + "-" + toString(endExcludingHiddenTokens) + ")"*/ 
		//" prefix = '" + prefix + "'" + 
		" scope = " + scopeID + "" + 
		" discardFollowing = " + discardFollowingExpectations;
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
