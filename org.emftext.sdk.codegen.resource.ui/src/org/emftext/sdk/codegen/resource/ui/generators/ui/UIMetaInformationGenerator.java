package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class UIMetaInformationGenerator extends UIJavaBaseGenerator {

	public UIMetaInformationGenerator() {
		super();
	}

	private UIMetaInformationGenerator(GenerationContext context) {
		super(context, TextResourceUIArtifacts.UI_META_INFORMATION);
	}
	
	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName() + " extends " + metaInformationClassName + " {");
        sc.addLineBreak();
    	addMethods(sc);
        sc.add("}");
    	
    	return true;	
	}

	public void addMethods(StringComposite sc) {
    	addGetHoverTextProviderMethod(sc);
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

	public IGenerator<GenerationContext, Object> newInstance(
			GenerationContext context, Object parameters) {
		return new UIMetaInformationGenerator(context);
	}
}
