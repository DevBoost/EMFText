package org.emftext.sdk.concretesyntax.resource.cs.ui.actions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.IAction;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.ui.AbstractCsOutlinePageAction;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageTreeViewer;

public class HideOptionsAction extends AbstractCsOutlinePageAction {

	private static final EClass ECLASS_OPTION = ConcretesyntaxPackage.eINSTANCE.getOption();

	public HideOptionsAction(CsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Hide options", IAction.AS_CHECK_BOX);
		initialize("icons/hide_options_icon.gif");
	}

	@Override
	public void runInternal(boolean on) {
		CsOutlinePageTreeViewer treeViewer = getTreeViewer();
		if (on) {
			treeViewer.addTypeToFilter(ECLASS_OPTION);
		} else {
			treeViewer.removeTypeToFilter(ECLASS_OPTION);
		}
		treeViewer.refresh();
	}
}
