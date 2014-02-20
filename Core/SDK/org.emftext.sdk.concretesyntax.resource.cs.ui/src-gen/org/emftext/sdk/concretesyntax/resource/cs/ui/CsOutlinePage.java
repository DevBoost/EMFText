/*******************************************************************************
 * Copyright (c) 2006-2014
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import java.util.List;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.IViewerNotification;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

/**
 * Simple Outline Page using the ReflectiveItemAdapters provided by EMF
 */
public class CsOutlinePage extends Page implements ISelectionProvider, ISelectionChangedListener, IContentOutlinePage {
	
	public final static String CONTEXT_MENU_ID = "org.emftext.sdk.concretesyntax.resource.cs.ui.outlinecontext";
	
	/**
	 * The auto expand level determines the depth to which the outline tree is
	 * expanded by default.
	 */
	public static int AUTO_EXPAND_LEVEL = 2;
	
	/**
	 * The provider for the resource that is displayed in the outline page. Normally
	 * this is the current editor.
	 */
	private org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider resourceProvider;
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageTreeViewer treeViewer;
	private ListenerList selectionChangedListeners = new ListenerList();
	
	public CsOutlinePage(org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
	}
	
	public void createControl(Composite parent) {
		treeViewer = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		Object[] listeners = selectionChangedListeners.getListeners();
		for (int i = 0; i < listeners.length; ++i) {
			ISelectionChangedListener l = (ISelectionChangedListener) listeners[i];
			treeViewer.addSelectionChangedListener(l);
		}
		selectionChangedListeners.clear();
		org.eclipse.emf.edit.provider.ComposedAdapterFactory adapterFactory = new org.eclipse.emf.edit.provider.ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory());
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(adapterFactory) {
			
			@Override
			public void notifyChanged(Notification notification) {
				if (viewer != null && viewer.getControl() != null && !viewer.getControl().isDisposed()) {
					viewerRefresh = new ViewerRefresh(viewer) {
						
						protected void refresh(IViewerNotification notification) {
							if (viewer instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageTreeViewer) {
								org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageTreeViewer pageTreeViewer = (org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageTreeViewer) viewer;
								pageTreeViewer.setSuppressNotifications(true);
								super.refresh(notification);
								pageTreeViewer.setSuppressNotifications(false);
							} else {
								super.refresh(notification);
							}
						}
					};
				}
				super.notifyChanged(notification);
			}
		};
		
		treeViewer.setAutoExpandLevel(AUTO_EXPAND_LEVEL);
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		Resource resource = resourceProvider.getResource();
		treeViewer.setInput(resource);
		if (resource != null) {
			// Select the root object in the view.
			treeViewer.setSelection(new StructuredSelection(resource), true);
		}
		treeViewer.setComparator(new org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageTreeViewerComparator());
		createContextMenu();
		createActions();
	}
	
	private void createContextMenu() {
		// create menu manager
		MenuManager menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		// create menu
		Menu menu = menuManager.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);
		// register menu for extension
		getSite().registerContextMenu("org.emftext.sdk.concretesyntax.resource.cs.ui.outlinecontext", menuManager, treeViewer);
	}
	
	private void fillContextMenu(IMenuManager manager) {
		manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void createActions() {
		IPageSite site = getSite();
		IActionBars actionBars = site.getActionBars();
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		List<IAction> actions = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageActionProvider().getActions(treeViewer);
		for (IAction action : actions) {
			toolBarManager.add(action);
		}
	}
	
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		if (getTreeViewer() == null) {
			selectionChangedListeners.add(listener);
		} else {
			getTreeViewer().addSelectionChangedListener(listener);
		}
	}
	
	public Control getControl() {
		if (treeViewer == null) {
			return null;
		}
		return treeViewer.getControl();
	}
	
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
	 * <code>createControl</code> has not been called yet
	 */
	protected TreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public void init(IPageSite pageSite) {
		super.init(pageSite);
	}
	
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		if (getTreeViewer() == null) {
			selectionChangedListeners.remove(listener);
		} else {
			getTreeViewer().removeSelectionChangedListener(listener);
		}
	}
	
	public void selectionChanged(SelectionChangedEvent event) {
		if (getTreeViewer() != null) {
			getTreeViewer().setSelection(event.getSelection(), true);
		}
	}
	
	/**
	 * Sets focus to a part in the page.
	 */
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}
	
	public void setSelection(ISelection selection) {
		if (treeViewer != null) {
			treeViewer.setSelection(selection);
		}
	}
	
}
