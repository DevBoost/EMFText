package org.antlr.stringtemplate.language;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.reflect.Array;

/** Turn an array into a List; subclass ArrayList for easy development, but
 *  it really doesn't use super stuff for anything.  Ensure we create
 *  ArrayIterator for this List.
 */
public class ArrayWrappedInList extends ArrayList {
	protected Object array = null;
	/** Arrays are fixed size; precompute. */
	protected int n;

	public ArrayWrappedInList(Object array) {
		this.array = array;
		n = Array.getLength(array);
	}

	public Object get(int i) {
		return Array.get(array, i);
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n==0;
	}

	public Object[] toArray() {
		return (Object[])array;
	}

	public Iterator iterator() {
		return new ArrayIterator(array);
	}
}
