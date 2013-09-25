/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource.generators.mopp;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class BracketPairGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A single pair of brackets.");
		sc.add("public class " + getResourceClassName() + " implements " + iBracketPairClassName + " {");
		sc.addLineBreak();
		sc.addFieldGetSet("openingBracket", "String");
		sc.addFieldGetSet("closingBracket", "String");
		sc.addFieldGetSet("closingEnabledInside", "boolean");
		sc.addFieldGetSet("closeAfterEnter", "boolean");
		sc.addFields();
		sc.addGettersSetters();
		addConstructor(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String openingBracket, String closingBracket, boolean closingEnabledInside, boolean closeAfterEnter) {");
		sc.add("super();");
		sc.add("this.openingBracket = openingBracket;");
		sc.add("this.closingBracket = closingBracket;");
		sc.add("this.closingEnabledInside = closingEnabledInside;");
		sc.add("this.closeAfterEnter = closeAfterEnter;");
		sc.add("}");
		sc.addLineBreak();
	}
}
