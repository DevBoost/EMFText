package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class UIMetaInformationGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName() + " extends " + metaInformationClassName + " {");
        sc.addLineBreak();
    	addMethods(sc);
        sc.add("}");
	}

	public void addMethods(StringComposite sc) {
    	addGetHoverTextProviderMethod(sc);
    	addGetImageProviderMethod(sc);
		addCreateColorManagerMethod(sc);
        addCreateTokenScannerMethod(sc);
        addCreateCodeCompletionHelperMethod(sc);
	}

	private void addCreateTokenScannerMethod(StringComposite sc) {
		sc.add("public " + tokenScannerClassName + " createTokenScanner(" + colorManagerClassName + " colorManager) {");
		sc.add("return new " + tokenScannerClassName + "(colorManager);");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateCodeCompletionHelperMethod(StringComposite sc) {
		sc.add("public " + codeCompletionHelperClassName + " createCodeCompletionHelper() {");
        sc.add("return new " + codeCompletionHelperClassName + "();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateColorManagerMethod(StringComposite sc) {
		sc.add("public " + colorManagerClassName + " createColorManager() {");
        sc.add("return new " + colorManagerClassName + "();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetHoverTextProviderMethod(StringComposite sc) {
		sc.add("public " + iHoverTextProviderClassName + " getHoverTextProvider() {");
		sc.add("return new " + hoverTextProviderClassName + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetImageProviderMethod(StringComposite sc) {
		sc.add("public " + imageProviderClassName + " getImageProvider() {");
		sc.add("return " + imageProviderClassName + ".INSTANCE;");
		sc.add("}");
		sc.addLineBreak();
	}
}
