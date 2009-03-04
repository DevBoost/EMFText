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
/**
 * 
 */
package org.emftext.runtime.ui.outline;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * This custom implementation of a TreeViewer expands the tree
 * automatically up to a specified depth. 
 */
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
