/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import org.eclipse.jface.action.IAction;

public class Cct5OutlinePageCollapseAllAction extends org.emftext.test.cct5.resource.cct5.ui.AbstractCct5OutlinePageAction {
	
	public Cct5OutlinePageCollapseAllAction(org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
