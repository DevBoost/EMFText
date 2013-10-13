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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class IBracketPairGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final static String closingEnabledDocumentation = " whether other bracket pairs shall be " +
			"automatically closed, when used inside of this " +
			"bracket pair.";

	private final static String closeAfterEnterDocumentation = " whether this bracket pair shall be " +
			"automatically closed, when a line break is entered. " +
			"If this method returns false, the closing bracket is " +
			"inserted right away when the opening bracket is typed.";

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc("A simple interface to access information about bracket handling.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		sc.addJavadoc("Returns the opening bracket.");
		sc.add("public String getOpeningBracket();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the closing bracket.");
		sc.add("public String getClosingBracket();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns" + closingEnabledDocumentation);
		sc.add("public boolean isClosingEnabledInside();");
		sc.addLineBreak();
		
		sc.addJavadoc("Sets" + closingEnabledDocumentation);
		sc.add("public void setClosingEnabledInside(boolean closingEnabledInside);");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns" + closeAfterEnterDocumentation);
		sc.add("public boolean isCloseAfterEnter();");
		sc.addLineBreak();
		
		sc.addJavadoc("Sets" + closeAfterEnterDocumentation);
		sc.add("public void setCloseAfterEnter(boolean closingAfterEnter);");
		sc.addLineBreak();
	}
}
