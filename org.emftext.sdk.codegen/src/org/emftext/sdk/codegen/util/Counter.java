package org.emftext.sdk.codegen.util;

/**
 * A simple wrapper for an integer, which can be increased and
 * read.
 */
public class Counter {

	private int value;

	public int getValue() {
		return value;
	}
	
	public void inc() {
		value += 1;
	}
}
