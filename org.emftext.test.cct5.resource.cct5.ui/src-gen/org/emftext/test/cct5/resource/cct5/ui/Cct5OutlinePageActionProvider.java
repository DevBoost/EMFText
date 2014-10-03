/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class Cct5OutlinePageActionProvider {
	
	public List<IAction> getActions(org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.test.cct5.resource.cct5.ui.Cct5OutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
