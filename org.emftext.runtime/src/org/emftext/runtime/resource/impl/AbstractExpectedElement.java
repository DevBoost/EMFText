package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.IExpectedElement;

/**
 * Abstract super class for all expected elements. Provides method to
 * set and retrieve the document range, where the element is expected.
 * This range is expressed using four integers - two denoting the range
 * including hidden tokens (e.g., whitespace) and two denoting the range
 * excluding those token (i.e., the part of the document containing the
 * relevant characters).
 */
public abstract class AbstractExpectedElement implements IExpectedElement {

	private int startIncludingHiddenTokens;
	private int startExcludingHiddenTokens;
	private int endIncludingHiddenTokens;
	private int endExcludingHiddenTokens;
	private String prefix;

	public void setPosition(
			int startIncludingHiddenTokens, 
			int startExcludingHiddenTokens, 
			int endIncludingHiddenTokens,
			int endExcludingHiddenTokens
	) {
		startIncludingHiddenTokens = Math.min(startIncludingHiddenTokens, startExcludingHiddenTokens);
		startIncludingHiddenTokens = Math.min(startIncludingHiddenTokens, endIncludingHiddenTokens);
		endIncludingHiddenTokens = Math.max(endIncludingHiddenTokens, endExcludingHiddenTokens);
/*
		System.out.println("setPosition: " +
				startIncludingHiddenTokens + "-" +
				endIncludingHiddenTokens + " (" +
				startExcludingHiddenTokens + "-" +
				endExcludingHiddenTokens + 
				")");*/
		
		assert startIncludingHiddenTokens <= endIncludingHiddenTokens;
		assert endIncludingHiddenTokens <= endIncludingHiddenTokens;
		assert startExcludingHiddenTokens <= startExcludingHiddenTokens;
		assert endExcludingHiddenTokens <= endExcludingHiddenTokens;
		
		assert startIncludingHiddenTokens <= startExcludingHiddenTokens;
		assert endExcludingHiddenTokens <= endIncludingHiddenTokens;

		this.startIncludingHiddenTokens = startIncludingHiddenTokens;
		this.startExcludingHiddenTokens = startExcludingHiddenTokens;
		this.endIncludingHiddenTokens = endIncludingHiddenTokens;
		this.endExcludingHiddenTokens = endExcludingHiddenTokens;
	}

	public int getStartIncludingHiddenTokens() {
		return startIncludingHiddenTokens;
	}

	public int getStartExcludingHiddenTokens() {
		return startExcludingHiddenTokens;
	}

	public int getEndIncludingHiddenTokens() {
		return endIncludingHiddenTokens;
	}

	public int getEndExcludingHiddenTokens() {
		return endExcludingHiddenTokens;
	}
	
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
			endExcludingHiddenTokens >= cursorIndex) {
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
			endIncludingHiddenTokens == Integer.MAX_VALUE;
	}
	
	public String toString() {
		return 
		toString(startIncludingHiddenTokens) + "-" + toString(endIncludingHiddenTokens) +
		" (" + toString(startExcludingHiddenTokens) + "-" + toString(endExcludingHiddenTokens) + ") prefix = '" + prefix + "'" ;
	}
	
	private String toString(int index) {
		if (index == -1) {
			return "MIN";
		} else if (index == Integer.MAX_VALUE) {
			return "?";
		} else {
			return "" + index;
		}
	}
}
