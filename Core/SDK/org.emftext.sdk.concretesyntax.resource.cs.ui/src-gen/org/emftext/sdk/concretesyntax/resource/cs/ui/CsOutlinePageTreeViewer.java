/*******************************************************************************
 * Copyright (c) 2006-2012
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

/**
 * This custom implementation of a TreeViewer expands the tree automatically up to
 * a specified depth.
 */
public class CsOutlinePageTreeViewer extends org.eclipse.jface.viewers.TreeViewer {
	
	public class TypeFilter extends org.eclipse.jface.viewers.ViewerFilter {
		
		private java.util.Set<org.eclipse.emf.ecore.EClass> filteredTypes = new java.util.LinkedHashSet<org.eclipse.emf.ecore.EClass>();
		
		@Override		
		public boolean select(org.eclipse.jface.viewers.Viewer viewer, Object parentElement, Object element) {
			if (element instanceof org.eclipse.emf.ecore.EObject) {
				org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) element;
				for (org.eclipse.emf.ecore.EClass filteredType : filteredTypes) {
					if (filteredType.isInstance(eObject)) {
						return false;
					}
				}
			}
			return true;
		}
		
		public java.util.Set<org.eclipse.emf.ecore.EClass> getFilteredTypes() {
			return filteredTypes;
		}
	}
	
	private static class FlatEObjectComparer extends org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper {
		
		private static final long serialVersionUID = 1L;
		
		@Override		
		protected boolean haveEqualReference(org.eclipse.emf.ecore.EObject eObject1, org.eclipse.emf.ecore.EObject eObject2, org.eclipse.emf.ecore.EReference reference) {
			return true;
		}
		
		@Override		
		protected boolean equalFeatureMaps(org.eclipse.emf.ecore.util.FeatureMap featureMap1, org.eclipse.emf.ecore.util.FeatureMap featureMap2) {
			return true;
		}
		
	}
	
	private boolean suppressNotifications = false;
	
	private boolean linkWithEditor = false;
	
	private boolean autoExpand = false;
	
	private TypeFilter typeFilter = new TypeFilter();
	
	public CsOutlinePageTreeViewer(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		addFilter(typeFilter);
		setComparer(new org.eclipse.jface.viewers.IElementComparer() {
			
			public int hashCode(Object element) {
				String s = toString(element);
				if (s != null) {
					return s.hashCode();
				}
				return element.hashCode();
			}
			
			public boolean equals(Object o1, Object o2) {
				if (o1 instanceof org.eclipse.emf.ecore.EObject && o2 instanceof org.eclipse.emf.ecore.EObject) {
					return new FlatEObjectComparer().equals((org.eclipse.emf.ecore.EObject) o1, (org.eclipse.emf.ecore.EObject) o2);
				}
				String s1 = toString(o1);
				String s2 = toString(o2);
				if (s1 != null) {
					return s1.equals(s2);
				}
				return o1.equals(o2);
			}
			
			private String toString(Object o) {
				if (o instanceof String) {
					return (String) o;
				}
				if (o instanceof org.eclipse.emf.ecore.resource.Resource) {
					return ((org.eclipse.emf.ecore.resource.Resource) o).getURI().toString();
				}
				return null;
			}
			
		});
		
	}
	
	public void setSelection(org.eclipse.jface.viewers.ISelection selection, boolean reveal) {
		if (!linkWithEditor) {
			return;
		}
		if (selection instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsEObjectSelection) {
			suppressNotifications = true;
			super.setSelection(selection, reveal);
			suppressNotifications = false;
		}
		else {
			super.setSelection(selection, reveal);
		}
	}
	
	protected void handleSelect(org.eclipse.swt.events.SelectionEvent event) {
		if (event.item == null) {
			// In the cases of an invalid document, the tree widget in the outline might fire
			// an event (with item == null) without user interaction. We do not want to react
			// to that event.
		} else {
			super.handleSelect(event);
		}
	}
	
	protected void handleInvalidSelection(org.eclipse.jface.viewers.ISelection selection, org.eclipse.jface.viewers.ISelection newSelection) {
		// this may not fire a selection changed event to avoid cyclic events between
		// editor and outline
	}
	
	public void refresh(Object element, boolean updateLabels) {
		super.refresh(element, updateLabels);
		doAutoExpand();
	}
	
	public void refresh(Object element) {
		super.refresh(element);
		doAutoExpand();
	}
	
	public void refresh() {
		super.refresh();
		doAutoExpand();
	}
	
	public void refresh(boolean updateLabels) {
		super.refresh(updateLabels);
		doAutoExpand();
	}
	
	public void setAutoExpand(boolean autoExpand) {
		this.autoExpand = autoExpand;
	}
	
	public void expandToLevel(int level) {
		// we need to catch exceptions here, because refreshing the outline does sometimes
		// cause the LabelProviders to throw exceptions, if the model is in some
		// inconsistent state.
		try {
			super.expandToLevel(level);
		} catch (Exception e) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("Exception while refreshing outline view", e);
		}
	}
	
	protected void fireSelectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		if (suppressNotifications == true) {
			return;
		}
		super.fireSelectionChanged(event);
	}
	
	public void setLinkWithEditor(boolean on) {
		this.linkWithEditor = on;
	}
	
	private void doAutoExpand() {
		if (!autoExpand) {
			return;
		}
		expandToLevel(getAutoExpandLevel());
	}
	
	public void addTypeToFilter(org.eclipse.emf.ecore.EClass typeToFilter) {
		typeFilter.getFilteredTypes().add(typeToFilter);
	}
	
	public void removeTypeToFilter(org.eclipse.emf.ecore.EClass typeToNotFilter) {
		typeFilter.getFilteredTypes().remove(typeToNotFilter);
	}
	
}
