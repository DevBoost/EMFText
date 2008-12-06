package org.antlr.stringtemplate.language;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.reflect.Array;

/** Iterator for an array so I don't have to copy the array to a List
 *  just to make it iteratable.
 */
public class ArrayIterator implements Iterator {
	/** Index into the data array */
	protected int i = -1;
	protected Object array = null;
	/** Arrays are fixed size; precompute. */
	protected int n;

	public ArrayIterator(Object array) {
		this.array = array;
		n = Array.getLength(array);
	}

	public boolean hasNext() {
		return (i+1)<n && n>0;
	}

	public Object next() {
		i++; // move to next element
		if ( i >= n ) {
			throw new NoSuchElementException();
		}
		return Array.get(array, i);
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
