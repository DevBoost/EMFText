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

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class OutlinePageLinkWithEditorActionGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + abstractOutlinePageActionClassName + " {");
		sc.addLineBreak();
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + outlinePageTreeViewerClassName + " treeViewer) {");
		sc.add("super(treeViewer, \"Link with Editor\", " + I_ACTION + ".AS_CHECK_BOX);");
		sc.add("initialize(\"" + UIConstants.DEFAULT_ICON_DIR + "/" + UIConstants.Icon.DEFAULT_LINK_WITH_EDITOR_ICON.getFilename() + "\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addRunInternalMethod(sc);
	}

	private void addRunInternalMethod(JavaComposite sc) {
		sc.add("public void runInternal(boolean on) {");
		sc.add("getTreeViewer().setLinkWithEditor(on);");
		sc.add("}");
		sc.addLineBreak();
	}
}
