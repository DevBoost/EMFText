/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.ui.outline;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.emftext.runtime.ui.editor.EMFTextEditor;

/**
 * Simple Outline Page using the ReflectiveItemAdapters provided by EMF
 * 
 * @author cw
 * 
 */
public class EMFTextOutlinePage extends Page implements ISelectionProvider,
		ISelectionChangedListener, IContentOutlinePage {

	private EMFTextEditor editor;
	private ListenerList selectionChangedListeners = new ListenerList();
	private TreeViewer treeViewer;

	public EMFTextOutlinePage(EMFTextEditor textEditor) {
		super();
		this.editor = textEditor;

	}

	@Override
	public void createControl(Composite parent) {
		treeViewer = new EMFTextOutlinePageTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		treeViewer.addSelectionChangedListener(this);

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(
				adapterFactory);

		treeViewer.setAutoExpandLevel(3);
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		treeViewer.setInput(editor.getResourceSet().getResources().get(0));

		if (!editor.getResourceSet().getResources().isEmpty()) {
			// Select the root object in the view.
			//
			treeViewer.setSelection(new StructuredSelection(editor
					.getResourceSet().getResources().get(0)), true);
		}

	}

	/*
	 * (non-Javadoc) Method declared on ISelectionProvider.
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/**
	 * Fires a selection changed event.
	 * 
	 * @param selection
	 *            the new selection
	 */
	protected void fireSelectionChanged(ISelection selection) {
		// create an event
		final SelectionChangedEvent event = new SelectionChangedEvent(this,
				selection);

		// fire the event
		Object[] listeners = selectionChangedListeners.getListeners();
		for (int i = 0; i < listeners.length; ++i) {
			final ISelectionChangedListener l = (ISelectionChangedListener) listeners[i];
			SafeRunner.run(new SafeRunnable() {
				public void run() {
					l.selectionChanged(event);
				}
			});
		}
	}

	/*
	 * (non-Javadoc) Method declared on IPage (and Page).
	 */
	public Control getControl() {
		if (treeViewer == null) {
			return null;
		}
		return treeViewer.getControl();
	}

	/*
	 * (non-Javadoc) Method declared on ISelectionProvider.
	 */
	public ISelection getSelection() {
		if (treeViewer == null) {
			return StructuredSelection.EMPTY;
		}
		return treeViewer.getSelection();
	}

	/**
	 * Returns this page's tree viewer.
	 * 
	 * @return this page's tree viewer, or <code>null</code> if
	 *         <code>createControl</code> has not been called yet
	 */
	protected TreeViewer getTreeViewer() {
		return treeViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.part.IPageBookViewPage#init(org.eclipse.ui.part.IPageSite)
	 */
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		pageSite.setSelectionProvider(this);
	}

	/*
	 * (non-Javadoc) Method declared on ISelectionProvider.
	 */
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/*
	 * (non-Javadoc) Method declared on ISelectionChangeListener. Gives
	 * notification that the tree selection has changed.
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		fireSelectionChanged(event.getSelection());
	}

	/**
	 * Sets focus to a part in the page.
	 */
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

	/*
	 * (non-Javadoc) Method declared on ISelectionProvider.
	 */
	public void setSelection(ISelection selection) {
		if (treeViewer != null) {
			treeViewer.setSelection(selection);
		}
	}

}
