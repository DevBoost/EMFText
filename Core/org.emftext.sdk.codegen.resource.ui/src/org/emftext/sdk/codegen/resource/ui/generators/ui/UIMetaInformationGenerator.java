/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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

	public void addMethods(JavaComposite sc) {
    	addGetHoverTextProviderMethod(sc);
    	addGetImageProviderMethod(sc);
		addCreateColorManagerMethod(sc);
        addCreateTokenScannerMethod1(sc);
        addCreateTokenScannerMethod2(sc);
        addCreateCodeCompletionHelperMethod(sc);
	}

	private void addCreateTokenScannerMethod1(JavaComposite sc) {
		sc.addJavadoc(
				"@deprecated this method is only provided to preserve API compatibility. " +
				"Use createTokenScanner(" + iTextResourceClassName + ", " + colorManagerClassName + ") instead.");
		sc.add("public " + tokenScannerClassName + " createTokenScanner(" + colorManagerClassName + " colorManager) {");
		sc.add("return createTokenScanner(null, colorManager);");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateTokenScannerMethod2(StringComposite sc) {
		sc.add("public " + tokenScannerClassName + " createTokenScanner(" + iTextResourceClassName + " resource, " + colorManagerClassName + " colorManager) {");
		sc.add("return new " + tokenScannerClassName + "(resource, colorManager);");
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
