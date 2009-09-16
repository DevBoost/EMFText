package org.emftext.runtime.ui.extensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

@Deprecated
public class EObjectSelection implements IStructuredSelection {
	
	private final EObject selectedObject;
	private final boolean highlighting;
	
	public EObjectSelection(EObject selectedObject, boolean highlighting) {
		super();
		this.selectedObject = selectedObject;
		this.highlighting = highlighting;
	}
	
	public EObject getSelectedObject() {
		return selectedObject;
	}

	public boolean doHighlighting() {
		return highlighting;
	}

	public boolean isEmpty() {
		return false;
	}

	public Object getFirstElement() {
		return selectedObject;
	}

	public Iterator<?> iterator() {
		return new Iterator<?>() {
			
			private boolean hasNext = true;

			public boolean hasNext() {
				return hasNext;
			}

			public EObject next(){
				hasNext = false;
				return selectedObject;
			}

			public void remove() {
			}
		};
	}

	public int size() {
		return 1;
	}

	public Object[] toArray() {
		return new Object[] {selectedObject};
	}

	public List<?> toList() {
		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(selectedObject);
		return list;
	}
}
