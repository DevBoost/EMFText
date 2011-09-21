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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.ui.actions.HideOptionsAction;
import org.emftext.sdk.concretesyntax.resource.cs.ui.actions.HideTokenDefinitionsAction;

public class CsOutlinePageActionProvider {
	
	public List<IAction> getActions(CsOutlinePageTreeViewer treeViewer) {
		// we do not want to see annotations in the outline view
		treeViewer.addTypeToFilter(ConcretesyntaxPackage.eINSTANCE.getAnnotation());
		
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new CsOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new CsOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new CsOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new CsOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new CsOutlinePageLexicalSortingAction(treeViewer));
		// here come the custom options
		defaultActions.add(new HideOptionsAction(treeViewer));
		defaultActions.add(new HideTokenDefinitionsAction(treeViewer));
		return defaultActions;
	}
	
}
