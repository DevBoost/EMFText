package org.antlr.stringtemplate.language;

import java.util.Iterator;
import java.util.List;
import java.util.AbstractList;
import java.util.ArrayList;

/** Given a list of attributes, return the combined elements in a list. */
public class Cat extends AbstractList {
	protected List elements;

	public Iterator iterator() {
		return super.iterator();
	}

	public Object get(int index) {
		return elements.get(index);
	}

	public int size() {
		return elements.size();
	}

	public Cat(List attributes) {
		elements = new ArrayList();
		for (int i = 0; i < attributes.size(); i++) {
			Object attribute = (Object) attributes.get(i);
			attribute = ASTExpr.convertAnythingIteratableToIterator(attribute);
			if ( attribute instanceof Iterator ) {
				Iterator it = (Iterator)attribute;
				while (it.hasNext()) {
					Object o = (Object) it.next();
					elements.add(o);
				}
			}
			else {
				elements.add(attribute);
			}
		}
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < elements.size(); i++) {
			Object o = (Object) elements.get(i);
			buf.append(o);
		}
		return buf.toString();
	}
}
