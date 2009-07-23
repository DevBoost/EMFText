package org.emftext.runtime.ui.extensions;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * A simple default implementation of a {@link ISelectionProvider}. It stores
 * the selection and notifies all selection change listeners when the selection
 * is set.
 */
public class SimpleSelectionProvider implements ISelectionProvider {

	private final ListenerList selectionChangedListeners;
	private ISelection selection;

	/**
	 * Create a new SimpleSelectionProvider
	 */
	public SimpleSelectionProvider() {
		selectionChangedListeners = new ListenerList();
	}

	/*
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	public ISelection getSelection() {
		return selection;
	}

	/*
	 * @see
	 * org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	public void setSelection(ISelection selection) {
		this.selection = selection;

		Object[] listeners = selectionChangedListeners.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((ISelectionChangedListener) listeners[i]).selectionChanged(new SelectionChangedEvent(this, selection));
		}
	}

	/*
	 * @see
	 * org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener
	 * (org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}
}
