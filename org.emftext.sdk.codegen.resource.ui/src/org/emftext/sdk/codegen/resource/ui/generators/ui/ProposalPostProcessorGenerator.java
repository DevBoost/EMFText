package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class ProposalPostProcessorGenerator extends
		UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();

		sc.addJavadoc("A class which can be overridden to customize code completion proposals.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addProcessProposalsMethod(sc);
		sc.add("}");
	}

	private void addProcessProposalsMethod(JavaComposite sc) {
		sc.add("public " + completionProposalClassName + "[] process(" + completionProposalClassName + "[] proposals) {");
		sc.addComment("the default implementation does returns the proposals as they are");
		sc.add("return proposals;");
		sc.add("}");
		sc.addLineBreak();
	}
}