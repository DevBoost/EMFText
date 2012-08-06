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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.ui;

// This custom implementation of a TreeViewer expands the tree
// automatically up to a specified depth.
public class GeneratorconfigOutlinePageTreeViewer extends org.eclipse.jface.viewers.TreeViewer {

	boolean suppressNotifications = false;

	public GeneratorconfigOutlinePageTreeViewer(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
	}

	public void setSelection(org.eclipse.jface.viewers.ISelection selection, boolean reveal) {
		if (selection instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigEObjectSelection) {
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
			// In the cases of an invalid document, the tree widget in the outline might fire an event
			// (with item == null) without user interaction. We do not want to react to that event.
		}
		else {
			super.handleSelect(event);
		}
	}

	protected void handleInvalidSelection(org.eclipse.jface.viewers.ISelection selection, org.eclipse.jface.viewers.ISelection newSelection) {
		//this may not fire a selection changed event to avoid cyclic events between editor and outline
	}

	public void refresh(Object element, boolean updateLabels) {
		super.refresh(element, updateLabels);
		expandToLevel(getAutoExpandLevel());
	}

	public void refresh(Object element) {
		super.refresh(element);
		expandToLevel(getAutoExpandLevel());
	}

	public void refresh() {
		super.refresh();
		expandToLevel(getAutoExpandLevel());
	}

	public void refresh(boolean updateLabels) {
		super.refresh(updateLabels);
		expandToLevel(getAutoExpandLevel());
	}
	protected void fireSelectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		if (suppressNotifications == true) return;
		super.fireSelectionChanged(event);
	}

}
