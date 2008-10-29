/**
 * 
 */
package org.reuseware.emftextedit.ui.editor;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

final class EMFTextOutlinePageTreeViewer extends TreeViewer {
	
	EMFTextOutlinePageTreeViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void refresh(Object element, boolean updateLabels) {
		super.refresh(element, updateLabels);
		expandToLevel(getAutoExpandLevel());
	}

	@Override
	public void refresh(Object element) {
		super.refresh(element);
		expandToLevel(getAutoExpandLevel());
	}

	@Override
	public void refresh() {
		super.refresh();
		expandToLevel(getAutoExpandLevel());
	}

	@Override
	public void refresh(boolean updateLabels) {
		super.refresh(updateLabels);
		expandToLevel(getAutoExpandLevel());
	}
}