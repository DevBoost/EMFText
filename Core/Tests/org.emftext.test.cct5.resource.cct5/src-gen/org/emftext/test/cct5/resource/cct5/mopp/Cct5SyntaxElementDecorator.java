/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.ArrayList;
import java.util.List;

public class Cct5SyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private Cct5SyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private List<Integer> indicesToPrint = new ArrayList<Integer>();
	
	public Cct5SyntaxElementDecorator(org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement decoratedElement, Cct5SyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public Cct5SyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
