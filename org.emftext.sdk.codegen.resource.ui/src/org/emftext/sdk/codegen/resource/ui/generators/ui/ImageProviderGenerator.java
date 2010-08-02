package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.*;

import org.eclipse.ui.ISharedImages;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class ImageProviderGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A provider class for all images that are required by the generated UI plug-in. " +
			"The default implementation load images from the bundle and caches them to make sure " +
			"each image is loaded at most once."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addGetImageMethod(sc);
		sc.add("}");
	}

	private void addGetImageMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the image associated with the given key. " +
			"The key can be either a path to an image file in the resource bundle or " +
			"a shared image from " + ISharedImages.class.getName() + "."
		);
		sc.add("public " + IMAGE + " getImage(String key) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
}
