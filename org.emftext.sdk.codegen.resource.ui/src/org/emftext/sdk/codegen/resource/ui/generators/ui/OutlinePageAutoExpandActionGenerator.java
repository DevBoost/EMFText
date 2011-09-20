package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ACTION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class OutlinePageAutoExpandActionGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

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
		sc.add("super(treeViewer, \"Auto expand\", " + I_ACTION + ".AS_CHECK_BOX);");
		sc.add("initialize(\"" + UIConstants.DEFAULT_ICON_DIR + "/" + UIConstants.Icon.DEFAULT_AUTO_EXPAND_ICON.getFilename() + "\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRunInternalMethod(JavaComposite sc) {
		sc.add("public void runInternal(boolean on) {");
		sc.add("getTreeViewer().setAutoExpand(on);");
		sc.add("getTreeViewer().refresh();");
		sc.add("}");
		sc.addLineBreak();
	}
}
