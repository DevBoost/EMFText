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
package org.emftext.sdk.codegen.resource.generators;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class TokenResolveResultGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc("A basic implementation of the ITokenResolveResult interface.");
		sc.add("public class " + getResourceClassName() + " implements " + iTokenResolveResultClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetErrorMessage(sc);
		addGetResolvedTokenMethod(sc);
		addSetErrorMessageMethod(sc);
		addSetResolvedTokenMethod(sc);
		addClearMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private String errorMessage;");
		sc.add("private Object resolvedToken;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("clear();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetErrorMessage(JavaComposite sc) {
		sc.add("public String getErrorMessage() {");
		sc.add("return errorMessage;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResolvedTokenMethod(JavaComposite sc) {
		sc.add("public Object getResolvedToken() {");
		sc.add("return resolvedToken;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetErrorMessageMethod(JavaComposite sc) {
		sc.add("public void setErrorMessage(String message) {");
		sc.add("errorMessage = message;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetResolvedTokenMethod(JavaComposite sc) {
		sc.add("public void setResolvedToken(Object resolvedToken) {");
		sc.add("this.resolvedToken = resolvedToken;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addClearMethod(JavaComposite sc) {
		sc.add("public void clear() {");
		sc.add("errorMessage = \"Can't resolve token.\";");
		sc.add("resolvedToken = null;");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
