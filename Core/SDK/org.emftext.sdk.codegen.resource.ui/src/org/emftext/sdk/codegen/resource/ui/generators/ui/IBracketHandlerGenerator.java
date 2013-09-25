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

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class IBracketHandlerGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The BracketHandler is responsible for handling the input of " +
			"brackets. It automatically adds closing brackets, if the opening " +
			"counterpart is entered in editors. It does also ignore the input " +
			"of closing brackets, if these were automatically inserted right " +
			"before."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("If a closing bracket was added right before, this method returns true.");
		sc.add("public boolean addedClosingBracket();");
		sc.addLineBreak();
		sc.addJavadoc("Returns the last closing bracket that was added automatically.");
		sc.add("public String getClosingBracket();");
		sc.addLineBreak();
		sc.add("}");
	}
}
