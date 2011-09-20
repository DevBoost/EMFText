package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ACTION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class OutlinePageExpandAllActionGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

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
		sc.add("super(treeViewer, \"Expand all\", " + I_ACTION + ".AS_PUSH_BUTTON);");
		sc.add("initialize(\"" + UIConstants.DEFAULT_ICON_DIR + "/" + UIConstants.Icon.DEFAULT_EXPAND_ALL_ICON.getFilename() + "\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addRunInternalMethod(sc);
		addKeepStateMethod(sc);
	}

	private void addRunInternalMethod(JavaComposite sc) {
		sc.add("public void runInternal(boolean on) {");
		sc.add("getTreeViewer().expandAll();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addKeepStateMethod(JavaComposite sc) {
		sc.add("public boolean keepState() {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
}
