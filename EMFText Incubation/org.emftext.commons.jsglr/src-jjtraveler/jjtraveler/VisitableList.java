package jjtraveler;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * An auxiliary class to represent collections that implement the Visitable
 * interface. The element of the collection are assumed to be Visitables as
 * well.
 */

public class VisitableList extends AbstractList implements Visitable {

	/**
	 * Create a new list of visitables, backed by the given list. All elements
	 * of this list should be visitables.
	 */
	public VisitableList(List visitables) {
		this.visitables = visitables;
	}

	/**
	 * Create a new list of visitables, backed by a Vector initialized with the
	 * given collection. All elements of this collection should be visitables.
	 */
	public VisitableList(Collection visitables) {
		this(new Vector(visitables));
	}

	/** 
	 * Create a new list of visitables, backed by a Vector that is initially
	 * empty.
	 */
	public VisitableList() {
		this(new Vector());
	}

	private List visitables;

	public Object get(int i) {
		return visitables.get(i);
	}
	public int size() {
		return visitables.size();
	}
	public Object set(int index, Object element) {
		return visitables.set(index, element);
	}
	public void add(int index, Object element) {
		visitables.add(index, element);
	}
	
	public boolean add(Object element) {  
		visitables.add(element);
		return true;
	}
	
	public Object remove(int index) {
		return visitables.remove(index);
	}

	/**
	 * Return the number of visitables in the list.
	 */
	public int getChildCount() {
		return visitables.size();
	}

	/**
	 * Return the visitable at the given position in the list.
	 */
	public Visitable getChildAt(int i) {
		return (Visitable) get(i);
	}

	/**
	 * Update the list at the given position with the given visitable, and
	 * return the resulting list.
	 */
	public Visitable setChildAt(int i, Visitable visitable) {
		set(i, visitable);
		return this;
	}
}
