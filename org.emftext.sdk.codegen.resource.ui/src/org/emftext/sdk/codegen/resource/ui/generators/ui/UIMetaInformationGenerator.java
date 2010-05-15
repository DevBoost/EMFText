package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class UIMetaInformationGenerator extends UIJavaBaseGenerator {

	public static final GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new UIMetaInformationGenerator());

	private UIMetaInformationGenerator() {
		super();
	}

	private UIMetaInformationGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceUIArtifacts.UI_META_INFORMATION);
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
			ICodeGenerationComponent parent, 
			GenerationContext context, Object parameters) {
		return new UIMetaInformationGenerator(parent, context);
	}
}
