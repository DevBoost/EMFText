/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import org.eclipse.jface.action.IAction;

public class Cct5OutlinePageLexicalSortingAction extends org.emftext.test.cct5.resource.cct5.ui.AbstractCct5OutlinePageAction {
	
	public Cct5OutlinePageLexicalSortingAction(org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
