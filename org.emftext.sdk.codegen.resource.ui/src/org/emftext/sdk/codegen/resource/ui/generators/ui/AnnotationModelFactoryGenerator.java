package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ANNOTATION_MODEL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ANNOTATION_MODEL_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PATH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKSPACE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKSPACE_ROOT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCES_PLUGIN;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class AnnotationModelFactoryGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_ANNOTATION_MODEL_FACTORY + " {");
		sc.addLineBreak();
		addCreateAnnotationModelMethod(sc);
		sc.add("}");
	}

	private void addCreateAnnotationModelMethod(JavaComposite sc) {
		sc.add("public " + I_ANNOTATION_MODEL + " createAnnotationModel(" + I_PATH + " location) {");
		sc.add(I_WORKSPACE + " workspace = " + RESOURCES_PLUGIN + ".getWorkspace();");
		sc.add(I_WORKSPACE_ROOT + " root = workspace.getRoot();");
		sc.add(I_RESOURCE + " resource = root.findMember(location);");
		sc.add("return new " + annotationModelClassName + "(resource);");
		sc.add("}");
		sc.addLineBreak();
	}
}
