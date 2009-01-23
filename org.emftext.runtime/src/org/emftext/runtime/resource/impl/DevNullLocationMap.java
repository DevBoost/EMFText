package org.emftext.runtime.resource.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ILocationMap;

public class DevNullLocationMap implements ILocationMap {

	public int getCharEnd(EObject element) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCharStart(EObject element) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumn(EObject element) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<EObject> getElementsAt(EObject root, int documentOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EObject> getElementsBetween(EObject root, int startOffset,
			int endOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLine(EObject element) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setCharEnd(EObject element, int charEnd) {
		// TODO Auto-generated method stub
		
	}

	public void setCharStart(EObject element, int charStart) {
		// TODO Auto-generated method stub
		
	}

	public void setColumn(EObject element, int column) {
		// TODO Auto-generated method stub
		
	}

	public void setLine(EObject element, int line) {
		// TODO Auto-generated method stub
		
	}

}
