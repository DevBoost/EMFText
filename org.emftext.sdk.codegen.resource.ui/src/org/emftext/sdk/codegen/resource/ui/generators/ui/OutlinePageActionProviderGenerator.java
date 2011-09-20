package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.*;

public class OutlinePageActionProviderGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
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
		sc.add("public " + LIST + "<" + I_ACTION + "> getActions(" + outlinePageTreeViewerClassName + " treeViewer) {");
		sc.addComment(
				"To add custom actions to the outline view, " + 
				"set the '" + OptionTypes.OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER.getLiteral() + "' " +
				"option to <code>false</code> and modify this method.");
		sc.add(sc.declareArrayList("defaultActions", I_ACTION));
		sc.add("defaultActions.add(new " + outlinePageLinkWithEditorActionClassName + "(treeViewer));");
		sc.add("defaultActions.add(new " + outlinePageCollapseAllActionClassName + "(treeViewer));");
		sc.add("defaultActions.add(new " + outlinePageExpandAllActionClassName + "(treeViewer));");
		sc.add("defaultActions.add(new " + outlinePageLexicalSortingActionClassName + "(treeViewer));");
		sc.add("defaultActions.add(new " + outlinePageTypeSortingActionClassName + "(treeViewer));");
		sc.add("return defaultActions;");
		sc.add("}");
		sc.addLineBreak();
	}
}
