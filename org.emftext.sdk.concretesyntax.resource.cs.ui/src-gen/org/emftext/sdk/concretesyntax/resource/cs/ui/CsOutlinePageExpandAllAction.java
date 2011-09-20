/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsOutlinePageExpandAllAction extends org.emftext.sdk.concretesyntax.resource.cs.ui.AbstractCsOutlinePageAction {
	
	public CsOutlinePageExpandAllAction(org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().expandAll();
	}
	
	public boolean keepState() {
		return false;
	}
	
}
