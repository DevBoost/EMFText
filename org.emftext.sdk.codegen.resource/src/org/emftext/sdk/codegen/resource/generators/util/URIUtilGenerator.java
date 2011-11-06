package org.emftext.sdk.codegen.resource.generators.util;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class URIUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addIsInBinFolderMethod(sc);
		sc.add("}");
	}

	private void addIsInBinFolderMethod(JavaComposite sc) {
		sc.add("public boolean isInBinFolder(" + URI + " uri) {");
		sc.add("String[] segments = uri.segments();");
		sc.add("for (String segment : segments) {");
		sc.add("if (\"bin\".equals(segment)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
}
