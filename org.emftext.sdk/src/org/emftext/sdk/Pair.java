package org.emftext.sdk;

/**
 * A types pair of objects.
 *
 * @param <T1> the type of the first (left) object
 * @param <T2> the type of the second (right) object
 */
public class Pair<T1, T2> {
	
	private T1 left; 
	private T2 right;
	
	public Pair(T1 left, T2 right) {
		this.left = left;
		this.right = right;
	}

	public T1 getLeft() {
		return left;
	}

	public T2 getRight() {
		return right;
	}
}
