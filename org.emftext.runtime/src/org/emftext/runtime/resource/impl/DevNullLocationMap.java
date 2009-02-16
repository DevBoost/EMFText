package org.emftext.runtime.resource.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ILocationMap;

/**
 * An implementation of the ILocationMap interface that 
 * does not store location information at all. This class
 * can be used in test cases where location information
 * is not required.
 */
public class DevNullLocationMap implements ILocationMap {

	public int getCharEnd(EObject element) {
		return 0;
	}

	public int getCharStart(EObject element) {
		return 0;
	}

	public int getColumn(EObject element) {
		return 0;
	}

	public List<EObject> getElementsAt(EObject root, int documentOffset) {
		return null;
	}

	public List<EObject> getElementsBetween(EObject root, int startOffset,
			int endOffset) {
		return null;
	}

	public int getLine(EObject element) {
		return 0;
	}

	public void setCharEnd(EObject element, int charEnd) {
	}

	public void setCharStart(EObject element, int charStart) {
	}

	public void setColumn(EObject element, int column) {
	}

	public void setLine(EObject element, int line) {
	}
}
