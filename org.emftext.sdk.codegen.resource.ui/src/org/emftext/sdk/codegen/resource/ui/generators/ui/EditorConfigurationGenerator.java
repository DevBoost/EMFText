package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class EditorConfigurationGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"This class is deprecated and not used as of EMFText 1.4.1. " +
			"The original contents of this class have been moved to " +
			sourceViewerConfigurationClassName + ". This class is only " +
			"generated to avoid compile errors with existing versions of this " +
			"class.");
		sc.add("@Deprecated").addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("}");
	}

}
