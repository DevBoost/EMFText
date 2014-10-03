/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import org.eclipse.jface.action.IAction;

public class Cct5OutlinePageTypeSortingAction extends org.emftext.test.cct5.resource.cct5.ui.AbstractCct5OutlinePageAction {
	
	public Cct5OutlinePageTypeSortingAction(org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
