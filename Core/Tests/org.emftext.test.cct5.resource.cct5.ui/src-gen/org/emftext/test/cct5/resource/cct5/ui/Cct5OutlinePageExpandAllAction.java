/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import org.eclipse.jface.action.IAction;

public class Cct5OutlinePageExpandAllAction extends org.emftext.test.cct5.resource.cct5.ui.AbstractCct5OutlinePageAction {
	
	public Cct5OutlinePageExpandAllAction(org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
