package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.*;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER_RESOLUTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER_RESOLUTION_GENERATOR;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

// TODO mseifert: complete implementation
public class MarkerResolutionGeneratorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_MARKER_RESOLUTION_GENERATOR + " {");
		sc.addLineBreak();
		addGetResolutionsMethod(sc);
		sc.add("}");
	}

	private void addGetResolutionsMethod(JavaComposite sc) {
		sc.add("public " + I_MARKER_RESOLUTION + "[] getResolutions(" + I_MARKER + " marker) {");
		sc.add("try {");
		sc.add(I_RESOURCE + " resource = marker.getResource();");
		sc.add("if (resource instanceof " + I_FILE + ") {");
		sc.add("// load model");
		sc.add("final " + I_FILE + " file = (" + I_FILE + ") resource;");
		sc.add(URI + " uri = " + URI + ".createPlatformResourceURI(file.getFullPath().toString(), true);");
		sc.add(RESOURCE_SET + " rs = new " + RESOURCE_SET_IMPL + "();");
		sc.add(RESOURCE + " emfResource = rs.getResource(uri, true);");
		sc.add("if (emfResource instanceof " + textResourceClassName + ") {");
		sc.add(textResourceClassName + " customResource = (" + textResourceClassName + ") emfResource;");
		sc.add(ECORE_UTIL + ".resolveAll(customResource);");
		sc.addComment("get data from marker (quick fix type and context object URIs)");
		sc.add("Object sourceIdObject = marker.getAttribute(" + I_MARKER + ".SOURCE_ID);");
		sc.add("String quickFixContext = null;");
		sc.add("if (sourceIdObject instanceof String) {");
		sc.add("quickFixContext = (String) sourceIdObject;");
		//sc.add("System.out.println(this + \".getResolutions() \" + quickFixContext);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("final " + iQuickFixClassName + " quickFix = customResource.getQuickFix(quickFixContext);");
		sc.add("return new " + I_MARKER_RESOLUTION + "[] {");
		sc.add("new " + I_MARKER_RESOLUTION + "() {");
		sc.addLineBreak();
		sc.add("public void run(" + I_MARKER + " marker) {");
		// TODO do we need to pass the old text here?
		sc.add("String newText = quickFix.apply(null);");
		sc.addComment("set new text as content for resource");
		sc.add("try {");
		sc.add("file.setContents(new " + BYTE_ARRAY_INPUT_STREAM + "(newText.getBytes()), true, true, null);");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while applying quick fix\", e);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getLabel() {");
		sc.add("return quickFix.getDisplayString();");
		sc.add("}");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + EXCEPTION + " e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while applying quick fix\", e);");
		sc.add("}");
		sc.add("return new " + I_MARKER_RESOLUTION + "[] {};");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}
}
