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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ACTION;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class OutlinePageLexicalSortingActionGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + abstractOutlinePageActionClassName + " {");
		sc.addLineBreak();
		addConstructor(sc);
		addRunInternalMethod(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + outlinePageTreeViewerClassName + " treeViewer) {");
		sc.add("super(treeViewer, \"Sort alphabetically\", " + I_ACTION + ".AS_CHECK_BOX);");
		sc.add("initialize(\"" + UIConstants.DEFAULT_ICON_DIR + "/" + UIConstants.Icon.DEFAULT_SORT_LEXICALLY_ICON.getFilename() + "\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRunInternalMethod(JavaComposite sc) {
		sc.add("public void runInternal(boolean on) {");
		sc.add("getTreeViewerComparator().setSortLexically(on);");
		sc.add("getTreeViewer().refresh();");
		sc.add("}");
		sc.addLineBreak();
	}
}
