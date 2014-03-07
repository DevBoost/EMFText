/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ACTION;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

public class OutlinePageActionProviderGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetActionsMethod(sc);
	}

	private void addGetActionsMethod(JavaComposite sc) {
		sc.add("public " + LIST(sc) + "<" + I_ACTION(sc) + "> getActions(" + outlinePageTreeViewerClassName + " treeViewer) {");
		sc.addComment(
				"To add custom actions to the outline view, " + 
				"set the '" + OptionTypes.OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER.getLiteral() + "' " +
				"option to <code>false</code> and modify this method.");
		sc.add(sc.declareArrayList("defaultActions",I_ACTION(sc)));
		sc.add("defaultActions.add(new " + outlinePageLinkWithEditorActionClassName + "(treeViewer));");
		sc.add("defaultActions.add(new " + outlinePageCollapseAllActionClassName + "(treeViewer));");
		sc.add("defaultActions.add(new " + outlinePageExpandAllActionClassName + "(treeViewer));");
		sc.add("defaultActions.add(new " + outlinePageAutoExpandActionClassName + "(treeViewer));");
		sc.add("defaultActions.add(new " + outlinePageLexicalSortingActionClassName + "(treeViewer));");
		sc.add("defaultActions.add(new " + outlinePageTypeSortingActionClassName + "(treeViewer));");
		sc.add("return defaultActions;");
		sc.add("}");
		sc.addLineBreak();
	}
}
