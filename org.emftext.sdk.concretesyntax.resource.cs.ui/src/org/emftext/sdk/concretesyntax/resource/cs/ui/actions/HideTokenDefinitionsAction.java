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
package org.emftext.sdk.concretesyntax.resource.cs.ui.actions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.IAction;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.ui.AbstractCsOutlinePageAction;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsOutlinePageTreeViewer;

public class HideTokenDefinitionsAction extends AbstractCsOutlinePageAction {

	private static final EClass ECLASS_TOKEN_DIRECTIVE = ConcretesyntaxPackage.eINSTANCE.getTokenDirective();

	public HideTokenDefinitionsAction(CsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Hide token directives", IAction.AS_CHECK_BOX);
		initialize("icons/hide_token_directives_icon.gif");
	}

	@Override
	public void runInternal(boolean on) {
		CsOutlinePageTreeViewer treeViewer = getTreeViewer();
		if (on) {
			treeViewer.addTypeToFilter(ECLASS_TOKEN_DIRECTIVE);
		} else {
			treeViewer.removeTypeToFilter(ECLASS_TOKEN_DIRECTIVE);
		}
		treeViewer.refresh();
	}
}
